package com.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BookExample() {
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

        public Criteria andBookIdIsNull() {
            addCriterion("book_id is null");
            return (Criteria) this;
        }

        public Criteria andBookIdIsNotNull() {
            addCriterion("book_id is not null");
            return (Criteria) this;
        }

        public Criteria andBookIdEqualTo(Integer value) {
            addCriterion("book_id =", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotEqualTo(Integer value) {
            addCriterion("book_id <>", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThan(Integer value) {
            addCriterion("book_id >", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_id >=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThan(Integer value) {
            addCriterion("book_id <", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThanOrEqualTo(Integer value) {
            addCriterion("book_id <=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdIn(List<Integer> values) {
            addCriterion("book_id in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotIn(List<Integer> values) {
            addCriterion("book_id not in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdBetween(Integer value1, Integer value2) {
            addCriterion("book_id between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotBetween(Integer value1, Integer value2) {
            addCriterion("book_id not between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNull() {
            addCriterion("book_name is null");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNotNull() {
            addCriterion("book_name is not null");
            return (Criteria) this;
        }

        public Criteria andBookNameEqualTo(String value) {
            addCriterion("book_name =", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotEqualTo(String value) {
            addCriterion("book_name <>", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThan(String value) {
            addCriterion("book_name >", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThanOrEqualTo(String value) {
            addCriterion("book_name >=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThan(String value) {
            addCriterion("book_name <", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThanOrEqualTo(String value) {
            addCriterion("book_name <=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLike(String value) {
            addCriterion("book_name like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotLike(String value) {
            addCriterion("book_name not like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameIn(List<String> values) {
            addCriterion("book_name in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotIn(List<String> values) {
            addCriterion("book_name not in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameBetween(String value1, String value2) {
            addCriterion("book_name between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotBetween(String value1, String value2) {
            addCriterion("book_name not between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(Integer value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Integer value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Integer value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Integer value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<Integer> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<Integer> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andBookAuthorIsNull() {
            addCriterion("book_author is null");
            return (Criteria) this;
        }

        public Criteria andBookAuthorIsNotNull() {
            addCriterion("book_author is not null");
            return (Criteria) this;
        }

        public Criteria andBookAuthorEqualTo(String value) {
            addCriterion("book_author =", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorNotEqualTo(String value) {
            addCriterion("book_author <>", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorGreaterThan(String value) {
            addCriterion("book_author >", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("book_author >=", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorLessThan(String value) {
            addCriterion("book_author <", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorLessThanOrEqualTo(String value) {
            addCriterion("book_author <=", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorLike(String value) {
            addCriterion("book_author like", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorNotLike(String value) {
            addCriterion("book_author not like", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorIn(List<String> values) {
            addCriterion("book_author in", values, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorNotIn(List<String> values) {
            addCriterion("book_author not in", values, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorBetween(String value1, String value2) {
            addCriterion("book_author between", value1, value2, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorNotBetween(String value1, String value2) {
            addCriterion("book_author not between", value1, value2, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookPressIsNull() {
            addCriterion("book_press is null");
            return (Criteria) this;
        }

        public Criteria andBookPressIsNotNull() {
            addCriterion("book_press is not null");
            return (Criteria) this;
        }

        public Criteria andBookPressEqualTo(String value) {
            addCriterion("book_press =", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressNotEqualTo(String value) {
            addCriterion("book_press <>", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressGreaterThan(String value) {
            addCriterion("book_press >", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressGreaterThanOrEqualTo(String value) {
            addCriterion("book_press >=", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressLessThan(String value) {
            addCriterion("book_press <", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressLessThanOrEqualTo(String value) {
            addCriterion("book_press <=", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressLike(String value) {
            addCriterion("book_press like", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressNotLike(String value) {
            addCriterion("book_press not like", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressIn(List<String> values) {
            addCriterion("book_press in", values, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressNotIn(List<String> values) {
            addCriterion("book_press not in", values, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressBetween(String value1, String value2) {
            addCriterion("book_press between", value1, value2, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressNotBetween(String value1, String value2) {
            addCriterion("book_press not between", value1, value2, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPriceIsNull() {
            addCriterion("book_price is null");
            return (Criteria) this;
        }

        public Criteria andBookPriceIsNotNull() {
            addCriterion("book_price is not null");
            return (Criteria) this;
        }

        public Criteria andBookPriceEqualTo(Float value) {
            addCriterion("book_price =", value, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookPriceNotEqualTo(Float value) {
            addCriterion("book_price <>", value, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookPriceGreaterThan(Float value) {
            addCriterion("book_price >", value, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("book_price >=", value, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookPriceLessThan(Float value) {
            addCriterion("book_price <", value, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookPriceLessThanOrEqualTo(Float value) {
            addCriterion("book_price <=", value, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookPriceIn(List<Float> values) {
            addCriterion("book_price in", values, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookPriceNotIn(List<Float> values) {
            addCriterion("book_price not in", values, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookPriceBetween(Float value1, Float value2) {
            addCriterion("book_price between", value1, value2, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookPriceNotBetween(Float value1, Float value2) {
            addCriterion("book_price not between", value1, value2, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookLanguageIsNull() {
            addCriterion("book_language is null");
            return (Criteria) this;
        }

        public Criteria andBookLanguageIsNotNull() {
            addCriterion("book_language is not null");
            return (Criteria) this;
        }

        public Criteria andBookLanguageEqualTo(String value) {
            addCriterion("book_language =", value, "bookLanguage");
            return (Criteria) this;
        }

        public Criteria andBookLanguageNotEqualTo(String value) {
            addCriterion("book_language <>", value, "bookLanguage");
            return (Criteria) this;
        }

        public Criteria andBookLanguageGreaterThan(String value) {
            addCriterion("book_language >", value, "bookLanguage");
            return (Criteria) this;
        }

        public Criteria andBookLanguageGreaterThanOrEqualTo(String value) {
            addCriterion("book_language >=", value, "bookLanguage");
            return (Criteria) this;
        }

        public Criteria andBookLanguageLessThan(String value) {
            addCriterion("book_language <", value, "bookLanguage");
            return (Criteria) this;
        }

        public Criteria andBookLanguageLessThanOrEqualTo(String value) {
            addCriterion("book_language <=", value, "bookLanguage");
            return (Criteria) this;
        }

        public Criteria andBookLanguageLike(String value) {
            addCriterion("book_language like", value, "bookLanguage");
            return (Criteria) this;
        }

        public Criteria andBookLanguageNotLike(String value) {
            addCriterion("book_language not like", value, "bookLanguage");
            return (Criteria) this;
        }

        public Criteria andBookLanguageIn(List<String> values) {
            addCriterion("book_language in", values, "bookLanguage");
            return (Criteria) this;
        }

        public Criteria andBookLanguageNotIn(List<String> values) {
            addCriterion("book_language not in", values, "bookLanguage");
            return (Criteria) this;
        }

        public Criteria andBookLanguageBetween(String value1, String value2) {
            addCriterion("book_language between", value1, value2, "bookLanguage");
            return (Criteria) this;
        }

        public Criteria andBookLanguageNotBetween(String value1, String value2) {
            addCriterion("book_language not between", value1, value2, "bookLanguage");
            return (Criteria) this;
        }

        public Criteria andBookPdfurlIsNull() {
            addCriterion("book_pdfURL is null");
            return (Criteria) this;
        }

        public Criteria andBookPdfurlIsNotNull() {
            addCriterion("book_pdfURL is not null");
            return (Criteria) this;
        }

        public Criteria andBookPdfurlEqualTo(String value) {
            addCriterion("book_pdfURL =", value, "bookPdfurl");
            return (Criteria) this;
        }

        public Criteria andBookPdfurlNotEqualTo(String value) {
            addCriterion("book_pdfURL <>", value, "bookPdfurl");
            return (Criteria) this;
        }

        public Criteria andBookPdfurlGreaterThan(String value) {
            addCriterion("book_pdfURL >", value, "bookPdfurl");
            return (Criteria) this;
        }

        public Criteria andBookPdfurlGreaterThanOrEqualTo(String value) {
            addCriterion("book_pdfURL >=", value, "bookPdfurl");
            return (Criteria) this;
        }

        public Criteria andBookPdfurlLessThan(String value) {
            addCriterion("book_pdfURL <", value, "bookPdfurl");
            return (Criteria) this;
        }

        public Criteria andBookPdfurlLessThanOrEqualTo(String value) {
            addCriterion("book_pdfURL <=", value, "bookPdfurl");
            return (Criteria) this;
        }

        public Criteria andBookPdfurlLike(String value) {
            addCriterion("book_pdfURL like", value, "bookPdfurl");
            return (Criteria) this;
        }

        public Criteria andBookPdfurlNotLike(String value) {
            addCriterion("book_pdfURL not like", value, "bookPdfurl");
            return (Criteria) this;
        }

        public Criteria andBookPdfurlIn(List<String> values) {
            addCriterion("book_pdfURL in", values, "bookPdfurl");
            return (Criteria) this;
        }

        public Criteria andBookPdfurlNotIn(List<String> values) {
            addCriterion("book_pdfURL not in", values, "bookPdfurl");
            return (Criteria) this;
        }

        public Criteria andBookPdfurlBetween(String value1, String value2) {
            addCriterion("book_pdfURL between", value1, value2, "bookPdfurl");
            return (Criteria) this;
        }

        public Criteria andBookPdfurlNotBetween(String value1, String value2) {
            addCriterion("book_pdfURL not between", value1, value2, "bookPdfurl");
            return (Criteria) this;
        }

        public Criteria andBookEntryTimeIsNull() {
            addCriterion("book_entry_time is null");
            return (Criteria) this;
        }

        public Criteria andBookEntryTimeIsNotNull() {
            addCriterion("book_entry_time is not null");
            return (Criteria) this;
        }

        public Criteria andBookEntryTimeEqualTo(Date value) {
            addCriterion("book_entry_time =", value, "bookEntryTime");
            return (Criteria) this;
        }

        public Criteria andBookEntryTimeNotEqualTo(Date value) {
            addCriterion("book_entry_time <>", value, "bookEntryTime");
            return (Criteria) this;
        }

        public Criteria andBookEntryTimeGreaterThan(Date value) {
            addCriterion("book_entry_time >", value, "bookEntryTime");
            return (Criteria) this;
        }

        public Criteria andBookEntryTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("book_entry_time >=", value, "bookEntryTime");
            return (Criteria) this;
        }

        public Criteria andBookEntryTimeLessThan(Date value) {
            addCriterion("book_entry_time <", value, "bookEntryTime");
            return (Criteria) this;
        }

        public Criteria andBookEntryTimeLessThanOrEqualTo(Date value) {
            addCriterion("book_entry_time <=", value, "bookEntryTime");
            return (Criteria) this;
        }

        public Criteria andBookEntryTimeIn(List<Date> values) {
            addCriterion("book_entry_time in", values, "bookEntryTime");
            return (Criteria) this;
        }

        public Criteria andBookEntryTimeNotIn(List<Date> values) {
            addCriterion("book_entry_time not in", values, "bookEntryTime");
            return (Criteria) this;
        }

        public Criteria andBookEntryTimeBetween(Date value1, Date value2) {
            addCriterion("book_entry_time between", value1, value2, "bookEntryTime");
            return (Criteria) this;
        }

        public Criteria andBookEntryTimeNotBetween(Date value1, Date value2) {
            addCriterion("book_entry_time not between", value1, value2, "bookEntryTime");
            return (Criteria) this;
        }

        public Criteria andToborrowTimesIsNull() {
            addCriterion("toBorrow_times is null");
            return (Criteria) this;
        }

        public Criteria andToborrowTimesIsNotNull() {
            addCriterion("toBorrow_times is not null");
            return (Criteria) this;
        }

        public Criteria andToborrowTimesEqualTo(Integer value) {
            addCriterion("toBorrow_times =", value, "toborrowTimes");
            return (Criteria) this;
        }

        public Criteria andToborrowTimesNotEqualTo(Integer value) {
            addCriterion("toBorrow_times <>", value, "toborrowTimes");
            return (Criteria) this;
        }

        public Criteria andToborrowTimesGreaterThan(Integer value) {
            addCriterion("toBorrow_times >", value, "toborrowTimes");
            return (Criteria) this;
        }

        public Criteria andToborrowTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("toBorrow_times >=", value, "toborrowTimes");
            return (Criteria) this;
        }

        public Criteria andToborrowTimesLessThan(Integer value) {
            addCriterion("toBorrow_times <", value, "toborrowTimes");
            return (Criteria) this;
        }

        public Criteria andToborrowTimesLessThanOrEqualTo(Integer value) {
            addCriterion("toBorrow_times <=", value, "toborrowTimes");
            return (Criteria) this;
        }

        public Criteria andToborrowTimesIn(List<Integer> values) {
            addCriterion("toBorrow_times in", values, "toborrowTimes");
            return (Criteria) this;
        }

        public Criteria andToborrowTimesNotIn(List<Integer> values) {
            addCriterion("toBorrow_times not in", values, "toborrowTimes");
            return (Criteria) this;
        }

        public Criteria andToborrowTimesBetween(Integer value1, Integer value2) {
            addCriterion("toBorrow_times between", value1, value2, "toborrowTimes");
            return (Criteria) this;
        }

        public Criteria andToborrowTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("toBorrow_times not between", value1, value2, "toborrowTimes");
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

        public Criteria andBorrowedTimesIsNull() {
            addCriterion("borrowed_times is null");
            return (Criteria) this;
        }

        public Criteria andBorrowedTimesIsNotNull() {
            addCriterion("borrowed_times is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowedTimesEqualTo(Integer value) {
            addCriterion("borrowed_times =", value, "borrowedTimes");
            return (Criteria) this;
        }

        public Criteria andBorrowedTimesNotEqualTo(Integer value) {
            addCriterion("borrowed_times <>", value, "borrowedTimes");
            return (Criteria) this;
        }

        public Criteria andBorrowedTimesGreaterThan(Integer value) {
            addCriterion("borrowed_times >", value, "borrowedTimes");
            return (Criteria) this;
        }

        public Criteria andBorrowedTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("borrowed_times >=", value, "borrowedTimes");
            return (Criteria) this;
        }

        public Criteria andBorrowedTimesLessThan(Integer value) {
            addCriterion("borrowed_times <", value, "borrowedTimes");
            return (Criteria) this;
        }

        public Criteria andBorrowedTimesLessThanOrEqualTo(Integer value) {
            addCriterion("borrowed_times <=", value, "borrowedTimes");
            return (Criteria) this;
        }

        public Criteria andBorrowedTimesIn(List<Integer> values) {
            addCriterion("borrowed_times in", values, "borrowedTimes");
            return (Criteria) this;
        }

        public Criteria andBorrowedTimesNotIn(List<Integer> values) {
            addCriterion("borrowed_times not in", values, "borrowedTimes");
            return (Criteria) this;
        }

        public Criteria andBorrowedTimesBetween(Integer value1, Integer value2) {
            addCriterion("borrowed_times between", value1, value2, "borrowedTimes");
            return (Criteria) this;
        }

        public Criteria andBorrowedTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("borrowed_times not between", value1, value2, "borrowedTimes");
            return (Criteria) this;
        }

        public Criteria andBookCaseIdIsNull() {
            addCriterion("book_case_id is null");
            return (Criteria) this;
        }

        public Criteria andBookCaseIdIsNotNull() {
            addCriterion("book_case_id is not null");
            return (Criteria) this;
        }

        public Criteria andBookCaseIdEqualTo(Integer value) {
            addCriterion("book_case_id =", value, "bookCaseId");
            return (Criteria) this;
        }

        public Criteria andBookCaseIdNotEqualTo(Integer value) {
            addCriterion("book_case_id <>", value, "bookCaseId");
            return (Criteria) this;
        }

        public Criteria andBookCaseIdGreaterThan(Integer value) {
            addCriterion("book_case_id >", value, "bookCaseId");
            return (Criteria) this;
        }

        public Criteria andBookCaseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_case_id >=", value, "bookCaseId");
            return (Criteria) this;
        }

        public Criteria andBookCaseIdLessThan(Integer value) {
            addCriterion("book_case_id <", value, "bookCaseId");
            return (Criteria) this;
        }

        public Criteria andBookCaseIdLessThanOrEqualTo(Integer value) {
            addCriterion("book_case_id <=", value, "bookCaseId");
            return (Criteria) this;
        }

        public Criteria andBookCaseIdIn(List<Integer> values) {
            addCriterion("book_case_id in", values, "bookCaseId");
            return (Criteria) this;
        }

        public Criteria andBookCaseIdNotIn(List<Integer> values) {
            addCriterion("book_case_id not in", values, "bookCaseId");
            return (Criteria) this;
        }

        public Criteria andBookCaseIdBetween(Integer value1, Integer value2) {
            addCriterion("book_case_id between", value1, value2, "bookCaseId");
            return (Criteria) this;
        }

        public Criteria andBookCaseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("book_case_id not between", value1, value2, "bookCaseId");
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