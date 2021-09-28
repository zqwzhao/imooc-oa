package com.imooc.oa.entity;

import java.util.Date;

/**
 * @author : [zqwzh]
 * @version : [v1.0]
 * @createTime : [2021-09-28 16:19]
 */
public class Notice {
    private Long noticeId;
    private Long receiverId;
    private String content;
    private Date createTime;

    public Notice() {
    }

    public Notice(Long receiverId, String content) {
        this.receiverId = receiverId;
        this.content = content;
    }

    public Long getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "noticeId=" + noticeId +
                ", receiverId=" + receiverId +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
