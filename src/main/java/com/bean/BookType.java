package com.bean;

public class BookType {
    private Integer typeId;

    private String typeName;

    private Integer toborrowDays;

    public BookType() {
    }

    public BookType(Integer typeId, String typeName, Integer toborrowDays) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.toborrowDays = toborrowDays;
    }

    public BookType(Integer typeId, String typeName, String toborrowDays) {
        int days = Integer.parseInt(toborrowDays);
        this.typeId = typeId;
        this.typeName = typeName;
        this.toborrowDays = days;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public Integer getToborrowDays() {
        return toborrowDays;
    }

    public void setToborrowDays(Integer toborrowDays) {
        this.toborrowDays = toborrowDays;
    }
}