package com.ruoyi.biaozhu.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.biaozhu.utils.FileUploadUtils;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.biaozhu.domain.PicInfo;
import com.ruoyi.biaozhu.service.IPicInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 数据图表Controller
 * 
 * @author ruoyi
 * @date 2024-05-03
 */
@RestController
@RequestMapping("/info/biao")
public class PicInfoController extends BaseController
{
    @Autowired
    private IPicInfoService picInfoService;

    @Autowired
    private FileUploadUtils fileUploadUtils;

    /**
     * 查询数据图表列表
     */
    @PreAuthorize("@ss.hasPermi('info:biao:list')")
    @GetMapping("/list")
    public TableDataInfo list(PicInfo picInfo)
    {
        startPage();
        List<PicInfo> list = picInfoService.selectPicInfoList(picInfo);
        return getDataTable(list);
    }

    /**
     * 查询患者列表
     */
    @PreAuthorize("@ss.hasPermi('info:biao:list')")
    @GetMapping("/getPatientList")
    public TableDataInfo getPatientList(PicInfo picInfo)
    {
        startPage();
        List<PicInfo> list = picInfoService.selectPicInfoListByPatient(picInfo);
        return getDataTable(list);
    }

    /**
     * 导出数据图表列表
     */
    @PreAuthorize("@ss.hasPermi('info:biao:export')")
    @Log(title = "数据图表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PicInfo picInfo)
    {
        List<PicInfo> list = picInfoService.selectPicInfoList(picInfo);
        ExcelUtil<PicInfo> util = new ExcelUtil<PicInfo>(PicInfo.class);
        util.exportExcel(response, list, "数据图表数据");
    }

    /**
     * 获取数据图表详细信息
     */
    @PreAuthorize("@ss.hasPermi('info:biao:query')")
    @GetMapping(value = "/{pId}")
    public AjaxResult getInfo(@PathVariable("pId") String pId)
    {
        return success(picInfoService.selectPicInfoByPId(pId));
    }

    /**
     * 新增数据图表
     */
    @PreAuthorize("@ss.hasPermi('info:biao:add')")
    @Log(title = "数据图表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PicInfo picInfo)
    {
        return toAjax(picInfoService.insertPicInfo(picInfo));
    }

    /**
     * 修改数据图表
     */
    @PreAuthorize("@ss.hasPermi('info:biao:edit')")
    @Log(title = "数据图表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PicInfo picInfo)
    {
        return toAjax(picInfoService.updatePicInfo(picInfo));
    }

    /**
     * 删除数据图表
     */
    @PreAuthorize("@ss.hasPermi('info:biao:remove')")
    @Log(title = "数据图表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{pIds}")
    public AjaxResult remove(@PathVariable String[] pIds)
    {
        return toAjax(picInfoService.deletePicInfoByPIds(pIds));
    }


    @PostMapping("/fileUpload")
    public AjaxResult uploadFile(MultipartFile file) throws Exception
    {
        try
        {
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath();
            // 上传并返回新文件名称
            String fileName = fileUploadUtils.uploadImgUrl(file);
            AjaxResult ajax = AjaxResult.success();
            ajax.put("url", fileName);
            ajax.put("fileName", fileName);
            ajax.put("newFileName", FileUtils.getName(fileName));
            ajax.put("originalFilename", file.getOriginalFilename());
            return ajax;
        }
        catch (Exception e)
        {
            return AjaxResult.error(e.getMessage());
        }
    }


    /**
     * 通用上传请求（多个）
     */
    @PostMapping("/fileUploads")
    public AjaxResult uploadFiles(@RequestParam(value = "files",required = false) List<MultipartFile> files) throws Exception
    {
        try
        {
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath();
            List<String> urls = new ArrayList<String>();
            List<String> fileNames = new ArrayList<String>();
            List<String> newFileNames = new ArrayList<String>();
            List<String> originalFilenames = new ArrayList<String>();
            for (MultipartFile file : files)
            {
                // 上传并返回新文件名称
                String fileName = fileUploadUtils.uploadImgUrl(file);
                urls.add(fileName);
                fileNames.add(fileName);
                newFileNames.add(FileUtils.getName(fileName));
                originalFilenames.add(file.getOriginalFilename());
            }
            AjaxResult ajax = AjaxResult.success();
            ajax.put("urls", StringUtils.join(urls, ","));
            ajax.put("fileNames", StringUtils.join(fileNames, ","));
            ajax.put("newFileNames", StringUtils.join(newFileNames, ","));
            ajax.put("originalFilenames", StringUtils.join(originalFilenames, ","));
            return ajax;
        }
        catch (Exception e)
        {
            return AjaxResult.error(e.getMessage());
        }
    }

}
