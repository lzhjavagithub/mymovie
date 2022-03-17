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
import com.ruoyi.system.domain.VideoInfoBase;
import com.ruoyi.system.service.IVideoInfoBaseService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 视频基础Controller
 *
 * @author ruoyi
 * @date 2022-03-17
 */
@RestController
@RequestMapping("/video/info")
public class VideoInfoBaseController extends BaseController {
    @Autowired
    private IVideoInfoBaseService videoInfoBaseService;

    /**
     * 查询视频基础列表
     */
    @PreAuthorize("@ss.hasPermi('system:base:list')")
    @GetMapping("/list")
    public TableDataInfo list(VideoInfoBase videoInfoBase) {
        startPage();
        List<VideoInfoBase> list = videoInfoBaseService.selectVideoInfoBaseList(videoInfoBase);
        return getDataTable(list);
    }

    /**
     * 导出视频基础列表
     */
    @PreAuthorize("@ss.hasPermi('system:base:export')")
    @Log(title = "视频基础", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, VideoInfoBase videoInfoBase) {
        List<VideoInfoBase> list = videoInfoBaseService.selectVideoInfoBaseList(videoInfoBase);
        ExcelUtil<VideoInfoBase> util = new ExcelUtil<VideoInfoBase>(VideoInfoBase.class);
        util.exportExcel(response, list, "视频基础数据");
    }

    /**
     * 获取视频基础详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:base:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return AjaxResult.success(videoInfoBaseService.selectVideoInfoBaseById(id));
    }

    /**
     * 新增视频基础
     */
    @PreAuthorize("@ss.hasPermi('system:base:add')")
    @Log(title = "视频基础", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody VideoInfoBase videoInfoBase) {
        return toAjax(videoInfoBaseService.insertVideoInfoBase(videoInfoBase));
    }

    /**
     * 修改视频基础
     */
    @PreAuthorize("@ss.hasPermi('system:base:edit')")
    @Log(title = "视频基础", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody VideoInfoBase videoInfoBase) {
        return toAjax(videoInfoBaseService.updateVideoInfoBase(videoInfoBase));
    }

    /**
     * 删除视频基础
     */
    @PreAuthorize("@ss.hasPermi('system:base:remove')")
    @Log(title = "视频基础", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(videoInfoBaseService.deleteVideoInfoBaseByIds(ids));
    }
}
