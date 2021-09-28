package com.imooc.oa.entity;

/**
 * @author : [zqwzh]
 * @version : [v1.0]
 * @createTime : [2021-09-20 21:21]
 */
public class Node {
    private Long nodeId;
    private Integer nodeType;//节点类型 1-模块 2-功能
    private String nodeName;//节点名
    private String url;//页面url
    private Integer nodeCode;
    private Long parentId;

    public Node() {
    }

    public Node(Long nodeId, Integer nodeType, String nodeName, String url, Integer nodeCode, Long parentId) {
        this.nodeId = nodeId;
        this.nodeType = nodeType;
        this.nodeName = nodeName;
        this.url = url;
        this.nodeCode = nodeCode;
        this.parentId = parentId;
    }

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeType() {
        return nodeType;
    }

    public void setNodeType(Integer nodeType) {
        this.nodeType = nodeType;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getNodeCode() {
        return nodeCode;
    }

    public void setNodeCode(Integer nodeCode) {
        this.nodeCode = nodeCode;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "Node{" +
                "nodeId=" + nodeId +
                ", nodeType=" + nodeType +
                ", nodeName='" + nodeName + '\'' +
                ", url='" + url + '\'' +
                ", nodeCode=" + nodeCode +
                ", parentId=" + parentId +
                '}';
    }
}
