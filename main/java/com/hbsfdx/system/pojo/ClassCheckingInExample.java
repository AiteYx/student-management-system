package com.hbsfdx.system.pojo;

import java.util.ArrayList;
import java.util.List;

public class ClassCheckingInExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClassCheckingInExample() {
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

        public Criteria andTermIsNull() {
            addCriterion("term is null");
            return (Criteria) this;
        }

        public Criteria andTermIsNotNull() {
            addCriterion("term is not null");
            return (Criteria) this;
        }

        public Criteria andTermEqualTo(String value) {
            addCriterion("term =", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotEqualTo(String value) {
            addCriterion("term <>", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermGreaterThan(String value) {
            addCriterion("term >", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermGreaterThanOrEqualTo(String value) {
            addCriterion("term >=", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermLessThan(String value) {
            addCriterion("term <", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermLessThanOrEqualTo(String value) {
            addCriterion("term <=", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermLike(String value) {
            addCriterion("term like", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotLike(String value) {
            addCriterion("term not like", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermIn(List<String> values) {
            addCriterion("term in", values, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotIn(List<String> values) {
            addCriterion("term not in", values, "term");
            return (Criteria) this;
        }

        public Criteria andTermBetween(String value1, String value2) {
            addCriterion("term between", value1, value2, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotBetween(String value1, String value2) {
            addCriterion("term not between", value1, value2, "term");
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

        public Criteria andWeekTimesEqualTo(Long value) {
            addCriterion("week_times =", value, "weekTimes");
            return (Criteria) this;
        }

        public Criteria andWeekTimesNotEqualTo(Long value) {
            addCriterion("week_times <>", value, "weekTimes");
            return (Criteria) this;
        }

        public Criteria andWeekTimesGreaterThan(Long value) {
            addCriterion("week_times >", value, "weekTimes");
            return (Criteria) this;
        }

        public Criteria andWeekTimesGreaterThanOrEqualTo(Long value) {
            addCriterion("week_times >=", value, "weekTimes");
            return (Criteria) this;
        }

        public Criteria andWeekTimesLessThan(Long value) {
            addCriterion("week_times <", value, "weekTimes");
            return (Criteria) this;
        }

        public Criteria andWeekTimesLessThanOrEqualTo(Long value) {
            addCriterion("week_times <=", value, "weekTimes");
            return (Criteria) this;
        }

        public Criteria andWeekTimesIn(List<Long> values) {
            addCriterion("week_times in", values, "weekTimes");
            return (Criteria) this;
        }

        public Criteria andWeekTimesNotIn(List<Long> values) {
            addCriterion("week_times not in", values, "weekTimes");
            return (Criteria) this;
        }

        public Criteria andWeekTimesBetween(Long value1, Long value2) {
            addCriterion("week_times between", value1, value2, "weekTimes");
            return (Criteria) this;
        }

        public Criteria andWeekTimesNotBetween(Long value1, Long value2) {
            addCriterion("week_times not between", value1, value2, "weekTimes");
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

        public Criteria andWeekEqualTo(String value) {
            addCriterion("week =", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotEqualTo(String value) {
            addCriterion("week <>", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekGreaterThan(String value) {
            addCriterion("week >", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekGreaterThanOrEqualTo(String value) {
            addCriterion("week >=", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLessThan(String value) {
            addCriterion("week <", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLessThanOrEqualTo(String value) {
            addCriterion("week <=", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLike(String value) {
            addCriterion("week like", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotLike(String value) {
            addCriterion("week not like", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekIn(List<String> values) {
            addCriterion("week in", values, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotIn(List<String> values) {
            addCriterion("week not in", values, "week");
            return (Criteria) this;
        }

        public Criteria andWeekBetween(String value1, String value2) {
            addCriterion("week between", value1, value2, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotBetween(String value1, String value2) {
            addCriterion("week not between", value1, value2, "week");
            return (Criteria) this;
        }

        public Criteria andCourseTimeIsNull() {
            addCriterion("course_time is null");
            return (Criteria) this;
        }

        public Criteria andCourseTimeIsNotNull() {
            addCriterion("course_time is not null");
            return (Criteria) this;
        }

        public Criteria andCourseTimeEqualTo(String value) {
            addCriterion("course_time =", value, "courseTime");
            return (Criteria) this;
        }

        public Criteria andCourseTimeNotEqualTo(String value) {
            addCriterion("course_time <>", value, "courseTime");
            return (Criteria) this;
        }

        public Criteria andCourseTimeGreaterThan(String value) {
            addCriterion("course_time >", value, "courseTime");
            return (Criteria) this;
        }

        public Criteria andCourseTimeGreaterThanOrEqualTo(String value) {
            addCriterion("course_time >=", value, "courseTime");
            return (Criteria) this;
        }

        public Criteria andCourseTimeLessThan(String value) {
            addCriterion("course_time <", value, "courseTime");
            return (Criteria) this;
        }

        public Criteria andCourseTimeLessThanOrEqualTo(String value) {
            addCriterion("course_time <=", value, "courseTime");
            return (Criteria) this;
        }

        public Criteria andCourseTimeLike(String value) {
            addCriterion("course_time like", value, "courseTime");
            return (Criteria) this;
        }

        public Criteria andCourseTimeNotLike(String value) {
            addCriterion("course_time not like", value, "courseTime");
            return (Criteria) this;
        }

        public Criteria andCourseTimeIn(List<String> values) {
            addCriterion("course_time in", values, "courseTime");
            return (Criteria) this;
        }

        public Criteria andCourseTimeNotIn(List<String> values) {
            addCriterion("course_time not in", values, "courseTime");
            return (Criteria) this;
        }

        public Criteria andCourseTimeBetween(String value1, String value2) {
            addCriterion("course_time between", value1, value2, "courseTime");
            return (Criteria) this;
        }

        public Criteria andCourseTimeNotBetween(String value1, String value2) {
            addCriterion("course_time not between", value1, value2, "courseTime");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismIsNull() {
            addCriterion("absenteeism is null");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismIsNotNull() {
            addCriterion("absenteeism is not null");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismEqualTo(Long value) {
            addCriterion("absenteeism =", value, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismNotEqualTo(Long value) {
            addCriterion("absenteeism <>", value, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismGreaterThan(Long value) {
            addCriterion("absenteeism >", value, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismGreaterThanOrEqualTo(Long value) {
            addCriterion("absenteeism >=", value, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismLessThan(Long value) {
            addCriterion("absenteeism <", value, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismLessThanOrEqualTo(Long value) {
            addCriterion("absenteeism <=", value, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismIn(List<Long> values) {
            addCriterion("absenteeism in", values, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismNotIn(List<Long> values) {
            addCriterion("absenteeism not in", values, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismBetween(Long value1, Long value2) {
            addCriterion("absenteeism between", value1, value2, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismNotBetween(Long value1, Long value2) {
            addCriterion("absenteeism not between", value1, value2, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andLateIsNull() {
            addCriterion("late is null");
            return (Criteria) this;
        }

        public Criteria andLateIsNotNull() {
            addCriterion("late is not null");
            return (Criteria) this;
        }

        public Criteria andLateEqualTo(Long value) {
            addCriterion("late =", value, "late");
            return (Criteria) this;
        }

        public Criteria andLateNotEqualTo(Long value) {
            addCriterion("late <>", value, "late");
            return (Criteria) this;
        }

        public Criteria andLateGreaterThan(Long value) {
            addCriterion("late >", value, "late");
            return (Criteria) this;
        }

        public Criteria andLateGreaterThanOrEqualTo(Long value) {
            addCriterion("late >=", value, "late");
            return (Criteria) this;
        }

        public Criteria andLateLessThan(Long value) {
            addCriterion("late <", value, "late");
            return (Criteria) this;
        }

        public Criteria andLateLessThanOrEqualTo(Long value) {
            addCriterion("late <=", value, "late");
            return (Criteria) this;
        }

        public Criteria andLateIn(List<Long> values) {
            addCriterion("late in", values, "late");
            return (Criteria) this;
        }

        public Criteria andLateNotIn(List<Long> values) {
            addCriterion("late not in", values, "late");
            return (Criteria) this;
        }

        public Criteria andLateBetween(Long value1, Long value2) {
            addCriterion("late between", value1, value2, "late");
            return (Criteria) this;
        }

        public Criteria andLateNotBetween(Long value1, Long value2) {
            addCriterion("late not between", value1, value2, "late");
            return (Criteria) this;
        }

        public Criteria andAskForLeaveIsNull() {
            addCriterion("ask_for_leave is null");
            return (Criteria) this;
        }

        public Criteria andAskForLeaveIsNotNull() {
            addCriterion("ask_for_leave is not null");
            return (Criteria) this;
        }

        public Criteria andAskForLeaveEqualTo(Long value) {
            addCriterion("ask_for_leave =", value, "askForLeave");
            return (Criteria) this;
        }

        public Criteria andAskForLeaveNotEqualTo(Long value) {
            addCriterion("ask_for_leave <>", value, "askForLeave");
            return (Criteria) this;
        }

        public Criteria andAskForLeaveGreaterThan(Long value) {
            addCriterion("ask_for_leave >", value, "askForLeave");
            return (Criteria) this;
        }

        public Criteria andAskForLeaveGreaterThanOrEqualTo(Long value) {
            addCriterion("ask_for_leave >=", value, "askForLeave");
            return (Criteria) this;
        }

        public Criteria andAskForLeaveLessThan(Long value) {
            addCriterion("ask_for_leave <", value, "askForLeave");
            return (Criteria) this;
        }

        public Criteria andAskForLeaveLessThanOrEqualTo(Long value) {
            addCriterion("ask_for_leave <=", value, "askForLeave");
            return (Criteria) this;
        }

        public Criteria andAskForLeaveIn(List<Long> values) {
            addCriterion("ask_for_leave in", values, "askForLeave");
            return (Criteria) this;
        }

        public Criteria andAskForLeaveNotIn(List<Long> values) {
            addCriterion("ask_for_leave not in", values, "askForLeave");
            return (Criteria) this;
        }

        public Criteria andAskForLeaveBetween(Long value1, Long value2) {
            addCriterion("ask_for_leave between", value1, value2, "askForLeave");
            return (Criteria) this;
        }

        public Criteria andAskForLeaveNotBetween(Long value1, Long value2) {
            addCriterion("ask_for_leave not between", value1, value2, "askForLeave");
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