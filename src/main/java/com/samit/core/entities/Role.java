package com.samit.core.entities;
import com.google.gson.annotations.SerializedName;

public class Role {

    @SerializedName("id")
    private Long id;

    @SerializedName("name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
