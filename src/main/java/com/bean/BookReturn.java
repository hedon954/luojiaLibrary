package com.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class BookReturn {
    private Integer bookReturnId;

    private Integer bookId;

    private String bookName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GTM+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date toborrowDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GTM+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date toreturnDate;

    private Integer borrowerId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GTM+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date retrunDate;


    public BookReturn() {
    }

    public BookReturn(Integer bookReturnId, Integer bookId, String bookName, Date toborrowDate, Date toreturnDate, Integer borrowerId, Date retrunDate) {
        this.bookReturnId = bookReturnId;
        this.bookId = bookId;
        this.bookName = bookName;
        this.toborrowDate = toborrowDate;
        this.toreturnDate = toreturnDate;
        this.borrowerId = borrowerId;
        this.retrunDate = retrunDate;
    }

    public Integer getBookReturnId() {
        return bookReturnId;
    }

    public void setBookReturnId(Integer bookReturnId) {
        this.bookReturnId = bookReturnId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public Date getToborrowDate() {
        return toborrowDate;
    }

    public void setToborrowDate(Date toborrowDate) {
        this.toborrowDate = toborrowDate;
    }

    public Date getToreturnDate() {
        return toreturnDate;
    }

    public void setToreturnDate(Date toreturnDate) {
        this.toreturnDate = toreturnDate;
    }

    public Integer getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(Integer borrowerId) {
        this.borrowerId = borrowerId;
    }

    public Date getRetrunDate() {
        return retrunDate;
    }

    public void setRetrunDate(Date retrunDate) {
        this.retrunDate = retrunDate;
    }
}