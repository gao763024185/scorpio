package com.gao.scorpio.cookie;

/**
 * @description 用户登陆实体类
 * @author: gaobh
 * @date: 2017/2/23
 * @version: v1.0
 */
public class UserAgent {

    private String uid;

    private String userName;

    private String password;

    public UserAgent() {
    }

    public UserAgent(String uid, String userName, String password) {
        this.uid = uid;
        this.userName = userName;
        this.password = password;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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


}
