package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 视频基础对象 video_info_base
 * 
 * @author ruoyi
 * @date 2022-03-17
 */
public class VideoInfoBase extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String id;

    /** 所属视频组ID */
    @Excel(name = "所属视频组ID")
    private String videoGroupId;

    /** 视频标题 */
    @Excel(name = "视频标题")
    private String videoTitle;

    /** 视频简介 */
    @Excel(name = "视频简介")
    private String videoInfomation;

    /** 视频封面 */
    @Excel(name = "视频封面")
    private String videoBanner;

    /** 视频资源id */
    @Excel(name = "视频资源id")
    private String videoSourceId;

    /** 视频分类ID */
    @Excel(name = "视频分类ID")
    private String typeId;

    /** 状态 0：未审核 1：下架  2:审核通过 3:审核不通过 */
    @Excel(name = "状态 0：未审核 1：下架  2:审核通过 3:审核不通过")
    private Long status;

    /** 是否推荐 */
    @Excel(name = "是否推荐")
    private Long isTop;

    /** 是否热门 */
    @Excel(name = "是否热门")
    private Long isHot;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateDate;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setVideoGroupId(String videoGroupId) 
    {
        this.videoGroupId = videoGroupId;
    }

    public String getVideoGroupId() 
    {
        return videoGroupId;
    }
    public void setVideoTitle(String videoTitle) 
    {
        this.videoTitle = videoTitle;
    }

    public String getVideoTitle() 
    {
        return videoTitle;
    }
    public void setVideoInfomation(String videoInfomation) 
    {
        this.videoInfomation = videoInfomation;
    }

    public String getVideoInfomation() 
    {
        return videoInfomation;
    }
    public void setVideoBanner(String videoBanner) 
    {
        this.videoBanner = videoBanner;
    }

    public String getVideoBanner() 
    {
        return videoBanner;
    }
    public void setVideoSourceId(String videoSourceId) 
    {
        this.videoSourceId = videoSourceId;
    }

    public String getVideoSourceId() 
    {
        return videoSourceId;
    }
    public void setTypeId(String typeId) 
    {
        this.typeId = typeId;
    }

    public String getTypeId() 
    {
        return typeId;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setIsTop(Long isTop) 
    {
        this.isTop = isTop;
    }

    public Long getIsTop() 
    {
        return isTop;
    }
    public void setIsHot(Long isHot) 
    {
        this.isHot = isHot;
    }

    public Long getIsHot() 
    {
        return isHot;
    }
    public void setCreateDate(Date createDate) 
    {
        this.createDate = createDate;
    }

    public Date getCreateDate() 
    {
        return createDate;
    }
    public void setUpdateDate(Date updateDate) 
    {
        this.updateDate = updateDate;
    }

    public Date getUpdateDate() 
    {
        return updateDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("videoGroupId", getVideoGroupId())
            .append("videoTitle", getVideoTitle())
            .append("videoInfomation", getVideoInfomation())
            .append("videoBanner", getVideoBanner())
            .append("videoSourceId", getVideoSourceId())
            .append("typeId", getTypeId())
            .append("status", getStatus())
            .append("isTop", getIsTop())
            .append("isHot", getIsHot())
            .append("createDate", getCreateDate())
            .append("createBy", getCreateBy())
            .append("updateDate", getUpdateDate())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .toString();
    }
}
