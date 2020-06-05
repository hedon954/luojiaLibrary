package com.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reader {
    private Integer readerId;

    private String readerName;

    private String readerGender;

    private String readerBarcode;

    private String readerProfession;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date readerBirth;

    private String readerDocumentType;

    private String readerDocumentNumber;

    private String readerEmail;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date readerRegisterDate;

    private Integer borrowedBookCount;

    private Integer remainingBookCount;

    private Integer operatorId;

    //添加一个 Manager 属性，用作联合查询
    private Manager manager;


    public Reader() {
    }

    public Reader(Integer readerId, String readerName, String readerGender, String readerBarcode, String readerProfession, Date readerBirth, String readerDocumentType, String readerDocumentNumber, String readerEmail, Date readerRegisterDate, Integer borrowedBookCount, Integer remainingBookCount, Integer operatorId) {
        this.readerId = readerId;
        this.readerName = readerName;
        this.readerGender = readerGender;
        this.readerBarcode = readerBarcode;
        this.readerProfession = readerProfession;
        this.readerBirth = readerBirth;
        this.readerDocumentType = readerDocumentType;
        this.readerDocumentNumber = readerDocumentNumber;
        this.readerEmail = readerEmail;
        this.readerRegisterDate = readerRegisterDate;
        this.borrowedBookCount = borrowedBookCount;
        this.remainingBookCount = remainingBookCount;
        this.operatorId = operatorId;
    }


    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName == null ? null : readerName.trim();
    }

    public String getReaderGender() {
        return readerGender;
    }

    public void setReaderGender(String readerGender) {
        this.readerGender = readerGender == null ? null : readerGender.trim();
    }

    public String getReaderBarcode() {
        return readerBarcode;
    }

    public void setReaderBarcode(String readerBarcode) {
        this.readerBarcode = readerBarcode == null ? null : readerBarcode.trim();
    }

    public String getReaderProfession() {
        return readerProfession;
    }

    public void setReaderProfession(String readerProfession) {
        this.readerProfession = readerProfession == null ? null : readerProfession.trim();
    }

    public Date getReaderBirth() {
        return readerBirth;
    }

    public void setReaderBirth(Date readerBirth) {
        this.readerBirth = readerBirth;
    }

    public String getReaderDocumentType() {
        return readerDocumentType;
    }

    public void setReaderDocumentType(String readerDocumentType) {
        this.readerDocumentType = readerDocumentType == null ? null : readerDocumentType.trim();
    }

    public String getReaderDocumentNumber() {
        return readerDocumentNumber;
    }

    public void setReaderDocumentNumber(String readerDocumentNumber) {
        this.readerDocumentNumber = readerDocumentNumber == null ? null : readerDocumentNumber.trim();
    }

    public String getReaderEmail() {
        return readerEmail;
    }

    public void setReaderEmail(String readerEmail) {
        this.readerEmail = readerEmail == null ? null : readerEmail.trim();
    }


    public Date getReaderRegisterDate() {
        return readerRegisterDate;
    }

    public void setReaderRegisterDate(Date readerRegisterDate) {
        this.readerRegisterDate = readerRegisterDate;
    }

    public Integer getBorrowedBookCount() {
        return borrowedBookCount;
    }

    public void setBorrowedBookCount(Integer borrowedBookCount) {
        this.borrowedBookCount = borrowedBookCount;
    }

    public Integer getRemainingBookCount() {
        return remainingBookCount;
    }

    public void setRemainingBookCount(Integer remainingBookCount) {
        this.remainingBookCount = remainingBookCount;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "readerId=" + readerId +
                ", readerName='" + readerName + '\'' +
                ", readerGender='" + readerGender + '\'' +
                ", readerBarcode='" + readerBarcode + '\'' +
                ", readerProfession='" + readerProfession + '\'' +
                ", readerBirth=" + readerBirth +
                ", readerDocumentType='" + readerDocumentType + '\'' +
                ", readerDocumentNumber='" + readerDocumentNumber + '\'' +
                ", readerEmail='" + readerEmail + '\'' +
                ", readerRegisterDate=" + readerRegisterDate +
                ", borrowedBookCount=" + borrowedBookCount +
                ", remainingBookCount=" + remainingBookCount +
                ", operatorId=" + operatorId +
                '}';
    }
}