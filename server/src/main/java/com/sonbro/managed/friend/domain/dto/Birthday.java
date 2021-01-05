package com.sonbro.managed.friend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;

@Embeddable
//@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Birthday {
    private int yearOfBirthday;

    private int monthOfBirthday;

    private int dayOfBirthday;

    // @AllArgsConstructor 때문에 해당 생성자가 인식되지 않았음
    // TODO: 조사필요
    public Birthday(LocalDate birthday) {
        this.yearOfBirthday = birthday.getYear();
        this.monthOfBirthday = birthday.getMonthValue();
        this.dayOfBirthday = birthday.getDayOfMonth();
    }
}
