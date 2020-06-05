package com.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReaderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReaderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andReaderIdIsNull() {
            addCriterion("reader_id is null");
            return (Criteria) this;
        }

        public Criteria andReaderIdIsNotNull() {
            addCriterion("reader_id is not null");
            return (Criteria) this;
        }

        public Criteria andReaderIdEqualTo(Integer value) {
            addCriterion("reader_id =", value, "readerId");
            return (Criteria) this;
        }

        public Criteria andReaderIdNotEqualTo(Integer value) {
            addCriterion("reader_id <>", value, "readerId");
            return (Criteria) this;
        }

        public Criteria andReaderIdGreaterThan(Integer value) {
            addCriterion("reader_id >", value, "readerId");
            return (Criteria) this;
        }

        public Criteria andReaderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("reader_id >=", value, "readerId");
            return (Criteria) this;
        }

        public Criteria andReaderIdLessThan(Integer value) {
            addCriterion("reader_id <", value, "readerId");
            return (Criteria) this;
        }

        public Criteria andReaderIdLessThanOrEqualTo(Integer value) {
            addCriterion("reader_id <=", value, "readerId");
            return (Criteria) this;
        }

        public Criteria andReaderIdIn(List<Integer> values) {
            addCriterion("reader_id in", values, "readerId");
            return (Criteria) this;
        }

        public Criteria andReaderIdNotIn(List<Integer> values) {
            addCriterion("reader_id not in", values, "readerId");
            return (Criteria) this;
        }

        public Criteria andReaderIdBetween(Integer value1, Integer value2) {
            addCriterion("reader_id between", value1, value2, "readerId");
            return (Criteria) this;
        }

        public Criteria andReaderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("reader_id not between", value1, value2, "readerId");
            return (Criteria) this;
        }

        public Criteria andReaderNameIsNull() {
            addCriterion("reader_name is null");
            return (Criteria) this;
        }

        public Criteria andReaderNameIsNotNull() {
            addCriterion("reader_name is not null");
            return (Criteria) this;
        }

        public Criteria andReaderNameEqualTo(String value) {
            addCriterion("reader_name =", value, "readerName");
            return (Criteria) this;
        }

        public Criteria andReaderNameNotEqualTo(String value) {
            addCriterion("reader_name <>", value, "readerName");
            return (Criteria) this;
        }

        public Criteria andReaderNameGreaterThan(String value) {
            addCriterion("reader_name >", value, "readerName");
            return (Criteria) this;
        }

        public Criteria andReaderNameGreaterThanOrEqualTo(String value) {
            addCriterion("reader_name >=", value, "readerName");
            return (Criteria) this;
        }

        public Criteria andReaderNameLessThan(String value) {
            addCriterion("reader_name <", value, "readerName");
            return (Criteria) this;
        }

        public Criteria andReaderNameLessThanOrEqualTo(String value) {
            addCriterion("reader_name <=", value, "readerName");
            return (Criteria) this;
        }

        public Criteria andReaderNameLike(String value) {
            addCriterion("reader_name like", value, "readerName");
            return (Criteria) this;
        }

        public Criteria andReaderNameNotLike(String value) {
            addCriterion("reader_name not like", value, "readerName");
            return (Criteria) this;
        }

        public Criteria andReaderNameIn(List<String> values) {
            addCriterion("reader_name in", values, "readerName");
            return (Criteria) this;
        }

        public Criteria andReaderNameNotIn(List<String> values) {
            addCriterion("reader_name not in", values, "readerName");
            return (Criteria) this;
        }

        public Criteria andReaderNameBetween(String value1, String value2) {
            addCriterion("reader_name between", value1, value2, "readerName");
            return (Criteria) this;
        }

        public Criteria andReaderNameNotBetween(String value1, String value2) {
            addCriterion("reader_name not between", value1, value2, "readerName");
            return (Criteria) this;
        }

        public Criteria andReaderGenderIsNull() {
            addCriterion("reader_gender is null");
            return (Criteria) this;
        }

        public Criteria andReaderGenderIsNotNull() {
            addCriterion("reader_gender is not null");
            return (Criteria) this;
        }

        public Criteria andReaderGenderEqualTo(String value) {
            addCriterion("reader_gender =", value, "readerGender");
            return (Criteria) this;
        }

        public Criteria andReaderGenderNotEqualTo(String value) {
            addCriterion("reader_gender <>", value, "readerGender");
            return (Criteria) this;
        }

        public Criteria andReaderGenderGreaterThan(String value) {
            addCriterion("reader_gender >", value, "readerGender");
            return (Criteria) this;
        }

        public Criteria andReaderGenderGreaterThanOrEqualTo(String value) {
            addCriterion("reader_gender >=", value, "readerGender");
            return (Criteria) this;
        }

        public Criteria andReaderGenderLessThan(String value) {
            addCriterion("reader_gender <", value, "readerGender");
            return (Criteria) this;
        }

        public Criteria andReaderGenderLessThanOrEqualTo(String value) {
            addCriterion("reader_gender <=", value, "readerGender");
            return (Criteria) this;
        }

        public Criteria andReaderGenderLike(String value) {
            addCriterion("reader_gender like", value, "readerGender");
            return (Criteria) this;
        }

        public Criteria andReaderGenderNotLike(String value) {
            addCriterion("reader_gender not like", value, "readerGender");
            return (Criteria) this;
        }

        public Criteria andReaderGenderIn(List<String> values) {
            addCriterion("reader_gender in", values, "readerGender");
            return (Criteria) this;
        }

        public Criteria andReaderGenderNotIn(List<String> values) {
            addCriterion("reader_gender not in", values, "readerGender");
            return (Criteria) this;
        }

        public Criteria andReaderGenderBetween(String value1, String value2) {
            addCriterion("reader_gender between", value1, value2, "readerGender");
            return (Criteria) this;
        }

        public Criteria andReaderGenderNotBetween(String value1, String value2) {
            addCriterion("reader_gender not between", value1, value2, "readerGender");
            return (Criteria) this;
        }

        public Criteria andReaderBarcodeIsNull() {
            addCriterion("reader_barcode is null");
            return (Criteria) this;
        }

        public Criteria andReaderBarcodeIsNotNull() {
            addCriterion("reader_barcode is not null");
            return (Criteria) this;
        }

        public Criteria andReaderBarcodeEqualTo(String value) {
            addCriterion("reader_barcode =", value, "readerBarcode");
            return (Criteria) this;
        }

        public Criteria andReaderBarcodeNotEqualTo(String value) {
            addCriterion("reader_barcode <>", value, "readerBarcode");
            return (Criteria) this;
        }

        public Criteria andReaderBarcodeGreaterThan(String value) {
            addCriterion("reader_barcode >", value, "readerBarcode");
            return (Criteria) this;
        }

        public Criteria andReaderBarcodeGreaterThanOrEqualTo(String value) {
            addCriterion("reader_barcode >=", value, "readerBarcode");
            return (Criteria) this;
        }

        public Criteria andReaderBarcodeLessThan(String value) {
            addCriterion("reader_barcode <", value, "readerBarcode");
            return (Criteria) this;
        }

        public Criteria andReaderBarcodeLessThanOrEqualTo(String value) {
            addCriterion("reader_barcode <=", value, "readerBarcode");
            return (Criteria) this;
        }

        public Criteria andReaderBarcodeLike(String value) {
            addCriterion("reader_barcode like", value, "readerBarcode");
            return (Criteria) this;
        }

        public Criteria andReaderBarcodeNotLike(String value) {
            addCriterion("reader_barcode not like", value, "readerBarcode");
            return (Criteria) this;
        }

        public Criteria andReaderBarcodeIn(List<String> values) {
            addCriterion("reader_barcode in", values, "readerBarcode");
            return (Criteria) this;
        }

        public Criteria andReaderBarcodeNotIn(List<String> values) {
            addCriterion("reader_barcode not in", values, "readerBarcode");
            return (Criteria) this;
        }

        public Criteria andReaderBarcodeBetween(String value1, String value2) {
            addCriterion("reader_barcode between", value1, value2, "readerBarcode");
            return (Criteria) this;
        }

        public Criteria andReaderBarcodeNotBetween(String value1, String value2) {
            addCriterion("reader_barcode not between", value1, value2, "readerBarcode");
            return (Criteria) this;
        }

        public Criteria andReaderProfessionIsNull() {
            addCriterion("reader_profession is null");
            return (Criteria) this;
        }

        public Criteria andReaderProfessionIsNotNull() {
            addCriterion("reader_profession is not null");
            return (Criteria) this;
        }

        public Criteria andReaderProfessionEqualTo(String value) {
            addCriterion("reader_profession =", value, "readerProfession");
            return (Criteria) this;
        }

        public Criteria andReaderProfessionNotEqualTo(String value) {
            addCriterion("reader_profession <>", value, "readerProfession");
            return (Criteria) this;
        }

        public Criteria andReaderProfessionGreaterThan(String value) {
            addCriterion("reader_profession >", value, "readerProfession");
            return (Criteria) this;
        }

        public Criteria andReaderProfessionGreaterThanOrEqualTo(String value) {
            addCriterion("reader_profession >=", value, "readerProfession");
            return (Criteria) this;
        }

        public Criteria andReaderProfessionLessThan(String value) {
            addCriterion("reader_profession <", value, "readerProfession");
            return (Criteria) this;
        }

        public Criteria andReaderProfessionLessThanOrEqualTo(String value) {
            addCriterion("reader_profession <=", value, "readerProfession");
            return (Criteria) this;
        }

        public Criteria andReaderProfessionLike(String value) {
            addCriterion("reader_profession like", value, "readerProfession");
            return (Criteria) this;
        }

        public Criteria andReaderProfessionNotLike(String value) {
            addCriterion("reader_profession not like", value, "readerProfession");
            return (Criteria) this;
        }

        public Criteria andReaderProfessionIn(List<String> values) {
            addCriterion("reader_profession in", values, "readerProfession");
            return (Criteria) this;
        }

        public Criteria andReaderProfessionNotIn(List<String> values) {
            addCriterion("reader_profession not in", values, "readerProfession");
            return (Criteria) this;
        }

        public Criteria andReaderProfessionBetween(String value1, String value2) {
            addCriterion("reader_profession between", value1, value2, "readerProfession");
            return (Criteria) this;
        }

        public Criteria andReaderProfessionNotBetween(String value1, String value2) {
            addCriterion("reader_profession not between", value1, value2, "readerProfession");
            return (Criteria) this;
        }

        public Criteria andReaderBirthIsNull() {
            addCriterion("reader_birth is null");
            return (Criteria) this;
        }

        public Criteria andReaderBirthIsNotNull() {
            addCriterion("reader_birth is not null");
            return (Criteria) this;
        }

        public Criteria andReaderBirthEqualTo(Date value) {
            addCriterion("reader_birth =", value, "readerBirth");
            return (Criteria) this;
        }

        public Criteria andReaderBirthNotEqualTo(Date value) {
            addCriterion("reader_birth <>", value, "readerBirth");
            return (Criteria) this;
        }

        public Criteria andReaderBirthGreaterThan(Date value) {
            addCriterion("reader_birth >", value, "readerBirth");
            return (Criteria) this;
        }

        public Criteria andReaderBirthGreaterThanOrEqualTo(Date value) {
            addCriterion("reader_birth >=", value, "readerBirth");
            return (Criteria) this;
        }

        public Criteria andReaderBirthLessThan(Date value) {
            addCriterion("reader_birth <", value, "readerBirth");
            return (Criteria) this;
        }

        public Criteria andReaderBirthLessThanOrEqualTo(Date value) {
            addCriterion("reader_birth <=", value, "readerBirth");
            return (Criteria) this;
        }

        public Criteria andReaderBirthIn(List<Date> values) {
            addCriterion("reader_birth in", values, "readerBirth");
            return (Criteria) this;
        }

        public Criteria andReaderBirthNotIn(List<Date> values) {
            addCriterion("reader_birth not in", values, "readerBirth");
            return (Criteria) this;
        }

        public Criteria andReaderBirthBetween(Date value1, Date value2) {
            addCriterion("reader_birth between", value1, value2, "readerBirth");
            return (Criteria) this;
        }

        public Criteria andReaderBirthNotBetween(Date value1, Date value2) {
            addCriterion("reader_birth not between", value1, value2, "readerBirth");
            return (Criteria) this;
        }

        public Criteria andReaderDocumentTypeIsNull() {
            addCriterion("reader_document_type is null");
            return (Criteria) this;
        }

        public Criteria andReaderDocumentTypeIsNotNull() {
            addCriterion("reader_document_type is not null");
            return (Criteria) this;
        }

        public Criteria andReaderDocumentTypeEqualTo(String value) {
            addCriterion("reader_document_type =", value, "readerDocumentType");
            return (Criteria) this;
        }

        public Criteria andReaderDocumentTypeNotEqualTo(String value) {
            addCriterion("reader_document_type <>", value, "readerDocumentType");
            return (Criteria) this;
        }

        public Criteria andReaderDocumentTypeGreaterThan(String value) {
            addCriterion("reader_document_type >", value, "readerDocumentType");
            return (Criteria) this;
        }

        public Criteria andReaderDocumentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("reader_document_type >=", value, "readerDocumentType");
            return (Criteria) this;
        }

        public Criteria andReaderDocumentTypeLessThan(String value) {
            addCriterion("reader_document_type <", value, "readerDocumentType");
            return (Criteria) this;
        }

        public Criteria andReaderDocumentTypeLessThanOrEqualTo(String value) {
            addCriterion("reader_document_type <=", value, "readerDocumentType");
            return (Criteria) this;
        }

        public Criteria andReaderDocumentTypeLike(String value) {
            addCriterion("reader_document_type like", value, "readerDocumentType");
            return (Criteria) this;
        }

        public Criteria andReaderDocumentTypeNotLike(String value) {
            addCriterion("reader_document_type not like", value, "readerDocumentType");
            return (Criteria) this;
        }

        public Criteria andReaderDocumentTypeIn(List<String> values) {
            addCriterion("reader_document_type in", values, "readerDocumentType");
            return (Criteria) this;
        }

        public Criteria andReaderDocumentTypeNotIn(List<String> values) {
            addCriterion("reader_document_type not in", values, "readerDocumentType");
            return (Criteria) this;
        }

        public Criteria andReaderDocumentTypeBetween(String value1, String value2) {
            addCriterion("reader_document_type between", value1, value2, "readerDocumentType");
            return (Criteria) this;
        }

        public Criteria andReaderDocumentTypeNotBetween(String value1, String value2) {
            addCriterion("reader_document_type not between", value1, value2, "readerDocumentType");
            return (Criteria) this;
        }

        public Criteria andReaderDocumentNumberIsNull() {
            addCriterion("reader_document_number is null");
            return (Criteria) this;
        }

        public Criteria andReaderDocumentNumberIsNotNull() {
            addCriterion("reader_document_number is not null");
            return (Criteria) this;
        }

        public Criteria andReaderDocumentNumberEqualTo(String value) {
            addCriterion("reader_document_number =", value, "readerDocumentNumber");
            return (Criteria) this;
        }

        public Criteria andReaderDocumentNumberNotEqualTo(String value) {
            addCriterion("reader_document_number <>", value, "readerDocumentNumber");
            return (Criteria) this;
        }

        public Criteria andReaderDocumentNumberGreaterThan(String value) {
            addCriterion("reader_document_number >", value, "readerDocumentNumber");
            return (Criteria) this;
        }

        public Criteria andReaderDocumentNumberGreaterThanOrEqualTo(String value) {
            addCriterion("reader_document_number >=", value, "readerDocumentNumber");
            return (Criteria) this;
        }

        public Criteria andReaderDocumentNumberLessThan(String value) {
            addCriterion("reader_document_number <", value, "readerDocumentNumber");
            return (Criteria) this;
        }

        public Criteria andReaderDocumentNumberLessThanOrEqualTo(String value) {
            addCriterion("reader_document_number <=", value, "readerDocumentNumber");
            return (Criteria) this;
        }

        public Criteria andReaderDocumentNumberLike(String value) {
            addCriterion("reader_document_number like", value, "readerDocumentNumber");
            return (Criteria) this;
        }

        public Criteria andReaderDocumentNumberNotLike(String value) {
            addCriterion("reader_document_number not like", value, "readerDocumentNumber");
            return (Criteria) this;
        }

        public Criteria andReaderDocumentNumberIn(List<String> values) {
            addCriterion("reader_document_number in", values, "readerDocumentNumber");
            return (Criteria) this;
        }

        public Criteria andReaderDocumentNumberNotIn(List<String> values) {
            addCriterion("reader_document_number not in", values, "readerDocumentNumber");
            return (Criteria) this;
        }

        public Criteria andReaderDocumentNumberBetween(String value1, String value2) {
            addCriterion("reader_document_number between", value1, value2, "readerDocumentNumber");
            return (Criteria) this;
        }

        public Criteria andReaderDocumentNumberNotBetween(String value1, String value2) {
            addCriterion("reader_document_number not between", value1, value2, "readerDocumentNumber");
            return (Criteria) this;
        }

        public Criteria andReaderEmailIsNull() {
            addCriterion("reader_email is null");
            return (Criteria) this;
        }

        public Criteria andReaderEmailIsNotNull() {
            addCriterion("reader_email is not null");
            return (Criteria) this;
        }

        public Criteria andReaderEmailEqualTo(String value) {
            addCriterion("reader_email =", value, "readerEmail");
            return (Criteria) this;
        }

        public Criteria andReaderEmailNotEqualTo(String value) {
            addCriterion("reader_email <>", value, "readerEmail");
            return (Criteria) this;
        }

        public Criteria andReaderEmailGreaterThan(String value) {
            addCriterion("reader_email >", value, "readerEmail");
            return (Criteria) this;
        }

        public Criteria andReaderEmailGreaterThanOrEqualTo(String value) {
            addCriterion("reader_email >=", value, "readerEmail");
            return (Criteria) this;
        }

        public Criteria andReaderEmailLessThan(String value) {
            addCriterion("reader_email <", value, "readerEmail");
            return (Criteria) this;
        }

        public Criteria andReaderEmailLessThanOrEqualTo(String value) {
            addCriterion("reader_email <=", value, "readerEmail");
            return (Criteria) this;
        }

        public Criteria andReaderEmailLike(String value) {
            addCriterion("reader_email like", value, "readerEmail");
            return (Criteria) this;
        }

        public Criteria andReaderEmailNotLike(String value) {
            addCriterion("reader_email not like", value, "readerEmail");
            return (Criteria) this;
        }

        public Criteria andReaderEmailIn(List<String> values) {
            addCriterion("reader_email in", values, "readerEmail");
            return (Criteria) this;
        }

        public Criteria andReaderEmailNotIn(List<String> values) {
            addCriterion("reader_email not in", values, "readerEmail");
            return (Criteria) this;
        }

        public Criteria andReaderEmailBetween(String value1, String value2) {
            addCriterion("reader_email between", value1, value2, "readerEmail");
            return (Criteria) this;
        }

        public Criteria andReaderEmailNotBetween(String value1, String value2) {
            addCriterion("reader_email not between", value1, value2, "readerEmail");
            return (Criteria) this;
        }

        public Criteria andReaderRegisterDateIsNull() {
            addCriterion("reader_register_date is null");
            return (Criteria) this;
        }

        public Criteria andReaderRegisterDateIsNotNull() {
            addCriterion("reader_register_date is not null");
            return (Criteria) this;
        }

        public Criteria andReaderRegisterDateEqualTo(Date value) {
            addCriterion("reader_register_date =", value, "readerRegisterDate");
            return (Criteria) this;
        }

        public Criteria andReaderRegisterDateNotEqualTo(Date value) {
            addCriterion("reader_register_date <>", value, "readerRegisterDate");
            return (Criteria) this;
        }

        public Criteria andReaderRegisterDateGreaterThan(Date value) {
            addCriterion("reader_register_date >", value, "readerRegisterDate");
            return (Criteria) this;
        }

        public Criteria andReaderRegisterDateGreaterThanOrEqualTo(Date value) {
            addCriterion("reader_register_date >=", value, "readerRegisterDate");
            return (Criteria) this;
        }

        public Criteria andReaderRegisterDateLessThan(Date value) {
            addCriterion("reader_register_date <", value, "readerRegisterDate");
            return (Criteria) this;
        }

        public Criteria andReaderRegisterDateLessThanOrEqualTo(Date value) {
            addCriterion("reader_register_date <=", value, "readerRegisterDate");
            return (Criteria) this;
        }

        public Criteria andReaderRegisterDateIn(List<Date> values) {
            addCriterion("reader_register_date in", values, "readerRegisterDate");
            return (Criteria) this;
        }

        public Criteria andReaderRegisterDateNotIn(List<Date> values) {
            addCriterion("reader_register_date not in", values, "readerRegisterDate");
            return (Criteria) this;
        }

        public Criteria andReaderRegisterDateBetween(Date value1, Date value2) {
            addCriterion("reader_register_date between", value1, value2, "readerRegisterDate");
            return (Criteria) this;
        }

        public Criteria andReaderRegisterDateNotBetween(Date value1, Date value2) {
            addCriterion("reader_register_date not between", value1, value2, "readerRegisterDate");
            return (Criteria) this;
        }

        public Criteria andBorrowedBookCountIsNull() {
            addCriterion("borrowed_book_count is null");
            return (Criteria) this;
        }

        public Criteria andBorrowedBookCountIsNotNull() {
            addCriterion("borrowed_book_count is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowedBookCountEqualTo(Integer value) {
            addCriterion("borrowed_book_count =", value, "borrowedBookCount");
            return (Criteria) this;
        }

        public Criteria andBorrowedBookCountNotEqualTo(Integer value) {
            addCriterion("borrowed_book_count <>", value, "borrowedBookCount");
            return (Criteria) this;
        }

        public Criteria andBorrowedBookCountGreaterThan(Integer value) {
            addCriterion("borrowed_book_count >", value, "borrowedBookCount");
            return (Criteria) this;
        }

        public Criteria andBorrowedBookCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("borrowed_book_count >=", value, "borrowedBookCount");
            return (Criteria) this;
        }

        public Criteria andBorrowedBookCountLessThan(Integer value) {
            addCriterion("borrowed_book_count <", value, "borrowedBookCount");
            return (Criteria) this;
        }

        public Criteria andBorrowedBookCountLessThanOrEqualTo(Integer value) {
            addCriterion("borrowed_book_count <=", value, "borrowedBookCount");
            return (Criteria) this;
        }

        public Criteria andBorrowedBookCountIn(List<Integer> values) {
            addCriterion("borrowed_book_count in", values, "borrowedBookCount");
            return (Criteria) this;
        }

        public Criteria andBorrowedBookCountNotIn(List<Integer> values) {
            addCriterion("borrowed_book_count not in", values, "borrowedBookCount");
            return (Criteria) this;
        }

        public Criteria andBorrowedBookCountBetween(Integer value1, Integer value2) {
            addCriterion("borrowed_book_count between", value1, value2, "borrowedBookCount");
            return (Criteria) this;
        }

        public Criteria andBorrowedBookCountNotBetween(Integer value1, Integer value2) {
            addCriterion("borrowed_book_count not between", value1, value2, "borrowedBookCount");
            return (Criteria) this;
        }

        public Criteria andRemainingBookCountIsNull() {
            addCriterion("remaining_book_count is null");
            return (Criteria) this;
        }

        public Criteria andRemainingBookCountIsNotNull() {
            addCriterion("remaining_book_count is not null");
            return (Criteria) this;
        }

        public Criteria andRemainingBookCountEqualTo(Integer value) {
            addCriterion("remaining_book_count =", value, "remainingBookCount");
            return (Criteria) this;
        }

        public Criteria andRemainingBookCountNotEqualTo(Integer value) {
            addCriterion("remaining_book_count <>", value, "remainingBookCount");
            return (Criteria) this;
        }

        public Criteria andRemainingBookCountGreaterThan(Integer value) {
            addCriterion("remaining_book_count >", value, "remainingBookCount");
            return (Criteria) this;
        }

        public Criteria andRemainingBookCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("remaining_book_count >=", value, "remainingBookCount");
            return (Criteria) this;
        }

        public Criteria andRemainingBookCountLessThan(Integer value) {
            addCriterion("remaining_book_count <", value, "remainingBookCount");
            return (Criteria) this;
        }

        public Criteria andRemainingBookCountLessThanOrEqualTo(Integer value) {
            addCriterion("remaining_book_count <=", value, "remainingBookCount");
            return (Criteria) this;
        }

        public Criteria andRemainingBookCountIn(List<Integer> values) {
            addCriterion("remaining_book_count in", values, "remainingBookCount");
            return (Criteria) this;
        }

        public Criteria andRemainingBookCountNotIn(List<Integer> values) {
            addCriterion("remaining_book_count not in", values, "remainingBookCount");
            return (Criteria) this;
        }

        public Criteria andRemainingBookCountBetween(Integer value1, Integer value2) {
            addCriterion("remaining_book_count between", value1, value2, "remainingBookCount");
            return (Criteria) this;
        }

        public Criteria andRemainingBookCountNotBetween(Integer value1, Integer value2) {
            addCriterion("remaining_book_count not between", value1, value2, "remainingBookCount");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNull() {
            addCriterion("operator_id is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNotNull() {
            addCriterion("operator_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdEqualTo(Integer value) {
            addCriterion("operator_id =", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotEqualTo(Integer value) {
            addCriterion("operator_id <>", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThan(Integer value) {
            addCriterion("operator_id >", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("operator_id >=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThan(Integer value) {
            addCriterion("operator_id <", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThanOrEqualTo(Integer value) {
            addCriterion("operator_id <=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIn(List<Integer> values) {
            addCriterion("operator_id in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotIn(List<Integer> values) {
            addCriterion("operator_id not in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdBetween(Integer value1, Integer value2) {
            addCriterion("operator_id between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("operator_id not between", value1, value2, "operatorId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}