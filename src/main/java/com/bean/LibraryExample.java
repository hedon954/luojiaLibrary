package com.bean;

import java.util.ArrayList;
import java.util.List;

public class LibraryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LibraryExample() {
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

        public Criteria andLibraryNameIsNull() {
            addCriterion("library_name is null");
            return (Criteria) this;
        }

        public Criteria andLibraryNameIsNotNull() {
            addCriterion("library_name is not null");
            return (Criteria) this;
        }

        public Criteria andLibraryNameEqualTo(String value) {
            addCriterion("library_name =", value, "libraryName");
            return (Criteria) this;
        }

        public Criteria andLibraryNameNotEqualTo(String value) {
            addCriterion("library_name <>", value, "libraryName");
            return (Criteria) this;
        }

        public Criteria andLibraryNameGreaterThan(String value) {
            addCriterion("library_name >", value, "libraryName");
            return (Criteria) this;
        }

        public Criteria andLibraryNameGreaterThanOrEqualTo(String value) {
            addCriterion("library_name >=", value, "libraryName");
            return (Criteria) this;
        }

        public Criteria andLibraryNameLessThan(String value) {
            addCriterion("library_name <", value, "libraryName");
            return (Criteria) this;
        }

        public Criteria andLibraryNameLessThanOrEqualTo(String value) {
            addCriterion("library_name <=", value, "libraryName");
            return (Criteria) this;
        }

        public Criteria andLibraryNameLike(String value) {
            addCriterion("library_name like", value, "libraryName");
            return (Criteria) this;
        }

        public Criteria andLibraryNameNotLike(String value) {
            addCriterion("library_name not like", value, "libraryName");
            return (Criteria) this;
        }

        public Criteria andLibraryNameIn(List<String> values) {
            addCriterion("library_name in", values, "libraryName");
            return (Criteria) this;
        }

        public Criteria andLibraryNameNotIn(List<String> values) {
            addCriterion("library_name not in", values, "libraryName");
            return (Criteria) this;
        }

        public Criteria andLibraryNameBetween(String value1, String value2) {
            addCriterion("library_name between", value1, value2, "libraryName");
            return (Criteria) this;
        }

        public Criteria andLibraryNameNotBetween(String value1, String value2) {
            addCriterion("library_name not between", value1, value2, "libraryName");
            return (Criteria) this;
        }

        public Criteria andLibraryCuratorIsNull() {
            addCriterion("library_curator is null");
            return (Criteria) this;
        }

        public Criteria andLibraryCuratorIsNotNull() {
            addCriterion("library_curator is not null");
            return (Criteria) this;
        }

        public Criteria andLibraryCuratorEqualTo(String value) {
            addCriterion("library_curator =", value, "libraryCurator");
            return (Criteria) this;
        }

        public Criteria andLibraryCuratorNotEqualTo(String value) {
            addCriterion("library_curator <>", value, "libraryCurator");
            return (Criteria) this;
        }

        public Criteria andLibraryCuratorGreaterThan(String value) {
            addCriterion("library_curator >", value, "libraryCurator");
            return (Criteria) this;
        }

        public Criteria andLibraryCuratorGreaterThanOrEqualTo(String value) {
            addCriterion("library_curator >=", value, "libraryCurator");
            return (Criteria) this;
        }

        public Criteria andLibraryCuratorLessThan(String value) {
            addCriterion("library_curator <", value, "libraryCurator");
            return (Criteria) this;
        }

        public Criteria andLibraryCuratorLessThanOrEqualTo(String value) {
            addCriterion("library_curator <=", value, "libraryCurator");
            return (Criteria) this;
        }

        public Criteria andLibraryCuratorLike(String value) {
            addCriterion("library_curator like", value, "libraryCurator");
            return (Criteria) this;
        }

        public Criteria andLibraryCuratorNotLike(String value) {
            addCriterion("library_curator not like", value, "libraryCurator");
            return (Criteria) this;
        }

        public Criteria andLibraryCuratorIn(List<String> values) {
            addCriterion("library_curator in", values, "libraryCurator");
            return (Criteria) this;
        }

        public Criteria andLibraryCuratorNotIn(List<String> values) {
            addCriterion("library_curator not in", values, "libraryCurator");
            return (Criteria) this;
        }

        public Criteria andLibraryCuratorBetween(String value1, String value2) {
            addCriterion("library_curator between", value1, value2, "libraryCurator");
            return (Criteria) this;
        }

        public Criteria andLibraryCuratorNotBetween(String value1, String value2) {
            addCriterion("library_curator not between", value1, value2, "libraryCurator");
            return (Criteria) this;
        }

        public Criteria andLibraryTelnumberIsNull() {
            addCriterion("library_telnumber is null");
            return (Criteria) this;
        }

        public Criteria andLibraryTelnumberIsNotNull() {
            addCriterion("library_telnumber is not null");
            return (Criteria) this;
        }

        public Criteria andLibraryTelnumberEqualTo(String value) {
            addCriterion("library_telnumber =", value, "libraryTelnumber");
            return (Criteria) this;
        }

        public Criteria andLibraryTelnumberNotEqualTo(String value) {
            addCriterion("library_telnumber <>", value, "libraryTelnumber");
            return (Criteria) this;
        }

        public Criteria andLibraryTelnumberGreaterThan(String value) {
            addCriterion("library_telnumber >", value, "libraryTelnumber");
            return (Criteria) this;
        }

        public Criteria andLibraryTelnumberGreaterThanOrEqualTo(String value) {
            addCriterion("library_telnumber >=", value, "libraryTelnumber");
            return (Criteria) this;
        }

        public Criteria andLibraryTelnumberLessThan(String value) {
            addCriterion("library_telnumber <", value, "libraryTelnumber");
            return (Criteria) this;
        }

        public Criteria andLibraryTelnumberLessThanOrEqualTo(String value) {
            addCriterion("library_telnumber <=", value, "libraryTelnumber");
            return (Criteria) this;
        }

        public Criteria andLibraryTelnumberLike(String value) {
            addCriterion("library_telnumber like", value, "libraryTelnumber");
            return (Criteria) this;
        }

        public Criteria andLibraryTelnumberNotLike(String value) {
            addCriterion("library_telnumber not like", value, "libraryTelnumber");
            return (Criteria) this;
        }

        public Criteria andLibraryTelnumberIn(List<String> values) {
            addCriterion("library_telnumber in", values, "libraryTelnumber");
            return (Criteria) this;
        }

        public Criteria andLibraryTelnumberNotIn(List<String> values) {
            addCriterion("library_telnumber not in", values, "libraryTelnumber");
            return (Criteria) this;
        }

        public Criteria andLibraryTelnumberBetween(String value1, String value2) {
            addCriterion("library_telnumber between", value1, value2, "libraryTelnumber");
            return (Criteria) this;
        }

        public Criteria andLibraryTelnumberNotBetween(String value1, String value2) {
            addCriterion("library_telnumber not between", value1, value2, "libraryTelnumber");
            return (Criteria) this;
        }

        public Criteria andLibraryAddressIsNull() {
            addCriterion("library_address is null");
            return (Criteria) this;
        }

        public Criteria andLibraryAddressIsNotNull() {
            addCriterion("library_address is not null");
            return (Criteria) this;
        }

        public Criteria andLibraryAddressEqualTo(String value) {
            addCriterion("library_address =", value, "libraryAddress");
            return (Criteria) this;
        }

        public Criteria andLibraryAddressNotEqualTo(String value) {
            addCriterion("library_address <>", value, "libraryAddress");
            return (Criteria) this;
        }

        public Criteria andLibraryAddressGreaterThan(String value) {
            addCriterion("library_address >", value, "libraryAddress");
            return (Criteria) this;
        }

        public Criteria andLibraryAddressGreaterThanOrEqualTo(String value) {
            addCriterion("library_address >=", value, "libraryAddress");
            return (Criteria) this;
        }

        public Criteria andLibraryAddressLessThan(String value) {
            addCriterion("library_address <", value, "libraryAddress");
            return (Criteria) this;
        }

        public Criteria andLibraryAddressLessThanOrEqualTo(String value) {
            addCriterion("library_address <=", value, "libraryAddress");
            return (Criteria) this;
        }

        public Criteria andLibraryAddressLike(String value) {
            addCriterion("library_address like", value, "libraryAddress");
            return (Criteria) this;
        }

        public Criteria andLibraryAddressNotLike(String value) {
            addCriterion("library_address not like", value, "libraryAddress");
            return (Criteria) this;
        }

        public Criteria andLibraryAddressIn(List<String> values) {
            addCriterion("library_address in", values, "libraryAddress");
            return (Criteria) this;
        }

        public Criteria andLibraryAddressNotIn(List<String> values) {
            addCriterion("library_address not in", values, "libraryAddress");
            return (Criteria) this;
        }

        public Criteria andLibraryAddressBetween(String value1, String value2) {
            addCriterion("library_address between", value1, value2, "libraryAddress");
            return (Criteria) this;
        }

        public Criteria andLibraryAddressNotBetween(String value1, String value2) {
            addCriterion("library_address not between", value1, value2, "libraryAddress");
            return (Criteria) this;
        }

        public Criteria andLibraryEmailIsNull() {
            addCriterion("library_email is null");
            return (Criteria) this;
        }

        public Criteria andLibraryEmailIsNotNull() {
            addCriterion("library_email is not null");
            return (Criteria) this;
        }

        public Criteria andLibraryEmailEqualTo(String value) {
            addCriterion("library_email =", value, "libraryEmail");
            return (Criteria) this;
        }

        public Criteria andLibraryEmailNotEqualTo(String value) {
            addCriterion("library_email <>", value, "libraryEmail");
            return (Criteria) this;
        }

        public Criteria andLibraryEmailGreaterThan(String value) {
            addCriterion("library_email >", value, "libraryEmail");
            return (Criteria) this;
        }

        public Criteria andLibraryEmailGreaterThanOrEqualTo(String value) {
            addCriterion("library_email >=", value, "libraryEmail");
            return (Criteria) this;
        }

        public Criteria andLibraryEmailLessThan(String value) {
            addCriterion("library_email <", value, "libraryEmail");
            return (Criteria) this;
        }

        public Criteria andLibraryEmailLessThanOrEqualTo(String value) {
            addCriterion("library_email <=", value, "libraryEmail");
            return (Criteria) this;
        }

        public Criteria andLibraryEmailLike(String value) {
            addCriterion("library_email like", value, "libraryEmail");
            return (Criteria) this;
        }

        public Criteria andLibraryEmailNotLike(String value) {
            addCriterion("library_email not like", value, "libraryEmail");
            return (Criteria) this;
        }

        public Criteria andLibraryEmailIn(List<String> values) {
            addCriterion("library_email in", values, "libraryEmail");
            return (Criteria) this;
        }

        public Criteria andLibraryEmailNotIn(List<String> values) {
            addCriterion("library_email not in", values, "libraryEmail");
            return (Criteria) this;
        }

        public Criteria andLibraryEmailBetween(String value1, String value2) {
            addCriterion("library_email between", value1, value2, "libraryEmail");
            return (Criteria) this;
        }

        public Criteria andLibraryEmailNotBetween(String value1, String value2) {
            addCriterion("library_email not between", value1, value2, "libraryEmail");
            return (Criteria) this;
        }

        public Criteria andLibraryUrlIsNull() {
            addCriterion("library_URL is null");
            return (Criteria) this;
        }

        public Criteria andLibraryUrlIsNotNull() {
            addCriterion("library_URL is not null");
            return (Criteria) this;
        }

        public Criteria andLibraryUrlEqualTo(String value) {
            addCriterion("library_URL =", value, "libraryUrl");
            return (Criteria) this;
        }

        public Criteria andLibraryUrlNotEqualTo(String value) {
            addCriterion("library_URL <>", value, "libraryUrl");
            return (Criteria) this;
        }

        public Criteria andLibraryUrlGreaterThan(String value) {
            addCriterion("library_URL >", value, "libraryUrl");
            return (Criteria) this;
        }

        public Criteria andLibraryUrlGreaterThanOrEqualTo(String value) {
            addCriterion("library_URL >=", value, "libraryUrl");
            return (Criteria) this;
        }

        public Criteria andLibraryUrlLessThan(String value) {
            addCriterion("library_URL <", value, "libraryUrl");
            return (Criteria) this;
        }

        public Criteria andLibraryUrlLessThanOrEqualTo(String value) {
            addCriterion("library_URL <=", value, "libraryUrl");
            return (Criteria) this;
        }

        public Criteria andLibraryUrlLike(String value) {
            addCriterion("library_URL like", value, "libraryUrl");
            return (Criteria) this;
        }

        public Criteria andLibraryUrlNotLike(String value) {
            addCriterion("library_URL not like", value, "libraryUrl");
            return (Criteria) this;
        }

        public Criteria andLibraryUrlIn(List<String> values) {
            addCriterion("library_URL in", values, "libraryUrl");
            return (Criteria) this;
        }

        public Criteria andLibraryUrlNotIn(List<String> values) {
            addCriterion("library_URL not in", values, "libraryUrl");
            return (Criteria) this;
        }

        public Criteria andLibraryUrlBetween(String value1, String value2) {
            addCriterion("library_URL between", value1, value2, "libraryUrl");
            return (Criteria) this;
        }

        public Criteria andLibraryUrlNotBetween(String value1, String value2) {
            addCriterion("library_URL not between", value1, value2, "libraryUrl");
            return (Criteria) this;
        }

        public Criteria andLibraryBuildingDateIsNull() {
            addCriterion("library_Building_date is null");
            return (Criteria) this;
        }

        public Criteria andLibraryBuildingDateIsNotNull() {
            addCriterion("library_Building_date is not null");
            return (Criteria) this;
        }

        public Criteria andLibraryBuildingDateEqualTo(String value) {
            addCriterion("library_Building_date =", value, "libraryBuildingDate");
            return (Criteria) this;
        }

        public Criteria andLibraryBuildingDateNotEqualTo(String value) {
            addCriterion("library_Building_date <>", value, "libraryBuildingDate");
            return (Criteria) this;
        }

        public Criteria andLibraryBuildingDateGreaterThan(String value) {
            addCriterion("library_Building_date >", value, "libraryBuildingDate");
            return (Criteria) this;
        }

        public Criteria andLibraryBuildingDateGreaterThanOrEqualTo(String value) {
            addCriterion("library_Building_date >=", value, "libraryBuildingDate");
            return (Criteria) this;
        }

        public Criteria andLibraryBuildingDateLessThan(String value) {
            addCriterion("library_Building_date <", value, "libraryBuildingDate");
            return (Criteria) this;
        }

        public Criteria andLibraryBuildingDateLessThanOrEqualTo(String value) {
            addCriterion("library_Building_date <=", value, "libraryBuildingDate");
            return (Criteria) this;
        }

        public Criteria andLibraryBuildingDateLike(String value) {
            addCriterion("library_Building_date like", value, "libraryBuildingDate");
            return (Criteria) this;
        }

        public Criteria andLibraryBuildingDateNotLike(String value) {
            addCriterion("library_Building_date not like", value, "libraryBuildingDate");
            return (Criteria) this;
        }

        public Criteria andLibraryBuildingDateIn(List<String> values) {
            addCriterion("library_Building_date in", values, "libraryBuildingDate");
            return (Criteria) this;
        }

        public Criteria andLibraryBuildingDateNotIn(List<String> values) {
            addCriterion("library_Building_date not in", values, "libraryBuildingDate");
            return (Criteria) this;
        }

        public Criteria andLibraryBuildingDateBetween(String value1, String value2) {
            addCriterion("library_Building_date between", value1, value2, "libraryBuildingDate");
            return (Criteria) this;
        }

        public Criteria andLibraryBuildingDateNotBetween(String value1, String value2) {
            addCriterion("library_Building_date not between", value1, value2, "libraryBuildingDate");
            return (Criteria) this;
        }

        public Criteria andLibraryInfoIsNull() {
            addCriterion("library_info is null");
            return (Criteria) this;
        }

        public Criteria andLibraryInfoIsNotNull() {
            addCriterion("library_info is not null");
            return (Criteria) this;
        }

        public Criteria andLibraryInfoEqualTo(String value) {
            addCriterion("library_info =", value, "libraryInfo");
            return (Criteria) this;
        }

        public Criteria andLibraryInfoNotEqualTo(String value) {
            addCriterion("library_info <>", value, "libraryInfo");
            return (Criteria) this;
        }

        public Criteria andLibraryInfoGreaterThan(String value) {
            addCriterion("library_info >", value, "libraryInfo");
            return (Criteria) this;
        }

        public Criteria andLibraryInfoGreaterThanOrEqualTo(String value) {
            addCriterion("library_info >=", value, "libraryInfo");
            return (Criteria) this;
        }

        public Criteria andLibraryInfoLessThan(String value) {
            addCriterion("library_info <", value, "libraryInfo");
            return (Criteria) this;
        }

        public Criteria andLibraryInfoLessThanOrEqualTo(String value) {
            addCriterion("library_info <=", value, "libraryInfo");
            return (Criteria) this;
        }

        public Criteria andLibraryInfoLike(String value) {
            addCriterion("library_info like", value, "libraryInfo");
            return (Criteria) this;
        }

        public Criteria andLibraryInfoNotLike(String value) {
            addCriterion("library_info not like", value, "libraryInfo");
            return (Criteria) this;
        }

        public Criteria andLibraryInfoIn(List<String> values) {
            addCriterion("library_info in", values, "libraryInfo");
            return (Criteria) this;
        }

        public Criteria andLibraryInfoNotIn(List<String> values) {
            addCriterion("library_info not in", values, "libraryInfo");
            return (Criteria) this;
        }

        public Criteria andLibraryInfoBetween(String value1, String value2) {
            addCriterion("library_info between", value1, value2, "libraryInfo");
            return (Criteria) this;
        }

        public Criteria andLibraryInfoNotBetween(String value1, String value2) {
            addCriterion("library_info not between", value1, value2, "libraryInfo");
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