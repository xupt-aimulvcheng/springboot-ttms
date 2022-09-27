package com.xupt.ttms.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Hall implements Serializable {
    private static final long serialVersionUID = 1l;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hall.id
     *
     * @mbggenerated Wed Jul 06 13:45:59 CST 2022
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hall.h_name
     *
     * @mbggenerated Wed Jul 06 13:45:59 CST 2022
     */
    private String hname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hall.h_row
     *
     * @mbggenerated Wed Jul 06 13:45:59 CST 2022
     */
    private Integer hrow;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hall.h_col
     *
     * @mbggenerated Wed Jul 06 13:45:59 CST 2022
     */
    private Integer hcol;

    @Override
    public String toString() {
        return "Hall{" +
                "id=" + id +
                ", hname='" + hname + '\'' +
                ", hrow=" + hrow +
                ", hcol=" + hcol +
                ", hdesc='" + hdesc + '\'' +
                '}';
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hall.h_desc
     *
     * @mbggenerated Wed Jul 06 13:45:59 CST 2022
     */
    private String hdesc;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hall.id
     *
     * @return the value of hall.id
     *
     * @mbggenerated Wed Jul 06 13:45:59 CST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hall.id
     *
     * @param id the value for hall.id
     *
     * @mbggenerated Wed Jul 06 13:45:59 CST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hall.h_name
     *
     * @return the value of hall.h_name
     *
     * @mbggenerated Wed Jul 06 13:45:59 CST 2022
     */
    public String getHname() {
        return hname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hall.h_name
     *
     * @param hname the value for hall.h_name
     *
     * @mbggenerated Wed Jul 06 13:45:59 CST 2022
     */
    public void setHname(String hname) {
        this.hname = hname == null ? null : hname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hall.h_row
     *
     * @return the value of hall.h_row
     *
     * @mbggenerated Wed Jul 06 13:45:59 CST 2022
     */
    public Integer getHrow() {
        return hrow;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hall.h_row
     *
     * @param hrow the value for hall.h_row
     *
     * @mbggenerated Wed Jul 06 13:45:59 CST 2022
     */
    public void setHrow(Integer hrow) {
        this.hrow = hrow;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hall.h_col
     *
     * @return the value of hall.h_col
     *
     * @mbggenerated Wed Jul 06 13:45:59 CST 2022
     */
    public Integer getHcol() {
        return hcol;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hall.h_col
     *
     * @param hcol the value for hall.h_col
     *
     * @mbggenerated Wed Jul 06 13:45:59 CST 2022
     */
    public void setHcol(Integer hcol) {
        this.hcol = hcol;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hall.h_desc
     *
     * @return the value of hall.h_desc
     *
     * @mbggenerated Wed Jul 06 13:45:59 CST 2022
     */
    public String getHdesc() {
        return hdesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hall.h_desc
     *
     * @param hdesc the value for hall.h_desc
     *
     * @mbggenerated Wed Jul 06 13:45:59 CST 2022
     */
    public void setHdesc(String hdesc) {
        this.hdesc = hdesc == null ? null : hdesc.trim();
    }
}