package com.ruoyi.biaozhu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 标注对象 pic
 * 
 * @author ruoyi
 * @date 2024-04-29
 */
public class Pic extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String pId;

    /** 病人id */
    @Excel(name = "病人id")
    private String patientId;

    /** 年龄
 */
    @Excel(name = "年龄 ")
    private Long age;

    /** 性别 */
    @Excel(name = "性别")
    private String gender;

    /** 甲状腺实质弥漫 0假1真 */
    @Excel(name = "甲状腺实质弥漫 0假1真")
    private Long jiazhuangxianshizhimiman;

    /** 甲状腺是否双侧恶性 0假1真 */
    @Excel(name = "甲状腺是否双侧恶性 0假1真")
    private Long jzxShifoushuangceexing;

    /** 甲状腺多发病灶（单侧叶） 0假1真 */
    @Excel(name = "甲状腺多发病灶", readConverterExp = "单=侧叶")
    private Long jzxDuofabingzhao;

    /** 甲状腺位置上极 0假1真 */
    @Excel(name = "甲状腺位置上极 0假1真")
    private Long jzxWeizhiShangji;

    /** 甲状腺位置下极 0假1真 */
    @Excel(name = "甲状腺位置下极 0假1真")
    private Long jzxWeizhiXiaji;

    /** 甲状腺位置中部 0假1真 */
    @Excel(name = "甲状腺位置中部 0假1真")
    private Long jzxWeizhiZhongbu;

    /** 甲状腺位置峡部 0假1真 */
    @Excel(name = "甲状腺位置峡部 0假1真")
    private Long jzxWeizhiXiabu;

    /** 甲状腺病理组织结果 良性0假1真 */
    @Excel(name = "甲状腺病理组织结果 良性0假1真")
    private Long jzxZuzhibingliLiangxing;

    /** 甲状腺病理组织结果乳头状癌 0假1真 */
    @Excel(name = "甲状腺病理组织结果乳头状癌 0假1真")
    private Long jzxZuzhibingliRutouzhuangai;

    /** 甲状腺病理组织结果髓样癌 0假1真 */
    @Excel(name = "甲状腺病理组织结果髓样癌 0假1真")
    private Long jzxZuzhibingliSuiyangai;

    /** 甲状腺病理组织结果滤泡状癌 0假1真 */
    @Excel(name = "甲状腺病理组织结果滤泡状癌 0假1真")
    private Long jzxZuzhibinbliLvpaozhuangai;

    /** 甲状腺病理组织结果其他恶性 0假1真 */
    @Excel(name = "甲状腺病理组织结果其他恶性 0假1真")
    private Long jzxZuzhibingliQitaexing;

    /** 甲状腺结节最大径 float类型 */
    @Excel(name = "甲状腺结节最大径 float类型")
    private Long jzxJiejiezuidajing;

    /** 甲状腺内部结构实性0假1真 */
    @Excel(name = "甲状腺内部结构实性0假1真")
    private Long jzxNeibujiegouShixing;

    /** 甲状腺内部结构实性为主0假1真 */
    @Excel(name = "甲状腺内部结构实性为主0假1真")
    private Long jzxNeibujiegouShixingweizhu;

    /** 甲状腺内部结构囊性为主0假1真 */
    @Excel(name = "甲状腺内部结构囊性为主0假1真")
    private Long jzxNeibujiegouNangxingweizhu;

    /** 甲状腺内部结构囊实性0假1真 */
    @Excel(name = "甲状腺内部结构囊实性0假1真")
    private Long jzxNeibujiegouNangshixing;

    /** 甲状腺内部结构海绵样0假1真 */
    @Excel(name = "甲状腺内部结构海绵样0假1真")
    private Long jzxNeibujiegouHaimianyang;

    /** 甲状腺内部结构囊性0假1真 */
    @Excel(name = "甲状腺内部结构囊性0假1真")
    private Long jzxNeibujiegouNangxing;

    /** 甲状腺内部结构无法判断0假1真 */
    @Excel(name = "甲状腺内部结构无法判断0假1真")
    private Long jzxNeibujiegouWufapanduan;

    /** 甲状腺回声高回声0假1真 */
    @Excel(name = "甲状腺回声高回声0假1真")
    private Long jzxHuishengGaohuisheng;

    /** 甲状腺回声等回声0假1真 */
    @Excel(name = "甲状腺回声等回声0假1真")
    private Long jzxHuishengDenghuisheng;

    /** 甲状腺回声低回声0假1真 */
    @Excel(name = "甲状腺回声低回声0假1真")
    private Long jzxHuishengDihuisheng;

    /** 甲状腺回声极低回声0假1真 */
    @Excel(name = "甲状腺回声极低回声0假1真")
    private Long jzxHuishengJidihuisheng;

    /** 甲状腺回声无法判断0假1真 */
    @Excel(name = "甲状腺回声无法判断0假1真")
    private Long jzxHuishengWufapanduan;

    /** 甲状腺形状纵横比≥1  0假1真 */
    @Excel(name = "甲状腺形状纵横比≥1  0假1真")
    private Long jzxXingzhuangDayudengyu;

    /** 甲状腺形状纵横比&lt;1  0假1真 */
    @Excel(name = "甲状腺形状纵横比&lt;1  0假1真")
    private Long jzxXingzhuangXiaoyu;

    /** 甲状腺边缘光整0假1真 */
    @Excel(name = "甲状腺边缘光整0假1真")
    private Long jzxBianyuanGuangzheng;

    /** 甲状腺边缘不规则0假1真 */
    @Excel(name = "甲状腺边缘不规则0假1真")
    private Long jzxBianyuanBuguize;

    /** 甲状腺边缘分叶状0假1真 */
    @Excel(name = "甲状腺边缘分叶状0假1真")
    private Long jzxBianyuanFenyezhuang;

    /** 甲状腺边缘模糊0假1真 */
    @Excel(name = "甲状腺边缘模糊0假1真")
    private Long jzxBianyuanMohu;

    /** 甲状腺边缘ETE0假1真 */
    @Excel(name = "甲状腺边缘ETE0假1真")
    private Long jzxBianyuanEte;

    /** 甲状腺边缘无法确定 */
    @Excel(name = "甲状腺边缘无法确定")
    private Long jzxBianyuanWufaqueding;

    /** 甲状腺局灶强回声点状强回声0假1真 */
    @Excel(name = "甲状腺局灶强回声点状强回声0假1真")
    private Long jzxJuzhaoqianghuishengDianzhuang;

    /** 甲状腺局灶强回声粗大钙化0假1真 */
    @Excel(name = "甲状腺局灶强回声粗大钙化0假1真")
    private Long jzxJuzhaoqianghuishengCudagaihua;

    /** 甲状腺局灶强回声边缘钙化0假1真 */
    @Excel(name = "甲状腺局灶强回声边缘钙化0假1真")
    private Long jzxJuzhaoqianghuishengBianyuangaihua;

    /** 甲状腺局灶强回声彗星尾0假1真 */
    @Excel(name = "甲状腺局灶强回声彗星尾0假1真")
    private Long jzxJuzhaoqianghuishengHuixingwei;

    /** 淋巴结大小水平径 */
    @Excel(name = "淋巴结大小水平径")
    private Long lbjDaxiaoShuipingjing;

    /** 淋巴结大小垂直径 */
    @Excel(name = "淋巴结大小垂直径")
    private Long lbjDaxiaoCuizhijing;

    /** 淋巴结形状椭圆形0假1真 */
    @Excel(name = "淋巴结形状椭圆形0假1真")
    private Long lbjXingzhuangTuoyuan;

    /** 淋巴结形状类圆形0假1真 */
    @Excel(name = "淋巴结形状类圆形0假1真")
    private Long lbjXingzhuangLeiyuan;

    /** 淋巴结形状不规则0假1真 */
    @Excel(name = "淋巴结形状不规则0假1真")
    private Long lbjXingzhuangBuguize;

    /** 淋巴结边缘不规则0假1真 */
    @Excel(name = "淋巴结边缘不规则0假1真")
    private Long lbjBianyuanBuguize;

    /** 淋巴结边缘光整0假1真 */
    @Excel(name = "淋巴结边缘光整0假1真")
    private Long lbjBianyuanGuangzheng;

    /** 淋巴结淋巴门正常0假1真 */
    @Excel(name = "淋巴结淋巴门正常0假1真")
    private Long lbjLinbamenZhengchang;

    /** 淋巴结淋巴门偏心0假1真 */
    @Excel(name = "淋巴结淋巴门偏心0假1真")
    private Long lbjLinbamenPianxin;

    /** 淋巴结淋巴门消失0假1真 */
    @Excel(name = "淋巴结淋巴门消失0假1真")
    private Long lbjLinbamenXiaoshi;

    /** 淋巴结淋巴门高回声团快0假1真 */
    @Excel(name = "淋巴结淋巴门高回声团快0假1真")
    private Long lbjLinbamenGaohuishengtuankuai;

    /** 淋巴结皮质均匀增厚0假1真 */
    @Excel(name = "淋巴结皮质均匀增厚0假1真")
    private Long lbjPizhiJunyunzenghou;

    /** 淋巴结皮质不均匀增厚0假1真 */
    @Excel(name = "淋巴结皮质不均匀增厚0假1真")
    private Long lbjPizhiBujunyunzenghou;

    /** 淋巴结内均质高回声0假1真 */
    @Excel(name = "淋巴结内均质高回声0假1真")
    private Long lbjNeijunzhigaohuisheng;

    /** 淋巴结液化0假1真 */
    @Excel(name = "淋巴结液化0假1真")
    private Long lbjYehua;

    /** 淋巴结钙化0假1真 */
    @Excel(name = "淋巴结钙化0假1真")
    private Long lbjGaihua;

    /** 淋巴结血流正常0假1真 */
    @Excel(name = "淋巴结血流正常0假1真")
    private Long lbjXueliuZhengchang;

    /** 淋巴结血流门型0假1真 */
    @Excel(name = "淋巴结血流门型0假1真")
    private Long lbjXueliuMenxing;

    /** 淋巴结血流边缘为主型0假1真 */
    @Excel(name = "淋巴结血流边缘为主型0假1真")
    private Long lbjXueliuBianyuanweizhuxing;

    /** 淋巴结血流混合型0假1真 */
    @Excel(name = "淋巴结血流混合型0假1真")
    private Long lbjXueliuHunhexing;

    /** 淋巴结病理结果是否 0假1真 */
    @Excel(name = "淋巴结病理结果是否 0假1真")
    private Long lbjBinglijieguo;

    /** 图片线段信息 */
    @Excel(name = "图片线段信息")
    private String date;

    /** 图片路径 */
    @Excel(name = "图片路径")
    private String imgAddress;

    /** 是否标注0为未标注1为已标注2丢弃 */
    @Excel(name = "是否标注0为未标注1为已标注2丢弃")
    private Long isBiaozhu;

    public void setpId(String pId) 
    {
        this.pId = pId;
    }

    public String getpId() 
    {
        return pId;
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
    public void setJzxBianyuanWufaqueding(Long jzxBianyuanWufaqueding) 
    {
        this.jzxBianyuanWufaqueding = jzxBianyuanWufaqueding;
    }

    public Long getJzxBianyuanWufaqueding() 
    {
        return jzxBianyuanWufaqueding;
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
    public void setDate(String date) 
    {
        this.date = date;
    }

    public String getDate() 
    {
        return date;
    }
    public void setImgAddress(String imgAddress) 
    {
        this.imgAddress = imgAddress;
    }

    public String getImgAddress() 
    {
        return imgAddress;
    }
    public void setIsBiaozhu(Long isBiaozhu) 
    {
        this.isBiaozhu = isBiaozhu;
    }

    public Long getIsBiaozhu() 
    {
        return isBiaozhu;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("pId", getpId())
            .append("patientId", getPatientId())
            .append("age", getAge())
            .append("gender", getGender())
            .append("createTime", getCreateTime())
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
            .append("jzxBianyuanWufaqueding", getJzxBianyuanWufaqueding())
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
            .append("date", getDate())
            .append("imgAddress", getImgAddress())
            .append("isBiaozhu", getIsBiaozhu())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
