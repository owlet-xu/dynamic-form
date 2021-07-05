package com.dynamicform.springboot.seed.bz1.service.repository;

import com.dynamicform.springboot.seed.bz1.service.entity.DictionaryDatasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author xgy
 * @description
 * @date 2018/10/23
 */
public interface DictionaryDatasRepository extends JpaRepository<DictionaryDatasEntity, String> {

    List<DictionaryDatasEntity> findByParentIdOrderBySeq(String parentId);

    List<DictionaryDatasEntity> findByNameLikeAndHasChildAndParentId(String name, Boolean hasChild, String parentId);
}
