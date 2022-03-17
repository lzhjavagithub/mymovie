package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.system.domain.VideoType;

/**
 * 视频分类Service接口
 *
 * @author ruoyi
 * @date 2022-03-17
 */
public interface IVideoTypeService {
    /**
     * 查询视频分类
     *
     * @param id 视频分类主键
     * @return 视频分类
     */
    public VideoType selectVideoTypeById(String id);

    /**
     * 查询视频分类列表
     *
     * @param videoType 视频分类
     * @return 视频分类集合
     */
    public List<VideoType> selectVideoTypeList(VideoType videoType);

    /**
     * 新增视频分类
     *
     * @param videoType 视频分类
     * @return 结果
     */
    public int insertVideoType(VideoType videoType);

    /**
     * 修改视频分类
     *
     * @param videoType 视频分类
     * @return 结果
     */
    public int updateVideoType(VideoType videoType);

    /**
     * 批量删除视频分类
     *
     * @param ids 需要删除的视频分类主键集合
     * @return 结果
     */
    public int deleteVideoTypeByIds(String[] ids);

    /**
     * 删除视频分类信息
     *
     * @param id 视频分类主键
     * @return 结果
     */
    public int deleteVideoTypeById(String id);
}
