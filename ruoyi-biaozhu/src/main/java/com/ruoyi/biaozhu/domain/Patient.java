package com.ruoyi.biaozhu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 患者对象 patient
 * 
 * @author ruoyi
 * @date 2024-06-11
 */
public class Patient extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 患者id */
    @Excel(name = "患者id")
    private String patientId;

    /** 年龄 */
    @Excel(name = "年龄")
    private Long age;

    /** 性别 */
    @Excel(name = "性别")
    private String gender;

    private Integer all;


    private Integer wei;


    private Integer yi;


    private Integer diu;

    public Integer getAll() {
        return all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }

    public Integer getWei() {
        return wei;
    }

    public void setWei(Integer wei) {
        this.wei = wei;
    }

    public Integer getYi() {
        return yi;
    }

    public void setYi(Integer yi) {
        this.yi = yi;
    }

    public Integer getDiu() {
        return diu;
    }

    public void setDiu(Integer diu) {
        this.diu = diu;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPatientId(String patientId) 
    {
        this.patientId = patientId;
    }

    public String getPatientId() 
    {
        return patientId;
    }
    public void setAge(Long age) 
    {
        this.age = age;
    }

    public Long getAge() 
    {
        return age;
    }
    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("patientId", getPatientId())
            .append("age", getAge())
            .append("gender", getGender())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
