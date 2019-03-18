package com.hbsfdx.system.pojo;

import java.util.Date;

public class ClassExpenditure {
    private Long classId;

    private Date updated;

    private Long amount;

    private String location;

    private String reson;

    private Long weekTimes;

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getReson() {
        return reson;
    }

    public void setReson(String reson) {
        this.reson = reson == null ? null : reson.trim();
    }

    public Long getWeekTimes() {
        return weekTimes;
    }

    public void setWeekTimes(Long weekTimes) {
        this.weekTimes = weekTimes;
    }
}