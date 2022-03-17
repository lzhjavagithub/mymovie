package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.VideoInfoBase;
import org.springframework.stereotype.Repository;

/**
 * 视频基础Mapper接口
 *
 * @author ruoyi
 * @date 2022-03-17
 */
@Repository
public interface VideoInfoBaseMapper {
    /**
     * 查询视频基础
     *
     * @param id 视频基础主键
     * @return 视频基础
     */
    public VideoInfoBase selectVideoInfoBaseById(String id);

    /**
     * 查询视频基础列表
     *
     * @param videoInfoBase 视频基础
     * @return 视频基础集合
     */
    public List<VideoInfoBase> selectVideoInfoBaseList(VideoInfoBase videoInfoBase);

    /**
     * 新增视频基础
     *
     * @param videoInfoBase 视频基础
     * @return 结果
     */
    public int insertVideoInfoBase(VideoInfoBase videoInfoBase);

    /**
     * 修改视频基础
     *
     * @param videoInfoBase 视频基础
     * @return 结果
     */
    public int updateVideoInfoBase(VideoInfoBase videoInfoBase);

    /**
     * 删除视频基础
     *
     * @param id 视频基础主键
     * @return 结果
     */
    public int deleteVideoInfoBaseById(String id);

    /**
     * 批量删除视频基础
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteVideoInfoBaseByIds(String[] ids);
}
