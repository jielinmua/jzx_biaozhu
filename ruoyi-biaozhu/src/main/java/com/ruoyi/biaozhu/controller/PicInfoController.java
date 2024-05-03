package com.ruoyi.biaozhu.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.biaozhu.domain.PicInfo;
import com.ruoyi.biaozhu.service.IPicInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

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
}
