package com.baidu.rigel.unique.bo;

import com.baidu.rigel.platform.bo.FieldAccessVo;
import com.baidu.rigel.platform.bo.annotaions.ColumnDescription;
import com.baidu.rigel.platform.bo.annotaions.Id;
import java.io.Serializable;
import java.util.Date;

public abstract class CustUrlBase extends FieldAccessVo implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_cust_url.cust_url_id
     *
     * @mbggenerated Wed Jul 27 18:34:30 CST 2011
     */
    @ColumnDescription(desc="主键ID")
    @Id
    private Integer custUrlId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_cust_url.cust_id
     *
     * @mbggenerated Wed Jul 27 18:34:30 CST 2011
     */
    @ColumnDescription(desc="客户资料ID")
    private Integer custId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_cust_url.cust_url_name
     *
     * @mbggenerated Wed Jul 27 18:34:30 CST 2011
     */
    @ColumnDescription(desc="客户网站")
    private String custUrlName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_cust_url.domain
     *
     * @mbggenerated Wed Jul 27 18:34:30 CST 2011
     */
    @ColumnDescription(desc="")
    private String domain;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_cust_url.add_user
     *
     * @mbggenerated Wed Jul 27 18:34:30 CST 2011
     */
    @ColumnDescription(desc="客户网站url录入人ID")
    private Integer addUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_cust_url.add_time
     *
     * @mbggenerated Wed Jul 27 18:34:30 CST 2011
     */
    @ColumnDescription(desc="客户网站url录入时间")
    private Date addTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_cust_url.cust_url_id
     *
     * @return the value of tb_cust_url.cust_url_id
     *
     * @mbggenerated Wed Jul 27 18:34:30 CST 2011
     */
    public Integer getCustUrlId() {
        return custUrlId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_cust_url.cust_url_id
     *
     * @param custUrlId the value for tb_cust_url.cust_url_id
     *
     * @mbggenerated Wed Jul 27 18:34:30 CST 2011
     */
    public void setCustUrlId(Integer custUrlId) {
        setField("custUrlId", custUrlId);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_cust_url.cust_id
     *
     * @return the value of tb_cust_url.cust_id
     *
     * @mbggenerated Wed Jul 27 18:34:30 CST 2011
     */
    public Integer getCustId() {
        return custId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_cust_url.cust_id
     *
     * @param custId the value for tb_cust_url.cust_id
     *
     * @mbggenerated Wed Jul 27 18:34:30 CST 2011
     */
    public void setCustId(Integer custId) {
        setField("custId", custId);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_cust_url.cust_url_name
     *
     * @return the value of tb_cust_url.cust_url_name
     *
     * @mbggenerated Wed Jul 27 18:34:30 CST 2011
     */
    public String getCustUrlName() {
        return custUrlName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_cust_url.cust_url_name
     *
     * @param custUrlName the value for tb_cust_url.cust_url_name
     *
     * @mbggenerated Wed Jul 27 18:34:30 CST 2011
     */
    public void setCustUrlName(String custUrlName) {
        custUrlName = custUrlName == null ? null : custUrlName.trim();

        setField("custUrlName", custUrlName);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_cust_url.domain
     *
     * @return the value of tb_cust_url.domain
     *
     * @mbggenerated Wed Jul 27 18:34:30 CST 2011
     */
    public String getDomain() {
        return domain;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_cust_url.domain
     *
     * @param domain the value for tb_cust_url.domain
     *
     * @mbggenerated Wed Jul 27 18:34:30 CST 2011
     */
    public void setDomain(String domain) {
        domain = domain == null ? null : domain.trim();

        setField("domain", domain);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_cust_url.add_user
     *
     * @return the value of tb_cust_url.add_user
     *
     * @mbggenerated Wed Jul 27 18:34:30 CST 2011
     */
    public Integer getAddUser() {
        return addUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_cust_url.add_user
     *
     * @param addUser the value for tb_cust_url.add_user
     *
     * @mbggenerated Wed Jul 27 18:34:30 CST 2011
     */
    public void setAddUser(Integer addUser) {
        setField("addUser", addUser);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_cust_url.add_time
     *
     * @return the value of tb_cust_url.add_time
     *
     * @mbggenerated Wed Jul 27 18:34:30 CST 2011
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_cust_url.add_time
     *
     * @param addTime the value for tb_cust_url.add_time
     *
     * @mbggenerated Wed Jul 27 18:34:30 CST 2011
     */
    public void setAddTime(Date addTime) {
        setField("addTime", addTime);
    }
}