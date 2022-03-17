package com.ruoyi.system.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.VideoInfoBaseMapper;
import com.ruoyi.system.domain.VideoInfoBase;
import com.ruoyi.system.service.IVideoInfoBaseService;

/**
 * 视频基础Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-17
 */
@Service
public class VideoInfoBaseServiceImpl implements IVideoInfoBaseService {
    @Autowired
    private VideoInfoBaseMapper videoInfoBaseMapper;

    @Autowired
    private IdWorker idWorker;

    /**
     * 查询视频基础
     *
     * @param id 视频基础主键
     * @return 视频基础
     */
    @Override
    public VideoInfoBase selectVideoInfoBaseById(String id) {
        return videoInfoBaseMapper.selectVideoInfoBaseById(id);
    }

    /**
     * 查询视频基础列表
     *
     * @param videoInfoBase 视频基础
     * @return 视频基础
     */
    @Override
    public List<VideoInfoBase> selectVideoInfoBaseList(VideoInfoBase videoInfoBase) {
        return videoInfoBaseMapper.selectVideoInfoBaseList(videoInfoBase);
    }

    /**
     * 新增视频基础
     *
     * @param videoInfoBase 视频基础
     * @return 结果
     */
    @Override
    public int insertVideoInfoBase(VideoInfoBase videoInfoBase) {
        videoInfoBase.setId(idWorker.nextId() + "");
        videoInfoBase.setCreateDate(new Date());
        videoInfoBase.setUpdateDate(new Date());
        return videoInfoBaseMapper.insertVideoInfoBase(videoInfoBase);
    }

    /**
     * 修改视频基础
     *
     * @param videoInfoBase 视频基础
     * @return 结果
     */
    @Override
    public int updateVideoInfoBase(VideoInfoBase videoInfoBase) {
        videoInfoBase.setUpdateDate(new Date());
        return videoInfoBaseMapper.updateVideoInfoBase(videoInfoBase);
    }

    /**
     * 批量删除视频基础
     *
     * @param ids 需要删除的视频基础主键
     * @return 结果
     */
    @Override
    public int deleteVideoInfoBaseByIds(String[] ids) {
        return videoInfoBaseMapper.deleteVideoInfoBaseByIds(ids);
    }

    /**
     * 删除视频基础信息
     *
     * @param id 视频基础主键
     * @return 结果
     */
    @Override
    public int deleteVideoInfoBaseById(String id) {
        return videoInfoBaseMapper.deleteVideoInfoBaseById(id);
    }
}
