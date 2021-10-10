package com.imooc.oa.service;

import com.imooc.oa.entity.Notice;
import com.imooc.oa.mapper.NoticeMapper;
import com.imooc.oa.utils.MyBatisUtils;

import java.util.List;

/**
 * @author : [zqwzh]
 * @version : [v1.0]
 * @createTime : [2021-10-10 10:14]
 */
public class NoticeService {

    public List<Notice> getNoticeList(Long receiverId) {
        return (List)MyBatisUtils.executeQuery(sqlSession -> {
            NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
            List<Notice> notices = mapper.selectByReceiverId(receiverId);
            return notices;
        });
    }
}
