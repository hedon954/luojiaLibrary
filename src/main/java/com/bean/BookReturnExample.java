package com.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookReturnExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BookReturnExample() {
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

        public Criteria andBookReturnIdIsNull() {
            addCriterion("book_return_id is null");
            return (Criteria) this;
        }

        public Criteria andBookReturnIdIsNotNull() {
            addCriterion("book_return_id is not null");
            return (Criteria) this;
        }

        public Criteria andBookReturnIdEqualTo(Integer value) {
            addCriterion("book_return_id =", value, "bookReturnId");
            return (Criteria) this;
        }

        public Criteria andBookReturnIdNotEqualTo(Integer value) {
            addCriterion("book_return_id <>", value, "bookReturnId");
            return (Criteria) this;
        }

        public Criteria andBookReturnIdGreaterThan(Integer value) {
            addCriterion("book_return_id >", value, "bookReturnId");
            return (Criteria) this;
        }

        public Criteria andBookReturnIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_return_id >=", value, "bookReturnId");
            return (Criteria) this;
        }

        public Criteria andBookReturnIdLessThan(Integer value) {
            addCriterion("book_return_id <", value, "bookReturnId");
            return (Criteria) this;
        }

        public Criteria andBookReturnIdLessThanOrEqualTo(Integer value) {
            addCriterion("book_return_id <=", value, "bookReturnId");
            return (Criteria) this;
        }

        public Criteria andBookReturnIdIn(List<Integer> values) {
            addCriterion("book_return_id in", values, "bookReturnId");
            return (Criteria) this;
        }

        public Criteria andBookReturnIdNotIn(List<Integer> values) {
            addCriterion("book_return_id not in", values, "bookReturnId");
            return (Criteria) this;
        }

        public Criteria andBookReturnIdBetween(Integer value1, Integer value2) {
            addCriterion("book_return_id between", value1, value2, "bookReturnId");
            return (Criteria) this;
        }

        public Criteria andBookReturnIdNotBetween(Integer value1, Integer value2) {
            addCriterion("book_return_id not between", value1, value2, "bookReturnId");
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

        public Criteria andToborrowDateIsNull() {
            addCriterion("toBorrow_date is null");
            return (Criteria) this;
        }

        public Criteria andToborrowDateIsNotNull() {
            addCriterion("toBorrow_date is not null");
            return (Criteria) this;
        }

        public Criteria andToborrowDateEqualTo(Date value) {
            addCriterion("toBorrow_date =", value, "toborrowDate");
            return (Criteria) this;
        }

        public Criteria andToborrowDateNotEqualTo(Date value) {
            addCriterion("toBorrow_date <>", value, "toborrowDate");
            return (Criteria) this;
        }

        public Criteria andToborrowDateGreaterThan(Date value) {
            addCriterion("toBorrow_date >", value, "toborrowDate");
            return (Criteria) this;
        }

        public Criteria andToborrowDateGreaterThanOrEqualTo(Date value) {
            addCriterion("toBorrow_date >=", value, "toborrowDate");
            return (Criteria) this;
        }

        public Criteria andToborrowDateLessThan(Date value) {
            addCriterion("toBorrow_date <", value, "toborrowDate");
            return (Criteria) this;
        }

        public Criteria andToborrowDateLessThanOrEqualTo(Date value) {
            addCriterion("toBorrow_date <=", value, "toborrowDate");
            return (Criteria) this;
        }

        public Criteria andToborrowDateIn(List<Date> values) {
            addCriterion("toBorrow_date in", values, "toborrowDate");
            return (Criteria) this;
        }

        public Criteria andToborrowDateNotIn(List<Date> values) {
            addCriterion("toBorrow_date not in", values, "toborrowDate");
            return (Criteria) this;
        }

        public Criteria andToborrowDateBetween(Date value1, Date value2) {
            addCriterion("toBorrow_date between", value1, value2, "toborrowDate");
            return (Criteria) this;
        }

        public Criteria andToborrowDateNotBetween(Date value1, Date value2) {
            addCriterion("toBorrow_date not between", value1, value2, "toborrowDate");
            return (Criteria) this;
        }

        public Criteria andToreturnDateIsNull() {
            addCriterion("toReturn_date is null");
            return (Criteria) this;
        }

        public Criteria andToreturnDateIsNotNull() {
            addCriterion("toReturn_date is not null");
            return (Criteria) this;
        }

        public Criteria andToreturnDateEqualTo(Date value) {
            addCriterion("toReturn_date =", value, "toreturnDate");
            return (Criteria) this;
        }

        public Criteria andToreturnDateNotEqualTo(Date value) {
            addCriterion("toReturn_date <>", value, "toreturnDate");
            return (Criteria) this;
        }

        public Criteria andToreturnDateGreaterThan(Date value) {
            addCriterion("toReturn_date >", value, "toreturnDate");
            return (Criteria) this;
        }

        public Criteria andToreturnDateGreaterThanOrEqualTo(Date value) {
            addCriterion("toReturn_date >=", value, "toreturnDate");
            return (Criteria) this;
        }

        public Criteria andToreturnDateLessThan(Date value) {
            addCriterion("toReturn_date <", value, "toreturnDate");
            return (Criteria) this;
        }

        public Criteria andToreturnDateLessThanOrEqualTo(Date value) {
            addCriterion("toReturn_date <=", value, "toreturnDate");
            return (Criteria) this;
        }

        public Criteria andToreturnDateIn(List<Date> values) {
            addCriterion("toReturn_date in", values, "toreturnDate");
            return (Criteria) this;
        }

        public Criteria andToreturnDateNotIn(List<Date> values) {
            addCriterion("toReturn_date not in", values, "toreturnDate");
            return (Criteria) this;
        }

        public Criteria andToreturnDateBetween(Date value1, Date value2) {
            addCriterion("toReturn_date between", value1, value2, "toreturnDate");
            return (Criteria) this;
        }

        public Criteria andToreturnDateNotBetween(Date value1, Date value2) {
            addCriterion("toReturn_date not between", value1, value2, "toreturnDate");
            return (Criteria) this;
        }

        public Criteria andBorrowerIdIsNull() {
            addCriterion("borrower_id is null");
            return (Criteria) this;
        }

        public Criteria andBorrowerIdIsNotNull() {
            addCriterion("borrower_id is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowerIdEqualTo(Integer value) {
            addCriterion("borrower_id =", value, "borrowerId");
            return (Criteria) this;
        }

        public Criteria andBorrowerIdNotEqualTo(Integer value) {
            addCriterion("borrower_id <>", value, "borrowerId");
            return (Criteria) this;
        }

        public Criteria andBorrowerIdGreaterThan(Integer value) {
            addCriterion("borrower_id >", value, "borrowerId");
            return (Criteria) this;
        }

        public Criteria andBorrowerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("borrower_id >=", value, "borrowerId");
            return (Criteria) this;
        }

        public Criteria andBorrowerIdLessThan(Integer value) {
            addCriterion("borrower_id <", value, "borrowerId");
            return (Criteria) this;
        }

        public Criteria andBorrowerIdLessThanOrEqualTo(Integer value) {
            addCriterion("borrower_id <=", value, "borrowerId");
            return (Criteria) this;
        }

        public Criteria andBorrowerIdIn(List<Integer> values) {
            addCriterion("borrower_id in", values, "borrowerId");
            return (Criteria) this;
        }

        public Criteria andBorrowerIdNotIn(List<Integer> values) {
            addCriterion("borrower_id not in", values, "borrowerId");
            return (Criteria) this;
        }

        public Criteria andBorrowerIdBetween(Integer value1, Integer value2) {
            addCriterion("borrower_id between", value1, value2, "borrowerId");
            return (Criteria) this;
        }

        public Criteria andBorrowerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("borrower_id not between", value1, value2, "borrowerId");
            return (Criteria) this;
        }

        public Criteria andRetrunDateIsNull() {
            addCriterion("retrun_date is null");
            return (Criteria) this;
        }

        public Criteria andRetrunDateIsNotNull() {
            addCriterion("retrun_date is not null");
            return (Criteria) this;
        }

        public Criteria andRetrunDateEqualTo(Date value) {
            addCriterion("retrun_date =", value, "retrunDate");
            return (Criteria) this;
        }

        public Criteria andRetrunDateNotEqualTo(Date value) {
            addCriterion("retrun_date <>", value, "retrunDate");
            return (Criteria) this;
        }

        public Criteria andRetrunDateGreaterThan(Date value) {
            addCriterion("retrun_date >", value, "retrunDate");
            return (Criteria) this;
        }

        public Criteria andRetrunDateGreaterThanOrEqualTo(Date value) {
            addCriterion("retrun_date >=", value, "retrunDate");
            return (Criteria) this;
        }

        public Criteria andRetrunDateLessThan(Date value) {
            addCriterion("retrun_date <", value, "retrunDate");
            return (Criteria) this;
        }

        public Criteria andRetrunDateLessThanOrEqualTo(Date value) {
            addCriterion("retrun_date <=", value, "retrunDate");
            return (Criteria) this;
        }

        public Criteria andRetrunDateIn(List<Date> values) {
            addCriterion("retrun_date in", values, "retrunDate");
            return (Criteria) this;
        }

        public Criteria andRetrunDateNotIn(List<Date> values) {
            addCriterion("retrun_date not in", values, "retrunDate");
            return (Criteria) this;
        }

        public Criteria andRetrunDateBetween(Date value1, Date value2) {
            addCriterion("retrun_date between", value1, value2, "retrunDate");
            return (Criteria) this;
        }

        public Criteria andRetrunDateNotBetween(Date value1, Date value2) {
            addCriterion("retrun_date not between", value1, value2, "retrunDate");
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