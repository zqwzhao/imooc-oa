package com.imooc.oa.entity;

/**
 * @author : [zqwzh]
 * @version : [v1.0]
 * @createTime : [2021-09-19 11:44]
 */
public class User {
    private Long userId;
    private String username;
    private String password;
    private Long employeeId;
    private Integer salt;

    public User() {
    }
    public User(Long userId, String username, String password, Long employeeId, Integer salt) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.employeeId = employeeId;
        this.salt = salt;
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getSalt() {
        return salt;
    }

    public void setSalt(Integer salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", employeeId=" + employeeId +
                ", salt=" + salt +
                '}';
    }
}
