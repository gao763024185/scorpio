package com.gao.scorpio.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Feed {

    private Integer id;

    private String logId;

    private Integer uid;

    private String feedContent;

    private Date feedTime;

    private String status;

}