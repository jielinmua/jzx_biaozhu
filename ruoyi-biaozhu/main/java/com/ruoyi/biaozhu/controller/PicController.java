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
import com.ruoyi.biaozhu.domain.Pic;
import com.ruoyi.biaozhu.service.IPicService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 标注Controller
 * 
 * @author ruoyi
 * @date 2024-03-30
 */
@RestController
@RequestMapping("/biaozhu/pic")
public class PicController extends BaseController
{
    @Autowired
    private IPicService picService;

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
//        Pic pic=picService.selectPicByPId(pId);
//        System.out.println(pic);
        return success(picService.selectPicByPId(pId));
    }

    /**
     * 新增标注
     */
    @PreAuthorize("@ss.hasPermi('biaozhu:pic:add')")
    @Log(title = "标注", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Pic pic)
    {
        //新增的pid由时间戳加随机字符串生成
        pic.setpId(String.valueOf(System.currentTimeMillis())+String.valueOf((int)((Math.random()*9+1)*100000)));
        return toAjax(picService.insertPic(pic));
    }

    /**
     * 修改标注
     */
    @PreAuthorize("@ss.hasPermi('biaozhu:pic:edit')")
    @Log(title = "标注", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Pic pic)
    {
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
        return toAjax(picService.deletePicByPIds(pIds));
    }
}
