package com.sonbro.reservation.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    @Test
    public void studentTest(){
        Student st1 = new Student(1, "son", "Bupyung");
        System.out.println(st1.getStudentName());
        System.out.println(st1);
    }
}