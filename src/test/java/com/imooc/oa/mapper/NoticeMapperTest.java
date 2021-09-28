package com.imooc.oa.mapper;

import com.imooc.oa.entity.Notice;
import com.imooc.oa.utils.MyBatisUtils;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class NoticeMapperTest {

    @Test
    public void insert() {
        MyBatisUtils.executeUpdate(sqlSession -> {
            NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
            Notice notice = new Notice(2l, "测试信息");
            notice.setCreateTime(new Date());
            mapper.insert(notice);
            return null;
        });

    }
}