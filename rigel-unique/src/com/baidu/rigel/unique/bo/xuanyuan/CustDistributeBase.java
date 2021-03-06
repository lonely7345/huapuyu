package com.baidu.rigel.unique.bo.xuanyuan;

import com.baidu.rigel.platform.bo.FieldAccessVo;
import com.baidu.rigel.platform.bo.annotaions.ColumnDescription;
import com.baidu.rigel.platform.bo.annotaions.Id;
import java.io.Serializable;
import java.util.Date;

public abstract class CustDistributeBase extends FieldAccessVo implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_cust_distribute.distribute_id
     *
     * @mbggenerated Thu Jul 28 13:47:00 CST 2011
     */
    @ColumnDescription(desc="客户资料下发id")
    @Id
    private Integer distributeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_cust_distribute.cust_id
     *
     * @mbggenerated Thu Jul 28 13:47:00 CST 2011
     */
    @ColumnDescription(desc="客户id")
    private Integer custId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_cust_distribute.state
     *
     * @mbggenerated Thu Jul 28 13:47:00 CST 2011
     */
    @ColumnDescription(desc="")
    private Integer state;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_cust_distribute.distribute_time
     *
     * @mbggenerated Thu Jul 28 13:47:00 CST 2011
     */
    @ColumnDescription(desc="下发时间")
    private Date distributeTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_cust_distribute.distribute_id
     *
     * @return the value of tb_cust_distribute.distribute_id
     *
     * @mbggenerated Thu Jul 28 13:47:00 CST 2011
     */
    public Integer getDistributeId() {
        return distributeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_cust_distribute.distribute_id
     *
     * @param distributeId the value for tb_cust_distribute.distribute_id
     *
     * @mbggenerated Thu Jul 28 13:47:00 CST 2011
     */
    public void setDistributeId(Integer distributeId) {
        setField("distributeId", distributeId);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_cust_distribute.cust_id
     *
     * @return the value of tb_cust_distribute.cust_id
     *
     * @mbggenerated Thu Jul 28 13:47:00 CST 2011
     */
    public Integer getCustId() {
        return custId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_cust_distribute.cust_id
     *
     * @param custId the value for tb_cust_distribute.cust_id
     *
     * @mbggenerated Thu Jul 28 13:47:00 CST 2011
     */
    public void setCustId(Integer custId) {
        setField("custId", custId);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_cust_distribute.state
     *
     * @return the value of tb_cust_distribute.state
     *
     * @mbggenerated Thu Jul 28 13:47:00 CST 2011
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_cust_distribute.state
     *
     * @param state the value for tb_cust_distribute.state
     *
     * @mbggenerated Thu Jul 28 13:47:00 CST 2011
     */
    public void setState(Integer state) {
        setField("state", state);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_cust_distribute.distribute_time
     *
     * @return the value of tb_cust_distribute.distribute_time
     *
     * @mbggenerated Thu Jul 28 13:47:00 CST 2011
     */
    public Date getDistributeTime() {
        return distributeTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_cust_distribute.distribute_time
     *
     * @param distributeTime the value for tb_cust_distribute.distribute_time
     *
     * @mbggenerated Thu Jul 28 13:47:00 CST 2011
     */
    public void setDistributeTime(Date distributeTime) {
        setField("distributeTime", distributeTime);
    }
}