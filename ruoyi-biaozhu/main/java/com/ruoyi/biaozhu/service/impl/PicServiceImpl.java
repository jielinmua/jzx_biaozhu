package com.ruoyi.biaozhu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.biaozhu.mapper.PicMapper;
import com.ruoyi.biaozhu.domain.Pic;
import com.ruoyi.biaozhu.service.IPicService;

/**
 * 标注Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-19
 */
@Service
public class PicServiceImpl implements IPicService 
{
    @Autowired
    private PicMapper picMapper;

    /**
     * 查询标注
     * 
     * @param pId 标注主键
     * @return 标注
     */
    @Override
    public Pic selectPicByPId(String pId)
    {
        return picMapper.selectPicByPId(pId);
    }

    /**
     * 查询标注列表
     * 
     * @param pic 标注
     * @return 标注
     */
    @Override
    public List<Pic> selectPicList(Pic pic)
    {
        return picMapper.selectPicList(pic);
    }

    /**
     * 新增标注
     * 
     * @param pic 标注
     * @return 结果
     */
    @Override
    public int insertPic(Pic pic)
    {
        return picMapper.insertPic(pic);
    }

    /**
     * 修改标注
     * 
     * @param pic 标注
     * @return 结果
     */
    @Override
    public int updatePic(Pic pic)
    {
        return picMapper.updatePic(pic);
    }

    /**
     * 批量删除标注
     * 
     * @param pIds 需要删除的标注主键
     * @return 结果
     */
    @Override
    public int deletePicByPIds(String[] pIds)
    {
        return picMapper.deletePicByPIds(pIds);
    }

    /**
     * 删除标注信息
     * 
     * @param pId 标注主键
     * @return 结果
     */
    @Override
    public int deletePicByPId(String pId)
    {
        return picMapper.deletePicByPId(pId);
    }

    @Override
    public List<Pic> selectUnlabeled(Pic pic) {
        return picMapper.selectUnlabeled(pic);
    }

    @Override
    public int insertPics(List<Pic> picList) {
        return picMapper.insertPics(picList);
    }
}
