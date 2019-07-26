package com.samit.core.entities;

import com.google.gson.annotations.SerializedName;

public class Item extends BaseEntity{

    @SerializedName("id")
    private Long id;

    @SerializedName("pic_url")
    private String picUrl;

    @SerializedName("stock")
    private Long stock;

    @SerializedName("description")
    private String description;

    @SerializedName("price")
    private Double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public <T> void update(T dto) {
        Item item = (Item) dto;
        setIfNotNull(this::setPicUrl, item.getPicUrl());
        setIfNotNull(this::setStock, item.getStock());
        setIfNotNull(this::setDescription, item.getDescription());
        setIfNotNull(this::setPrice, item.getPrice());
    }
}
