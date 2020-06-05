package com.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookToBorrowExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BookToBorrowExample() {
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

        public Criteria andBookToborrowIdIsNull() {
            addCriterion("book_toBorrow_id is null");
            return (Criteria) this;
        }

        public Criteria andBookToborrowIdIsNotNull() {
            addCriterion("book_toBorrow_id is not null");
            return (Criteria) this;
        }

        public Criteria andBookToborrowIdEqualTo(Integer value) {
            addCriterion("book_toBorrow_id =", value, "bookToborrowId");
            return (Criteria) this;
        }

        public Criteria andBookToborrowIdNotEqualTo(Integer value) {
            addCriterion("book_toBorrow_id <>", value, "bookToborrowId");
            return (Criteria) this;
        }

        public Criteria andBookToborrowIdGreaterThan(Integer value) {
            addCriterion("book_toBorrow_id >", value, "bookToborrowId");
            return (Criteria) this;
        }

        public Criteria andBookToborrowIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_toBorrow_id >=", value, "bookToborrowId");
            return (Criteria) this;
        }

        public Criteria andBookToborrowIdLessThan(Integer value) {
            addCriterion("book_toBorrow_id <", value, "bookToborrowId");
            return (Criteria) this;
        }

        public Criteria andBookToborrowIdLessThanOrEqualTo(Integer value) {
            addCriterion("book_toBorrow_id <=", value, "bookToborrowId");
            return (Criteria) this;
        }

        public Criteria andBookToborrowIdIn(List<Integer> values) {
            addCriterion("book_toBorrow_id in", values, "bookToborrowId");
            return (Criteria) this;
        }

        public Criteria andBookToborrowIdNotIn(List<Integer> values) {
            addCriterion("book_toBorrow_id not in", values, "bookToborrowId");
            return (Criteria) this;
        }

        public Criteria andBookToborrowIdBetween(Integer value1, Integer value2) {
            addCriterion("book_toBorrow_id between", value1, value2, "bookToborrowId");
            return (Criteria) this;
        }

        public Criteria andBookToborrowIdNotBetween(Integer value1, Integer value2) {
            addCriterion("book_toBorrow_id not between", value1, value2, "bookToborrowId");
            return (Criteria) this;
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

        public Criteria andBorrowedDateIsNull() {
            addCriterion("borrowed_date is null");
            return (Criteria) this;
        }

        public Criteria andBorrowedDateIsNotNull() {
            addCriterion("borrowed_date is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowedDateEqualTo(Date value) {
            addCriterion("borrowed_date =", value, "borrowedDate");
            return (Criteria) this;
        }

        public Criteria andBorrowedDateNotEqualTo(Date value) {
            addCriterion("borrowed_date <>", value, "borrowedDate");
            return (Criteria) this;
        }

        public Criteria andBorrowedDateGreaterThan(Date value) {
            addCriterion("borrowed_date >", value, "borrowedDate");
            return (Criteria) this;
        }

        public Criteria andBorrowedDateGreaterThanOrEqualTo(Date value) {
            addCriterion("borrowed_date >=", value, "borrowedDate");
            return (Criteria) this;
        }

        public Criteria andBorrowedDateLessThan(Date value) {
            addCriterion("borrowed_date <", value, "borrowedDate");
            return (Criteria) this;
        }

        public Criteria andBorrowedDateLessThanOrEqualTo(Date value) {
            addCriterion("borrowed_date <=", value, "borrowedDate");
            return (Criteria) this;
        }

        public Criteria andBorrowedDateIn(List<Date> values) {
            addCriterion("borrowed_date in", values, "borrowedDate");
            return (Criteria) this;
        }

        public Criteria andBorrowedDateNotIn(List<Date> values) {
            addCriterion("borrowed_date not in", values, "borrowedDate");
            return (Criteria) this;
        }

        public Criteria andBorrowedDateBetween(Date value1, Date value2) {
            addCriterion("borrowed_date between", value1, value2, "borrowedDate");
            return (Criteria) this;
        }

        public Criteria andBorrowedDateNotBetween(Date value1, Date value2) {
            addCriterion("borrowed_date not between", value1, value2, "borrowedDate");
            return (Criteria) this;
        }

        public Criteria andReturnedDateIsNull() {
            addCriterion("returned_date is null");
            return (Criteria) this;
        }

        public Criteria andReturnedDateIsNotNull() {
            addCriterion("returned_date is not null");
            return (Criteria) this;
        }

        public Criteria andReturnedDateEqualTo(Date value) {
            addCriterion("returned_date =", value, "returnedDate");
            return (Criteria) this;
        }

        public Criteria andReturnedDateNotEqualTo(Date value) {
            addCriterion("returned_date <>", value, "returnedDate");
            return (Criteria) this;
        }

        public Criteria andReturnedDateGreaterThan(Date value) {
            addCriterion("returned_date >", value, "returnedDate");
            return (Criteria) this;
        }

        public Criteria andReturnedDateGreaterThanOrEqualTo(Date value) {
            addCriterion("returned_date >=", value, "returnedDate");
            return (Criteria) this;
        }

        public Criteria andReturnedDateLessThan(Date value) {
            addCriterion("returned_date <", value, "returnedDate");
            return (Criteria) this;
        }

        public Criteria andReturnedDateLessThanOrEqualTo(Date value) {
            addCriterion("returned_date <=", value, "returnedDate");
            return (Criteria) this;
        }

        public Criteria andReturnedDateIn(List<Date> values) {
            addCriterion("returned_date in", values, "returnedDate");
            return (Criteria) this;
        }

        public Criteria andReturnedDateNotIn(List<Date> values) {
            addCriterion("returned_date not in", values, "returnedDate");
            return (Criteria) this;
        }

        public Criteria andReturnedDateBetween(Date value1, Date value2) {
            addCriterion("returned_date between", value1, value2, "returnedDate");
            return (Criteria) this;
        }

        public Criteria andReturnedDateNotBetween(Date value1, Date value2) {
            addCriterion("returned_date not between", value1, value2, "returnedDate");
            return (Criteria) this;
        }

        public Criteria andIsReturnedIsNull() {
            addCriterion("is_returned is null");
            return (Criteria) this;
        }

        public Criteria andIsReturnedIsNotNull() {
            addCriterion("is_returned is not null");
            return (Criteria) this;
        }

        public Criteria andIsReturnedEqualTo(Byte value) {
            addCriterion("is_returned =", value, "isReturned");
            return (Criteria) this;
        }

        public Criteria andIsReturnedNotEqualTo(Byte value) {
            addCriterion("is_returned <>", value, "isReturned");
            return (Criteria) this;
        }

        public Criteria andIsReturnedGreaterThan(Byte value) {
            addCriterion("is_returned >", value, "isReturned");
            return (Criteria) this;
        }

        public Criteria andIsReturnedGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_returned >=", value, "isReturned");
            return (Criteria) this;
        }

        public Criteria andIsReturnedLessThan(Byte value) {
            addCriterion("is_returned <", value, "isReturned");
            return (Criteria) this;
        }

        public Criteria andIsReturnedLessThanOrEqualTo(Byte value) {
            addCriterion("is_returned <=", value, "isReturned");
            return (Criteria) this;
        }

        public Criteria andIsReturnedIn(List<Byte> values) {
            addCriterion("is_returned in", values, "isReturned");
            return (Criteria) this;
        }

        public Criteria andIsReturnedNotIn(List<Byte> values) {
            addCriterion("is_returned not in", values, "isReturned");
            return (Criteria) this;
        }

        public Criteria andIsReturnedBetween(Byte value1, Byte value2) {
            addCriterion("is_returned between", value1, value2, "isReturned");
            return (Criteria) this;
        }

        public Criteria andIsReturnedNotBetween(Byte value1, Byte value2) {
            addCriterion("is_returned not between", value1, value2, "isReturned");
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