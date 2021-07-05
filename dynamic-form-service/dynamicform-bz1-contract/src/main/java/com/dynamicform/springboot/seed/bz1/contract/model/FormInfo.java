package com.dynamicform.springboot.seed.bz1.contract.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * @author xgy
 * @description
 * @date 2018/9/6
 */
public class FormInfo {
    @Size(max = 50)
    private String id;
    private String name;
    @NotBlank
    private String type;
    private String remark;
    private String createPerson;
    private Date createTime;
    private String updatePerson;
    private Date updateTime;
    private List<FormElementInfo> formElementInfoList;
    private Boolean isValid;
    private String layoutType;
    private String attributes;
    private String groupData;
    private String styleData;
    private String classData;

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

    public List<FormElementInfo> getFormElementInfoList() {
        return formElementInfoList;
    }

    public void setFormElementInfoList(List<FormElementInfo> formElementInfoList) {
        this.formElementInfoList = formElementInfoList;
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
}
