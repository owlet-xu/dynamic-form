package com.dynamicform.springboot.seed.bz1.contract.service;


import com.dynamicform.springboot.seed.bz1.contract.model.FormDatasInfo;
import com.dynamicform.springboot.seed.bz1.contract.model.FormInfo;
import com.dynamicform.springboot.seed.bz1.contract.model.ResponseInfo;

import java.util.List;

/**
 * @author xgy
 * @description
 * @date 2018/9/6
 */
public interface FormService {
    List<FormInfo> findAll();

    List<FormInfo> findByGroup(String group);

    List<FormInfo> findFormByType(String type);

    List<FormInfo> findFormByTypes(String[] types);

    List<FormInfo> findForbiddenFormByTypes(String[] types);

    List<FormInfo> findAllFormByType(String type);

    ResponseInfo saveForm(FormInfo form);

    ResponseInfo updateForm(FormInfo form);

    ResponseInfo saveFormDatas(FormDatasInfo formDatasInfo);

    ResponseInfo getFormDatas(String id);

    ResponseInfo getDictionaryDatasByParentId(String parentId);

    ResponseInfo getDictionaryDatas(String name);

    ResponseInfo getDictionaryById(String id);
}
