package com.dynamicform.springboot.seed.bz1.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author xgy
 * @description 动态表单
 * @date 2018/9/6
 */
@Entity
@Table(name= "C_GS_FORM", schema = "dynamic_form")
public class FormEntity {
    @Id
    @Column(name = "ID", nullable = false, length = 36)
    private String id;
    /**
     * 表单名
     */
    @Column(name = "NAME", nullable = false)
    private String name;
    /**
     * 表单唯一标识（有意义）
     */
    @Column(name = "TYPE", nullable = false)
    private String type;
    /**
     * 表单备注
     */
    @Column(name = "REMARK")
    private String remark;
    /**
     * 创建人
     */
    @Column(name = "CREATE_PERSON")
    private String createPerson;
    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;
    /**
     * 更新人
     */
    @Column(name = "UPDATE_PERSON")
    private String updatePerson;
    /**
     * 更新时间
     */
    @Column(name = "UPDATE_TIME")
    private Date updateTime;
    /**
     * 表单整体样式
     */
    @Column(name = "STYLE_DATA", length = 1000)
    private String styleData;
    /**
     * 表单整体样式名
     */
    @Column(name = "CLASS_DATA", length = 500)
    private String classData;
    /**
     * 表单是否有效
     */
    @Column(name = "IS_VALID")
    private Boolean isValid;
    /**
     * 布局方式-暂时未用
     */
    @Column(name = "LAYOUT_TYPE")
    private String layoutType;
    /**
     * 自定义属性-暂时未用
     */
    @Column(name = "ATTRIBUTES", length = 500)
    private String attributes;
    /**
     * 表单分组字段
     */
    @Column(name = "GROUP_DATA")
    private String groupData;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(String updatePerson) {
        this.updatePerson = updatePerson;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getStyleData() {
        return styleData;
    }

    public void setStyleData(String styleData) {
        this.styleData = styleData;
    }

    public String getClassData() {
        return classData;
    }

    public void setClassData(String classData) {
        this.classData = classData;
    }

    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }

    public String getLayoutType() {
        return layoutType;
    }

    public void setLayoutType(String layoutType) {
        this.layoutType = layoutType;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public String getGroupData() {
        return groupData;
    }

    public void setGroupData(String groupData) {
        this.groupData = groupData;
    }
}
