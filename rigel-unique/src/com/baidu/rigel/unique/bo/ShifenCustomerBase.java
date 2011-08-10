package com.baidu.rigel.unique.bo;

import com.baidu.rigel.platform.bo.FieldAccessVo;
import com.baidu.rigel.platform.bo.annotaions.ColumnDescription;
import com.baidu.rigel.platform.bo.annotaions.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public abstract class ShifenCustomerBase extends FieldAccessVo implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_shifen_customer.customerd
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    @ColumnDescription(desc="")
    @Id
    private Integer customerd;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_shifen_customer.customername
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    @ColumnDescription(desc="")
    private String customername;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_shifen_customer.status
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    @ColumnDescription(desc="")
    private Byte status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_shifen_customer.companyname
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    @ColumnDescription(desc="")
    private String companyname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_shifen_customer.siteurl
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    @ColumnDescription(desc="")
    private String siteurl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_shifen_customer.urldomain
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    @ColumnDescription(desc="")
    private String urldomain;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_shifen_customer.conphone
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    @ColumnDescription(desc="")
    private String conphone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_shifen_customer.realcompanyname
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    @ColumnDescription(desc="")
    private String realcompanyname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_shifen_customer.fcontactorname
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    @ColumnDescription(desc="")
    private String fcontactorname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_shifen_customer.domain
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    @ColumnDescription(desc="")
    private String domain;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_shifen_customer.invalidate
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    @ColumnDescription(desc="")
    private Date invalidate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_shifen_customer.firstcusttime
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    @ColumnDescription(desc="")
    private Date firstcusttime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_shifen_customer.validdate
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    @ColumnDescription(desc="")
    private Date validdate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_shifen_customer.accountmoney
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    @ColumnDescription(desc="")
    private BigDecimal accountmoney;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_shifen_customer.beidoufirstcusttime
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    @ColumnDescription(desc="")
    private Date beidoufirstcusttime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_shifen_customer.customerd
     *
     * @return the value of tb_shifen_customer.customerd
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    public Integer getCustomerd() {
        return customerd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_shifen_customer.customerd
     *
     * @param customerd the value for tb_shifen_customer.customerd
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    public void setCustomerd(Integer customerd) {
        setField("customerd", customerd);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_shifen_customer.customername
     *
     * @return the value of tb_shifen_customer.customername
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    public String getCustomername() {
        return customername;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_shifen_customer.customername
     *
     * @param customername the value for tb_shifen_customer.customername
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    public void setCustomername(String customername) {
        customername = customername == null ? null : customername.trim();

        setField("customername", customername);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_shifen_customer.status
     *
     * @return the value of tb_shifen_customer.status
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_shifen_customer.status
     *
     * @param status the value for tb_shifen_customer.status
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    public void setStatus(Byte status) {
        setField("status", status);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_shifen_customer.companyname
     *
     * @return the value of tb_shifen_customer.companyname
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    public String getCompanyname() {
        return companyname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_shifen_customer.companyname
     *
     * @param companyname the value for tb_shifen_customer.companyname
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    public void setCompanyname(String companyname) {
        companyname = companyname == null ? null : companyname.trim();

        setField("companyname", companyname);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_shifen_customer.siteurl
     *
     * @return the value of tb_shifen_customer.siteurl
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    public String getSiteurl() {
        return siteurl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_shifen_customer.siteurl
     *
     * @param siteurl the value for tb_shifen_customer.siteurl
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    public void setSiteurl(String siteurl) {
        siteurl = siteurl == null ? null : siteurl.trim();

        setField("siteurl", siteurl);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_shifen_customer.urldomain
     *
     * @return the value of tb_shifen_customer.urldomain
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    public String getUrldomain() {
        return urldomain;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_shifen_customer.urldomain
     *
     * @param urldomain the value for tb_shifen_customer.urldomain
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    public void setUrldomain(String urldomain) {
        urldomain = urldomain == null ? null : urldomain.trim();

        setField("urldomain", urldomain);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_shifen_customer.conphone
     *
     * @return the value of tb_shifen_customer.conphone
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    public String getConphone() {
        return conphone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_shifen_customer.conphone
     *
     * @param conphone the value for tb_shifen_customer.conphone
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    public void setConphone(String conphone) {
        conphone = conphone == null ? null : conphone.trim();

        setField("conphone", conphone);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_shifen_customer.realcompanyname
     *
     * @return the value of tb_shifen_customer.realcompanyname
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    public String getRealcompanyname() {
        return realcompanyname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_shifen_customer.realcompanyname
     *
     * @param realcompanyname the value for tb_shifen_customer.realcompanyname
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    public void setRealcompanyname(String realcompanyname) {
        realcompanyname = realcompanyname == null ? null : realcompanyname.trim();

        setField("realcompanyname", realcompanyname);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_shifen_customer.fcontactorname
     *
     * @return the value of tb_shifen_customer.fcontactorname
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    public String getFcontactorname() {
        return fcontactorname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_shifen_customer.fcontactorname
     *
     * @param fcontactorname the value for tb_shifen_customer.fcontactorname
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    public void setFcontactorname(String fcontactorname) {
        fcontactorname = fcontactorname == null ? null : fcontactorname.trim();

        setField("fcontactorname", fcontactorname);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_shifen_customer.domain
     *
     * @return the value of tb_shifen_customer.domain
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    public String getDomain() {
        return domain;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_shifen_customer.domain
     *
     * @param domain the value for tb_shifen_customer.domain
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    public void setDomain(String domain) {
        domain = domain == null ? null : domain.trim();

        setField("domain", domain);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_shifen_customer.invalidate
     *
     * @return the value of tb_shifen_customer.invalidate
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    public Date getInvalidate() {
        return invalidate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_shifen_customer.invalidate
     *
     * @param invalidate the value for tb_shifen_customer.invalidate
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    public void setInvalidate(Date invalidate) {
        setField("invalidate", invalidate);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_shifen_customer.firstcusttime
     *
     * @return the value of tb_shifen_customer.firstcusttime
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    public Date getFirstcusttime() {
        return firstcusttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_shifen_customer.firstcusttime
     *
     * @param firstcusttime the value for tb_shifen_customer.firstcusttime
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    public void setFirstcusttime(Date firstcusttime) {
        setField("firstcusttime", firstcusttime);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_shifen_customer.validdate
     *
     * @return the value of tb_shifen_customer.validdate
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    public Date getValiddate() {
        return validdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_shifen_customer.validdate
     *
     * @param validdate the value for tb_shifen_customer.validdate
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    public void setValiddate(Date validdate) {
        setField("validdate", validdate);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_shifen_customer.accountmoney
     *
     * @return the value of tb_shifen_customer.accountmoney
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    public BigDecimal getAccountmoney() {
        return accountmoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_shifen_customer.accountmoney
     *
     * @param accountmoney the value for tb_shifen_customer.accountmoney
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    public void setAccountmoney(BigDecimal accountmoney) {
        setField("accountmoney", accountmoney);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_shifen_customer.beidoufirstcusttime
     *
     * @return the value of tb_shifen_customer.beidoufirstcusttime
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    public Date getBeidoufirstcusttime() {
        return beidoufirstcusttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_shifen_customer.beidoufirstcusttime
     *
     * @param beidoufirstcusttime the value for tb_shifen_customer.beidoufirstcusttime
     *
     * @mbggenerated Tue Jul 26 18:06:35 CST 2011
     */
    public void setBeidoufirstcusttime(Date beidoufirstcusttime) {
        setField("beidoufirstcusttime", beidoufirstcusttime);
    }
}