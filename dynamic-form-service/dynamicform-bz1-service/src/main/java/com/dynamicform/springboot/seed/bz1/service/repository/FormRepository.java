package com.dynamicform.springboot.seed.bz1.service.repository;

import com.dynamicform.springboot.seed.bz1.service.entity.FormEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author xgy
 * @description 表单repository
 * @date 2018/9/6
 */
public interface FormRepository extends JpaRepository<FormEntity, String> {

    /**
     * 根据表单类型type和有效无效isValid查询
     * @param type
     * @return
     */
    List<FormEntity> findByTypeAndIsValid(String type, Boolean isValid);

    /**
     * 根据表单类型type和有效无效isValid查询
     * @param types
     * @return
     */
    List<FormEntity> findByTypeInAndIsValid(String[] types, Boolean isValid);

    /**
     * 根据type查询
     * @param type
     * @return
     */
    List<FormEntity> findByType(String type);

    /**
     * 根据group查询
     * @param groupData
     * @return
     */
    List<FormEntity> findByGroupDataOrderByIsValidDescUpdateTimeDesc(String groupData);
}
