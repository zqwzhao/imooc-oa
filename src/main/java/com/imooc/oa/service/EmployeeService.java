package com.imooc.oa.service;

import com.imooc.oa.entity.Employee;
import com.imooc.oa.mapper.EmployeeMapper;
import com.imooc.oa.utils.MyBatisUtils;

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
}
