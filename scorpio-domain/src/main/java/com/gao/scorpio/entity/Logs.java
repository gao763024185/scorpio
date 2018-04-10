package com.gao.scorpio.entity;


import com.gao.scorpio.DateUtil;
import lombok.Data;

import java.util.Date;

@Data
public class Logs {

    private String logId;

    private String logTitle;

    private String logSummary;

    private String logContent;

    private Date logCreated;
    private String logCreatedStr;

    private Date logUpdate;
    private String logUpdateStr;

    private String year;
    private String month;
    private Integer count;



    public void setLogCreatedStr(Date logCreated,String pattern) {
        this.logCreatedStr = DateUtil.format(logCreated,pattern);
    }

    public void setLogUpdateStr(Date logCreated,String pattern) {
        this.logUpdateStr = DateUtil.format(logCreated,pattern);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Logs logs = (Logs) o;

        if (!logId.equals(logs.logId)) return false;
        return logTitle.equals(logs.logTitle);
    }

    @Override
    public int hashCode() {
        int result = logId.hashCode();
        result = 31 * result + logTitle.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Logs{" +
                "logId='" + logId + '\'' +
                ", logTitle='" + logTitle + '\'' +
                ", logSummary='" + logSummary + '\'' +
                ", logContent='" + logContent + '\'' +
                ", logCreated=" + logCreated +
                ", logCreatedStr='" + logCreatedStr + '\'' +
                ", logUpdate=" + logUpdate +
                ", logUpdateStr='" + logUpdateStr + '\'' +
                '}';
    }
}