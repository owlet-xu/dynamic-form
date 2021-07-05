package com.dynamicform.springboot.seed.bz1.contract.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author xgy
 * @description
 * @date 2018/9/30
 */
public class FormDatasInfo {
    @Size(max = 50)
    private String id;
    @NotBlank
    private String formId;
    @NotBlank
    private String formType;
    @NotBlank
    private String jsonDatas;
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
