package org.wxx.ssm.orclproject.entity;

import java.util.ArrayList;
import java.util.List;

public class StudentInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentInfoExample() {
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

        public Criteria andStudentidIsNull() {
            addCriterion("STUDENTID is null");
            return (Criteria) this;
        }

        public Criteria andStudentidIsNotNull() {
            addCriterion("STUDENTID is not null");
            return (Criteria) this;
        }

        public Criteria andStudentidEqualTo(Integer value) {
            addCriterion("STUDENTID =", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotEqualTo(Integer value) {
            addCriterion("STUDENTID <>", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidGreaterThan(Integer value) {
            addCriterion("STUDENTID >", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("STUDENTID >=", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidLessThan(Integer value) {
            addCriterion("STUDENTID <", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidLessThanOrEqualTo(Integer value) {
            addCriterion("STUDENTID <=", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidIn(List<Integer> values) {
            addCriterion("STUDENTID in", values, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotIn(List<Integer> values) {
            addCriterion("STUDENTID not in", values, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidBetween(Integer value1, Integer value2) {
            addCriterion("STUDENTID between", value1, value2, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotBetween(Integer value1, Integer value2) {
            addCriterion("STUDENTID not between", value1, value2, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentnameIsNull() {
            addCriterion("STUDENTNAME is null");
            return (Criteria) this;
        }

        public Criteria andStudentnameIsNotNull() {
            addCriterion("STUDENTNAME is not null");
            return (Criteria) this;
        }

        public Criteria andStudentnameEqualTo(String value) {
            addCriterion("STUDENTNAME =", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotEqualTo(String value) {
            addCriterion("STUDENTNAME <>", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameGreaterThan(String value) {
            addCriterion("STUDENTNAME >", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameGreaterThanOrEqualTo(String value) {
            addCriterion("STUDENTNAME >=", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameLessThan(String value) {
            addCriterion("STUDENTNAME <", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameLessThanOrEqualTo(String value) {
            addCriterion("STUDENTNAME <=", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameLike(String value) {
            addCriterion("STUDENTNAME like", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotLike(String value) {
            addCriterion("STUDENTNAME not like", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameIn(List<String> values) {
            addCriterion("STUDENTNAME in", values, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotIn(List<String> values) {
            addCriterion("STUDENTNAME not in", values, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameBetween(String value1, String value2) {
            addCriterion("STUDENTNAME between", value1, value2, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotBetween(String value1, String value2) {
            addCriterion("STUDENTNAME not between", value1, value2, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentsexIsNull() {
            addCriterion("STUDENTSEX is null");
            return (Criteria) this;
        }

        public Criteria andStudentsexIsNotNull() {
            addCriterion("STUDENTSEX is not null");
            return (Criteria) this;
        }

        public Criteria andStudentsexEqualTo(String value) {
            addCriterion("STUDENTSEX =", value, "studentsex");
            return (Criteria) this;
        }

        public Criteria andStudentsexNotEqualTo(String value) {
            addCriterion("STUDENTSEX <>", value, "studentsex");
            return (Criteria) this;
        }

        public Criteria andStudentsexGreaterThan(String value) {
            addCriterion("STUDENTSEX >", value, "studentsex");
            return (Criteria) this;
        }

        public Criteria andStudentsexGreaterThanOrEqualTo(String value) {
            addCriterion("STUDENTSEX >=", value, "studentsex");
            return (Criteria) this;
        }

        public Criteria andStudentsexLessThan(String value) {
            addCriterion("STUDENTSEX <", value, "studentsex");
            return (Criteria) this;
        }

        public Criteria andStudentsexLessThanOrEqualTo(String value) {
            addCriterion("STUDENTSEX <=", value, "studentsex");
            return (Criteria) this;
        }

        public Criteria andStudentsexLike(String value) {
            addCriterion("STUDENTSEX like", value, "studentsex");
            return (Criteria) this;
        }

        public Criteria andStudentsexNotLike(String value) {
            addCriterion("STUDENTSEX not like", value, "studentsex");
            return (Criteria) this;
        }

        public Criteria andStudentsexIn(List<String> values) {
            addCriterion("STUDENTSEX in", values, "studentsex");
            return (Criteria) this;
        }

        public Criteria andStudentsexNotIn(List<String> values) {
            addCriterion("STUDENTSEX not in", values, "studentsex");
            return (Criteria) this;
        }

        public Criteria andStudentsexBetween(String value1, String value2) {
            addCriterion("STUDENTSEX between", value1, value2, "studentsex");
            return (Criteria) this;
        }

        public Criteria andStudentsexNotBetween(String value1, String value2) {
            addCriterion("STUDENTSEX not between", value1, value2, "studentsex");
            return (Criteria) this;
        }

        public Criteria andStudentageIsNull() {
            addCriterion("STUDENTAGE is null");
            return (Criteria) this;
        }

        public Criteria andStudentageIsNotNull() {
            addCriterion("STUDENTAGE is not null");
            return (Criteria) this;
        }

        public Criteria andStudentageEqualTo(Integer value) {
            addCriterion("STUDENTAGE =", value, "studentage");
            return (Criteria) this;
        }

        public Criteria andStudentageNotEqualTo(Integer value) {
            addCriterion("STUDENTAGE <>", value, "studentage");
            return (Criteria) this;
        }

        public Criteria andStudentageGreaterThan(Integer value) {
            addCriterion("STUDENTAGE >", value, "studentage");
            return (Criteria) this;
        }

        public Criteria andStudentageGreaterThanOrEqualTo(Integer value) {
            addCriterion("STUDENTAGE >=", value, "studentage");
            return (Criteria) this;
        }

        public Criteria andStudentageLessThan(Integer value) {
            addCriterion("STUDENTAGE <", value, "studentage");
            return (Criteria) this;
        }

        public Criteria andStudentageLessThanOrEqualTo(Integer value) {
            addCriterion("STUDENTAGE <=", value, "studentage");
            return (Criteria) this;
        }

        public Criteria andStudentageIn(List<Integer> values) {
            addCriterion("STUDENTAGE in", values, "studentage");
            return (Criteria) this;
        }

        public Criteria andStudentageNotIn(List<Integer> values) {
            addCriterion("STUDENTAGE not in", values, "studentage");
            return (Criteria) this;
        }

        public Criteria andStudentageBetween(Integer value1, Integer value2) {
            addCriterion("STUDENTAGE between", value1, value2, "studentage");
            return (Criteria) this;
        }

        public Criteria andStudentageNotBetween(Integer value1, Integer value2) {
            addCriterion("STUDENTAGE not between", value1, value2, "studentage");
            return (Criteria) this;
        }

        public Criteria andStudenttelIsNull() {
            addCriterion("STUDENTTEL is null");
            return (Criteria) this;
        }

        public Criteria andStudenttelIsNotNull() {
            addCriterion("STUDENTTEL is not null");
            return (Criteria) this;
        }

        public Criteria andStudenttelEqualTo(Long value) {
            addCriterion("STUDENTTEL =", value, "studenttel");
            return (Criteria) this;
        }

        public Criteria andStudenttelNotEqualTo(Long value) {
            addCriterion("STUDENTTEL <>", value, "studenttel");
            return (Criteria) this;
        }

        public Criteria andStudenttelGreaterThan(Long value) {
            addCriterion("STUDENTTEL >", value, "studenttel");
            return (Criteria) this;
        }

        public Criteria andStudenttelGreaterThanOrEqualTo(Long value) {
            addCriterion("STUDENTTEL >=", value, "studenttel");
            return (Criteria) this;
        }

        public Criteria andStudenttelLessThan(Long value) {
            addCriterion("STUDENTTEL <", value, "studenttel");
            return (Criteria) this;
        }

        public Criteria andStudenttelLessThanOrEqualTo(Long value) {
            addCriterion("STUDENTTEL <=", value, "studenttel");
            return (Criteria) this;
        }

        public Criteria andStudenttelIn(List<Long> values) {
            addCriterion("STUDENTTEL in", values, "studenttel");
            return (Criteria) this;
        }

        public Criteria andStudenttelNotIn(List<Long> values) {
            addCriterion("STUDENTTEL not in", values, "studenttel");
            return (Criteria) this;
        }

        public Criteria andStudenttelBetween(Long value1, Long value2) {
            addCriterion("STUDENTTEL between", value1, value2, "studenttel");
            return (Criteria) this;
        }

        public Criteria andStudenttelNotBetween(Long value1, Long value2) {
            addCriterion("STUDENTTEL not between", value1, value2, "studenttel");
            return (Criteria) this;
        }

        public Criteria andStudentaddressIsNull() {
            addCriterion("STUDENTADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andStudentaddressIsNotNull() {
            addCriterion("STUDENTADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andStudentaddressEqualTo(String value) {
            addCriterion("STUDENTADDRESS =", value, "studentaddress");
            return (Criteria) this;
        }

        public Criteria andStudentaddressNotEqualTo(String value) {
            addCriterion("STUDENTADDRESS <>", value, "studentaddress");
            return (Criteria) this;
        }

        public Criteria andStudentaddressGreaterThan(String value) {
            addCriterion("STUDENTADDRESS >", value, "studentaddress");
            return (Criteria) this;
        }

        public Criteria andStudentaddressGreaterThanOrEqualTo(String value) {
            addCriterion("STUDENTADDRESS >=", value, "studentaddress");
            return (Criteria) this;
        }

        public Criteria andStudentaddressLessThan(String value) {
            addCriterion("STUDENTADDRESS <", value, "studentaddress");
            return (Criteria) this;
        }

        public Criteria andStudentaddressLessThanOrEqualTo(String value) {
            addCriterion("STUDENTADDRESS <=", value, "studentaddress");
            return (Criteria) this;
        }

        public Criteria andStudentaddressLike(String value) {
            addCriterion("STUDENTADDRESS like", value, "studentaddress");
            return (Criteria) this;
        }

        public Criteria andStudentaddressNotLike(String value) {
            addCriterion("STUDENTADDRESS not like", value, "studentaddress");
            return (Criteria) this;
        }

        public Criteria andStudentaddressIn(List<String> values) {
            addCriterion("STUDENTADDRESS in", values, "studentaddress");
            return (Criteria) this;
        }

        public Criteria andStudentaddressNotIn(List<String> values) {
            addCriterion("STUDENTADDRESS not in", values, "studentaddress");
            return (Criteria) this;
        }

        public Criteria andStudentaddressBetween(String value1, String value2) {
            addCriterion("STUDENTADDRESS between", value1, value2, "studentaddress");
            return (Criteria) this;
        }

        public Criteria andStudentaddressNotBetween(String value1, String value2) {
            addCriterion("STUDENTADDRESS not between", value1, value2, "studentaddress");
            return (Criteria) this;
        }

        public Criteria andCidIsNull() {
            addCriterion("CID is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("CID is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Integer value) {
            addCriterion("CID =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Integer value) {
            addCriterion("CID <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Integer value) {
            addCriterion("CID >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Integer value) {
            addCriterion("CID >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Integer value) {
            addCriterion("CID <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Integer value) {
            addCriterion("CID <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Integer> values) {
            addCriterion("CID in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Integer> values) {
            addCriterion("CID not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Integer value1, Integer value2) {
            addCriterion("CID between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Integer value1, Integer value2) {
            addCriterion("CID not between", value1, value2, "cid");
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