package com.sonbro.reservation.domain;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Restaurant {
    private Long id;
    private String name;
    private String location;
}
