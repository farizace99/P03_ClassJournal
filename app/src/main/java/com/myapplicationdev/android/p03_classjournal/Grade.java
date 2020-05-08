package com.myapplicationdev.android.p03_classjournal;

import java.io.Serializable;

public class Grade implements Serializable {

    private int week;
    private String moduleCode;
    private String grade;

    public Grade(int week, String moduleCode, String grade) {
        this.week = week;
        this.moduleCode = moduleCode;
        this.grade = grade;
    }

    public int getWeek() {
        return week;
    }

    public String getmoduleCode() {
        return moduleCode;
    }

    public String getGrade() {
        return grade;
    }

}
