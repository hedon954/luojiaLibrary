package com.bean;

public class Bookcase {
    private Integer bookcaseId;

    private String bookcaseName;

    public Integer getBookcaseId() {
        return bookcaseId;
    }

    public void setBookcaseId(Integer bookcaseId) {
        this.bookcaseId = bookcaseId;
    }

    public String getBookcaseName() {
        return bookcaseName;
    }

    public void setBookcaseName(String bookcaseName) {
        this.bookcaseName = bookcaseName == null ? null : bookcaseName.trim();
    }
}