package com.xupt.ttms.pojo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
@Component
public class MovieExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table movie
     *
     * @mbggenerated Wed Jul 06 15:34:23 CST 2022
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table movie
     *
     * @mbggenerated Wed Jul 06 15:34:23 CST 2022
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table movie
     *
     * @mbggenerated Wed Jul 06 15:34:23 CST 2022
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie
     *
     * @mbggenerated Wed Jul 06 15:34:23 CST 2022
     */
    public MovieExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie
     *
     * @mbggenerated Wed Jul 06 15:34:23 CST 2022
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie
     *
     * @mbggenerated Wed Jul 06 15:34:23 CST 2022
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie
     *
     * @mbggenerated Wed Jul 06 15:34:23 CST 2022
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie
     *
     * @mbggenerated Wed Jul 06 15:34:23 CST 2022
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie
     *
     * @mbggenerated Wed Jul 06 15:34:23 CST 2022
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie
     *
     * @mbggenerated Wed Jul 06 15:34:23 CST 2022
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie
     *
     * @mbggenerated Wed Jul 06 15:34:23 CST 2022
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie
     *
     * @mbggenerated Wed Jul 06 15:34:23 CST 2022
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie
     *
     * @mbggenerated Wed Jul 06 15:34:23 CST 2022
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie
     *
     * @mbggenerated Wed Jul 06 15:34:23 CST 2022
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table movie
     *
     * @mbggenerated Wed Jul 06 15:34:23 CST 2022
     */
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMNameIsNull() {
            addCriterion("m_name is null");
            return (Criteria) this;
        }

        public Criteria andMNameIsNotNull() {
            addCriterion("m_name is not null");
            return (Criteria) this;
        }

        public Criteria andMNameEqualTo(String value) {
            addCriterion("m_name =", value, "mName");
            return (Criteria) this;
        }

        public Criteria andMNameNotEqualTo(String value) {
            addCriterion("m_name <>", value, "mName");
            return (Criteria) this;
        }

        public Criteria andMNameGreaterThan(String value) {
            addCriterion("m_name >", value, "mName");
            return (Criteria) this;
        }

        public Criteria andMNameGreaterThanOrEqualTo(String value) {
            addCriterion("m_name >=", value, "mName");
            return (Criteria) this;
        }

        public Criteria andMNameLessThan(String value) {
            addCriterion("m_name <", value, "mName");
            return (Criteria) this;
        }

        public Criteria andMNameLessThanOrEqualTo(String value) {
            addCriterion("m_name <=", value, "mName");
            return (Criteria) this;
        }

        public Criteria andMNameLike(String value) {
            addCriterion("m_name like", value, "mName");
            return (Criteria) this;
        }

        public Criteria andMNameNotLike(String value) {
            addCriterion("m_name not like", value, "mName");
            return (Criteria) this;
        }

        public Criteria andMNameIn(List<String> values) {
            addCriterion("m_name in", values, "mName");
            return (Criteria) this;
        }

        public Criteria andMNameNotIn(List<String> values) {
            addCriterion("m_name not in", values, "mName");
            return (Criteria) this;
        }

        public Criteria andMNameBetween(String value1, String value2) {
            addCriterion("m_name between", value1, value2, "mName");
            return (Criteria) this;
        }

        public Criteria andMNameNotBetween(String value1, String value2) {
            addCriterion("m_name not between", value1, value2, "mName");
            return (Criteria) this;
        }

        public Criteria andMTypeIsNull() {
            addCriterion("m_type is null");
            return (Criteria) this;
        }

        public Criteria andMTypeIsNotNull() {
            addCriterion("m_type is not null");
            return (Criteria) this;
        }

        public Criteria andMTypeEqualTo(String value) {
            addCriterion("m_type =", value, "mType");
            return (Criteria) this;
        }

        public Criteria andMTypeNotEqualTo(String value) {
            addCriterion("m_type <>", value, "mType");
            return (Criteria) this;
        }

        public Criteria andMTypeGreaterThan(String value) {
            addCriterion("m_type >", value, "mType");
            return (Criteria) this;
        }

        public Criteria andMTypeGreaterThanOrEqualTo(String value) {
            addCriterion("m_type >=", value, "mType");
            return (Criteria) this;
        }

        public Criteria andMTypeLessThan(String value) {
            addCriterion("m_type <", value, "mType");
            return (Criteria) this;
        }

        public Criteria andMTypeLessThanOrEqualTo(String value) {
            addCriterion("m_type <=", value, "mType");
            return (Criteria) this;
        }

        public Criteria andMTypeLike(String value) {
            addCriterion("m_type like", value, "mType");
            return (Criteria) this;
        }

        public Criteria andMTypeNotLike(String value) {
            addCriterion("m_type not like", value, "mType");
            return (Criteria) this;
        }

        public Criteria andMTypeIn(List<String> values) {
            addCriterion("m_type in", values, "mType");
            return (Criteria) this;
        }

        public Criteria andMTypeNotIn(List<String> values) {
            addCriterion("m_type not in", values, "mType");
            return (Criteria) this;
        }

        public Criteria andMTypeBetween(String value1, String value2) {
            addCriterion("m_type between", value1, value2, "mType");
            return (Criteria) this;
        }

        public Criteria andMTypeNotBetween(String value1, String value2) {
            addCriterion("m_type not between", value1, value2, "mType");
            return (Criteria) this;
        }

        public Criteria andMLengthIsNull() {
            addCriterion("m_length is null");
            return (Criteria) this;
        }

        public Criteria andMLengthIsNotNull() {
            addCriterion("m_length is not null");
            return (Criteria) this;
        }

        public Criteria andMLengthEqualTo(Integer value) {
            addCriterion("m_length =", value, "mLength");
            return (Criteria) this;
        }

        public Criteria andMLengthNotEqualTo(Integer value) {
            addCriterion("m_length <>", value, "mLength");
            return (Criteria) this;
        }

        public Criteria andMLengthGreaterThan(Integer value) {
            addCriterion("m_length >", value, "mLength");
            return (Criteria) this;
        }

        public Criteria andMLengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("m_length >=", value, "mLength");
            return (Criteria) this;
        }

        public Criteria andMLengthLessThan(Integer value) {
            addCriterion("m_length <", value, "mLength");
            return (Criteria) this;
        }

        public Criteria andMLengthLessThanOrEqualTo(Integer value) {
            addCriterion("m_length <=", value, "mLength");
            return (Criteria) this;
        }

        public Criteria andMLengthIn(List<Integer> values) {
            addCriterion("m_length in", values, "mLength");
            return (Criteria) this;
        }

        public Criteria andMLengthNotIn(List<Integer> values) {
            addCriterion("m_length not in", values, "mLength");
            return (Criteria) this;
        }

        public Criteria andMLengthBetween(Integer value1, Integer value2) {
            addCriterion("m_length between", value1, value2, "mLength");
            return (Criteria) this;
        }

        public Criteria andMLengthNotBetween(Integer value1, Integer value2) {
            addCriterion("m_length not between", value1, value2, "mLength");
            return (Criteria) this;
        }

        public Criteria andMPriceIsNull() {
            addCriterion("m_price is null");
            return (Criteria) this;
        }

        public Criteria andMPriceIsNotNull() {
            addCriterion("m_price is not null");
            return (Criteria) this;
        }

        public Criteria andMPriceEqualTo(Double value) {
            addCriterion("m_price =", value, "mPrice");
            return (Criteria) this;
        }

        public Criteria andMPriceNotEqualTo(Double value) {
            addCriterion("m_price <>", value, "mPrice");
            return (Criteria) this;
        }

        public Criteria andMPriceGreaterThan(Double value) {
            addCriterion("m_price >", value, "mPrice");
            return (Criteria) this;
        }

        public Criteria andMPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("m_price >=", value, "mPrice");
            return (Criteria) this;
        }

        public Criteria andMPriceLessThan(Double value) {
            addCriterion("m_price <", value, "mPrice");
            return (Criteria) this;
        }

        public Criteria andMPriceLessThanOrEqualTo(Double value) {
            addCriterion("m_price <=", value, "mPrice");
            return (Criteria) this;
        }

        public Criteria andMPriceIn(List<Double> values) {
            addCriterion("m_price in", values, "mPrice");
            return (Criteria) this;
        }

        public Criteria andMPriceNotIn(List<Double> values) {
            addCriterion("m_price not in", values, "mPrice");
            return (Criteria) this;
        }

        public Criteria andMPriceBetween(Double value1, Double value2) {
            addCriterion("m_price between", value1, value2, "mPrice");
            return (Criteria) this;
        }

        public Criteria andMPriceNotBetween(Double value1, Double value2) {
            addCriterion("m_price not between", value1, value2, "mPrice");
            return (Criteria) this;
        }

        public Criteria andMDateIsNull() {
            addCriterion("m_date is null");
            return (Criteria) this;
        }

        public Criteria andMDateIsNotNull() {
            addCriterion("m_date is not null");
            return (Criteria) this;
        }

        public Criteria andMDateEqualTo(Date value) {
            addCriterionForJDBCDate("m_date =", value, "mDate");
            return (Criteria) this;
        }

        public Criteria andMDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("m_date <>", value, "mDate");
            return (Criteria) this;
        }

        public Criteria andMDateGreaterThan(Date value) {
            addCriterionForJDBCDate("m_date >", value, "mDate");
            return (Criteria) this;
        }

        public Criteria andMDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("m_date >=", value, "mDate");
            return (Criteria) this;
        }

        public Criteria andMDateLessThan(Date value) {
            addCriterionForJDBCDate("m_date <", value, "mDate");
            return (Criteria) this;
        }

        public Criteria andMDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("m_date <=", value, "mDate");
            return (Criteria) this;
        }

        public Criteria andMDateIn(List<Date> values) {
            addCriterionForJDBCDate("m_date in", values, "mDate");
            return (Criteria) this;
        }

        public Criteria andMDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("m_date not in", values, "mDate");
            return (Criteria) this;
        }

        public Criteria andMDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("m_date between", value1, value2, "mDate");
            return (Criteria) this;
        }

        public Criteria andMDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("m_date not between", value1, value2, "mDate");
            return (Criteria) this;
        }

        public Criteria andMDirectorIsNull() {
            addCriterion("m_director is null");
            return (Criteria) this;
        }

        public Criteria andMDirectorIsNotNull() {
            addCriterion("m_director is not null");
            return (Criteria) this;
        }

        public Criteria andMDirectorEqualTo(String value) {
            addCriterion("m_director =", value, "mDirector");
            return (Criteria) this;
        }

        public Criteria andMDirectorNotEqualTo(String value) {
            addCriterion("m_director <>", value, "mDirector");
            return (Criteria) this;
        }

        public Criteria andMDirectorGreaterThan(String value) {
            addCriterion("m_director >", value, "mDirector");
            return (Criteria) this;
        }

        public Criteria andMDirectorGreaterThanOrEqualTo(String value) {
            addCriterion("m_director >=", value, "mDirector");
            return (Criteria) this;
        }

        public Criteria andMDirectorLessThan(String value) {
            addCriterion("m_director <", value, "mDirector");
            return (Criteria) this;
        }

        public Criteria andMDirectorLessThanOrEqualTo(String value) {
            addCriterion("m_director <=", value, "mDirector");
            return (Criteria) this;
        }

        public Criteria andMDirectorLike(String value) {
            addCriterion("m_director like", value, "mDirector");
            return (Criteria) this;
        }

        public Criteria andMDirectorNotLike(String value) {
            addCriterion("m_director not like", value, "mDirector");
            return (Criteria) this;
        }

        public Criteria andMDirectorIn(List<String> values) {
            addCriterion("m_director in", values, "mDirector");
            return (Criteria) this;
        }

        public Criteria andMDirectorNotIn(List<String> values) {
            addCriterion("m_director not in", values, "mDirector");
            return (Criteria) this;
        }

        public Criteria andMDirectorBetween(String value1, String value2) {
            addCriterion("m_director between", value1, value2, "mDirector");
            return (Criteria) this;
        }

        public Criteria andMDirectorNotBetween(String value1, String value2) {
            addCriterion("m_director not between", value1, value2, "mDirector");
            return (Criteria) this;
        }

        public Criteria andMActorIsNull() {
            addCriterion("m_actor is null");
            return (Criteria) this;
        }

        public Criteria andMActorIsNotNull() {
            addCriterion("m_actor is not null");
            return (Criteria) this;
        }

        public Criteria andMActorEqualTo(String value) {
            addCriterion("m_actor =", value, "mActor");
            return (Criteria) this;
        }

        public Criteria andMActorNotEqualTo(String value) {
            addCriterion("m_actor <>", value, "mActor");
            return (Criteria) this;
        }

        public Criteria andMActorGreaterThan(String value) {
            addCriterion("m_actor >", value, "mActor");
            return (Criteria) this;
        }

        public Criteria andMActorGreaterThanOrEqualTo(String value) {
            addCriterion("m_actor >=", value, "mActor");
            return (Criteria) this;
        }

        public Criteria andMActorLessThan(String value) {
            addCriterion("m_actor <", value, "mActor");
            return (Criteria) this;
        }

        public Criteria andMActorLessThanOrEqualTo(String value) {
            addCriterion("m_actor <=", value, "mActor");
            return (Criteria) this;
        }

        public Criteria andMActorLike(String value) {
            addCriterion("m_actor like", value, "mActor");
            return (Criteria) this;
        }

        public Criteria andMActorNotLike(String value) {
            addCriterion("m_actor not like", value, "mActor");
            return (Criteria) this;
        }

        public Criteria andMActorIn(List<String> values) {
            addCriterion("m_actor in", values, "mActor");
            return (Criteria) this;
        }

        public Criteria andMActorNotIn(List<String> values) {
            addCriterion("m_actor not in", values, "mActor");
            return (Criteria) this;
        }

        public Criteria andMActorBetween(String value1, String value2) {
            addCriterion("m_actor between", value1, value2, "mActor");
            return (Criteria) this;
        }

        public Criteria andMActorNotBetween(String value1, String value2) {
            addCriterion("m_actor not between", value1, value2, "mActor");
            return (Criteria) this;
        }

        public Criteria andMBoxOfficeIsNull() {
            addCriterion("m_box_office is null");
            return (Criteria) this;
        }

        public Criteria andMBoxOfficeIsNotNull() {
            addCriterion("m_box_office is not null");
            return (Criteria) this;
        }

        public Criteria andMBoxOfficeEqualTo(Double value) {
            addCriterion("m_box_office =", value, "mBoxOffice");
            return (Criteria) this;
        }

        public Criteria andMBoxOfficeNotEqualTo(Double value) {
            addCriterion("m_box_office <>", value, "mBoxOffice");
            return (Criteria) this;
        }

        public Criteria andMBoxOfficeGreaterThan(Double value) {
            addCriterion("m_box_office >", value, "mBoxOffice");
            return (Criteria) this;
        }

        public Criteria andMBoxOfficeGreaterThanOrEqualTo(Double value) {
            addCriterion("m_box_office >=", value, "mBoxOffice");
            return (Criteria) this;
        }

        public Criteria andMBoxOfficeLessThan(Double value) {
            addCriterion("m_box_office <", value, "mBoxOffice");
            return (Criteria) this;
        }

        public Criteria andMBoxOfficeLessThanOrEqualTo(Double value) {
            addCriterion("m_box_office <=", value, "mBoxOffice");
            return (Criteria) this;
        }

        public Criteria andMBoxOfficeIn(List<Double> values) {
            addCriterion("m_box_office in", values, "mBoxOffice");
            return (Criteria) this;
        }

        public Criteria andMBoxOfficeNotIn(List<Double> values) {
            addCriterion("m_box_office not in", values, "mBoxOffice");
            return (Criteria) this;
        }

        public Criteria andMBoxOfficeBetween(Double value1, Double value2) {
            addCriterion("m_box_office between", value1, value2, "mBoxOffice");
            return (Criteria) this;
        }

        public Criteria andMBoxOfficeNotBetween(Double value1, Double value2) {
            addCriterion("m_box_office not between", value1, value2, "mBoxOffice");
            return (Criteria) this;
        }

        public Criteria andMScoreIsNull() {
            addCriterion("m_score is null");
            return (Criteria) this;
        }

        public Criteria andMScoreIsNotNull() {
            addCriterion("m_score is not null");
            return (Criteria) this;
        }

        public Criteria andMScoreEqualTo(Integer value) {
            addCriterion("m_score =", value, "mScore");
            return (Criteria) this;
        }

        public Criteria andMScoreNotEqualTo(Integer value) {
            addCriterion("m_score <>", value, "mScore");
            return (Criteria) this;
        }

        public Criteria andMScoreGreaterThan(Integer value) {
            addCriterion("m_score >", value, "mScore");
            return (Criteria) this;
        }

        public Criteria andMScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("m_score >=", value, "mScore");
            return (Criteria) this;
        }

        public Criteria andMScoreLessThan(Integer value) {
            addCriterion("m_score <", value, "mScore");
            return (Criteria) this;
        }

        public Criteria andMScoreLessThanOrEqualTo(Integer value) {
            addCriterion("m_score <=", value, "mScore");
            return (Criteria) this;
        }

        public Criteria andMScoreIn(List<Integer> values) {
            addCriterion("m_score in", values, "mScore");
            return (Criteria) this;
        }

        public Criteria andMScoreNotIn(List<Integer> values) {
            addCriterion("m_score not in", values, "mScore");
            return (Criteria) this;
        }

        public Criteria andMScoreBetween(Integer value1, Integer value2) {
            addCriterion("m_score between", value1, value2, "mScore");
            return (Criteria) this;
        }

        public Criteria andMScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("m_score not between", value1, value2, "mScore");
            return (Criteria) this;
        }

        public Criteria andMIntroductionIsNull() {
            addCriterion("m_introduction is null");
            return (Criteria) this;
        }

        public Criteria andMIntroductionIsNotNull() {
            addCriterion("m_introduction is not null");
            return (Criteria) this;
        }

        public Criteria andMIntroductionEqualTo(String value) {
            addCriterion("m_introduction =", value, "mIntroduction");
            return (Criteria) this;
        }

        public Criteria andMIntroductionNotEqualTo(String value) {
            addCriterion("m_introduction <>", value, "mIntroduction");
            return (Criteria) this;
        }

        public Criteria andMIntroductionGreaterThan(String value) {
            addCriterion("m_introduction >", value, "mIntroduction");
            return (Criteria) this;
        }

        public Criteria andMIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("m_introduction >=", value, "mIntroduction");
            return (Criteria) this;
        }

        public Criteria andMIntroductionLessThan(String value) {
            addCriterion("m_introduction <", value, "mIntroduction");
            return (Criteria) this;
        }

        public Criteria andMIntroductionLessThanOrEqualTo(String value) {
            addCriterion("m_introduction <=", value, "mIntroduction");
            return (Criteria) this;
        }

        public Criteria andMIntroductionLike(String value) {
            addCriterion("m_introduction like", value, "mIntroduction");
            return (Criteria) this;
        }

        public Criteria andMIntroductionNotLike(String value) {
            addCriterion("m_introduction not like", value, "mIntroduction");
            return (Criteria) this;
        }

        public Criteria andMIntroductionIn(List<String> values) {
            addCriterion("m_introduction in", values, "mIntroduction");
            return (Criteria) this;
        }

        public Criteria andMIntroductionNotIn(List<String> values) {
            addCriterion("m_introduction not in", values, "mIntroduction");
            return (Criteria) this;
        }

        public Criteria andMIntroductionBetween(String value1, String value2) {
            addCriterion("m_introduction between", value1, value2, "mIntroduction");
            return (Criteria) this;
        }

        public Criteria andMIntroductionNotBetween(String value1, String value2) {
            addCriterion("m_introduction not between", value1, value2, "mIntroduction");
            return (Criteria) this;
        }

        public Criteria andMImageIsNull() {
            addCriterion("m_image is null");
            return (Criteria) this;
        }

        public Criteria andMImageIsNotNull() {
            addCriterion("m_image is not null");
            return (Criteria) this;
        }

        public Criteria andMImageEqualTo(String value) {
            addCriterion("m_image =", value, "mImage");
            return (Criteria) this;
        }

        public Criteria andMImageNotEqualTo(String value) {
            addCriterion("m_image <>", value, "mImage");
            return (Criteria) this;
        }

        public Criteria andMImageGreaterThan(String value) {
            addCriterion("m_image >", value, "mImage");
            return (Criteria) this;
        }

        public Criteria andMImageGreaterThanOrEqualTo(String value) {
            addCriterion("m_image >=", value, "mImage");
            return (Criteria) this;
        }

        public Criteria andMImageLessThan(String value) {
            addCriterion("m_image <", value, "mImage");
            return (Criteria) this;
        }

        public Criteria andMImageLessThanOrEqualTo(String value) {
            addCriterion("m_image <=", value, "mImage");
            return (Criteria) this;
        }

        public Criteria andMImageLike(String value) {
            addCriterion("m_image like", value, "mImage");
            return (Criteria) this;
        }

        public Criteria andMImageNotLike(String value) {
            addCriterion("m_image not like", value, "mImage");
            return (Criteria) this;
        }

        public Criteria andMImageIn(List<String> values) {
            addCriterion("m_image in", values, "mImage");
            return (Criteria) this;
        }

        public Criteria andMImageNotIn(List<String> values) {
            addCriterion("m_image not in", values, "mImage");
            return (Criteria) this;
        }

        public Criteria andMImageBetween(String value1, String value2) {
            addCriterion("m_image between", value1, value2, "mImage");
            return (Criteria) this;
        }

        public Criteria andMImageNotBetween(String value1, String value2) {
            addCriterion("m_image not between", value1, value2, "mImage");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table movie
     *
     * @mbggenerated do_not_delete_during_merge Wed Jul 06 15:34:23 CST 2022
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table movie
     *
     * @mbggenerated Wed Jul 06 15:34:23 CST 2022
     */
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