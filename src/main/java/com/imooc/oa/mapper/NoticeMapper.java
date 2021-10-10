package com.imooc.oa.mapper;

import com.imooc.oa.entity.Notice;

import java.util.List;

/**
 * @author : [zqwzh]
 * @version : [v1.0]
 * @createTime : [2021-09-28 16:21]
 */
public interface NoticeMapper {
    public void insert(Notice notice);

    public List<Notice> selectByReceiverId(Long receiverId);
}
