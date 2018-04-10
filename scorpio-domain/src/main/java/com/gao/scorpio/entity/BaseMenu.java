package com.gao.scorpio.entity;

import lombok.Data;

@Data
public class BaseMenu {

    private Integer menuId;

    private Integer pMenuId;

    private String menuName;

    private String menuUrl;

    private String menuType;
}