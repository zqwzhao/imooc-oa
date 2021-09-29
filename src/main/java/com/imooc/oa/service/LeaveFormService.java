package com.imooc.oa.service;

import com.imooc.oa.entity.Employee;
import com.imooc.oa.entity.LeaveForm;
import com.imooc.oa.entity.ProcessFlow;
import com.imooc.oa.mapper.EmployeeMapper;
import com.imooc.oa.mapper.LeaveFormMapper;
import com.imooc.oa.mapper.ProcessFlowMapper;
import com.imooc.oa.utils.MyBatisUtils;

import java.sql.PreparedStatement;
import java.util.Date;

/**
 * @author : [zqwzh]
 * @version : [v1.0]
 * @createTime : [2021-09-28 16:37]
 */
public class LeaveFormService {
    private EmployeeService employeeService = new EmployeeService();

    /**
     * 创建请假单
     * @param leaveForm 前端输入的请假单数据
     * @return 持久化后的请假单数据
     */
    public LeaveForm createLeaveForm(LeaveForm leaveForm) {


        //1.持久化form表单数据，8级以下员工表单状态为processing，8级总经理状态为approved
        LeaveForm f =(LeaveForm) MyBatisUtils.executeUpdate(sqlSession -> {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            long id = leaveForm.getEmployeeId();


            Employee employee = mapper.selectById(id);
            if (employee.getLevel() == 8) {
                leaveForm.setState("approved");
            } else {
                leaveForm.setState("processing");
            }

            LeaveFormMapper leaveFormMapper = sqlSession.getMapper(LeaveFormMapper.class);
            leaveFormMapper.insert(leaveForm);
            //2.增加一条流程数据说明表单已经提交，状态为complete
            ProcessFlowMapper processFlowMapper = sqlSession.getMapper(ProcessFlowMapper.class);
            ProcessFlow processFlow = new ProcessFlow();
            processFlow.setFormId(leaveForm.getFormId());
            processFlow.setOperatorId(employee.getEmployeeId());
            processFlow.setAction("apply");
            processFlow.setCreateTime(new Date());
            processFlow.setOrderNo(1);
            processFlow.setState("complete");
            processFlow.setIsLast(0);
            processFlowMapper.insert(processFlow);


            //3.分情况创建其余流程数据
            //3.1 7级以下员工，生成部门经理审批任务，请假时间大于72小时的，还需生成总经理审批任务
            if (employee.getLevel() < 7) {
                Employee dmanager = employeeService.selectLeader(employee.getEmployeeId());
                ProcessFlow flow = new ProcessFlow();
                flow.setFormId(leaveForm.getFormId());
                flow.setOperatorId(dmanager.getEmployeeId());
                flow.setAction("audit");
                flow.setCreateTime(new Date());
                flow.setOrderNo(2);
                flow.setState("process");
                long diff = leaveForm.getEndTime().getTime() - leaveForm.getCreateTime().getTime();
                float hours = diff / (1000 * 60 * 60) * 1f;
                if (hours >= 72) {
                    flow.setIsLast(0);
                    processFlowMapper.insert(flow);
                    employeeService.selectLeader(dmanager.getEmployeeId());
                    Employee manager = employeeService.selectById(dmanager.getEmployeeId());
                    ProcessFlow flow2 = new ProcessFlow();
                    flow2.setFormId(leaveForm.getFormId());
                    flow2.setOperatorId(manager.getEmployeeId());
                    flow2.setAction("audit");
                    flow2.setCreateTime(new Date());
                    flow2.setState("ready");
                    flow2.setOrderNo(3);
                    flow2.setIsLast(1);
                    processFlowMapper.insert(flow2);
                } else {
                    flow.setIsLast(1);
                    processFlowMapper.insert(flow);
                }

            } else if (employee.getLevel() == 7) {
                Employee manager = employeeService.selectLeader(employee.getEmployeeId());
                ProcessFlow flow3 = new ProcessFlow();
                flow3.setFormId(leaveForm.getFormId());
                flow3.setOperatorId(manager.getEmployeeId());
                flow3.setAction("audit");
                flow3.setCreateTime(new Date());
                flow3.setOrderNo(2);
                flow3.setState("process");
                flow3.setIsLast(1);
                processFlowMapper.insert(flow3);
            } else if (employee.getLevel() == 8) {
                ProcessFlow flow3 = new ProcessFlow();
                flow3.setFormId(leaveForm.getFormId());
                flow3.setOperatorId(employee.getEmployeeId());
                flow3.setAction("audit");
                flow3.setResult("approved");
                flow3.setReason("自动通过");
                flow3.setAuditTime(new Date());
                flow3.setOrderNo(2);
                flow3.setState("complete");
                flow3.setIsLast(1);
                processFlowMapper.insert(flow3);
            }

            return leaveForm;
        });


        //3.2 7级员工，仅生成总经理审批任务
        //3.3 8级员工，生成总经理审批任务，系统自动通过
        return f;
    }
}
