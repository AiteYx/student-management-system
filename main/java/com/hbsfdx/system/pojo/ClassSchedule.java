package com.hbsfdx.system.pojo;

public class ClassSchedule {
    private Long classId;

    private Long week;

    private String am1;

    private String am2;

    private String pm1;

    private String pm2;

    private String weekTimes;

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getWeek() {
        return week;
    }

    public void setWeek(Long week) {
        this.week = week;
    }

    public String getAm1() {
        return am1;
    }

    public void setAm1(String am1) {
        this.am1 = am1 == null ? null : am1.trim();
    }

    public String getAm2() {
        return am2;
    }

    public void setAm2(String am2) {
        this.am2 = am2 == null ? null : am2.trim();
    }

    public String getPm1() {
        return pm1;
    }

    public void setPm1(String pm1) {
        this.pm1 = pm1 == null ? null : pm1.trim();
    }

    public String getPm2() {
        return pm2;
    }

    public void setPm2(String pm2) {
        this.pm2 = pm2 == null ? null : pm2.trim();
    }

    public String getWeekTimes() {
        return weekTimes;
    }

    public void setWeekTimes(String weekTimes) {
        this.weekTimes = weekTimes == null ? null : weekTimes.trim();
    }
}