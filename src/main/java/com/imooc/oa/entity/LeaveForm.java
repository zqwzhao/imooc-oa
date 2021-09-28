package com.imooc.oa.entity;

import java.util.Date;

/**
 * @author : [zqwzh]
 * @version : [v1.0]
 * @createTime : [2021-09-25 16:08]
 */
public class LeaveForm {
    private Long formId;
    private Long employeeId;
    private Integer formType;
    private Date startTime;
    private Date endTime;
    private String reason;
    private Date createTime;
    private String state;

    public LeaveForm() {
    }

    public LeaveForm(Long formId, Long employeeId, Integer formType, Date startTime, Date endTime, String reason, Date createTime, String state) {
        this.formId = formId;
        this.employeeId = employeeId;
        this.formType = formType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.reason = reason;
        this.createTime = createTime;
        this.state = state;
    }

    public Long getFormId() {
        return formId;
    }

    public void setFormId(Long formId) {
        this.formId = formId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getFormType() {
        return formType;
    }

    public void setFormType(Integer formType) {
        this.formType = formType;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "LeaveForm{" +
                "formId=" + formId +
                ", employeeId=" + employeeId +
                ", formType=" + formType +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", reason='" + reason + '\'' +
                ", createTime=" + createTime +
                ", state='" + state + '\'' +
                '}';
    }


}
