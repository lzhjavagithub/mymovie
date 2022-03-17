package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.VideoGroupBase;
import org.springframework.stereotype.Repository;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2022-03-17
 */
@Repository
public interface VideoGroupBaseMapper {
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
     * 删除【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteVideoGroupBaseById(String id);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteVideoGroupBaseByIds(String[] ids);
}
