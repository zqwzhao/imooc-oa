package com.imooc.oa.entity;

import java.util.Date;

/**
 * @author : [zqwzh]
 * @version : [v1.0]
 * @createTime : [2021-09-25 16:32]
 */
public class ProcessFlow {
    private Long processId;
    private Long formId;
    private Long operatorId;
    private String action;
    private String result;
    private String reason;
    private Date createTime;
    private Date auditTime;
    private Integer orderNo ;
    private String state;
    private Integer isLast;

    public ProcessFlow() {
    }

    public ProcessFlow(Long processId, Long formId, Long operatorId, String action, String result, String reason, Date createTime, Date auditTime, Integer orderNo, String state, Integer isLast) {
        this.processId = processId;
        this.formId = formId;
        this.operatorId = operatorId;
        this.action = action;
        this.result = result;
        this.reason = reason;
        this.createTime = createTime;
        this.auditTime = auditTime;
        this.orderNo = orderNo;
        this.state = state;
        this.isLast = isLast;
    }

    public Long getProcessId() {
        return processId;
    }

    public void setProcessId(Long processId) {
        this.processId = processId;
    }

    public Long getFormId() {
        return formId;
    }

    public void setFormId(Long formId) {
        this.formId = formId;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getIsLast() {
        return isLast;
    }

    public void setIsLast(Integer isLast) {
        this.isLast = isLast;
    }

    @Override
    public String toString() {
        return "ProcessFlow{" +
                "processId=" + processId +
                ", formId=" + formId +
                ", operatorId=" + operatorId +
                ", action='" + action + '\'' +
                ", result='" + result + '\'' +
                ", reason='" + reason + '\'' +
                ", createTime=" + createTime +
                ", auditTime=" + auditTime +
                ", orderNo=" + orderNo +
                ", state='" + state + '\'' +
                ", isLast=" + isLast +
                '}';
    }
}
