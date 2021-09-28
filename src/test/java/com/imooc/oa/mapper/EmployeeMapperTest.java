package com.imooc.oa.mapper;

import com.imooc.oa.entity.Employee;
import com.imooc.oa.utils.MyBatisUtils;
import org.junit.Test;

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
}