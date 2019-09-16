package com.samit.core.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Order extends BaseEntity{

    @SerializedName("id")
    private Long id;

    @SerializedName("user_id")
    private Long userId;

    @SerializedName("items")
    private List<Item> items;

    @SerializedName("amount")
    private Double amount;

    @SerializedName("active")
    private Boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public <T> void update(T dto) {
        Order item = (Order) dto;
        setIfNotNull(this::setUserId, item.getUserId());
        setIfNotNull(this::setItems, item.getItems());
        setIfNotNull(this::setAmount, item.getAmount());
        setIfNotNull(this::setActive, item.getActive());
    }
}
