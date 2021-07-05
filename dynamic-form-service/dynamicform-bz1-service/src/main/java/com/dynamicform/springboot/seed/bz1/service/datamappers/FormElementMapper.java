package com.dynamicform.springboot.seed.bz1.service.datamappers;

import com.dynamicform.springboot.seed.bz1.contract.model.FormElementInfo;
import com.dynamicform.springboot.seed.bz1.service.entity.FormElementEntity;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author xgy
 * @description
 * @date 2018/9/7
 */
@Mapper(componentModel = "spring")
public interface FormElementMapper {

    FormElementInfo entityToModel(FormElementEntity formEntity);

    FormElementEntity modelToEntity(FormElementInfo formInfo);

    List<FormElementInfo> entitiesToModels(List<FormElementEntity> formEntity);

    List<FormElementEntity> modelsToEntities(List<FormElementInfo> formInfo);
}
