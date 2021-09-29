package com.imooc.oa.mapper;

import com.imooc.oa.entity.Employee;
import com.imooc.oa.utils.MyBatisUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class EmployeeMapperTest {

    @Test
    public void selectById() {
        Object o = MyBatisUtils.executeQuery(sqlSession -> {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = mapper.selectById(1l);
            System.out.println(employee);
            return employee;
        });
    }

    @Test
    public void testSelectByParams() {
        Map params = new HashMap();
        params.put("level","7");
        params.put("departmentId","2");
        MyBatisUtils.executeQuery(sqlSession -> {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            List<Employee> employees = mapper.selectByParams(params);
            for (Employee employee : employees) {
                System.out.println(employee);
            }
            return null;
        });
    }

    @Test
    public void testByParams() {
        Map params = new HashMap();
        params.put("level","8");
        params.put("departmentId","1");
        MyBatisUtils.executeQuery(sqlSession -> {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            List<Employee> employees = mapper.selectByParams(params);
            for (Employee employee : employees) {
                System.out.println(employee);
            }
            return null;
        });
    }
}