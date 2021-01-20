package com.sonbro.eatgo.domain;

import com.sun.el.lang.ELArithmetic;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private final String name;
    private final Long id;
    private final String address;
    private final List<MenuItem> menuItems = new ArrayList<MenuItem>();

    public Restaurant(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Long getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getAddress() {
        return this.address;
    }

    public String getInformation() {
        return this.name + " in " + this.address;
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        for (MenuItem menuItem : menuItems) {
            addMenuItem(menuItem);
        }
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

}
