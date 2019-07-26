package com.samit.core.entities;

import com.google.gson.annotations.SerializedName;

public class User extends BaseEntity{

    @SerializedName("id")
    private Long id;

    @SerializedName("username")
    private String username;

    @SerializedName("pw")
    private String password;

    @SerializedName("mail")
    private String mail;

    @SerializedName("role_id")
    private Long roleId;

    @SerializedName("country_id")
    private Long countryId;

    @SerializedName("province_id")
    private Long provinceId;

    @SerializedName("city_id")
    private Long cityId;

    @SerializedName("street")
    private String street;

    @SerializedName("zip_code")
    private String zipCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Long getRoleId() {
        return roleId;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public <T> void update(T dto) {
        User user = (User) dto;
        setIfNotNull(this::setUsername, user.getUsername());
        setIfNotNull(this::setPassword, user.getPassword());
        setIfNotNull(this::setMail, user.getMail());
        setIfNotNull(this::setRoleId, user.getRoleId());
        setIfNotNull(this::setCountryId, user.getCountryId());
        setIfNotNull(this::setProvinceId, user.getProvinceId());
        setIfNotNull(this::setCityId, user.getCityId());
        setIfNotNull(this::setStreet, user.getStreet());
        setIfNotNull(this::setZipCode, user.getZipCode());
    }
}
