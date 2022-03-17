package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.VideoType;
import org.springframework.stereotype.Repository;

/**
 * 视频分类Mapper接口
 * 
 * @author ruoyi
 * @date 2022-03-17
 */
@Repository
public interface VideoTypeMapper 
{
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
     * 删除视频分类
     * 
     * @param id 视频分类主键
     * @return 结果
     */
    public int deleteVideoTypeById(String id);

    /**
     * 批量删除视频分类
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteVideoTypeByIds(String[] ids);
}
