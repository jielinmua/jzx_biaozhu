package com.ruoyi.biaozhu.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.biaozhu.domain.PicInfo;
import com.ruoyi.biaozhu.service.IPicInfoService;
import com.ruoyi.biaozhu.utils.FileUploadUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.biaozhu.domain.Pic;
import com.ruoyi.biaozhu.service.IPicService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 标注Controller
 * 
 * @author ruoyi
 * @date 2024-04-29
 */
@RestController
@RequestMapping("/biaozhu/pic")
public class PicController extends BaseController
{
    @Autowired
    private IPicService picService;

    @Autowired
    private IPicInfoService picInfoService;

    @Autowired
    private FileUploadUtils fileUploadUtils;



    /**
     * 查询标注列表
     */
    @PreAuthorize("@ss.hasPermi('biaozhu:pic:list')")
    @GetMapping("/list")
    public TableDataInfo list(Pic pic)
    {
        startPage();
        List<Pic> list = picService.selectPicList(pic);
        return getDataTable(list);
    }

    /**
     * 导出标注列表
     */
    @PreAuthorize("@ss.hasPermi('biaozhu:pic:export')")
    @Log(title = "标注", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Pic pic)
    {
        List<Pic> list = picService.selectPicList(pic);
        ExcelUtil<Pic> util = new ExcelUtil<Pic>(Pic.class);
        util.exportExcel(response, list, "标注数据");
    }

    /**
     * 获取标注详细信息
     */
    @PreAuthorize("@ss.hasPermi('biaozhu:pic:query')")
    @GetMapping(value = "/{pId}")
    public AjaxResult getInfo(@PathVariable("pId") String pId)
    {
        return success(picService.selectPicByPId(pId));
    }

    /**
     * 新增标注
     */
    @PreAuthorize("@ss.hasPermi('biaozhu:pic:add')")
    @Log(title = "标注", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestParam("images") List<MultipartFile> images,String patientId,String gender,Long age) {
        //FileUploadUtils fileUploadUtils = new FileUploadUtils();
        List<Pic> pics = new ArrayList<>();
        List<PicInfo> picInfos = new ArrayList<>();
        try {
            for (MultipartFile image : images) {
                // 生成PID
                String pId = String.valueOf(System.currentTimeMillis()) + String.valueOf((int)((Math.random() * 9 + 1) * 100000));

                // 指定图片保存的位置和用户ID（这里假设使用PID作为示例的用户ID）
                String location = "jzx"; // 请根据实际情况修改位置
                String userId = pId; // 这应该是你识别用户的方式

                // 使用FileUploadUtils来保存文件
                String path = fileUploadUtils.uploadImgUrl(image, location, userId);

                if (path == null) {
                    return AjaxResult.error("上传图片失败");
                }

                // 创建Pic对象并设置属性
                Pic pic = new Pic();
                pic.setpId(pId);
                pic.setImgAddress(path);
                pic.setCreateTime(new java.util.Date());
                pic.setPatientId(patientId);
                pic.setGender(gender);
                pic.setAge(age);
                pics.add(pic);
                //插入创建时间


                PicInfo picInfo = new PicInfo();
                picInfo.setpId(pId);
                picInfo.setImgAddress(path);
                picInfo.setCreateTime(new java.util.Date());
                picInfo.setPatientId(patientId);
                picInfo.setGender(gender);
                picInfo.setAge(age);
                picInfos.add(picInfo);
            }

            // 批量将pic对象插入数据库
            int result = picService.insertPics(pics);
            int result2 = picInfoService.insertPicInfos(picInfos);
            boolean flag = result > 0 && result2 > 0;
            return toAjax(flag);
        } catch (Exception e) {
            return AjaxResult.error("操作失败：" + e.getMessage());
        }
    }

//    @PreAuthorize("@ss.hasPermi('biaozhu:pic:add')")
//    @Log(title = "标注", businessType = BusinessType.INSERT)
//    @PostMapping
//    public AjaxResult add(@RequestParam("image") MultipartFile image)
//    {
////        FileUploadUtils fileUploadUtils = new FileUploadUtils();
//        try {
//            // 生成PID
//            String pId = String.valueOf(System.currentTimeMillis()) + String.valueOf((int)((Math.random() * 9 + 1) * 100000));
//
//            // 指定图片保存的位置和用户ID（这里假设使用PID作为示例的用户ID）
//            String location = "jzx"; // 请根据实际情况修改位置
//            String userId = pId; // 这应该是你识别用户的方式
//
//            // 使用FileUploadUtils来保存文件
//            String path = fileUploadUtils.uploadImgUrl(image, location, userId);
//
//            if (path == null) {
//                return AjaxResult.error("上传图片失败");
//            }
//
//            // 创建Pic对象并设置属性
//            Pic pic = new Pic();
//            pic.setpId(pId);
//            pic.setImgAddress(path);
//            PicInfo picInfo = new PicInfo();
//            picInfo.setpId(pId);
//            picInfo.setImgAddress(path);
//
//            // 将pic对象插入数据库
//            int result = picService.insertPic(pic);
//            int result2 = picInfoService.insertPicInfo(picInfo);
//
//            return toAjax(result);
//        } catch (Exception e) {
//            return AjaxResult.error("操作失败：" + e.getMessage());
//        }
//    }
//    public AjaxResult add(@RequestBody Pic pic)
//    {
//        //新增的pid由时间戳加随机字符串生成
//        pic.setpId(String.valueOf(System.currentTimeMillis())+String.valueOf((int)((Math.random()*9+1)*100000)));
//        return toAjax(picService.insertPic(pic));
//    }


    /**
     * 修改标注
     */
    @PreAuthorize("@ss.hasPermi('biaozhu:pic:edit')")
    @Log(title = "标注", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Pic pic)
    {
        //获取年龄字段，性别字段
        PicInfo picInfo = new PicInfo();
        picInfo.setpId(pic.getpId());
        picInfo.setAge(pic.getAge());
        picInfo.setGender(pic.getGender());
        int i=picInfoService.updatePicInfo(picInfo);
//        //pic的isBiaoZhu字段设为1
//        pic.setIsBiaozhu(1L);
        return toAjax(picService.updatePic(pic));
    }

    /**
     * 删除标注
     */
    @PreAuthorize("@ss.hasPermi('biaozhu:pic:remove')")
    @Log(title = "标注", businessType = BusinessType.DELETE)
    @DeleteMapping("/{pIds}")
    public AjaxResult remove(@PathVariable String[] pIds)
    {
        picInfoService.deletePicInfoByPIds(pIds);
        return toAjax(picService.deletePicByPIds(pIds));
    }

    //查找未标注的图片
    @PreAuthorize("@ss.hasPermi('biaozhu:pic:unlabeled')")
    @GetMapping("/unlabeled")
    public TableDataInfo unlabeled(Pic pic)
    {
        startPage();
        pic.setIsBiaozhu(0L);
        List<Pic> list = picService.selectPicList(pic);
        return getDataTable(list);
    }

    //查找已标注图片
    @PreAuthorize("@ss.hasPermi('biaozhu:pic:labeled')")
    @GetMapping("/labeled")
    public TableDataInfo labeled(Pic pic)
    {
        startPage();
        pic.setIsBiaozhu(1L);
        List<Pic> list = picService.selectPicList(pic);
        return getDataTable(list);
    }

    //查找丢弃图片
    @PreAuthorize("@ss.hasPermi('biaozhu:pic:discard')")
    @GetMapping("/discard")
    public TableDataInfo discard(Pic pic)
    {
        startPage();
        pic.setIsBiaozhu(2L);
        List<Pic> list = picService.selectPicList(pic);
        return getDataTable(list);
    }

}
