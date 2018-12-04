package com.ccit.bean;

import com.ccit.annotation.Person;

@Person(role = "test1")
@Person(role = "test2")
@Person(role = "test3")
public class UserVo {

    private String userName;

    private String password;

    private UserBean userBean;

    public UserVo() {

    }

    public UserVo(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public UserVo(UserBean userBean) {
        this.userName = userBean.getUserName();
        this.password = userBean.getPassword();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
