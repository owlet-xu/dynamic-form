package com.dynamicform.springboot.seed.bz1.service.datamappers;

import com.dynamicform.springboot.seed.bz1.contract.model.FormDatasInfo;
import com.dynamicform.springboot.seed.bz1.service.entity.FormDatasEntity;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author xgy
 * @description
 * @date 2018/9/7
 */
@Mapper(componentModel = "spring")
public interface FormDatasMapper {

    FormDatasInfo entityToModel(FormDatasEntity formEntity);

    FormDatasEntity modelToEntity(FormDatasInfo formInfo);

    List<FormDatasInfo> entitiesToModels(List<FormDatasEntity> formEntity);

    List<FormDatasEntity> modelsToEntities(List<FormDatasInfo> formInfo);
}
