package com.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Book {
    private Integer bookId;

    private String bookName;

    private Integer typeId;

    private String bookAuthor;

    private String bookPress;

    private Float bookPrice;

    private String bookLanguage;

    private String bookPdfurl;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date bookEntryTime;

    private Integer toborrowTimes;

    private Integer operatorId;

    private Integer borrowedTimes;

    private Integer bookCaseId;

    //书架
    private Bookcase bookcase;
    //操作者
    private Manager manager;
    //类型
    private BookType bookType;

    public Book() {
    }

    public Book(Integer bookId, String bookName, Integer typeId, String bookAuthor, String bookPress, Float bookPrice, String bookLanguage, String bookPdfurl, Date bookEntryTime, Integer toborrowTimes, Integer operatorId, Integer borrowedTimes, Integer bookCaseId) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.typeId = typeId;
        this.bookAuthor = bookAuthor;
        this.bookPress = bookPress;
        this.bookPrice = bookPrice;
        this.bookLanguage = bookLanguage;
        this.bookPdfurl = bookPdfurl;
        this.bookEntryTime = bookEntryTime;
        this.toborrowTimes = toborrowTimes;
        this.operatorId = operatorId;
        this.borrowedTimes = borrowedTimes;
        this.bookCaseId = bookCaseId;
    }

    public Bookcase getBookcase() {
        return bookcase;
    }

    public void setBookcase(Bookcase bookcase) {
        this.bookcase = bookcase;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
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

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor == null ? null : bookAuthor.trim();
    }

    public String getBookPress() {
        return bookPress;
    }

    public void setBookPress(String bookPress) {
        this.bookPress = bookPress == null ? null : bookPress.trim();
    }

    public Float getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Float bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookLanguage() {
        return bookLanguage;
    }

    public void setBookLanguage(String bookLanguage) {
        this.bookLanguage = bookLanguage == null ? null : bookLanguage.trim();
    }

    public String getBookPdfurl() {
        return bookPdfurl;
    }

    public void setBookPdfurl(String bookPdfurl) {
        this.bookPdfurl = bookPdfurl == null ? null : bookPdfurl.trim();
    }

    public Date getBookEntryTime() {
        return bookEntryTime;
    }

    public void setBookEntryTime(Date bookEntryTime) {
        this.bookEntryTime = bookEntryTime;
    }

    public Integer getToborrowTimes() {
        return toborrowTimes;
    }

    public void setToborrowTimes(Integer toborrowTimes) {
        this.toborrowTimes = toborrowTimes;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public Integer getBorrowedTimes() {
        return borrowedTimes;
    }

    public void setBorrowedTimes(Integer borrowedTimes) {
        this.borrowedTimes = borrowedTimes;
    }

    public Integer getBookCaseId() {
        return bookCaseId;
    }

    public void setBookCaseId(Integer bookCaseId) {
        this.bookCaseId = bookCaseId;
    }
}