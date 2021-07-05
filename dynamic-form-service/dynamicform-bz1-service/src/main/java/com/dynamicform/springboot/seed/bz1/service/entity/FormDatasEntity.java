package com.dynamicform.springboot.seed.bz1.service.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @author xgy 表单填写json数据
 * @description
 * @date 2018/9/30
 */
@Entity
@Table(name = "C_GS_FORM_DATAS", schema = "dynamic_form")
public class FormDatasEntity {
    @Id
    @GenericGenerator(name = "idGenerator",strategy = "uuid")
    @GeneratedValue( generator = "idGenerator")
    @Column(name = "id", nullable = false)
    private String id;
    /**
     * 动态表单id
     */
    @Column(name = "formId", nullable = false)
    private String formId;
    /**
     * 动态表单type
     */
    @Column(name = "formType", nullable = false)
    private String formType;
    /**
     * json数据
     */
    @Lob
    @Column(columnDefinition = "TEXT")
    private String jsonDatas;
    /**
     * 添加时间
     */
    private Date addTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public String getJsonDatas() {
        return jsonDatas;
    }

    public void setJsonDatas(String jsonDatas) {
        this.jsonDatas = jsonDatas;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}
