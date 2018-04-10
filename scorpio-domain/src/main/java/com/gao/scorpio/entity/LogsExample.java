package com.gao.scorpio.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogsExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LogsExample() {
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

        public Criteria andLogIdIsNull() {
            addCriterion("log_id is null");
            return (Criteria) this;
        }

        public Criteria andLogIdIsNotNull() {
            addCriterion("log_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogIdEqualTo(String value) {
            addCriterion("log_id =", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotEqualTo(String value) {
            addCriterion("log_id <>", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThan(String value) {
            addCriterion("log_id >", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThanOrEqualTo(String value) {
            addCriterion("log_id >=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThan(String value) {
            addCriterion("log_id <", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThanOrEqualTo(String value) {
            addCriterion("log_id <=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLike(String value) {
            addCriterion("log_id like", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotLike(String value) {
            addCriterion("log_id not like", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdIn(List<String> values) {
            addCriterion("log_id in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotIn(List<String> values) {
            addCriterion("log_id not in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdBetween(String value1, String value2) {
            addCriterion("log_id between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotBetween(String value1, String value2) {
            addCriterion("log_id not between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andLogTitleIsNull() {
            addCriterion("log_title is null");
            return (Criteria) this;
        }

        public Criteria andLogTitleIsNotNull() {
            addCriterion("log_title is not null");
            return (Criteria) this;
        }

        public Criteria andLogTitleEqualTo(String value) {
            addCriterion("log_title =", value, "logTitle");
            return (Criteria) this;
        }

        public Criteria andLogTitleNotEqualTo(String value) {
            addCriterion("log_title <>", value, "logTitle");
            return (Criteria) this;
        }

        public Criteria andLogTitleGreaterThan(String value) {
            addCriterion("log_title >", value, "logTitle");
            return (Criteria) this;
        }

        public Criteria andLogTitleGreaterThanOrEqualTo(String value) {
            addCriterion("log_title >=", value, "logTitle");
            return (Criteria) this;
        }

        public Criteria andLogTitleLessThan(String value) {
            addCriterion("log_title <", value, "logTitle");
            return (Criteria) this;
        }

        public Criteria andLogTitleLessThanOrEqualTo(String value) {
            addCriterion("log_title <=", value, "logTitle");
            return (Criteria) this;
        }

        public Criteria andLogTitleLike(String value) {
            addCriterion("log_title like", value, "logTitle");
            return (Criteria) this;
        }

        public Criteria andLogTitleNotLike(String value) {
            addCriterion("log_title not like", value, "logTitle");
            return (Criteria) this;
        }

        public Criteria andLogTitleIn(List<String> values) {
            addCriterion("log_title in", values, "logTitle");
            return (Criteria) this;
        }

        public Criteria andLogTitleNotIn(List<String> values) {
            addCriterion("log_title not in", values, "logTitle");
            return (Criteria) this;
        }

        public Criteria andLogTitleBetween(String value1, String value2) {
            addCriterion("log_title between", value1, value2, "logTitle");
            return (Criteria) this;
        }

        public Criteria andLogTitleNotBetween(String value1, String value2) {
            addCriterion("log_title not between", value1, value2, "logTitle");
            return (Criteria) this;
        }

        public Criteria andLogSummaryIsNull() {
            addCriterion("log_summary is null");
            return (Criteria) this;
        }

        public Criteria andLogSummaryIsNotNull() {
            addCriterion("log_summary is not null");
            return (Criteria) this;
        }

        public Criteria andLogSummaryEqualTo(String value) {
            addCriterion("log_summary =", value, "logSummary");
            return (Criteria) this;
        }

        public Criteria andLogSummaryNotEqualTo(String value) {
            addCriterion("log_summary <>", value, "logSummary");
            return (Criteria) this;
        }

        public Criteria andLogSummaryGreaterThan(String value) {
            addCriterion("log_summary >", value, "logSummary");
            return (Criteria) this;
        }

        public Criteria andLogSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("log_summary >=", value, "logSummary");
            return (Criteria) this;
        }

        public Criteria andLogSummaryLessThan(String value) {
            addCriterion("log_summary <", value, "logSummary");
            return (Criteria) this;
        }

        public Criteria andLogSummaryLessThanOrEqualTo(String value) {
            addCriterion("log_summary <=", value, "logSummary");
            return (Criteria) this;
        }

        public Criteria andLogSummaryLike(String value) {
            addCriterion("log_summary like", value, "logSummary");
            return (Criteria) this;
        }

        public Criteria andLogSummaryNotLike(String value) {
            addCriterion("log_summary not like", value, "logSummary");
            return (Criteria) this;
        }

        public Criteria andLogSummaryIn(List<String> values) {
            addCriterion("log_summary in", values, "logSummary");
            return (Criteria) this;
        }

        public Criteria andLogSummaryNotIn(List<String> values) {
            addCriterion("log_summary not in", values, "logSummary");
            return (Criteria) this;
        }

        public Criteria andLogSummaryBetween(String value1, String value2) {
            addCriterion("log_summary between", value1, value2, "logSummary");
            return (Criteria) this;
        }

        public Criteria andLogSummaryNotBetween(String value1, String value2) {
            addCriterion("log_summary not between", value1, value2, "logSummary");
            return (Criteria) this;
        }

        public Criteria andLogContentIsNull() {
            addCriterion("log_content is null");
            return (Criteria) this;
        }

        public Criteria andLogContentIsNotNull() {
            addCriterion("log_content is not null");
            return (Criteria) this;
        }

        public Criteria andLogContentEqualTo(String value) {
            addCriterion("log_content =", value, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentNotEqualTo(String value) {
            addCriterion("log_content <>", value, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentGreaterThan(String value) {
            addCriterion("log_content >", value, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentGreaterThanOrEqualTo(String value) {
            addCriterion("log_content >=", value, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentLessThan(String value) {
            addCriterion("log_content <", value, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentLessThanOrEqualTo(String value) {
            addCriterion("log_content <=", value, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentLike(String value) {
            addCriterion("log_content like", value, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentNotLike(String value) {
            addCriterion("log_content not like", value, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentIn(List<String> values) {
            addCriterion("log_content in", values, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentNotIn(List<String> values) {
            addCriterion("log_content not in", values, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentBetween(String value1, String value2) {
            addCriterion("log_content between", value1, value2, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogContentNotBetween(String value1, String value2) {
            addCriterion("log_content not between", value1, value2, "logContent");
            return (Criteria) this;
        }

        public Criteria andLogCreatedIsNull() {
            addCriterion("log_created is null");
            return (Criteria) this;
        }

        public Criteria andLogCreatedIsNotNull() {
            addCriterion("log_created is not null");
            return (Criteria) this;
        }

        public Criteria andLogCreatedEqualTo(Date value) {
            addCriterion("log_created =", value, "logCreated");
            return (Criteria) this;
        }

        public Criteria andLogCreatedNotEqualTo(Date value) {
            addCriterion("log_created <>", value, "logCreated");
            return (Criteria) this;
        }

        public Criteria andLogCreatedGreaterThan(Date value) {
            addCriterion("log_created >", value, "logCreated");
            return (Criteria) this;
        }

        public Criteria andLogCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("log_created >=", value, "logCreated");
            return (Criteria) this;
        }

        public Criteria andLogCreatedLessThan(Date value) {
            addCriterion("log_created <", value, "logCreated");
            return (Criteria) this;
        }

        public Criteria andLogCreatedLessThanOrEqualTo(Date value) {
            addCriterion("log_created <=", value, "logCreated");
            return (Criteria) this;
        }

        public Criteria andLogCreatedIn(List<Date> values) {
            addCriterion("log_created in", values, "logCreated");
            return (Criteria) this;
        }

        public Criteria andLogCreatedNotIn(List<Date> values) {
            addCriterion("log_created not in", values, "logCreated");
            return (Criteria) this;
        }

        public Criteria andLogCreatedBetween(Date value1, Date value2) {
            addCriterion("log_created between", value1, value2, "logCreated");
            return (Criteria) this;
        }

        public Criteria andLogCreatedNotBetween(Date value1, Date value2) {
            addCriterion("log_created not between", value1, value2, "logCreated");
            return (Criteria) this;
        }

        public Criteria andLogUpdateIsNull() {
            addCriterion("log_update is null");
            return (Criteria) this;
        }

        public Criteria andLogUpdateIsNotNull() {
            addCriterion("log_update is not null");
            return (Criteria) this;
        }

        public Criteria andLogUpdateEqualTo(Date value) {
            addCriterion("log_update =", value, "logUpdate");
            return (Criteria) this;
        }

        public Criteria andLogUpdateNotEqualTo(Date value) {
            addCriterion("log_update <>", value, "logUpdate");
            return (Criteria) this;
        }

        public Criteria andLogUpdateGreaterThan(Date value) {
            addCriterion("log_update >", value, "logUpdate");
            return (Criteria) this;
        }

        public Criteria andLogUpdateGreaterThanOrEqualTo(Date value) {
            addCriterion("log_update >=", value, "logUpdate");
            return (Criteria) this;
        }

        public Criteria andLogUpdateLessThan(Date value) {
            addCriterion("log_update <", value, "logUpdate");
            return (Criteria) this;
        }

        public Criteria andLogUpdateLessThanOrEqualTo(Date value) {
            addCriterion("log_update <=", value, "logUpdate");
            return (Criteria) this;
        }

        public Criteria andLogUpdateIn(List<Date> values) {
            addCriterion("log_update in", values, "logUpdate");
            return (Criteria) this;
        }

        public Criteria andLogUpdateNotIn(List<Date> values) {
            addCriterion("log_update not in", values, "logUpdate");
            return (Criteria) this;
        }

        public Criteria andLogUpdateBetween(Date value1, Date value2) {
            addCriterion("log_update between", value1, value2, "logUpdate");
            return (Criteria) this;
        }

        public Criteria andLogUpdateNotBetween(Date value1, Date value2) {
            addCriterion("log_update not between", value1, value2, "logUpdate");
            return (Criteria) this;
        }
        public Criteria andCountIsNull() {
            addCriterion("count is null");
            return (Criteria) this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("count is not null");
            return (Criteria) this;
        }

        public Criteria andCountEqualTo(Integer value) {
            addCriterion("count =", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(Integer value) {
            addCriterion("count <>", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(Integer value) {
            addCriterion("count >", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("count >=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThan(Integer value) {
            addCriterion("count <", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(Integer value) {
            addCriterion("count <=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountIn(List<Integer> values) {
            addCriterion("count in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<Integer> values) {
            addCriterion("count not in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(Integer value1, Integer value2) {
            addCriterion("count between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(Integer value1, Integer value2) {
            addCriterion("count not between", value1, value2, "count");
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