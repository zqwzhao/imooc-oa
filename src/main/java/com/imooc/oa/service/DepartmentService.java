package com.imooc.oa.service;

import com.imooc.oa.entity.Department;
import com.imooc.oa.mapper.DepartmentMapper;
import com.imooc.oa.utils.MyBatisUtils;

/**
 * @author : [zqwzh]
 * @version : [v1.0]
 * @createTime : [2021-09-29 22:47]
 */
public class DepartmentService {
    public Department selectById(Long departmentId) {
        return (Department) MyBatisUtils.executeUpdate(sqlSession -> sqlSession.getMapper(DepartmentMapper.class).selectById(departmentId));
    }
}
