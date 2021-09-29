package com.imooc.oa.service;

import com.imooc.oa.entity.Employee;
import com.imooc.oa.mapper.EmployeeMapper;
import com.imooc.oa.utils.MyBatisUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : [zqwzh]
 * @version : [v1.0]
 * @createTime : [2021-09-20 23:05]
 */
public class EmployeeService {
    public Employee selectById(Long employeeId){
        Employee employee =(Employee) MyBatisUtils.executeQuery(sqlSession -> {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee e = mapper.selectById(employeeId);
            return e;
        });

        return employee;
    }

    public Employee selectLeader(Long employeeId) {
        Employee l =(Employee) MyBatisUtils.executeQuery(sqlSession -> {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee e = mapper.selectById(employeeId);
            Map params = new HashMap();
            Employee leader = null;
            if (e.getLevel() < 7) {
                //员工级别小于7，查询部门经理
                params.put("level","7");
                params.put("departmentId",e.getDepartmentId());

                List<Employee> employees = mapper.selectByParams(params);
                leader = employees.get(0);

            }else if (e.getLevel() == 7) {
                //员工级别等于7 查询总经理
                params.put("level","8");
                List<Employee> employees = mapper.selectByParams(params);
                leader = employees.get(0);
            }else if (e.getLevel() == 8) {
                //返回自己
                leader = e;
            }
            return leader;
        });

        return l;
    }
}
