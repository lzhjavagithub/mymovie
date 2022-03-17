package com.ruoyi.system.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.ruoyi.common.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.VideoTypeMapper;
import com.ruoyi.system.domain.VideoType;
import com.ruoyi.system.service.IVideoTypeService;

/**
 * 视频分类Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-17
 */
@Service
public class VideoTypeServiceImpl implements IVideoTypeService {
    @Autowired
    private VideoTypeMapper videoTypeMapper;

    @Autowired
    IdWorker idworker;

    /**
     * 查询视频分类
     *
     * @param id 视频分类主键
     * @return 视频分类
     */
    @Override
    public VideoType selectVideoTypeById(String id) {
        return videoTypeMapper.selectVideoTypeById(id);
    }

    /**
     * 查询视频分类列表
     *
     * @param videoType 视频分类
     * @return 视频分类
     */
    @Override
    public List<VideoType> selectVideoTypeList(VideoType videoType) {
        return videoTypeMapper.selectVideoTypeList(videoType);
    }

    /**
     * 新增视频分类
     *
     * @param videoType 视频分类
     * @return 结果
     */
    @Override
    public int insertVideoType(VideoType videoType) {
        videoType.setId(idworker.nextId() + "");
        videoType.setCreateDate(new Date());
        videoType.setUpdateDate(new Date());
        return videoTypeMapper.insertVideoType(videoType);
    }

    /**
     * 修改视频分类
     *
     * @param videoType 视频分类
     * @return 结果
     */
    @Override
    public int updateVideoType(VideoType videoType) {
        videoType.setUpdateDate(new Date());
        return videoTypeMapper.updateVideoType(videoType);
    }

    /**
     * 批量删除视频分类
     *
     * @param ids 需要删除的视频分类主键
     * @return 结果
     */
    @Override
    public int deleteVideoTypeByIds(String[] ids) {
        return videoTypeMapper.deleteVideoTypeByIds(ids);
    }

    /**
     * 删除视频分类信息
     *
     * @param id 视频分类主键
     * @return 结果
     */
    @Override
    public int deleteVideoTypeById(String id) {
        return videoTypeMapper.deleteVideoTypeById(id);
    }
}
