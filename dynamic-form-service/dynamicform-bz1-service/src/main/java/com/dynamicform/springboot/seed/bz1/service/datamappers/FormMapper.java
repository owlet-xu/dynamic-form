package com.dynamicform.springboot.seed.bz1.service.datamappers;

import com.dynamicform.springboot.seed.bz1.contract.model.FormInfo;
import com.dynamicform.springboot.seed.bz1.service.entity.FormEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * @author xgy
 * @description 表单Mapper
 * @date 2018/9/6
 */
@Mapper(componentModel = "spring")
public interface FormMapper {

    @Mapping(ignore = true, target = "formElementInfoList")
    FormInfo entityToModel(FormEntity formEntity);

    FormEntity modelToEntity(FormInfo formInfo);

    List<FormInfo> entitiesToModels(List<FormEntity> formEntity);

    List<FormEntity> modelsToEntities(List<FormInfo> formInfo);
}
