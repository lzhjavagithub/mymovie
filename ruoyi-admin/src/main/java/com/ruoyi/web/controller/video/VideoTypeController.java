package com.ruoyi.web.controller.video;

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
import com.ruoyi.system.domain.VideoType;
import com.ruoyi.system.service.IVideoTypeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 视频分类Controller
 * @author ruoyi
 * @date 2022-03-17
 */
@RestController
@RequestMapping("/video/type")
public class VideoTypeController extends BaseController {
    @Autowired
    private IVideoTypeService videoTypeService;

    /**
     * 查询视频分类列表
     */
    @PreAuthorize("@ss.hasPermi('system:type:list')")
    @GetMapping("/list")
    public TableDataInfo list(VideoType videoType) {
        startPage();
        List<VideoType> list = videoTypeService.selectVideoTypeList(videoType);
        return getDataTable(list);
    }

    /**
     * 导出视频分类列表
     */
    @PreAuthorize("@ss.hasPermi('system:type:export')")
    @Log(title = "视频分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, VideoType videoType) {
        List<VideoType> list = videoTypeService.selectVideoTypeList(videoType);
        ExcelUtil<VideoType> util = new ExcelUtil<VideoType>(VideoType.class);
        util.exportExcel(response, list, "视频分类数据");
    }

    /**
     * 获取视频分类详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:type:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return AjaxResult.success(videoTypeService.selectVideoTypeById(id));
    }

    /**
     * 新增视频分类
     */
    @PreAuthorize("@ss.hasPermi('system:type:add')")
    @Log(title = "视频分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody VideoType videoType) {
        return toAjax(videoTypeService.insertVideoType(videoType));
    }

    /**
     * 修改视频分类
     */
    @PreAuthorize("@ss.hasPermi('system:type:edit')")
    @Log(title = "视频分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody VideoType videoType) {
        return toAjax(videoTypeService.updateVideoType(videoType));
    }

    /**
     * 删除视频分类
     */
    @PreAuthorize("@ss.hasPermi('system:type:remove')")
    @Log(title = "视频分类", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(videoTypeService.deleteVideoTypeByIds(ids));
    }
}
