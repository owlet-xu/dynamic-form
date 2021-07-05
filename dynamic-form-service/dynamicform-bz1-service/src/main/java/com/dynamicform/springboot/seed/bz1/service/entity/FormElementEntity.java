package com.dynamicform.springboot.seed.bz1.service.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @author xgy
 * @description 表单元素
 * @date 2018/9/7
 */
@Entity
@Table(name = "C_GS_FORM_ELEMENT", schema = "dynamic_form")
public class FormElementEntity {

    @Id
    @GenericGenerator(name = "idGenerator",strategy = "uuid")
    @GeneratedValue( generator = "idGenerator")
    @Column(name = "ID", nullable = false, length = 36)
    private String id;
    /**
     * 元素唯一标识（有意义）
     */
    @Column(name = "NAME")
    private String name;
    /**
     * 元素类型（input，select等）
     */
    @Column(name = "TYPE", nullable = false)
    private String type;
    /**
     * 所属表单id
     */
    @Column(name = "FORM_ID", nullable = false)
    private String formId;
    /**
     * 是否必填
     */
    @Column(name = "REQUIRED")
    private String required;
    /**
     * 最小长度
     */
    @Column(name = "MIN_LEN")
    private String minLen;
    /**
     * 最大长度
     */
    @Column(name = "MAX_LEN")
    private String maxLen;
    /**
     * 排序字段
     */
    @Column(name = "ORDER_NUM")
    private Integer orderNum;
    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;
    /**
     * 父级id-目前未用到
     */
    @Column(name = "PARENT_ID")
    private String parentId;
    /**
     * 样式数据
     */
    @Column(name = "STYLE_DATA")
    private String styleData;
    /**
     * label的样式数据
     */
    @Column(name = "STYLE_DATA_LABEL")
    private String styleDataLabel;
    /**
     * 编辑框的样式数据
     */
    @Column(name = "STYLE_DATA_EDITOR")
    private String styleDataEditor;
    /**
     * 正则表达式
     */
    @Column(name = "PATTERNS_JSON")
    private String patternsJson;
    /**
     * 默认值
     */
    @Column(name = "VALUE")
    private String value;
    /**
     * 标签，标题
     */
    @Column(name = "LABEL")
    private String label;
    /**
     * 提示
     */
    @Column(name = "PLACEHOLDER")
    private String placeholder;
    /**
     * select，radio等的选项数据
     */
    @Column(name = "OPTIONS")
    private String options;
    /**
     * 是否禁用
     */
    @Column(name = "DISABLED")
    private String disabled;
    /**
     * 是否只读
     */
    @Column(name = "READONLY")
    private String readonly;
    /**
     * 横跨行-暂时未用
     */
    @Column(name = "ROWSPAN")
    private Integer rowspan;
    /**
     * 横跨列-暂时未用
     */
    @Column(name = "COLSPAN")
    private Integer colspan;
    /**
     * 样式名
     */
    @Column(name = "CLASS_DATA")
    private String classData;
    /**
     * label样式名
     */
    @Column(name = "CLASS_DATA_LABEL")
    private String classDataLabel;
    /**
     * 编辑框样式名
     */
    @Column(name = "CLASS_DATA_EDITOR")
    private String classDataEditor;
    /**
     * 自定义属性
     */
    @Column(name = "ATTRIBUTES")
    private String attributes;
    /**
     * 是否可在表单设计器中编辑
     */
    @Column(name = "EDITABLE")
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

    public Date getCreateTime() {
        return createTime;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
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
