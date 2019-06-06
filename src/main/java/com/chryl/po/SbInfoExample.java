package com.chryl.po;

import java.util.ArrayList;
import java.util.List;

public class SbInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SbInfoExample() {
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

        public Criteria andSbIdIsNull() {
            addCriterion("sb_id is null");
            return (Criteria) this;
        }

        public Criteria andSbIdIsNotNull() {
            addCriterion("sb_id is not null");
            return (Criteria) this;
        }

        public Criteria andSbIdEqualTo(String value) {
            addCriterion("sb_id =", value, "sbId");
            return (Criteria) this;
        }

        public Criteria andSbIdNotEqualTo(String value) {
            addCriterion("sb_id <>", value, "sbId");
            return (Criteria) this;
        }

        public Criteria andSbIdGreaterThan(String value) {
            addCriterion("sb_id >", value, "sbId");
            return (Criteria) this;
        }

        public Criteria andSbIdGreaterThanOrEqualTo(String value) {
            addCriterion("sb_id >=", value, "sbId");
            return (Criteria) this;
        }

        public Criteria andSbIdLessThan(String value) {
            addCriterion("sb_id <", value, "sbId");
            return (Criteria) this;
        }

        public Criteria andSbIdLessThanOrEqualTo(String value) {
            addCriterion("sb_id <=", value, "sbId");
            return (Criteria) this;
        }

        public Criteria andSbIdLike(String value) {
            addCriterion("sb_id like", value, "sbId");
            return (Criteria) this;
        }

        public Criteria andSbIdNotLike(String value) {
            addCriterion("sb_id not like", value, "sbId");
            return (Criteria) this;
        }

        public Criteria andSbIdIn(List<String> values) {
            addCriterion("sb_id in", values, "sbId");
            return (Criteria) this;
        }

        public Criteria andSbIdNotIn(List<String> values) {
            addCriterion("sb_id not in", values, "sbId");
            return (Criteria) this;
        }

        public Criteria andSbIdBetween(String value1, String value2) {
            addCriterion("sb_id between", value1, value2, "sbId");
            return (Criteria) this;
        }

        public Criteria andSbIdNotBetween(String value1, String value2) {
            addCriterion("sb_id not between", value1, value2, "sbId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andSbNameIsNull() {
            addCriterion("sb_name is null");
            return (Criteria) this;
        }

        public Criteria andSbNameIsNotNull() {
            addCriterion("sb_name is not null");
            return (Criteria) this;
        }

        public Criteria andSbNameEqualTo(String value) {
            addCriterion("sb_name =", value, "sbName");
            return (Criteria) this;
        }

        public Criteria andSbNameNotEqualTo(String value) {
            addCriterion("sb_name <>", value, "sbName");
            return (Criteria) this;
        }

        public Criteria andSbNameGreaterThan(String value) {
            addCriterion("sb_name >", value, "sbName");
            return (Criteria) this;
        }

        public Criteria andSbNameGreaterThanOrEqualTo(String value) {
            addCriterion("sb_name >=", value, "sbName");
            return (Criteria) this;
        }

        public Criteria andSbNameLessThan(String value) {
            addCriterion("sb_name <", value, "sbName");
            return (Criteria) this;
        }

        public Criteria andSbNameLessThanOrEqualTo(String value) {
            addCriterion("sb_name <=", value, "sbName");
            return (Criteria) this;
        }

        public Criteria andSbNameLike(String value) {
            addCriterion("sb_name like", value, "sbName");
            return (Criteria) this;
        }

        public Criteria andSbNameNotLike(String value) {
            addCriterion("sb_name not like", value, "sbName");
            return (Criteria) this;
        }

        public Criteria andSbNameIn(List<String> values) {
            addCriterion("sb_name in", values, "sbName");
            return (Criteria) this;
        }

        public Criteria andSbNameNotIn(List<String> values) {
            addCriterion("sb_name not in", values, "sbName");
            return (Criteria) this;
        }

        public Criteria andSbNameBetween(String value1, String value2) {
            addCriterion("sb_name between", value1, value2, "sbName");
            return (Criteria) this;
        }

        public Criteria andSbNameNotBetween(String value1, String value2) {
            addCriterion("sb_name not between", value1, value2, "sbName");
            return (Criteria) this;
        }

        public Criteria andSbTypeIsNull() {
            addCriterion("sb_type is null");
            return (Criteria) this;
        }

        public Criteria andSbTypeIsNotNull() {
            addCriterion("sb_type is not null");
            return (Criteria) this;
        }

        public Criteria andSbTypeEqualTo(String value) {
            addCriterion("sb_type =", value, "sbType");
            return (Criteria) this;
        }

        public Criteria andSbTypeNotEqualTo(String value) {
            addCriterion("sb_type <>", value, "sbType");
            return (Criteria) this;
        }

        public Criteria andSbTypeGreaterThan(String value) {
            addCriterion("sb_type >", value, "sbType");
            return (Criteria) this;
        }

        public Criteria andSbTypeGreaterThanOrEqualTo(String value) {
            addCriterion("sb_type >=", value, "sbType");
            return (Criteria) this;
        }

        public Criteria andSbTypeLessThan(String value) {
            addCriterion("sb_type <", value, "sbType");
            return (Criteria) this;
        }

        public Criteria andSbTypeLessThanOrEqualTo(String value) {
            addCriterion("sb_type <=", value, "sbType");
            return (Criteria) this;
        }

        public Criteria andSbTypeLike(String value) {
            addCriterion("sb_type like", value, "sbType");
            return (Criteria) this;
        }

        public Criteria andSbTypeNotLike(String value) {
            addCriterion("sb_type not like", value, "sbType");
            return (Criteria) this;
        }

        public Criteria andSbTypeIn(List<String> values) {
            addCriterion("sb_type in", values, "sbType");
            return (Criteria) this;
        }

        public Criteria andSbTypeNotIn(List<String> values) {
            addCriterion("sb_type not in", values, "sbType");
            return (Criteria) this;
        }

        public Criteria andSbTypeBetween(String value1, String value2) {
            addCriterion("sb_type between", value1, value2, "sbType");
            return (Criteria) this;
        }

        public Criteria andSbTypeNotBetween(String value1, String value2) {
            addCriterion("sb_type not between", value1, value2, "sbType");
            return (Criteria) this;
        }

        public Criteria andSbDescriptionIsNull() {
            addCriterion("sb_description is null");
            return (Criteria) this;
        }

        public Criteria andSbDescriptionIsNotNull() {
            addCriterion("sb_description is not null");
            return (Criteria) this;
        }

        public Criteria andSbDescriptionEqualTo(String value) {
            addCriterion("sb_description =", value, "sbDescription");
            return (Criteria) this;
        }

        public Criteria andSbDescriptionNotEqualTo(String value) {
            addCriterion("sb_description <>", value, "sbDescription");
            return (Criteria) this;
        }

        public Criteria andSbDescriptionGreaterThan(String value) {
            addCriterion("sb_description >", value, "sbDescription");
            return (Criteria) this;
        }

        public Criteria andSbDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("sb_description >=", value, "sbDescription");
            return (Criteria) this;
        }

        public Criteria andSbDescriptionLessThan(String value) {
            addCriterion("sb_description <", value, "sbDescription");
            return (Criteria) this;
        }

        public Criteria andSbDescriptionLessThanOrEqualTo(String value) {
            addCriterion("sb_description <=", value, "sbDescription");
            return (Criteria) this;
        }

        public Criteria andSbDescriptionLike(String value) {
            addCriterion("sb_description like", value, "sbDescription");
            return (Criteria) this;
        }

        public Criteria andSbDescriptionNotLike(String value) {
            addCriterion("sb_description not like", value, "sbDescription");
            return (Criteria) this;
        }

        public Criteria andSbDescriptionIn(List<String> values) {
            addCriterion("sb_description in", values, "sbDescription");
            return (Criteria) this;
        }

        public Criteria andSbDescriptionNotIn(List<String> values) {
            addCriterion("sb_description not in", values, "sbDescription");
            return (Criteria) this;
        }

        public Criteria andSbDescriptionBetween(String value1, String value2) {
            addCriterion("sb_description between", value1, value2, "sbDescription");
            return (Criteria) this;
        }

        public Criteria andSbDescriptionNotBetween(String value1, String value2) {
            addCriterion("sb_description not between", value1, value2, "sbDescription");
            return (Criteria) this;
        }

        public Criteria andSbProtocolIdIsNull() {
            addCriterion("sb_protocol_id is null");
            return (Criteria) this;
        }

        public Criteria andSbProtocolIdIsNotNull() {
            addCriterion("sb_protocol_id is not null");
            return (Criteria) this;
        }

        public Criteria andSbProtocolIdEqualTo(Integer value) {
            addCriterion("sb_protocol_id =", value, "sbProtocolId");
            return (Criteria) this;
        }

        public Criteria andSbProtocolIdNotEqualTo(Integer value) {
            addCriterion("sb_protocol_id <>", value, "sbProtocolId");
            return (Criteria) this;
        }

        public Criteria andSbProtocolIdGreaterThan(Integer value) {
            addCriterion("sb_protocol_id >", value, "sbProtocolId");
            return (Criteria) this;
        }

        public Criteria andSbProtocolIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sb_protocol_id >=", value, "sbProtocolId");
            return (Criteria) this;
        }

        public Criteria andSbProtocolIdLessThan(Integer value) {
            addCriterion("sb_protocol_id <", value, "sbProtocolId");
            return (Criteria) this;
        }

        public Criteria andSbProtocolIdLessThanOrEqualTo(Integer value) {
            addCriterion("sb_protocol_id <=", value, "sbProtocolId");
            return (Criteria) this;
        }

        public Criteria andSbProtocolIdIn(List<Integer> values) {
            addCriterion("sb_protocol_id in", values, "sbProtocolId");
            return (Criteria) this;
        }

        public Criteria andSbProtocolIdNotIn(List<Integer> values) {
            addCriterion("sb_protocol_id not in", values, "sbProtocolId");
            return (Criteria) this;
        }

        public Criteria andSbProtocolIdBetween(Integer value1, Integer value2) {
            addCriterion("sb_protocol_id between", value1, value2, "sbProtocolId");
            return (Criteria) this;
        }

        public Criteria andSbProtocolIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sb_protocol_id not between", value1, value2, "sbProtocolId");
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