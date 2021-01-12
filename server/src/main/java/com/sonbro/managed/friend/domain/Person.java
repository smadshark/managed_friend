package com.sonbro.managed.friend.domain;

import com.sonbro.managed.friend.domain.dto.Birthday;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Accessors(chain = true)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @Embedded
    private Birthday birthday;

    @ToString.Exclude
    private String phoneNumber;

    @OneToOne
    private Block block;

    // 나이
    public Integer getAge() {
        if(this.birthday != null) {
            return LocalDate.now().getYear() - this.birthday.getYearOfBirthday() + 1;
        }
        return null;
    }

    // 생일인지 아닌지
    public boolean isBirthdayToday() {
        return LocalDate.now().equals(LocalDate.of(this.birthday.getYearOfBirthday(), this.birthday.getMonthOfBirthday(), this.birthday.getDayOfBirthday()));
    }
}
