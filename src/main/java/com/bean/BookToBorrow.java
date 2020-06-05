package com.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class BookToBorrow {
    private Integer bookToborrowId;

    private Integer bookId;

    private Integer readerId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date borrowedDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date returnedDate;

    private Byte isReturned;

    private Book book;

    public BookToBorrow() {
    }

    public BookToBorrow(Integer bookToborrowId, Integer bookId, Integer readerId, Date borrowedDate, Date returnedDate, Byte isReturned) {
        this.bookToborrowId = bookToborrowId;
        this.bookId = bookId;
        this.readerId = readerId;
        this.borrowedDate = borrowedDate;
        this.returnedDate = returnedDate;
        this.isReturned = isReturned;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getBookToborrowId() {
        return bookToborrowId;
    }

    public void setBookToborrowId(Integer bookToborrowId) {
        this.bookToborrowId = bookToborrowId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public Date getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }

    public Byte getIsReturned() {
        return isReturned;
    }

    public void setIsReturned(Byte isReturned) {
        this.isReturned = isReturned;
    }

    @Override
    public String toString() {
        return "BookToBorrow{" +
                "bookToborrowId=" + bookToborrowId +
                ", bookId=" + bookId +
                ", readerId=" + readerId +
                ", borrowedDate=" + borrowedDate +
                ", returnedDate=" + returnedDate +
                ", isReturned=" + isReturned +
                '}';
    }
}