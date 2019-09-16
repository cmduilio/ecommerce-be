package com.samit.core.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Item extends BaseEntity{

    @SerializedName("id")
    private Long id;

    @SerializedName("pic_url")
    private List<String> picUrl;

    @SerializedName("stock")
    private Long stock;

    @SerializedName("description")
    private String description;

    @SerializedName("price")
    private Double price;

    @SerializedName("active")
    private Boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(List<String> picUrl) {
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public <T> void update(T dto) {
        Item item = (Item) dto;
        setIfNotNull(this::setPicUrl, item.getPicUrl());
        setIfNotNull(this::setStock, item.getStock());
        setIfNotNull(this::setDescription, item.getDescription());
        setIfNotNull(this::setPrice, item.getPrice());
        setIfNotNull(this::setActive, item.getActive());
    }
}
