package com.hbsfdx.system.pojo;

public class ClassCheckingIn {
    private Long studentId;

    private Long classId;

    private String term;

    private Long weekTimes;

    private String week;

    private String courseTime;

    private Long absenteeism;

    private Long late;

    private Long askForLeave;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term == null ? null : term.trim();
    }

    public Long getWeekTimes() {
        return weekTimes;
    }

    public void setWeekTimes(Long weekTimes) {
        this.weekTimes = weekTimes;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week == null ? null : week.trim();
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime == null ? null : courseTime.trim();
    }

    public Long getAbsenteeism() {
        return absenteeism;
    }

    public void setAbsenteeism(Long absenteeism) {
        this.absenteeism = absenteeism;
    }

    public Long getLate() {
        return late;
    }

    public void setLate(Long late) {
        this.late = late;
    }

    public Long getAskForLeave() {
        return askForLeave;
    }

    public void setAskForLeave(Long askForLeave) {
        this.askForLeave = askForLeave;
    }
}