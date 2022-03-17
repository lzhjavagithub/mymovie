package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 video_group_base
 * 
 * @author ruoyi
 * @date 2022-03-17
 */
public class VideoGroupBase extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 视频组标题 */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String videoGroupName;

    /** 创建日期 */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date createDate;

    /** 更新日期 */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date updateDate;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setVideoGroupName(String videoGroupName) 
    {
        this.videoGroupName = videoGroupName;
    }

    public String getVideoGroupName() 
    {
        return videoGroupName;
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
            .append("videoGroupName", getVideoGroupName())
            .append("createDate", getCreateDate())
            .append("createBy", getCreateBy())
            .append("updateDate", getUpdateDate())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .toString();
    }
}
