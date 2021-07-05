package com.dynamicform.springboot.seed.bz1.service.datamappers;

import com.dynamicform.springboot.seed.bz1.contract.model.DictionaryDatasInfo;
import com.dynamicform.springboot.seed.bz1.service.entity.DictionaryDatasEntity;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author xgy
 * @description
 * @date 2018/10/23
 */
@Mapper(componentModel = "spring")
public interface DictionaryDatasMapper {

    DictionaryDatasInfo entityToModel(DictionaryDatasEntity formEntity);

    DictionaryDatasEntity modelToEntity(DictionaryDatasInfo formInfo);

    List<DictionaryDatasInfo> entitiesToModels(List<DictionaryDatasEntity> formEntity);

    List<DictionaryDatasEntity> modelsToEntities(List<DictionaryDatasInfo> formInfo);
}
