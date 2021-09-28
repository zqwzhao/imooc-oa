package com.imooc.oa.service;

import com.imooc.oa.entity.Node;
import com.imooc.oa.mapper.RbacMapper;

import java.util.List;

/**
 * @author : [zqwzh]
 * @version : [v1.0]
 * @createTime : [2021-09-20 21:42]
 */
public class RbacService {
    private RbacMapper rbacMapper = new RbacMapper();
    public List<Node> selectNodeByUserId(Long userId){
        List<Node> nodes = rbacMapper.selectNodeByUserId(userId);
        return nodes;
    }

}
