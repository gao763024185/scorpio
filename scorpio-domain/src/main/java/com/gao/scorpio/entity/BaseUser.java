package com.gao.scorpio.entity;

import lombok.Data;

import java.util.Date;

@Data
public class BaseUser {

    private Integer uid;

    private String userName;

    private String password;

    private Date loginTime;

    private Date created;

    private String avatar;

    private String avatarthumbnail;

}