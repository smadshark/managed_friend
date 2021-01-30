package com.sonbro.reservation.domain;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class MenuItem {
    private Long id;
    private String name;
    private Integer price;
}
