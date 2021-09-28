package com.imooc.oa.entity;

/**
 * @author : [zqwzh]
 * @version : [v1.0]
 * @createTime : [2021-09-20 22:56]
 */
public class Employee {
    private Long employeeId;//员工编号
    private String name;//姓名
    private Long departmentId;//部门编号
    private String title; //头衔职位
    private Integer level;//岗位职级

    public Employee() {
    }

    public Employee(Long employeeId, String name, Long departmentId, String title, Integer level) {
        this.employeeId = employeeId;
        this.name = name;
        this.departmentId = departmentId;
        this.title = title;
        this.level = level;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", departmentId=" + departmentId +
                ", title='" + title + '\'' +
                ", level=" + level +
                '}';
    }
}
