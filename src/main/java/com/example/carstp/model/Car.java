package com.example.carstp.model;

public class Car {
    private int id;
    private String name;
    private String  detail_text;
    public String photo;
    private int price;
    public int category_id;

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

    public Car() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetail_text() {
        return detail_text;
    }

    public void setDetail_text(String detail_text) {
        this.detail_text = detail_text;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public void setCategoryId(int categoryId) {
    }
}
