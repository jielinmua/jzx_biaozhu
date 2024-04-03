package com.ruoyi.biaozhu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 标注对象 pic
 * 
 * @author ruoyi
 * @date 2024-03-30
 */
public class Pic extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String pId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long age;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String gender;

    /** 0假1真 */
    @Excel(name = "0假1真")
    private Long jiazhuangxianshizhimiman;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long jzxShifoushuangceexing;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long jzxDuofabingzhao;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long jzxWeizhiShangji;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long jzxWeizhiXiaji;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long jzxWeizhiZhongbu;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long jzxWeizhiXiabu;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long jzxZuzhibingliLiangxing;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long jzxZuzhibingliRutouzhuangai;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long jzxZuzhibingliSuiyangai;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long jzxZuzhibinbliLvpaozhuangai;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long jzxZuzhibingliQitaexing;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long jzxJiejiezuidajing;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long jzxNeibujiegouShixing;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long jzxNeibujiegouShixingweizhu;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long jzxNeibujiegouNangxingweizhu;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long jzxNeibujiegouNangshixing;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long jzxNeibujiegouHaimianyang;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long jzxNeibujiegouNangxing;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long jzxNeibujiegouWufapanduan;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long jzxHuishengGaohuisheng;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long jzxHuishengDenghuisheng;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long jzxHuishengDihuisheng;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long jzxHuishengJidihuisheng;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long jzxHuishengWufapanduan;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long jzxXingzhuangDayudengyu;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long jzxXingzhuangXiaoyu;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long jzxBianyuanGuangzheng;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long jzxBianyuanBuguize;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long jzxBianyuanFenyezhuang;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long jzxBianyuanMohu;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long jzxBianyuanEte;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long jzxJuzhaoqianghuishengDianzhuang;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long jzxJuzhaoqianghuishengCudagaihua;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long jzxJuzhaoqianghuishengBianyuangaihua;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long jzxJuzhaoqianghuishengHuixingwei;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long lbjDaxiaoShuipingjing;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long lbjDaxiaoCuizhijing;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long lbjXingzhuangTuoyuan;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long lbjXingzhuangLeiyuan;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long lbjXingzhuangBuguize;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long lbjBianyuanBuguize;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long lbjBianyuanGuangzheng;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long lbjLinbamenZhengchang;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long lbjLinbamenPianxin;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long lbjLinbamenXiaoshi;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long lbjLinbamenGaohuishengtuankuai;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long lbjPizhiJunyunzenghou;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long lbjPizhiBujunyunzenghou;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long lbjNeijunzhigaohuisheng;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long lbjYehua;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long lbjGaihua;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long lbjXueliuZhengchang;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long lbjXueliuMenxing;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long lbjXueliuBianyuanweizhuxing;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long lbjXueliuHunhexing;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long lbjBinglijieguo;

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
    public void setJiazhuangxianshizhimiman(Long jiazhuangxianshizhimiman) 
    {
        this.jiazhuangxianshizhimiman = jiazhuangxianshizhimiman;
    }

    public Long getJiazhuangxianshizhimiman() 
    {
        return jiazhuangxianshizhimiman;
    }
    public void setJzxShifoushuangceexing(Long jzxShifoushuangceexing) 
    {
        this.jzxShifoushuangceexing = jzxShifoushuangceexing;
    }

    public Long getJzxShifoushuangceexing() 
    {
        return jzxShifoushuangceexing;
    }
    public void setJzxDuofabingzhao(Long jzxDuofabingzhao) 
    {
        this.jzxDuofabingzhao = jzxDuofabingzhao;
    }

    public Long getJzxDuofabingzhao() 
    {
        return jzxDuofabingzhao;
    }
    public void setJzxWeizhiShangji(Long jzxWeizhiShangji) 
    {
        this.jzxWeizhiShangji = jzxWeizhiShangji;
    }

    public Long getJzxWeizhiShangji() 
    {
        return jzxWeizhiShangji;
    }
    public void setJzxWeizhiXiaji(Long jzxWeizhiXiaji) 
    {
        this.jzxWeizhiXiaji = jzxWeizhiXiaji;
    }

    public Long getJzxWeizhiXiaji() 
    {
        return jzxWeizhiXiaji;
    }
    public void setJzxWeizhiZhongbu(Long jzxWeizhiZhongbu) 
    {
        this.jzxWeizhiZhongbu = jzxWeizhiZhongbu;
    }

    public Long getJzxWeizhiZhongbu() 
    {
        return jzxWeizhiZhongbu;
    }
    public void setJzxWeizhiXiabu(Long jzxWeizhiXiabu) 
    {
        this.jzxWeizhiXiabu = jzxWeizhiXiabu;
    }

    public Long getJzxWeizhiXiabu() 
    {
        return jzxWeizhiXiabu;
    }
    public void setJzxZuzhibingliLiangxing(Long jzxZuzhibingliLiangxing) 
    {
        this.jzxZuzhibingliLiangxing = jzxZuzhibingliLiangxing;
    }

    public Long getJzxZuzhibingliLiangxing() 
    {
        return jzxZuzhibingliLiangxing;
    }
    public void setJzxZuzhibingliRutouzhuangai(Long jzxZuzhibingliRutouzhuangai) 
    {
        this.jzxZuzhibingliRutouzhuangai = jzxZuzhibingliRutouzhuangai;
    }

    public Long getJzxZuzhibingliRutouzhuangai() 
    {
        return jzxZuzhibingliRutouzhuangai;
    }
    public void setJzxZuzhibingliSuiyangai(Long jzxZuzhibingliSuiyangai) 
    {
        this.jzxZuzhibingliSuiyangai = jzxZuzhibingliSuiyangai;
    }

    public Long getJzxZuzhibingliSuiyangai() 
    {
        return jzxZuzhibingliSuiyangai;
    }
    public void setJzxZuzhibinbliLvpaozhuangai(Long jzxZuzhibinbliLvpaozhuangai) 
    {
        this.jzxZuzhibinbliLvpaozhuangai = jzxZuzhibinbliLvpaozhuangai;
    }

    public Long getJzxZuzhibinbliLvpaozhuangai() 
    {
        return jzxZuzhibinbliLvpaozhuangai;
    }
    public void setJzxZuzhibingliQitaexing(Long jzxZuzhibingliQitaexing) 
    {
        this.jzxZuzhibingliQitaexing = jzxZuzhibingliQitaexing;
    }

    public Long getJzxZuzhibingliQitaexing() 
    {
        return jzxZuzhibingliQitaexing;
    }
    public void setJzxJiejiezuidajing(Long jzxJiejiezuidajing) 
    {
        this.jzxJiejiezuidajing = jzxJiejiezuidajing;
    }

    public Long getJzxJiejiezuidajing() 
    {
        return jzxJiejiezuidajing;
    }
    public void setJzxNeibujiegouShixing(Long jzxNeibujiegouShixing) 
    {
        this.jzxNeibujiegouShixing = jzxNeibujiegouShixing;
    }

    public Long getJzxNeibujiegouShixing() 
    {
        return jzxNeibujiegouShixing;
    }
    public void setJzxNeibujiegouShixingweizhu(Long jzxNeibujiegouShixingweizhu) 
    {
        this.jzxNeibujiegouShixingweizhu = jzxNeibujiegouShixingweizhu;
    }

    public Long getJzxNeibujiegouShixingweizhu() 
    {
        return jzxNeibujiegouShixingweizhu;
    }
    public void setJzxNeibujiegouNangxingweizhu(Long jzxNeibujiegouNangxingweizhu) 
    {
        this.jzxNeibujiegouNangxingweizhu = jzxNeibujiegouNangxingweizhu;
    }

    public Long getJzxNeibujiegouNangxingweizhu() 
    {
        return jzxNeibujiegouNangxingweizhu;
    }
    public void setJzxNeibujiegouNangshixing(Long jzxNeibujiegouNangshixing) 
    {
        this.jzxNeibujiegouNangshixing = jzxNeibujiegouNangshixing;
    }

    public Long getJzxNeibujiegouNangshixing() 
    {
        return jzxNeibujiegouNangshixing;
    }
    public void setJzxNeibujiegouHaimianyang(Long jzxNeibujiegouHaimianyang) 
    {
        this.jzxNeibujiegouHaimianyang = jzxNeibujiegouHaimianyang;
    }

    public Long getJzxNeibujiegouHaimianyang() 
    {
        return jzxNeibujiegouHaimianyang;
    }
    public void setJzxNeibujiegouNangxing(Long jzxNeibujiegouNangxing) 
    {
        this.jzxNeibujiegouNangxing = jzxNeibujiegouNangxing;
    }

    public Long getJzxNeibujiegouNangxing() 
    {
        return jzxNeibujiegouNangxing;
    }
    public void setJzxNeibujiegouWufapanduan(Long jzxNeibujiegouWufapanduan) 
    {
        this.jzxNeibujiegouWufapanduan = jzxNeibujiegouWufapanduan;
    }

    public Long getJzxNeibujiegouWufapanduan() 
    {
        return jzxNeibujiegouWufapanduan;
    }
    public void setJzxHuishengGaohuisheng(Long jzxHuishengGaohuisheng) 
    {
        this.jzxHuishengGaohuisheng = jzxHuishengGaohuisheng;
    }

    public Long getJzxHuishengGaohuisheng() 
    {
        return jzxHuishengGaohuisheng;
    }
    public void setJzxHuishengDenghuisheng(Long jzxHuishengDenghuisheng) 
    {
        this.jzxHuishengDenghuisheng = jzxHuishengDenghuisheng;
    }

    public Long getJzxHuishengDenghuisheng() 
    {
        return jzxHuishengDenghuisheng;
    }
    public void setJzxHuishengDihuisheng(Long jzxHuishengDihuisheng) 
    {
        this.jzxHuishengDihuisheng = jzxHuishengDihuisheng;
    }

    public Long getJzxHuishengDihuisheng() 
    {
        return jzxHuishengDihuisheng;
    }
    public void setJzxHuishengJidihuisheng(Long jzxHuishengJidihuisheng) 
    {
        this.jzxHuishengJidihuisheng = jzxHuishengJidihuisheng;
    }

    public Long getJzxHuishengJidihuisheng() 
    {
        return jzxHuishengJidihuisheng;
    }
    public void setJzxHuishengWufapanduan(Long jzxHuishengWufapanduan) 
    {
        this.jzxHuishengWufapanduan = jzxHuishengWufapanduan;
    }

    public Long getJzxHuishengWufapanduan() 
    {
        return jzxHuishengWufapanduan;
    }
    public void setJzxXingzhuangDayudengyu(Long jzxXingzhuangDayudengyu) 
    {
        this.jzxXingzhuangDayudengyu = jzxXingzhuangDayudengyu;
    }

    public Long getJzxXingzhuangDayudengyu() 
    {
        return jzxXingzhuangDayudengyu;
    }
    public void setJzxXingzhuangXiaoyu(Long jzxXingzhuangXiaoyu) 
    {
        this.jzxXingzhuangXiaoyu = jzxXingzhuangXiaoyu;
    }

    public Long getJzxXingzhuangXiaoyu() 
    {
        return jzxXingzhuangXiaoyu;
    }
    public void setJzxBianyuanGuangzheng(Long jzxBianyuanGuangzheng) 
    {
        this.jzxBianyuanGuangzheng = jzxBianyuanGuangzheng;
    }

    public Long getJzxBianyuanGuangzheng() 
    {
        return jzxBianyuanGuangzheng;
    }
    public void setJzxBianyuanBuguize(Long jzxBianyuanBuguize) 
    {
        this.jzxBianyuanBuguize = jzxBianyuanBuguize;
    }

    public Long getJzxBianyuanBuguize() 
    {
        return jzxBianyuanBuguize;
    }
    public void setJzxBianyuanFenyezhuang(Long jzxBianyuanFenyezhuang) 
    {
        this.jzxBianyuanFenyezhuang = jzxBianyuanFenyezhuang;
    }

    public Long getJzxBianyuanFenyezhuang() 
    {
        return jzxBianyuanFenyezhuang;
    }
    public void setJzxBianyuanMohu(Long jzxBianyuanMohu) 
    {
        this.jzxBianyuanMohu = jzxBianyuanMohu;
    }

    public Long getJzxBianyuanMohu() 
    {
        return jzxBianyuanMohu;
    }
    public void setJzxBianyuanEte(Long jzxBianyuanEte) 
    {
        this.jzxBianyuanEte = jzxBianyuanEte;
    }

    public Long getJzxBianyuanEte() 
    {
        return jzxBianyuanEte;
    }
    public void setJzxJuzhaoqianghuishengDianzhuang(Long jzxJuzhaoqianghuishengDianzhuang) 
    {
        this.jzxJuzhaoqianghuishengDianzhuang = jzxJuzhaoqianghuishengDianzhuang;
    }

    public Long getJzxJuzhaoqianghuishengDianzhuang() 
    {
        return jzxJuzhaoqianghuishengDianzhuang;
    }
    public void setJzxJuzhaoqianghuishengCudagaihua(Long jzxJuzhaoqianghuishengCudagaihua) 
    {
        this.jzxJuzhaoqianghuishengCudagaihua = jzxJuzhaoqianghuishengCudagaihua;
    }

    public Long getJzxJuzhaoqianghuishengCudagaihua() 
    {
        return jzxJuzhaoqianghuishengCudagaihua;
    }
    public void setJzxJuzhaoqianghuishengBianyuangaihua(Long jzxJuzhaoqianghuishengBianyuangaihua) 
    {
        this.jzxJuzhaoqianghuishengBianyuangaihua = jzxJuzhaoqianghuishengBianyuangaihua;
    }

    public Long getJzxJuzhaoqianghuishengBianyuangaihua() 
    {
        return jzxJuzhaoqianghuishengBianyuangaihua;
    }
    public void setJzxJuzhaoqianghuishengHuixingwei(Long jzxJuzhaoqianghuishengHuixingwei) 
    {
        this.jzxJuzhaoqianghuishengHuixingwei = jzxJuzhaoqianghuishengHuixingwei;
    }

    public Long getJzxJuzhaoqianghuishengHuixingwei() 
    {
        return jzxJuzhaoqianghuishengHuixingwei;
    }
    public void setLbjDaxiaoShuipingjing(Long lbjDaxiaoShuipingjing) 
    {
        this.lbjDaxiaoShuipingjing = lbjDaxiaoShuipingjing;
    }

    public Long getLbjDaxiaoShuipingjing() 
    {
        return lbjDaxiaoShuipingjing;
    }
    public void setLbjDaxiaoCuizhijing(Long lbjDaxiaoCuizhijing) 
    {
        this.lbjDaxiaoCuizhijing = lbjDaxiaoCuizhijing;
    }

    public Long getLbjDaxiaoCuizhijing() 
    {
        return lbjDaxiaoCuizhijing;
    }
    public void setLbjXingzhuangTuoyuan(Long lbjXingzhuangTuoyuan) 
    {
        this.lbjXingzhuangTuoyuan = lbjXingzhuangTuoyuan;
    }

    public Long getLbjXingzhuangTuoyuan() 
    {
        return lbjXingzhuangTuoyuan;
    }
    public void setLbjXingzhuangLeiyuan(Long lbjXingzhuangLeiyuan) 
    {
        this.lbjXingzhuangLeiyuan = lbjXingzhuangLeiyuan;
    }

    public Long getLbjXingzhuangLeiyuan() 
    {
        return lbjXingzhuangLeiyuan;
    }
    public void setLbjXingzhuangBuguize(Long lbjXingzhuangBuguize) 
    {
        this.lbjXingzhuangBuguize = lbjXingzhuangBuguize;
    }

    public Long getLbjXingzhuangBuguize() 
    {
        return lbjXingzhuangBuguize;
    }
    public void setLbjBianyuanBuguize(Long lbjBianyuanBuguize) 
    {
        this.lbjBianyuanBuguize = lbjBianyuanBuguize;
    }

    public Long getLbjBianyuanBuguize() 
    {
        return lbjBianyuanBuguize;
    }
    public void setLbjBianyuanGuangzheng(Long lbjBianyuanGuangzheng) 
    {
        this.lbjBianyuanGuangzheng = lbjBianyuanGuangzheng;
    }

    public Long getLbjBianyuanGuangzheng() 
    {
        return lbjBianyuanGuangzheng;
    }
    public void setLbjLinbamenZhengchang(Long lbjLinbamenZhengchang) 
    {
        this.lbjLinbamenZhengchang = lbjLinbamenZhengchang;
    }

    public Long getLbjLinbamenZhengchang() 
    {
        return lbjLinbamenZhengchang;
    }
    public void setLbjLinbamenPianxin(Long lbjLinbamenPianxin) 
    {
        this.lbjLinbamenPianxin = lbjLinbamenPianxin;
    }

    public Long getLbjLinbamenPianxin() 
    {
        return lbjLinbamenPianxin;
    }
    public void setLbjLinbamenXiaoshi(Long lbjLinbamenXiaoshi) 
    {
        this.lbjLinbamenXiaoshi = lbjLinbamenXiaoshi;
    }

    public Long getLbjLinbamenXiaoshi() 
    {
        return lbjLinbamenXiaoshi;
    }
    public void setLbjLinbamenGaohuishengtuankuai(Long lbjLinbamenGaohuishengtuankuai) 
    {
        this.lbjLinbamenGaohuishengtuankuai = lbjLinbamenGaohuishengtuankuai;
    }

    public Long getLbjLinbamenGaohuishengtuankuai() 
    {
        return lbjLinbamenGaohuishengtuankuai;
    }
    public void setLbjPizhiJunyunzenghou(Long lbjPizhiJunyunzenghou) 
    {
        this.lbjPizhiJunyunzenghou = lbjPizhiJunyunzenghou;
    }

    public Long getLbjPizhiJunyunzenghou() 
    {
        return lbjPizhiJunyunzenghou;
    }
    public void setLbjPizhiBujunyunzenghou(Long lbjPizhiBujunyunzenghou) 
    {
        this.lbjPizhiBujunyunzenghou = lbjPizhiBujunyunzenghou;
    }

    public Long getLbjPizhiBujunyunzenghou() 
    {
        return lbjPizhiBujunyunzenghou;
    }
    public void setLbjNeijunzhigaohuisheng(Long lbjNeijunzhigaohuisheng) 
    {
        this.lbjNeijunzhigaohuisheng = lbjNeijunzhigaohuisheng;
    }

    public Long getLbjNeijunzhigaohuisheng() 
    {
        return lbjNeijunzhigaohuisheng;
    }
    public void setLbjYehua(Long lbjYehua) 
    {
        this.lbjYehua = lbjYehua;
    }

    public Long getLbjYehua() 
    {
        return lbjYehua;
    }
    public void setLbjGaihua(Long lbjGaihua) 
    {
        this.lbjGaihua = lbjGaihua;
    }

    public Long getLbjGaihua() 
    {
        return lbjGaihua;
    }
    public void setLbjXueliuZhengchang(Long lbjXueliuZhengchang) 
    {
        this.lbjXueliuZhengchang = lbjXueliuZhengchang;
    }

    public Long getLbjXueliuZhengchang() 
    {
        return lbjXueliuZhengchang;
    }
    public void setLbjXueliuMenxing(Long lbjXueliuMenxing) 
    {
        this.lbjXueliuMenxing = lbjXueliuMenxing;
    }

    public Long getLbjXueliuMenxing() 
    {
        return lbjXueliuMenxing;
    }
    public void setLbjXueliuBianyuanweizhuxing(Long lbjXueliuBianyuanweizhuxing) 
    {
        this.lbjXueliuBianyuanweizhuxing = lbjXueliuBianyuanweizhuxing;
    }

    public Long getLbjXueliuBianyuanweizhuxing() 
    {
        return lbjXueliuBianyuanweizhuxing;
    }
    public void setLbjXueliuHunhexing(Long lbjXueliuHunhexing) 
    {
        this.lbjXueliuHunhexing = lbjXueliuHunhexing;
    }

    public Long getLbjXueliuHunhexing() 
    {
        return lbjXueliuHunhexing;
    }
    public void setLbjBinglijieguo(Long lbjBinglijieguo) 
    {
        this.lbjBinglijieguo = lbjBinglijieguo;
    }

    public Long getLbjBinglijieguo() 
    {
        return lbjBinglijieguo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("pId", getpId())
            .append("age", getAge())
            .append("gender", getGender())
            .append("jiazhuangxianshizhimiman", getJiazhuangxianshizhimiman())
            .append("jzxShifoushuangceexing", getJzxShifoushuangceexing())
            .append("jzxDuofabingzhao", getJzxDuofabingzhao())
            .append("jzxWeizhiShangji", getJzxWeizhiShangji())
            .append("jzxWeizhiXiaji", getJzxWeizhiXiaji())
            .append("jzxWeizhiZhongbu", getJzxWeizhiZhongbu())
            .append("jzxWeizhiXiabu", getJzxWeizhiXiabu())
            .append("jzxZuzhibingliLiangxing", getJzxZuzhibingliLiangxing())
            .append("jzxZuzhibingliRutouzhuangai", getJzxZuzhibingliRutouzhuangai())
            .append("jzxZuzhibingliSuiyangai", getJzxZuzhibingliSuiyangai())
            .append("jzxZuzhibinbliLvpaozhuangai", getJzxZuzhibinbliLvpaozhuangai())
            .append("jzxZuzhibingliQitaexing", getJzxZuzhibingliQitaexing())
            .append("jzxJiejiezuidajing", getJzxJiejiezuidajing())
            .append("jzxNeibujiegouShixing", getJzxNeibujiegouShixing())
            .append("jzxNeibujiegouShixingweizhu", getJzxNeibujiegouShixingweizhu())
            .append("jzxNeibujiegouNangxingweizhu", getJzxNeibujiegouNangxingweizhu())
            .append("jzxNeibujiegouNangshixing", getJzxNeibujiegouNangshixing())
            .append("jzxNeibujiegouHaimianyang", getJzxNeibujiegouHaimianyang())
            .append("jzxNeibujiegouNangxing", getJzxNeibujiegouNangxing())
            .append("jzxNeibujiegouWufapanduan", getJzxNeibujiegouWufapanduan())
            .append("jzxHuishengGaohuisheng", getJzxHuishengGaohuisheng())
            .append("jzxHuishengDenghuisheng", getJzxHuishengDenghuisheng())
            .append("jzxHuishengDihuisheng", getJzxHuishengDihuisheng())
            .append("jzxHuishengJidihuisheng", getJzxHuishengJidihuisheng())
            .append("jzxHuishengWufapanduan", getJzxHuishengWufapanduan())
            .append("jzxXingzhuangDayudengyu", getJzxXingzhuangDayudengyu())
            .append("jzxXingzhuangXiaoyu", getJzxXingzhuangXiaoyu())
            .append("jzxBianyuanGuangzheng", getJzxBianyuanGuangzheng())
            .append("jzxBianyuanBuguize", getJzxBianyuanBuguize())
            .append("jzxBianyuanFenyezhuang", getJzxBianyuanFenyezhuang())
            .append("jzxBianyuanMohu", getJzxBianyuanMohu())
            .append("jzxBianyuanEte", getJzxBianyuanEte())
            .append("jzxJuzhaoqianghuishengDianzhuang", getJzxJuzhaoqianghuishengDianzhuang())
            .append("jzxJuzhaoqianghuishengCudagaihua", getJzxJuzhaoqianghuishengCudagaihua())
            .append("jzxJuzhaoqianghuishengBianyuangaihua", getJzxJuzhaoqianghuishengBianyuangaihua())
            .append("jzxJuzhaoqianghuishengHuixingwei", getJzxJuzhaoqianghuishengHuixingwei())
            .append("lbjDaxiaoShuipingjing", getLbjDaxiaoShuipingjing())
            .append("lbjDaxiaoCuizhijing", getLbjDaxiaoCuizhijing())
            .append("lbjXingzhuangTuoyuan", getLbjXingzhuangTuoyuan())
            .append("lbjXingzhuangLeiyuan", getLbjXingzhuangLeiyuan())
            .append("lbjXingzhuangBuguize", getLbjXingzhuangBuguize())
            .append("lbjBianyuanBuguize", getLbjBianyuanBuguize())
            .append("lbjBianyuanGuangzheng", getLbjBianyuanGuangzheng())
            .append("lbjLinbamenZhengchang", getLbjLinbamenZhengchang())
            .append("lbjLinbamenPianxin", getLbjLinbamenPianxin())
            .append("lbjLinbamenXiaoshi", getLbjLinbamenXiaoshi())
            .append("lbjLinbamenGaohuishengtuankuai", getLbjLinbamenGaohuishengtuankuai())
            .append("lbjPizhiJunyunzenghou", getLbjPizhiJunyunzenghou())
            .append("lbjPizhiBujunyunzenghou", getLbjPizhiBujunyunzenghou())
            .append("lbjNeijunzhigaohuisheng", getLbjNeijunzhigaohuisheng())
            .append("lbjYehua", getLbjYehua())
            .append("lbjGaihua", getLbjGaihua())
            .append("lbjXueliuZhengchang", getLbjXueliuZhengchang())
            .append("lbjXueliuMenxing", getLbjXueliuMenxing())
            .append("lbjXueliuBianyuanweizhuxing", getLbjXueliuBianyuanweizhuxing())
            .append("lbjXueliuHunhexing", getLbjXueliuHunhexing())
            .append("lbjBinglijieguo", getLbjBinglijieguo())
            .toString();
    }
}
