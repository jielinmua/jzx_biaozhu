package com.ruoyi.biaozhu.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.ruoyi.biaozhu.domain.Pic;
import com.ruoyi.biaozhu.mapper.PicMapper;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.biaozhu.mapper.PicInfoMapper;
import com.ruoyi.biaozhu.domain.PicInfo;
import com.ruoyi.biaozhu.service.IPicInfoService;

/**
 * 数据图表Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-05-03
 */
@Service
public class PicInfoServiceImpl implements IPicInfoService 
{
    @Autowired
    private PicInfoMapper picInfoMapper;

    @Autowired
    private PicMapper picMapper;

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

    @Override
    public List<PicInfo> selectPicInfoListByPatient(PicInfo picInfo) {
        return picInfoMapper.selectPicInfoListByPatient(picInfo);
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
        picInfo.setpId(getNo());
        if (StringUtils.isEmpty(picInfo.getPatientId())){
            picInfo.setPatientId(getNo());
        }

        picInfo.setCreateTime(DateUtils.getNowDate());
        if (!picInfo.getFileList().isEmpty()){
            for (String s : picInfo.getFileList()) {
                picInfo.setpId(getNo());
                picInfo.setImgAddress(s);
                picInfoMapper.insertPicInfo(picInfo);
                Pic pic = new Pic();
                BeanUtils.copyProperties(picInfo,pic);
                picMapper.insertPic(pic);
            }
            return 1;
        }else {
            Pic pic = new Pic();
            BeanUtils.copyProperties(picInfo,pic);
            picMapper.insertPic(pic);
            return picInfoMapper.insertPicInfo(picInfo);

        }

    }

    public String getNo() {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String newDate = sdf.format(new Date());
        String result = "";
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            result += random.nextInt(10);
        }
        return newDate + result;
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
        picInfo.setUpdateTime(DateUtils.getNowDate());
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
