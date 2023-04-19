package com.example.carstp.model;

public class Car {
    private int id;
    private String name;
    private String  detail_text;
    private String photo;
    private int price;
    private int category_id;

    public Car(int id, String name, String detail_text, String photo, int price, int category_id) {
        this.id = id;
        this.name = name;
        this.detail_text = detail_text;
        this.photo = photo;
        this.price = price;
        this.category_id = category_id;
    }

    public Car(String name, String detail_text, String photo, int price, int category_id) {
        this.name = name;
        this.detail_text = detail_text;
        this.photo = photo;
        this.price = price;
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
