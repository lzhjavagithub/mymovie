package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.system.domain.VideoGroupBase;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2022-03-17
 */
public interface IVideoGroupBaseService {
    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public VideoGroupBase selectVideoGroupBaseById(String id);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param videoGroupBase 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<VideoGroupBase> selectVideoGroupBaseList(VideoGroupBase videoGroupBase);

    /**
     * 新增【请填写功能名称】
     *
     * @param videoGroupBase 【请填写功能名称】
     * @return 结果
     */
    public int insertVideoGroupBase(VideoGroupBase videoGroupBase);

    /**
     * 修改【请填写功能名称】
     *
     * @param videoGroupBase 【请填写功能名称】
     * @return 结果
     */
    public int updateVideoGroupBase(VideoGroupBase videoGroupBase);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteVideoGroupBaseByIds(String[] ids);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteVideoGroupBaseById(String id);
}
