package com.dynamicform.springboot.seed.bz1.contract.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author xgy
 * @description
 * @date 2018/9/7
 */
public class FormElementInfo {
    @Size(max = 50)
    private String id;
    private String name;
    @NotBlank
    private String type;
    @Size(max = 50)
    @NotBlank
    private String formId;
    private String required;
    private String minLen;
    private String maxLen;
    private Integer orderNum;
    private Date createTime;
    private String parentId;
    private String styleData;
    private String styleDataLabel;
    private String styleDataEditor;
    private String patternsJson;

    private String value;
    private String label;
    private String placeholder;
    private String options;
    private String disabled;
    private String readonly;
    private Integer rowspan;
    private Integer colspan;
    private String classData;
    private String classDataLabel;
    private String classDataEditor;
    private String attributes;
    private Integer editable;

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

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }

    public String getMinLen() {
        return minLen;
    }

    public void setMinLen(String minLen) {
        this.minLen = minLen;
    }

    public String getMaxLen() {
        return maxLen;
    }

    public void setMaxLen(String maxLen) {
        this.maxLen = maxLen;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getStyleData() {
        return styleData;
    }

    public void setStyleData(String styleData) {
        this.styleData = styleData;
    }

    public String getPatternsJson() {
        return patternsJson;
    }

    public void setPatternsJson(String patternsJson) {
        this.patternsJson = patternsJson;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled;
    }

    public String getReadonly() {
        return readonly;
    }

    public void setReadonly(String readonly) {
        this.readonly = readonly;
    }

    public Integer getRowspan() {
        return rowspan;
    }

    public void setRowspan(Integer rowspan) {
        this.rowspan = rowspan;
    }

    public Integer getColspan() {
        return colspan;
    }

    public void setColspan(Integer colspan) {
        this.colspan = colspan;
    }

    public String getClassData() {
        return classData;
    }

    public void setClassData(String classData) {
        this.classData = classData;
    }

    public String getClassDataLabel() {
        return classDataLabel;
    }

    public void setClassDataLabel(String classDataLabel) {
        this.classDataLabel = classDataLabel;
    }

    public String getClassDataEditor() {
        return classDataEditor;
    }

    public void setClassDataEditor(String classDataEditor) {
        this.classDataEditor = classDataEditor;
    }

    public String getStyleDataLabel() {
        return styleDataLabel;
    }

    public void setStyleDataLabel(String styleDataLabel) {
        this.styleDataLabel = styleDataLabel;
    }

    public String getStyleDataEditor() {
        return styleDataEditor;
    }

    public void setStyleDataEditor(String styleDataEditor) {
        this.styleDataEditor = styleDataEditor;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public Integer getEditable() {
        return editable;
    }

    public void setEditable(Integer editable) {
        this.editable = editable;
    }
}
