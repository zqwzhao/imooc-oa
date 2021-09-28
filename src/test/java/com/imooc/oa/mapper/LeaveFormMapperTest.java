package com.imooc.oa.mapper;

import com.imooc.oa.entity.LeaveForm;
import com.imooc.oa.utils.MyBatisUtils;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class LeaveFormMapperTest {

    @Test
    public void insert() {
        MyBatisUtils.executeQuery(sqlSession -> {
            LeaveFormMapper mapper = sqlSession.getMapper(LeaveFormMapper.class);
            LeaveForm leaveForm = new LeaveForm();
            leaveForm.setEmployeeId(4l);
            leaveForm.setFormType(1); //事假


            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date startTime = null;
            Date endTime = null;

            try{
                startTime = simpleDateFormat.parse("2021-09-25 08:00:00");
                endTime = simpleDateFormat.parse("2021-09-27 08:00:00");

            } catch (ParseException e) {
                e.printStackTrace();
            }
            leaveForm.setStartTime(startTime);
            leaveForm.setEndTime(endTime);

            leaveForm.setReason("回家探亲");
            leaveForm.setCreateTime(new Date());
            leaveForm.setState("processing");

            mapper.insert(leaveForm);
            return null;
        });
    }
}