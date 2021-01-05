package com.sonbro.managed.friend.repository;

import com.sonbro.managed.friend.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByName(String name);

    List<Person> findByBlockIsNull();

    List<Person> findByBloodType(String bloodType);

    @Query(value = "select person from Person person where person.birthday.monthOfBirthday = ?1")
    List<Person> findByMonthOfBirthday(int monthOfBirthday);

    // JPQL ( nativeQuery option을 true로 주면 JPQL이 아닌 실제 row query로 가능 )
    @Query(value = "select person from Person person where person.birthday.monthOfBirthday = :monthOfBirthday and person.birthday.dayOfBirthday between :startDayOfBirthday and :endDayOfBirthday")
    List<Person> findByRangeOfBirthday(@Param("monthOfBirthday") int monthOfBirthday, @Param("startDayOfBirthday") int startDayOfBirthday, @Param("endDayOfBirthday") int endDayOfBirthday);
}
