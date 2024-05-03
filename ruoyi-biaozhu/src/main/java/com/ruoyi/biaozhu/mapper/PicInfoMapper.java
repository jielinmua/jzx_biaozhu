package com.ruoyi.biaozhu.mapper;

import java.util.List;
import com.ruoyi.biaozhu.domain.PicInfo;

/**
 * 数据图表Mapper接口
 * 
 * @author ruoyi
 * @date 2024-04-29
 */
public interface PicInfoMapper 
{
    /**
     * 查询数据图表
     * 
     * @param pId 数据图表主键
     * @return 数据图表
     */
    public PicInfo selectPicInfoByPId(String pId);

    /**
     * 查询数据图表列表
     * 
     * @param picInfo 数据图表
     * @return 数据图表集合
     */
    public List<PicInfo> selectPicInfoList(PicInfo picInfo);

    /**
     * 新增数据图表
     * 
     * @param picInfo 数据图表
     * @return 结果
     */
    public int insertPicInfo(PicInfo picInfo);

    /**
     * 修改数据图表
     * 
     * @param picInfo 数据图表
     * @return 结果
     */
    public int updatePicInfo(PicInfo picInfo);

    /**
     * 删除数据图表
     * 
     * @param pId 数据图表主键
     * @return 结果
     */
    public int deletePicInfoByPId(String pId);

    /**
     * 批量删除数据图表
     * 
     * @param pIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePicInfoByPIds(String[] pIds);

    //批量插入pId和imgAddress
    public int insertPicInfos(List<PicInfo> picInfoList);
}
