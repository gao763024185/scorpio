package com.gao.scorpio.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseMenuDTO implements Serializable {

    private Integer menuId;

    private Integer pMenuId;

    private String menuName;

    private String menuUrl;

    private String menuType;
}