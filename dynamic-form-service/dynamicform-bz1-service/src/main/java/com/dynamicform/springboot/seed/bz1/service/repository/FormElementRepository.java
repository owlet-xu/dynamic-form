package com.dynamicform.springboot.seed.bz1.service.repository;

import com.dynamicform.springboot.seed.bz1.service.entity.FormElementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author xgy
 * @description 表单元素repository
 * @date 2018/9/7
 */
public interface FormElementRepository extends JpaRepository<FormElementEntity, String> {
    /**
     * 根据表单id获取表单元素
     * @param formId
     * @return
     */
    List<FormElementEntity> findByFormIdOrderByOrderNumAsc(String formId);

    int deleteByIdIn(List<String> ids);
}
