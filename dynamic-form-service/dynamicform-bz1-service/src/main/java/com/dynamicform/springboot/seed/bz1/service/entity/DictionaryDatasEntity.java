package com.dynamicform.springboot.seed.bz1.service.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author xgy 字典表
 * @description
 * @date 2018/10/23
 */
@Entity
@Table(name = "C_GS_DICTIONARY_DATAS", schema = "dynamic_form")
public class DictionaryDatasEntity {
    @Id
    @GenericGenerator(name = "idGenerator",strategy = "uuid")
    @GeneratedValue( generator = "idGenerator")
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    /**
     * 父id
     */
    private String parentId;

    /**
     * 名称
     */
    private String name;

    /**
     * 顺序
     */
    private Integer seq;

    /**
     * 是否有子
     */
    private Boolean hasChild;

    /**
     * 属性
     */
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
