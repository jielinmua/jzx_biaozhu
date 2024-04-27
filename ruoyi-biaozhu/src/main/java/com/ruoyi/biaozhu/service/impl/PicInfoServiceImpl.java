package com.ruoyi.biaozhu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.biaozhu.mapper.PicInfoMapper;
import com.ruoyi.biaozhu.domain.PicInfo;
import com.ruoyi.biaozhu.service.IPicInfoService;

/**
 * 数据图表Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-07
 */
@Service
public class PicInfoServiceImpl implements IPicInfoService 
{
    @Autowired
    private PicInfoMapper picInfoMapper;

    /**
     * 查询数据图表
     * 
     * @param pId 数据图表主键
     * @return 数据图表
     */
    @Override
    public PicInfo selectPicInfoByPId(String pId)
    {
        return picInfoMapper.selectPicInfoByPId(pId);
    }

    /**
     * 查询数据图表列表
     * 
     * @param picInfo 数据图表
     * @return 数据图表
     */
    @Override
    public List<PicInfo> selectPicInfoList(PicInfo picInfo)
    {
        return picInfoMapper.selectPicInfoList(picInfo);
    }

    /**
     * 新增数据图表
     * 
     * @param picInfo 数据图表
     * @return 结果
     */
    @Override
    public int insertPicInfo(PicInfo picInfo)
    {
        return picInfoMapper.insertPicInfo(picInfo);
    }

    /**
     * 修改数据图表
     * 
     * @param picInfo 数据图表
     * @return 结果
     */
    @Override
    public int updatePicInfo(PicInfo picInfo)
    {
        return picInfoMapper.updatePicInfo(picInfo);
    }

    /**
     * 批量删除数据图表
     * 
     * @param pIds 需要删除的数据图表主键
     * @return 结果
     */
    @Override
    public int deletePicInfoByPIds(String[] pIds)
    {
        return picInfoMapper.deletePicInfoByPIds(pIds);
    }

    /**
     * 删除数据图表信息
     * 
     * @param pId 数据图表主键
     * @return 结果
     */
    @Override
    public int deletePicInfoByPId(String pId)
    {
        return picInfoMapper.deletePicInfoByPId(pId);
    }

    //批量插入id和路径url
    @Override
    public int insertPicInfos(List<PicInfo> picInfoList) {
        return picInfoMapper.insertPicInfos(picInfoList);
    }
}
