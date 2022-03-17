package com.ruoyi.system.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.VideoGroupBaseMapper;
import com.ruoyi.system.domain.VideoGroupBase;
import com.ruoyi.system.service.IVideoGroupBaseService;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-17
 */
@Service
public class VideoGroupBaseServiceImpl implements IVideoGroupBaseService {
    @Autowired
    private VideoGroupBaseMapper videoGroupBaseMapper;

    @Autowired
    private IdWorker idWorker;

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public VideoGroupBase selectVideoGroupBaseById(String id) {
        return videoGroupBaseMapper.selectVideoGroupBaseById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param videoGroupBase 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<VideoGroupBase> selectVideoGroupBaseList(VideoGroupBase videoGroupBase) {
        return videoGroupBaseMapper.selectVideoGroupBaseList(videoGroupBase);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param videoGroupBase 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertVideoGroupBase(VideoGroupBase videoGroupBase) {
        videoGroupBase.setId(idWorker.nextId() + "");
        videoGroupBase.setCreateDate(new Date());
        videoGroupBase.setUpdateDate(new Date());
        return videoGroupBaseMapper.insertVideoGroupBase(videoGroupBase);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param videoGroupBase 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateVideoGroupBase(VideoGroupBase videoGroupBase) {
        videoGroupBase.setUpdateDate(new Date());
        return videoGroupBaseMapper.updateVideoGroupBase(videoGroupBase);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteVideoGroupBaseByIds(String[] ids) {
        return videoGroupBaseMapper.deleteVideoGroupBaseByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteVideoGroupBaseById(String id) {
        return videoGroupBaseMapper.deleteVideoGroupBaseById(id);
    }
}
