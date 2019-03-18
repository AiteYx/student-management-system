package com.hbsfdx.system.pojo;

import java.util.ArrayList;
import java.util.List;

public class StudentEvaluationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentEvaluationExample() {
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

        public Criteria andStudentIdIsNull() {
            addCriterion("student_id is null");
            return (Criteria) this;
        }

        public Criteria andStudentIdIsNotNull() {
            addCriterion("student_id is not null");
            return (Criteria) this;
        }

        public Criteria andStudentIdEqualTo(Long value) {
            addCriterion("student_id =", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotEqualTo(Long value) {
            addCriterion("student_id <>", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThan(Long value) {
            addCriterion("student_id >", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("student_id >=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThan(Long value) {
            addCriterion("student_id <", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThanOrEqualTo(Long value) {
            addCriterion("student_id <=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdIn(List<Long> values) {
            addCriterion("student_id in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotIn(List<Long> values) {
            addCriterion("student_id not in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdBetween(Long value1, Long value2) {
            addCriterion("student_id between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotBetween(Long value1, Long value2) {
            addCriterion("student_id not between", value1, value2, "studentId");
            return (Criteria) this;
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

        public Criteria andA1IsNull() {
            addCriterion("A1 is null");
            return (Criteria) this;
        }

        public Criteria andA1IsNotNull() {
            addCriterion("A1 is not null");
            return (Criteria) this;
        }

        public Criteria andA1EqualTo(Long value) {
            addCriterion("A1 =", value, "a1");
            return (Criteria) this;
        }

        public Criteria andA1NotEqualTo(Long value) {
            addCriterion("A1 <>", value, "a1");
            return (Criteria) this;
        }

        public Criteria andA1GreaterThan(Long value) {
            addCriterion("A1 >", value, "a1");
            return (Criteria) this;
        }

        public Criteria andA1GreaterThanOrEqualTo(Long value) {
            addCriterion("A1 >=", value, "a1");
            return (Criteria) this;
        }

        public Criteria andA1LessThan(Long value) {
            addCriterion("A1 <", value, "a1");
            return (Criteria) this;
        }

        public Criteria andA1LessThanOrEqualTo(Long value) {
            addCriterion("A1 <=", value, "a1");
            return (Criteria) this;
        }

        public Criteria andA1In(List<Long> values) {
            addCriterion("A1 in", values, "a1");
            return (Criteria) this;
        }

        public Criteria andA1NotIn(List<Long> values) {
            addCriterion("A1 not in", values, "a1");
            return (Criteria) this;
        }

        public Criteria andA1Between(Long value1, Long value2) {
            addCriterion("A1 between", value1, value2, "a1");
            return (Criteria) this;
        }

        public Criteria andA1NotBetween(Long value1, Long value2) {
            addCriterion("A1 not between", value1, value2, "a1");
            return (Criteria) this;
        }

        public Criteria andA2IsNull() {
            addCriterion("A2 is null");
            return (Criteria) this;
        }

        public Criteria andA2IsNotNull() {
            addCriterion("A2 is not null");
            return (Criteria) this;
        }

        public Criteria andA2EqualTo(Long value) {
            addCriterion("A2 =", value, "a2");
            return (Criteria) this;
        }

        public Criteria andA2NotEqualTo(Long value) {
            addCriterion("A2 <>", value, "a2");
            return (Criteria) this;
        }

        public Criteria andA2GreaterThan(Long value) {
            addCriterion("A2 >", value, "a2");
            return (Criteria) this;
        }

        public Criteria andA2GreaterThanOrEqualTo(Long value) {
            addCriterion("A2 >=", value, "a2");
            return (Criteria) this;
        }

        public Criteria andA2LessThan(Long value) {
            addCriterion("A2 <", value, "a2");
            return (Criteria) this;
        }

        public Criteria andA2LessThanOrEqualTo(Long value) {
            addCriterion("A2 <=", value, "a2");
            return (Criteria) this;
        }

        public Criteria andA2In(List<Long> values) {
            addCriterion("A2 in", values, "a2");
            return (Criteria) this;
        }

        public Criteria andA2NotIn(List<Long> values) {
            addCriterion("A2 not in", values, "a2");
            return (Criteria) this;
        }

        public Criteria andA2Between(Long value1, Long value2) {
            addCriterion("A2 between", value1, value2, "a2");
            return (Criteria) this;
        }

        public Criteria andA2NotBetween(Long value1, Long value2) {
            addCriterion("A2 not between", value1, value2, "a2");
            return (Criteria) this;
        }

        public Criteria andA3IsNull() {
            addCriterion("A3 is null");
            return (Criteria) this;
        }

        public Criteria andA3IsNotNull() {
            addCriterion("A3 is not null");
            return (Criteria) this;
        }

        public Criteria andA3EqualTo(Long value) {
            addCriterion("A3 =", value, "a3");
            return (Criteria) this;
        }

        public Criteria andA3NotEqualTo(Long value) {
            addCriterion("A3 <>", value, "a3");
            return (Criteria) this;
        }

        public Criteria andA3GreaterThan(Long value) {
            addCriterion("A3 >", value, "a3");
            return (Criteria) this;
        }

        public Criteria andA3GreaterThanOrEqualTo(Long value) {
            addCriterion("A3 >=", value, "a3");
            return (Criteria) this;
        }

        public Criteria andA3LessThan(Long value) {
            addCriterion("A3 <", value, "a3");
            return (Criteria) this;
        }

        public Criteria andA3LessThanOrEqualTo(Long value) {
            addCriterion("A3 <=", value, "a3");
            return (Criteria) this;
        }

        public Criteria andA3In(List<Long> values) {
            addCriterion("A3 in", values, "a3");
            return (Criteria) this;
        }

        public Criteria andA3NotIn(List<Long> values) {
            addCriterion("A3 not in", values, "a3");
            return (Criteria) this;
        }

        public Criteria andA3Between(Long value1, Long value2) {
            addCriterion("A3 between", value1, value2, "a3");
            return (Criteria) this;
        }

        public Criteria andA3NotBetween(Long value1, Long value2) {
            addCriterion("A3 not between", value1, value2, "a3");
            return (Criteria) this;
        }

        public Criteria andA4IsNull() {
            addCriterion("A4 is null");
            return (Criteria) this;
        }

        public Criteria andA4IsNotNull() {
            addCriterion("A4 is not null");
            return (Criteria) this;
        }

        public Criteria andA4EqualTo(Long value) {
            addCriterion("A4 =", value, "a4");
            return (Criteria) this;
        }

        public Criteria andA4NotEqualTo(Long value) {
            addCriterion("A4 <>", value, "a4");
            return (Criteria) this;
        }

        public Criteria andA4GreaterThan(Long value) {
            addCriterion("A4 >", value, "a4");
            return (Criteria) this;
        }

        public Criteria andA4GreaterThanOrEqualTo(Long value) {
            addCriterion("A4 >=", value, "a4");
            return (Criteria) this;
        }

        public Criteria andA4LessThan(Long value) {
            addCriterion("A4 <", value, "a4");
            return (Criteria) this;
        }

        public Criteria andA4LessThanOrEqualTo(Long value) {
            addCriterion("A4 <=", value, "a4");
            return (Criteria) this;
        }

        public Criteria andA4In(List<Long> values) {
            addCriterion("A4 in", values, "a4");
            return (Criteria) this;
        }

        public Criteria andA4NotIn(List<Long> values) {
            addCriterion("A4 not in", values, "a4");
            return (Criteria) this;
        }

        public Criteria andA4Between(Long value1, Long value2) {
            addCriterion("A4 between", value1, value2, "a4");
            return (Criteria) this;
        }

        public Criteria andA4NotBetween(Long value1, Long value2) {
            addCriterion("A4 not between", value1, value2, "a4");
            return (Criteria) this;
        }

        public Criteria andA5IsNull() {
            addCriterion("A5 is null");
            return (Criteria) this;
        }

        public Criteria andA5IsNotNull() {
            addCriterion("A5 is not null");
            return (Criteria) this;
        }

        public Criteria andA5EqualTo(Long value) {
            addCriterion("A5 =", value, "a5");
            return (Criteria) this;
        }

        public Criteria andA5NotEqualTo(Long value) {
            addCriterion("A5 <>", value, "a5");
            return (Criteria) this;
        }

        public Criteria andA5GreaterThan(Long value) {
            addCriterion("A5 >", value, "a5");
            return (Criteria) this;
        }

        public Criteria andA5GreaterThanOrEqualTo(Long value) {
            addCriterion("A5 >=", value, "a5");
            return (Criteria) this;
        }

        public Criteria andA5LessThan(Long value) {
            addCriterion("A5 <", value, "a5");
            return (Criteria) this;
        }

        public Criteria andA5LessThanOrEqualTo(Long value) {
            addCriterion("A5 <=", value, "a5");
            return (Criteria) this;
        }

        public Criteria andA5In(List<Long> values) {
            addCriterion("A5 in", values, "a5");
            return (Criteria) this;
        }

        public Criteria andA5NotIn(List<Long> values) {
            addCriterion("A5 not in", values, "a5");
            return (Criteria) this;
        }

        public Criteria andA5Between(Long value1, Long value2) {
            addCriterion("A5 between", value1, value2, "a5");
            return (Criteria) this;
        }

        public Criteria andA5NotBetween(Long value1, Long value2) {
            addCriterion("A5 not between", value1, value2, "a5");
            return (Criteria) this;
        }

        public Criteria andA6IsNull() {
            addCriterion("A6 is null");
            return (Criteria) this;
        }

        public Criteria andA6IsNotNull() {
            addCriterion("A6 is not null");
            return (Criteria) this;
        }

        public Criteria andA6EqualTo(Long value) {
            addCriterion("A6 =", value, "a6");
            return (Criteria) this;
        }

        public Criteria andA6NotEqualTo(Long value) {
            addCriterion("A6 <>", value, "a6");
            return (Criteria) this;
        }

        public Criteria andA6GreaterThan(Long value) {
            addCriterion("A6 >", value, "a6");
            return (Criteria) this;
        }

        public Criteria andA6GreaterThanOrEqualTo(Long value) {
            addCriterion("A6 >=", value, "a6");
            return (Criteria) this;
        }

        public Criteria andA6LessThan(Long value) {
            addCriterion("A6 <", value, "a6");
            return (Criteria) this;
        }

        public Criteria andA6LessThanOrEqualTo(Long value) {
            addCriterion("A6 <=", value, "a6");
            return (Criteria) this;
        }

        public Criteria andA6In(List<Long> values) {
            addCriterion("A6 in", values, "a6");
            return (Criteria) this;
        }

        public Criteria andA6NotIn(List<Long> values) {
            addCriterion("A6 not in", values, "a6");
            return (Criteria) this;
        }

        public Criteria andA6Between(Long value1, Long value2) {
            addCriterion("A6 between", value1, value2, "a6");
            return (Criteria) this;
        }

        public Criteria andA6NotBetween(Long value1, Long value2) {
            addCriterion("A6 not between", value1, value2, "a6");
            return (Criteria) this;
        }

        public Criteria andR1IsNull() {
            addCriterion("R1 is null");
            return (Criteria) this;
        }

        public Criteria andR1IsNotNull() {
            addCriterion("R1 is not null");
            return (Criteria) this;
        }

        public Criteria andR1EqualTo(Long value) {
            addCriterion("R1 =", value, "r1");
            return (Criteria) this;
        }

        public Criteria andR1NotEqualTo(Long value) {
            addCriterion("R1 <>", value, "r1");
            return (Criteria) this;
        }

        public Criteria andR1GreaterThan(Long value) {
            addCriterion("R1 >", value, "r1");
            return (Criteria) this;
        }

        public Criteria andR1GreaterThanOrEqualTo(Long value) {
            addCriterion("R1 >=", value, "r1");
            return (Criteria) this;
        }

        public Criteria andR1LessThan(Long value) {
            addCriterion("R1 <", value, "r1");
            return (Criteria) this;
        }

        public Criteria andR1LessThanOrEqualTo(Long value) {
            addCriterion("R1 <=", value, "r1");
            return (Criteria) this;
        }

        public Criteria andR1In(List<Long> values) {
            addCriterion("R1 in", values, "r1");
            return (Criteria) this;
        }

        public Criteria andR1NotIn(List<Long> values) {
            addCriterion("R1 not in", values, "r1");
            return (Criteria) this;
        }

        public Criteria andR1Between(Long value1, Long value2) {
            addCriterion("R1 between", value1, value2, "r1");
            return (Criteria) this;
        }

        public Criteria andR1NotBetween(Long value1, Long value2) {
            addCriterion("R1 not between", value1, value2, "r1");
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