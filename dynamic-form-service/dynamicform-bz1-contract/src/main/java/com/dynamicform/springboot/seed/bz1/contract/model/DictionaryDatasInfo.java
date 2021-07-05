package com.dynamicform.springboot.seed.bz1.contract.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author xgy
 * @description
 * @date 2018/10/23
 */
public class DictionaryDatasInfo {
    @Size(max = 50)
    private String id;
    @Size(max = 50)
    private String parentId;
    @NotBlank
    private String name;

    private Integer seq;

    private Boolean hasChild;

    private String property;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Boolean getHasChild() {
        return hasChild;
    }

    public void setHasChild(Boolean hasChild) {
        this.hasChild = hasChild;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}
