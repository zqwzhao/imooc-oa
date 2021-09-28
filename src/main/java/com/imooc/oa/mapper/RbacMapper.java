package com.imooc.oa.mapper;

import com.imooc.oa.entity.Node;
import com.imooc.oa.utils.MyBatisUtils;

import java.util.List;

/**
 * @author : [zqwzh]
 * @version : [v1.0]
 * @createTime : [2021-09-20 21:39]
 */
public class RbacMapper {
    public List<Node> selectNodeByUserId(Long userId){
        List<Node> list =(List) MyBatisUtils.executeQuery(sqlSession -> sqlSession.selectList("rbacmapper.selectNodeByUserId", userId));
        return list;
    }
}
