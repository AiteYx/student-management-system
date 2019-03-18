package com.hbsfdx.system.pojo;

import java.util.ArrayList;
import java.util.List;

public class ClassScheduleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClassScheduleExample() {
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

        public Criteria andClassIdIsNull() {
            addCriterion("class_id is null");
            return (Criteria) this;
        }

        public Criteria andClassIdIsNotNull() {
            addCriterion("class_id is not null");
            return (Criteria) this;
        }

        public Criteria andClassIdEqualTo(Long value) {
            addCriterion("class_id =", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotEqualTo(Long value) {
            addCriterion("class_id <>", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThan(Long value) {
            addCriterion("class_id >", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThanOrEqualTo(Long value) {
            addCriterion("class_id >=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThan(Long value) {
            addCriterion("class_id <", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThanOrEqualTo(Long value) {
            addCriterion("class_id <=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdIn(List<Long> values) {
            addCriterion("class_id in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotIn(List<Long> values) {
            addCriterion("class_id not in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdBetween(Long value1, Long value2) {
            addCriterion("class_id between", value1, value2, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotBetween(Long value1, Long value2) {
            addCriterion("class_id not between", value1, value2, "classId");
            return (Criteria) this;
        }

        public Criteria andWeekIsNull() {
            addCriterion("week is null");
            return (Criteria) this;
        }

        public Criteria andWeekIsNotNull() {
            addCriterion("week is not null");
            return (Criteria) this;
        }

        public Criteria andWeekEqualTo(Long value) {
            addCriterion("week =", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotEqualTo(Long value) {
            addCriterion("week <>", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekGreaterThan(Long value) {
            addCriterion("week >", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekGreaterThanOrEqualTo(Long value) {
            addCriterion("week >=", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLessThan(Long value) {
            addCriterion("week <", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLessThanOrEqualTo(Long value) {
            addCriterion("week <=", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekIn(List<Long> values) {
            addCriterion("week in", values, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotIn(List<Long> values) {
            addCriterion("week not in", values, "week");
            return (Criteria) this;
        }

        public Criteria andWeekBetween(Long value1, Long value2) {
            addCriterion("week between", value1, value2, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotBetween(Long value1, Long value2) {
            addCriterion("week not between", value1, value2, "week");
            return (Criteria) this;
        }

        public Criteria andAm1IsNull() {
            addCriterion("am1 is null");
            return (Criteria) this;
        }

        public Criteria andAm1IsNotNull() {
            addCriterion("am1 is not null");
            return (Criteria) this;
        }

        public Criteria andAm1EqualTo(String value) {
            addCriterion("am1 =", value, "am1");
            return (Criteria) this;
        }

        public Criteria andAm1NotEqualTo(String value) {
            addCriterion("am1 <>", value, "am1");
            return (Criteria) this;
        }

        public Criteria andAm1GreaterThan(String value) {
            addCriterion("am1 >", value, "am1");
            return (Criteria) this;
        }

        public Criteria andAm1GreaterThanOrEqualTo(String value) {
            addCriterion("am1 >=", value, "am1");
            return (Criteria) this;
        }

        public Criteria andAm1LessThan(String value) {
            addCriterion("am1 <", value, "am1");
            return (Criteria) this;
        }

        public Criteria andAm1LessThanOrEqualTo(String value) {
            addCriterion("am1 <=", value, "am1");
            return (Criteria) this;
        }

        public Criteria andAm1Like(String value) {
            addCriterion("am1 like", value, "am1");
            return (Criteria) this;
        }

        public Criteria andAm1NotLike(String value) {
            addCriterion("am1 not like", value, "am1");
            return (Criteria) this;
        }

        public Criteria andAm1In(List<String> values) {
            addCriterion("am1 in", values, "am1");
            return (Criteria) this;
        }

        public Criteria andAm1NotIn(List<String> values) {
            addCriterion("am1 not in", values, "am1");
            return (Criteria) this;
        }

        public Criteria andAm1Between(String value1, String value2) {
            addCriterion("am1 between", value1, value2, "am1");
            return (Criteria) this;
        }

        public Criteria andAm1NotBetween(String value1, String value2) {
            addCriterion("am1 not between", value1, value2, "am1");
            return (Criteria) this;
        }

        public Criteria andAm2IsNull() {
            addCriterion("am2 is null");
            return (Criteria) this;
        }

        public Criteria andAm2IsNotNull() {
            addCriterion("am2 is not null");
            return (Criteria) this;
        }

        public Criteria andAm2EqualTo(String value) {
            addCriterion("am2 =", value, "am2");
            return (Criteria) this;
        }

        public Criteria andAm2NotEqualTo(String value) {
            addCriterion("am2 <>", value, "am2");
            return (Criteria) this;
        }

        public Criteria andAm2GreaterThan(String value) {
            addCriterion("am2 >", value, "am2");
            return (Criteria) this;
        }

        public Criteria andAm2GreaterThanOrEqualTo(String value) {
            addCriterion("am2 >=", value, "am2");
            return (Criteria) this;
        }

        public Criteria andAm2LessThan(String value) {
            addCriterion("am2 <", value, "am2");
            return (Criteria) this;
        }

        public Criteria andAm2LessThanOrEqualTo(String value) {
            addCriterion("am2 <=", value, "am2");
            return (Criteria) this;
        }

        public Criteria andAm2Like(String value) {
            addCriterion("am2 like", value, "am2");
            return (Criteria) this;
        }

        public Criteria andAm2NotLike(String value) {
            addCriterion("am2 not like", value, "am2");
            return (Criteria) this;
        }

        public Criteria andAm2In(List<String> values) {
            addCriterion("am2 in", values, "am2");
            return (Criteria) this;
        }

        public Criteria andAm2NotIn(List<String> values) {
            addCriterion("am2 not in", values, "am2");
            return (Criteria) this;
        }

        public Criteria andAm2Between(String value1, String value2) {
            addCriterion("am2 between", value1, value2, "am2");
            return (Criteria) this;
        }

        public Criteria andAm2NotBetween(String value1, String value2) {
            addCriterion("am2 not between", value1, value2, "am2");
            return (Criteria) this;
        }

        public Criteria andPm1IsNull() {
            addCriterion("pm1 is null");
            return (Criteria) this;
        }

        public Criteria andPm1IsNotNull() {
            addCriterion("pm1 is not null");
            return (Criteria) this;
        }

        public Criteria andPm1EqualTo(String value) {
            addCriterion("pm1 =", value, "pm1");
            return (Criteria) this;
        }

        public Criteria andPm1NotEqualTo(String value) {
            addCriterion("pm1 <>", value, "pm1");
            return (Criteria) this;
        }

        public Criteria andPm1GreaterThan(String value) {
            addCriterion("pm1 >", value, "pm1");
            return (Criteria) this;
        }

        public Criteria andPm1GreaterThanOrEqualTo(String value) {
            addCriterion("pm1 >=", value, "pm1");
            return (Criteria) this;
        }

        public Criteria andPm1LessThan(String value) {
            addCriterion("pm1 <", value, "pm1");
            return (Criteria) this;
        }

        public Criteria andPm1LessThanOrEqualTo(String value) {
            addCriterion("pm1 <=", value, "pm1");
            return (Criteria) this;
        }

        public Criteria andPm1Like(String value) {
            addCriterion("pm1 like", value, "pm1");
            return (Criteria) this;
        }

        public Criteria andPm1NotLike(String value) {
            addCriterion("pm1 not like", value, "pm1");
            return (Criteria) this;
        }

        public Criteria andPm1In(List<String> values) {
            addCriterion("pm1 in", values, "pm1");
            return (Criteria) this;
        }

        public Criteria andPm1NotIn(List<String> values) {
            addCriterion("pm1 not in", values, "pm1");
            return (Criteria) this;
        }

        public Criteria andPm1Between(String value1, String value2) {
            addCriterion("pm1 between", value1, value2, "pm1");
            return (Criteria) this;
        }

        public Criteria andPm1NotBetween(String value1, String value2) {
            addCriterion("pm1 not between", value1, value2, "pm1");
            return (Criteria) this;
        }

        public Criteria andPm2IsNull() {
            addCriterion("pm2 is null");
            return (Criteria) this;
        }

        public Criteria andPm2IsNotNull() {
            addCriterion("pm2 is not null");
            return (Criteria) this;
        }

        public Criteria andPm2EqualTo(String value) {
            addCriterion("pm2 =", value, "pm2");
            return (Criteria) this;
        }

        public Criteria andPm2NotEqualTo(String value) {
            addCriterion("pm2 <>", value, "pm2");
            return (Criteria) this;
        }

        public Criteria andPm2GreaterThan(String value) {
            addCriterion("pm2 >", value, "pm2");
            return (Criteria) this;
        }

        public Criteria andPm2GreaterThanOrEqualTo(String value) {
            addCriterion("pm2 >=", value, "pm2");
            return (Criteria) this;
        }

        public Criteria andPm2LessThan(String value) {
            addCriterion("pm2 <", value, "pm2");
            return (Criteria) this;
        }

        public Criteria andPm2LessThanOrEqualTo(String value) {
            addCriterion("pm2 <=", value, "pm2");
            return (Criteria) this;
        }

        public Criteria andPm2Like(String value) {
            addCriterion("pm2 like", value, "pm2");
            return (Criteria) this;
        }

        public Criteria andPm2NotLike(String value) {
            addCriterion("pm2 not like", value, "pm2");
            return (Criteria) this;
        }

        public Criteria andPm2In(List<String> values) {
            addCriterion("pm2 in", values, "pm2");
            return (Criteria) this;
        }

        public Criteria andPm2NotIn(List<String> values) {
            addCriterion("pm2 not in", values, "pm2");
            return (Criteria) this;
        }

        public Criteria andPm2Between(String value1, String value2) {
            addCriterion("pm2 between", value1, value2, "pm2");
            return (Criteria) this;
        }

        public Criteria andPm2NotBetween(String value1, String value2) {
            addCriterion("pm2 not between", value1, value2, "pm2");
            return (Criteria) this;
        }

        public Criteria andWeekTimesIsNull() {
            addCriterion("week_times is null");
            return (Criteria) this;
        }

        public Criteria andWeekTimesIsNotNull() {
            addCriterion("week_times is not null");
            return (Criteria) this;
        }

        public Criteria andWeekTimesEqualTo(String value) {
            addCriterion("week_times =", value, "weekTimes");
            return (Criteria) this;
        }

        public Criteria andWeekTimesNotEqualTo(String value) {
            addCriterion("week_times <>", value, "weekTimes");
            return (Criteria) this;
        }

        public Criteria andWeekTimesGreaterThan(String value) {
            addCriterion("week_times >", value, "weekTimes");
            return (Criteria) this;
        }

        public Criteria andWeekTimesGreaterThanOrEqualTo(String value) {
            addCriterion("week_times >=", value, "weekTimes");
            return (Criteria) this;
        }

        public Criteria andWeekTimesLessThan(String value) {
            addCriterion("week_times <", value, "weekTimes");
            return (Criteria) this;
        }

        public Criteria andWeekTimesLessThanOrEqualTo(String value) {
            addCriterion("week_times <=", value, "weekTimes");
            return (Criteria) this;
        }

        public Criteria andWeekTimesLike(String value) {
            addCriterion("week_times like", value, "weekTimes");
            return (Criteria) this;
        }

        public Criteria andWeekTimesNotLike(String value) {
            addCriterion("week_times not like", value, "weekTimes");
            return (Criteria) this;
        }

        public Criteria andWeekTimesIn(List<String> values) {
            addCriterion("week_times in", values, "weekTimes");
            return (Criteria) this;
        }

        public Criteria andWeekTimesNotIn(List<String> values) {
            addCriterion("week_times not in", values, "weekTimes");
            return (Criteria) this;
        }

        public Criteria andWeekTimesBetween(String value1, String value2) {
            addCriterion("week_times between", value1, value2, "weekTimes");
            return (Criteria) this;
        }

        public Criteria andWeekTimesNotBetween(String value1, String value2) {
            addCriterion("week_times not between", value1, value2, "weekTimes");
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