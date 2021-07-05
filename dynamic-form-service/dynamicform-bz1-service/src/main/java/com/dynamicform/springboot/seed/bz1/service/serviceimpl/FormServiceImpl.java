package com.dynamicform.springboot.seed.bz1.service.serviceimpl;

import com.dynamicform.springboot.seed.bz1.contract.model.*;
import com.dynamicform.springboot.seed.bz1.contract.service.FormService;
import com.dynamicform.springboot.seed.bz1.service.datamappers.DictionaryDatasMapper;
import com.dynamicform.springboot.seed.bz1.service.datamappers.FormDatasMapper;
import com.dynamicform.springboot.seed.bz1.service.datamappers.FormElementMapper;
import com.dynamicform.springboot.seed.bz1.service.datamappers.FormMapper;
import com.dynamicform.springboot.seed.bz1.service.entity.DictionaryDatasEntity;
import com.dynamicform.springboot.seed.bz1.service.entity.FormDatasEntity;
import com.dynamicform.springboot.seed.bz1.service.entity.FormElementEntity;
import com.dynamicform.springboot.seed.bz1.service.entity.FormEntity;
import com.dynamicform.springboot.seed.bz1.service.repository.DictionaryDatasRepository;
import com.dynamicform.springboot.seed.bz1.service.repository.FormDatasRepository;
import com.dynamicform.springboot.seed.bz1.service.repository.FormElementRepository;
import com.dynamicform.springboot.seed.bz1.service.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author xgy
 * @description
 * @date 2018/9/6
 */
@Service
public class FormServiceImpl implements FormService {

    @Autowired
    FormRepository formRepository;

    @Autowired
    FormElementRepository formElementRepository;

    @Autowired
    FormDatasRepository formDatasRepository;

    @Autowired
    DictionaryDatasRepository dictionaryDatasRepository;

    @Autowired
    FormMapper formMapper;

    @Autowired
    FormElementMapper formElementMapper;

    @Autowired
    FormDatasMapper formDatasMapper;

    @Autowired
    DictionaryDatasMapper dictionaryDatasMapper;

    @Override
    public List<FormInfo> findAll() {
        final List<FormEntity> resultList = new ArrayList<>();
        Sort.Order order1 = new Sort.Order(Sort.Direction.DESC, "isValid");
        Sort.Order order2 = new Sort.Order(Sort.Direction.DESC, "updateTime");
        final Iterable<FormEntity> all = this.formRepository.findAll(Sort.by(order1, order2));
        all.forEach(resultList::add);
        return this.formMapper.entitiesToModels(resultList);
    }

    @Override
    public List<FormInfo> findByGroup(String group) {

        List<FormEntity> formEntities = this.formRepository.findByGroupDataOrderByIsValidDescUpdateTimeDesc(group);
        // 添加元素信息
        return formEntitis2FormInfos(formEntities);
    }

    @Override
    public List<FormInfo> findFormByType(String type) {
        // 循环表单
        List<FormEntity> list = this.formRepository.findByTypeAndIsValid(type, true);
        return formEntitis2FormInfos(list);
    }

    @Override
    public List<FormInfo> findFormByTypes(String[] types) {
        // 循环表单
        List<FormEntity> listSort = new ArrayList<>();
        List<FormEntity> list = this.formRepository.findByTypeInAndIsValid(types, true);
        // 按照types数组排序
        for (String type : types) {
            List<FormEntity> listTemp = list.stream().filter(item -> item.getType().equals(type)).collect(Collectors.toList());
            listSort.addAll(listTemp);
        }
        return formEntitis2FormInfos(listSort);
    }

    @Override
    public List<FormInfo> findForbiddenFormByTypes(String[] types) {
        // 循环表单
        List<FormEntity> listSort = new ArrayList<>();
        List<FormEntity> list = this.formRepository.findByTypeInAndIsValid(types, true);
        // 按照types数组排序
        for (String type : types) {
            List<FormEntity> listTemp = list.stream().filter(item -> item.getType().equals(type)).collect(Collectors.toList());
            listSort.addAll(listTemp);
        }
        return forbiddenFormEntitis2FormInfos(listSort);
    }

    @Override
    public List<FormInfo> findAllFormByType(String type) {
        // 循环表单
        List<FormEntity> list = this.formRepository.findByType(type);
        return formEntitis2FormInfos(list);
    }

    /**
     * FormEntitis转FormInfos，携带子表信息
     *
     * @param list
     * @return
     */
    public List<FormInfo> formEntitis2FormInfos(List<FormEntity> list) {
        List<FormInfo> formsInfo = new ArrayList<>();
        list.forEach(form -> {
            FormInfo formInfo = this.formMapper.entityToModel(form);
            List<FormElementInfo> elementsInfo = null;
            // 查询子表信息
            List<FormElementEntity> elements = this.formElementRepository.findByFormIdOrderByOrderNumAsc(form.getId());
            elementsInfo = this.formElementMapper.entitiesToModels(elements);
            formInfo.setFormElementInfoList(elementsInfo);
            formsInfo.add(formInfo);
        });
        return formsInfo;
    }

    /**
     * FormEntitis转FormInfos，携带子表信息
     *
     * @param list
     * @return
     */
    public List<FormInfo> forbiddenFormEntitis2FormInfos(List<FormEntity> list) {
        List<FormInfo> formsInfo = new ArrayList<>();
        list.forEach(form -> {
            FormInfo formInfo = this.formMapper.entityToModel(form);
            List<FormElementInfo> elementsInfo = null;
            // 查询子表信息
            List<FormElementEntity> elements = this.formElementRepository.findByFormIdOrderByOrderNumAsc(form.getId());
            // 处警警情进行地方动态表单是禁用的专用接口
            elements.forEach( element ->{
                element.setDisabled("true");
            });
            elementsInfo = this.formElementMapper.entitiesToModels(elements);
            formInfo.setFormElementInfoList(elementsInfo);
            formsInfo.add(formInfo);
        });
        return formsInfo;
    }

    /**
     * 保存表单
     *
     * @param form
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseInfo saveForm(FormInfo form) {
        ResponseInfo res = new ResponseInfo();
        if (formTypeIsExited(form)) {
            res.setSuccess(false);
            res.setMsg("type is exited");
            return res;
        }
        return saveFormInfo(form, res);
    }

    /**
     * form是否已存在数据库
     *
     * @param form
     * @return
     */
    private boolean formTypeIsExited(FormInfo form) {
        boolean isExit = false;
        if (StringUtils.isEmpty(form.getId())) {
            List<FormEntity> forms = this.formRepository.findByType(form.getType());
            if (!CollectionUtils.isEmpty(forms)) {
                isExit = true;
            }
        }
        return isExit;
    }

    /**
     * 保存表单-抽取方法
     *
     * @param form
     * @param res
     * @return
     */
    private ResponseInfo saveFormInfo(FormInfo form, ResponseInfo res) {
        Date now = new Date();
        // 保存主表
        form.setCreateTime(now);
        FormEntity formEntity = this.formMapper.modelToEntity(form);
        if (StringUtils.isEmpty(formEntity.getId())) {
            formEntity.setId(UUID.randomUUID().toString()); // 插入
        }
        this.formRepository.saveAndFlush(formEntity);
        // 保存子表
        List<FormElementEntity> formElementEntities = this.formElementMapper.modelsToEntities(form.getFormElementInfoList());
        if (CollectionUtils.isEmpty(formElementEntities)) {
            res.setSuccess(false);
            res.setMsg("formElement not found");
            return res;
        }
        formElementEntities.forEach(attr -> {
            attr.setFormId(formEntity.getId());
            attr.setCreateTime(now);
            attr.setEditable(1);
            formElementRepository.saveAndFlush(attr);
        });
        res.setSuccess(true);
        return res;
    }

    /**
     * 更新表单
     *
     * @param form
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseInfo updateForm(FormInfo form) {
        if (null != form) {
            List<FormElementEntity> elements = this.formElementRepository.findByFormIdOrderByOrderNumAsc(form.getId());
            this.formElementRepository.deleteAll(elements);
        }
        return this.saveForm(form);
    }

    @Override
    public ResponseInfo saveFormDatas(FormDatasInfo formDatasInfo) {
        ResponseInfo res = new ResponseInfo();
        formDatasInfo.setAddTime(new Date());
        FormDatasEntity data = this.formDatasMapper.modelToEntity(formDatasInfo);
        this.formDatasRepository.save(data);
        res.setSuccess(true);
        return res;
    }

    @Override
    public ResponseInfo getFormDatas(String id) {
        ResponseInfo res = new ResponseInfo();
        FormDatasEntity entity = this.formDatasRepository.findById(id).orElse(null);
        if (null == entity) {
            res.setSuccess(false);
            res.setMsg("not found");
            return res;
        }
        FormDatasInfo info = this.formDatasMapper.entityToModel(entity);
        res.setSuccess(true);
        res.setData(info);
        return res;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseInfo getDictionaryDatasByParentId(String parentId) {
        ResponseInfo res = new ResponseInfo();
        List<DictionaryDatasEntity> childs = this.dictionaryDatasRepository.findByParentIdOrderBySeq(parentId);
        List<DictionaryDatasInfo> childInfo = this.dictionaryDatasMapper.entitiesToModels(childs);
        res.setSuccess(true);
        res.setData(childInfo);
        return res;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseInfo getDictionaryDatas(String name) {
        if (name.equals("all")) {
            name = "";
        }
        ResponseInfo res = new ResponseInfo();
        List<DictionaryDatasEntity> list = this.dictionaryDatasRepository.findByNameLikeAndHasChildAndParentId("%" + name + "%", true, null);
        List<DictionaryDatasInfo> listInfo = this.dictionaryDatasMapper.entitiesToModels(list);
        res.setSuccess(true);
        res.setData(listInfo);
        return res;
    }

    @Override
    public ResponseInfo getDictionaryById(String id) {
        ResponseInfo res = new ResponseInfo();
        DictionaryDatasEntity entity = this.dictionaryDatasRepository.findById(id).orElse(null);
        DictionaryDatasInfo info = this.dictionaryDatasMapper.entityToModel(entity);
        res.setSuccess(true);
        res.setData(info);
        return res;
    }
}
