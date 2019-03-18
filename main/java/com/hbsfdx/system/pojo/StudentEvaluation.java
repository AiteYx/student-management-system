package com.hbsfdx.system.pojo;

import org.omg.CORBA.PUBLIC_MEMBER;

public class StudentEvaluation {
    private Long studentId;

    private Long classId;

    private Long a1;

    private Long a2;

    private Long a3;

    private Long a4;

    private Long a5;

    private Long a6;

    private Long r1;

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

    public Long getA1() {
        return a1;
    }

    public void setA1(Long a1) {
        this.a1 = a1;
    }

    public Long getA2() {
        return a2;
    }

    public void setA2(Long a2) {
        this.a2 = a2;
    }

    public Long getA3() {
        return a3;
    }

    public void setA3(Long a3) {
        this.a3 = a3;
    }

    public Long getA4() {
        return a4;
    }

    public void setA4(Long a4) {
        this.a4 = a4;
    }

    public Long getA5() {
        return a5;
    }

    public void setA5(Long a5) {
        this.a5 = a5;
    }

    public Long getA6() {
        return a6;
    }

    public void setA6(Long a6) {
        this.a6 = a6;
    }

    public Long getR1() {
        return r1;
    }

    public void setR1(Long r1) {
        this.r1 = r1;
    }

    public void result(Long num){
        r1 = a1+a2+a3+a4+a5+a6/num;
    }
}