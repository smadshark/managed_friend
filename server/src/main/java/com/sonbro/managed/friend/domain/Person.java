package com.sonbro.managed.friend.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
// @NonNull 존재하면 그 member변수에 대해서만
@RequiredArgsConstructor
@ToString(exclude = {})
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private int age;

    private String bloodType;

    @ToString.Exclude
    private String phoneNumber;
}
