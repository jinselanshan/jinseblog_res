package com.jinse.blog.pojo;

import java.util.ArrayList;
import java.util.List;

public class ScoreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ScoreExample() {
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

        public Criteria andScoreIdIsNull() {
            addCriterion("score_id is null");
            return (Criteria) this;
        }

        public Criteria andScoreIdIsNotNull() {
            addCriterion("score_id is not null");
            return (Criteria) this;
        }

        public Criteria andScoreIdEqualTo(Integer value) {
            addCriterion("score_id =", value, "scoreId");
            return (Criteria) this;
        }

        public Criteria andScoreIdNotEqualTo(Integer value) {
            addCriterion("score_id <>", value, "scoreId");
            return (Criteria) this;
        }

        public Criteria andScoreIdGreaterThan(Integer value) {
            addCriterion("score_id >", value, "scoreId");
            return (Criteria) this;
        }

        public Criteria andScoreIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("score_id >=", value, "scoreId");
            return (Criteria) this;
        }

        public Criteria andScoreIdLessThan(Integer value) {
            addCriterion("score_id <", value, "scoreId");
            return (Criteria) this;
        }

        public Criteria andScoreIdLessThanOrEqualTo(Integer value) {
            addCriterion("score_id <=", value, "scoreId");
            return (Criteria) this;
        }

        public Criteria andScoreIdIn(List<Integer> values) {
            addCriterion("score_id in", values, "scoreId");
            return (Criteria) this;
        }

        public Criteria andScoreIdNotIn(List<Integer> values) {
            addCriterion("score_id not in", values, "scoreId");
            return (Criteria) this;
        }

        public Criteria andScoreIdBetween(Integer value1, Integer value2) {
            addCriterion("score_id between", value1, value2, "scoreId");
            return (Criteria) this;
        }

        public Criteria andScoreIdNotBetween(Integer value1, Integer value2) {
            addCriterion("score_id not between", value1, value2, "scoreId");
            return (Criteria) this;
        }

        public Criteria and博客idIsNull() {
            addCriterion("博客id is null");
            return (Criteria) this;
        }

        public Criteria and博客idIsNotNull() {
            addCriterion("博客id is not null");
            return (Criteria) this;
        }

        public Criteria and博客idEqualTo(Integer value) {
            addCriterion("博客id =", value, "博客id");
            return (Criteria) this;
        }

        public Criteria and博客idNotEqualTo(Integer value) {
            addCriterion("博客id <>", value, "博客id");
            return (Criteria) this;
        }

        public Criteria and博客idGreaterThan(Integer value) {
            addCriterion("博客id >", value, "博客id");
            return (Criteria) this;
        }

        public Criteria and博客idGreaterThanOrEqualTo(Integer value) {
            addCriterion("博客id >=", value, "博客id");
            return (Criteria) this;
        }

        public Criteria and博客idLessThan(Integer value) {
            addCriterion("博客id <", value, "博客id");
            return (Criteria) this;
        }

        public Criteria and博客idLessThanOrEqualTo(Integer value) {
            addCriterion("博客id <=", value, "博客id");
            return (Criteria) this;
        }

        public Criteria and博客idIn(List<Integer> values) {
            addCriterion("博客id in", values, "博客id");
            return (Criteria) this;
        }

        public Criteria and博客idNotIn(List<Integer> values) {
            addCriterion("博客id not in", values, "博客id");
            return (Criteria) this;
        }

        public Criteria and博客idBetween(Integer value1, Integer value2) {
            addCriterion("博客id between", value1, value2, "博客id");
            return (Criteria) this;
        }

        public Criteria and博客idNotBetween(Integer value1, Integer value2) {
            addCriterion("博客id not between", value1, value2, "博客id");
            return (Criteria) this;
        }

        public Criteria and用户idIsNull() {
            addCriterion("用户id is null");
            return (Criteria) this;
        }

        public Criteria and用户idIsNotNull() {
            addCriterion("用户id is not null");
            return (Criteria) this;
        }

        public Criteria and用户idEqualTo(Integer value) {
            addCriterion("用户id =", value, "用户id");
            return (Criteria) this;
        }

        public Criteria and用户idNotEqualTo(Integer value) {
            addCriterion("用户id <>", value, "用户id");
            return (Criteria) this;
        }

        public Criteria and用户idGreaterThan(Integer value) {
            addCriterion("用户id >", value, "用户id");
            return (Criteria) this;
        }

        public Criteria and用户idGreaterThanOrEqualTo(Integer value) {
            addCriterion("用户id >=", value, "用户id");
            return (Criteria) this;
        }

        public Criteria and用户idLessThan(Integer value) {
            addCriterion("用户id <", value, "用户id");
            return (Criteria) this;
        }

        public Criteria and用户idLessThanOrEqualTo(Integer value) {
            addCriterion("用户id <=", value, "用户id");
            return (Criteria) this;
        }

        public Criteria and用户idIn(List<Integer> values) {
            addCriterion("用户id in", values, "用户id");
            return (Criteria) this;
        }

        public Criteria and用户idNotIn(List<Integer> values) {
            addCriterion("用户id not in", values, "用户id");
            return (Criteria) this;
        }

        public Criteria and用户idBetween(Integer value1, Integer value2) {
            addCriterion("用户id between", value1, value2, "用户id");
            return (Criteria) this;
        }

        public Criteria and用户idNotBetween(Integer value1, Integer value2) {
            addCriterion("用户id not between", value1, value2, "用户id");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
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