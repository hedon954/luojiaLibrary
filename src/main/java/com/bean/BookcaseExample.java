package com.bean;

import java.util.ArrayList;
import java.util.List;

public class BookcaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BookcaseExample() {
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

        public Criteria andBookcaseIdIsNull() {
            addCriterion("bookcase_id is null");
            return (Criteria) this;
        }

        public Criteria andBookcaseIdIsNotNull() {
            addCriterion("bookcase_id is not null");
            return (Criteria) this;
        }

        public Criteria andBookcaseIdEqualTo(Integer value) {
            addCriterion("bookcase_id =", value, "bookcaseId");
            return (Criteria) this;
        }

        public Criteria andBookcaseIdNotEqualTo(Integer value) {
            addCriterion("bookcase_id <>", value, "bookcaseId");
            return (Criteria) this;
        }

        public Criteria andBookcaseIdGreaterThan(Integer value) {
            addCriterion("bookcase_id >", value, "bookcaseId");
            return (Criteria) this;
        }

        public Criteria andBookcaseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("bookcase_id >=", value, "bookcaseId");
            return (Criteria) this;
        }

        public Criteria andBookcaseIdLessThan(Integer value) {
            addCriterion("bookcase_id <", value, "bookcaseId");
            return (Criteria) this;
        }

        public Criteria andBookcaseIdLessThanOrEqualTo(Integer value) {
            addCriterion("bookcase_id <=", value, "bookcaseId");
            return (Criteria) this;
        }

        public Criteria andBookcaseIdIn(List<Integer> values) {
            addCriterion("bookcase_id in", values, "bookcaseId");
            return (Criteria) this;
        }

        public Criteria andBookcaseIdNotIn(List<Integer> values) {
            addCriterion("bookcase_id not in", values, "bookcaseId");
            return (Criteria) this;
        }

        public Criteria andBookcaseIdBetween(Integer value1, Integer value2) {
            addCriterion("bookcase_id between", value1, value2, "bookcaseId");
            return (Criteria) this;
        }

        public Criteria andBookcaseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("bookcase_id not between", value1, value2, "bookcaseId");
            return (Criteria) this;
        }

        public Criteria andBookcaseNameIsNull() {
            addCriterion("bookcase_name is null");
            return (Criteria) this;
        }

        public Criteria andBookcaseNameIsNotNull() {
            addCriterion("bookcase_name is not null");
            return (Criteria) this;
        }

        public Criteria andBookcaseNameEqualTo(String value) {
            addCriterion("bookcase_name =", value, "bookcaseName");
            return (Criteria) this;
        }

        public Criteria andBookcaseNameNotEqualTo(String value) {
            addCriterion("bookcase_name <>", value, "bookcaseName");
            return (Criteria) this;
        }

        public Criteria andBookcaseNameGreaterThan(String value) {
            addCriterion("bookcase_name >", value, "bookcaseName");
            return (Criteria) this;
        }

        public Criteria andBookcaseNameGreaterThanOrEqualTo(String value) {
            addCriterion("bookcase_name >=", value, "bookcaseName");
            return (Criteria) this;
        }

        public Criteria andBookcaseNameLessThan(String value) {
            addCriterion("bookcase_name <", value, "bookcaseName");
            return (Criteria) this;
        }

        public Criteria andBookcaseNameLessThanOrEqualTo(String value) {
            addCriterion("bookcase_name <=", value, "bookcaseName");
            return (Criteria) this;
        }

        public Criteria andBookcaseNameLike(String value) {
            addCriterion("bookcase_name like", value, "bookcaseName");
            return (Criteria) this;
        }

        public Criteria andBookcaseNameNotLike(String value) {
            addCriterion("bookcase_name not like", value, "bookcaseName");
            return (Criteria) this;
        }

        public Criteria andBookcaseNameIn(List<String> values) {
            addCriterion("bookcase_name in", values, "bookcaseName");
            return (Criteria) this;
        }

        public Criteria andBookcaseNameNotIn(List<String> values) {
            addCriterion("bookcase_name not in", values, "bookcaseName");
            return (Criteria) this;
        }

        public Criteria andBookcaseNameBetween(String value1, String value2) {
            addCriterion("bookcase_name between", value1, value2, "bookcaseName");
            return (Criteria) this;
        }

        public Criteria andBookcaseNameNotBetween(String value1, String value2) {
            addCriterion("bookcase_name not between", value1, value2, "bookcaseName");
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