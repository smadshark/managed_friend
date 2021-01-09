package com.sonbro.managed.friend.domain;

import com.sonbro.managed.friend.domain.dto.Birthday;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private int age;

    @Embedded
    private Birthday birthday;

    @NonNull
    private String bloodType;

    @ToString.Exclude
    private String phoneNumber;

    @OneToOne
    private Block block;
}
