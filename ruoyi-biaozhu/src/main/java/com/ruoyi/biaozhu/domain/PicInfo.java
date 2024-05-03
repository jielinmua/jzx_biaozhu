package com.ruoyi.biaozhu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 数据图表对象 pic_info
 * 
 * @author ruoyi
 * @date 2024-04-29
 */
public class PicInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    @Excel(name = "")
    private String pId;

    /** 年龄 */
    @Excel(name = "年龄")
    private Long age;

    /** 性别 */
    @Excel(name = "性别")
    private String gender;

    /** 图片地址 */
    @Excel(name = "图片地址")
    private String imgAddress;

    /** 病人id */
    @Excel(name = "病人id")
    private String patientId;

    public void setpId(String pId) 
    {
        this.pId = pId;
    }

    public String getpId() 
    {
        return pId;
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
    public void setImgAddress(String imgAddress) 
    {
        this.imgAddress = imgAddress;
    }

    public String getImgAddress() 
    {
        return imgAddress;
    }
    public void setPatientId(String patientId) 
    {
        this.patientId = patientId;
    }

    public String getPatientId() 
    {
        return patientId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("pId", getpId())
            .append("age", getAge())
            .append("gender", getGender())
            .append("imgAddress", getImgAddress())
            .append("patientId", getPatientId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
