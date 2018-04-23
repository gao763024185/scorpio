package com.gao.scorpio.controller.vo;

import com.gao.scorpio.entity.Logs;
import lombok.Data;

import java.util.List;

/**
 * @description 归档列表显示vo
 * @author: gaobh
 * @date: 2018/4/13 16:58
 * @version: v1.0
 */
@Data
public class DocumentVO {

    private Integer year;
    private List<Logs> logsList;
 }
