package com.sonbro.reservation.domain;

import lombok.Data;

@Data
public class Student {
    private int studentId;
    private String studentName;
    private String address;

    public Student(int studentId, String studentName, String address) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.address = address;
    }
}
