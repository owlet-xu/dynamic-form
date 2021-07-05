package com.dynamicform.com.springboot.seed.bz1.controller;
import com.dynamicform.springboot.seed.bz1.contract.model.DictionaryDatasInfo;
import com.dynamicform.springboot.seed.bz1.contract.model.FormDatasInfo;
import com.dynamicform.springboot.seed.bz1.contract.model.FormInfo;
import com.dynamicform.springboot.seed.bz1.contract.model.ResponseInfo;
import com.dynamicform.springboot.seed.bz1.contract.service.FormService;
import com.dynamicform.springboot.seed.common.qiqi.HttpError;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xgy
 * @description
 * @date 2018/9/6
 */
@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
@Api(value = "/api/v1", tags = { "动态表单Api"})
public class FormController {
    @Autowired
    FormService formService;


    @ApiOperation(value = "获取动态表单（不包含元素信息）", notes = "获取所有表单，包括有效和无效,不包含元素信息")
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功", response = FormInfo.class),
            @ApiResponse(code = 400, message = "参数非法", response = HttpError.class),
            @ApiResponse(code = 500, message = "服务器异常", response = HttpError.class)
    })
    @RequestMapping(value = "/forms", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findAll() {
        return new ResponseEntity<>(this.formService.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "根据group获取动态表单（含元素信息）", notes = "获取分组所有表单，包括有效和无效")
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功", response = FormInfo.class),
            @ApiResponse(code = 400, message = "参数非法", response = HttpError.class),
            @ApiResponse(code = 500, message = "服务器异常", response = HttpError.class)
    })
    @RequestMapping(value = "/{group}/forms", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findByGroup(@PathVariable String group) {
        return new ResponseEntity<>(this.formService.findByGroup(group), HttpStatus.OK);
    }


    @ApiOperation(value = "获取动态表单（不包括无效）", notes = "根据type获取表单，无效的表单获取不到")
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功", response = FormInfo.class),
            @ApiResponse(code = 400, message = "参数非法", response = HttpError.class),
            @ApiResponse(code = 500, message = "服务器异常", response = HttpError.class)
    })
    @RequestMapping(value = "/forms/{type}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findFormByType(@PathVariable String type) {
        return new ResponseEntity<>(this.formService.findFormByType(type), HttpStatus.OK);
    }

    @ApiOperation(value = "获取动态表单（不包括无效）", notes = "根据type获取表单(逗号分隔多个type)，无效的表单获取不到")
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功", response = FormInfo.class),
            @ApiResponse(code = 400, message = "参数非法", response = HttpError.class),
            @ApiResponse(code = 500, message = "服务器异常", response = HttpError.class)
    })
    @RequestMapping(value = "/forms/{types}/types", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findFormByTypes(@PathVariable String types) {
        String [] typess = types.split(",");
        return new ResponseEntity<>(this.formService.findFormByTypes(typess), HttpStatus.OK);
    }

    @ApiOperation(value = "获取动态表单（处警动态表单禁用效果）", notes = "根据type获取表单(逗号分隔多个type)，无效的表单获取不到")
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功", response = FormInfo.class),
            @ApiResponse(code = 400, message = "参数非法", response = HttpError.class),
            @ApiResponse(code = 500, message = "服务器异常", response = HttpError.class)
    })
    @RequestMapping(value = "/forbiddenForms/{types}/types", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findForbiddenFormByTypes(@PathVariable String types) {
        String [] typess = types.split(",");
        return new ResponseEntity<>(this.formService.findForbiddenFormByTypes(typess), HttpStatus.OK);
    }

    @ApiOperation(value = "获取动态表单（包括无效）", notes = "根据type获取表单，无效有效的表单都能获取")
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功", response = FormInfo.class),
            @ApiResponse(code = 400, message = "参数非法", response = HttpError.class),
            @ApiResponse(code = 500, message = "服务器异常", response = HttpError.class)
    })
    @RequestMapping(value = "/forms/all/{type}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findAllFormByType(@PathVariable String type) {
        return new ResponseEntity<>(this.formService.findAllFormByType(type), HttpStatus.OK);
    }

    @ApiOperation(value = "添加表单", notes = "添加表单")
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功", response = ResponseInfo.class),
            @ApiResponse(code = 400, message = "参数非法", response = HttpError.class),
            @ApiResponse(code = 500, message = "服务器异常", response = HttpError.class)
    })
    @RequestMapping(value = "/addform", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addform(@RequestBody FormInfo form) {
        return new ResponseEntity<>(this.formService.saveForm(form), HttpStatus.OK);
    }

    @ApiOperation(value = "更新表单", notes = "更新表单")
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功", response = ResponseInfo.class),
            @ApiResponse(code = 400, message = "参数非法", response = HttpError.class),
            @ApiResponse(code = 500, message = "服务器异常", response = HttpError.class)
    })
    @RequestMapping(value = "/updateform", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateform(@RequestBody FormInfo form) {

        return new ResponseEntity<>(this.formService.updateForm(form), HttpStatus.OK);
    }

    @ApiOperation(value = "表单数据保存", notes = "表单数据保存")
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功", response = ResponseInfo.class),
            @ApiResponse(code = 400, message = "参数非法", response = HttpError.class),
            @ApiResponse(code = 500, message = "服务器异常", response = HttpError.class)
    })
    @RequestMapping(value = "/saveFormData", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveFormData(@RequestBody FormDatasInfo formData) {

        return new ResponseEntity<>(this.formService.saveFormDatas(formData), HttpStatus.OK);
    }

    @ApiOperation(value = "获取动态表单填写数据", notes = "根据id获取动态表单填写数据")
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功", response = ResponseInfo.class),
            @ApiResponse(code = 400, message = "参数非法", response = HttpError.class),
            @ApiResponse(code = 500, message = "服务器异常", response = HttpError.class)
    })
    @RequestMapping(value = "/formData/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getFormData(@PathVariable String id) {
        return new ResponseEntity<>(this.formService.getFormDatas(id), HttpStatus.OK);
    }


    @ApiOperation(value = "字符串数组接口示例", notes = "字符串数组接口示例")
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功", response = ResponseEntity.class),
            @ApiResponse(code = 400, message = "参数非法", response = HttpError.class),
            @ApiResponse(code = 500, message = "服务器异常", response = HttpError.class)
    })
    @RequestMapping(value = "/getOptions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getOptions() {
        List<String> list = new ArrayList<>();
        list.add("James");
        list.add("Paul");
        list.add("William");
        list.add("GuoyuanXu");
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @ApiOperation(value = "json数组示例", notes = "json数组示例")
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功", response = ResponseEntity.class),
            @ApiResponse(code = 400, message = "参数非法", response = HttpError.class),
            @ApiResponse(code = 500, message = "服务器异常", response = HttpError.class)
    })
    @RequestMapping(value = "/getOptionsSelect", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getOptionsSelect() {
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        String key = "text";
        String value = "value";
        map.put(key, "北京");
        map.put(value, "0");
        list.add(map);
        map = new HashMap<>();
        map.put(key, "上海");
        map.put(value, "1");
        list.add(map);
        map = new HashMap<>();
        map.put(key, "合肥");
        map.put(value, "2");
        list.add(map);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @ApiOperation(value = "获取字典", notes = "根据父id获取字典")
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功", response = ResponseEntity.class),
            @ApiResponse(code = 400, message = "参数非法", response = HttpError.class),
            @ApiResponse(code = 500, message = "服务器异常", response = HttpError.class)
    })
    @RequestMapping(value = "/getDictionaryDatasByParentId/{parentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getDictionaryDatasByParentId(@PathVariable String parentId) {
        return new ResponseEntity<>(this.formService.getDictionaryDatasByParentId(parentId), HttpStatus.OK);
    }


    @ApiOperation(value = "获取字典", notes = "根据name获取字典")
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功", response = ResponseEntity.class),
            @ApiResponse(code = 400, message = "参数非法", response = HttpError.class),
            @ApiResponse(code = 500, message = "服务器异常", response = HttpError.class)
    })
    @RequestMapping(value = "/getDictionaryDatas/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getDictionaryDatas(@PathVariable String name) {
        return new ResponseEntity<>(this.formService.getDictionaryDatas(name), HttpStatus.OK);
    }

    @ApiOperation(value = "获取字典", notes = "根据id获取字典")
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功", response = ResponseEntity.class),
            @ApiResponse(code = 400, message = "参数非法", response = HttpError.class),
            @ApiResponse(code = 500, message = "服务器异常", response = HttpError.class)
    })
    @RequestMapping(value = "/getDictionaryDatasById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getDictionaryById(@PathVariable String id) {
        return new ResponseEntity<>(this.formService.getDictionaryById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "获取text，value格式的字典", notes = "获取text，value格式的字典")
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功", response = ResponseEntity.class),
            @ApiResponse(code = 400, message = "参数非法", response = HttpError.class),
            @ApiResponse(code = 500, message = "服务器异常", response = HttpError.class)
    })
    @RequestMapping(value = "/getTextValueDictionaryDatas/{parentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getTextValueDictionaryDatas(@PathVariable String parentId) {
        ResponseInfo res = this.formService.getDictionaryDatasByParentId(parentId);
        List<DictionaryDatasInfo> list = (List<DictionaryDatasInfo>) res.getData();
        List<Map<String, String>> list2 = new ArrayList<>();
        list.forEach(item -> {
            Map<String, String> map = new HashMap<>();
            map.put("text", item.getName());
            map.put("value", item.getProperty());
            list2.add(map);
        });
        res.setData(list2);
        return new ResponseEntity<>(list2, HttpStatus.OK);
    }


    @ApiOperation(value = "获取字典name", notes = "根据父id获取字典name")
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功", response = ResponseEntity.class),
            @ApiResponse(code = 400, message = "参数非法", response = HttpError.class),
            @ApiResponse(code = 500, message = "服务器异常", response = HttpError.class)
    })
    @RequestMapping(value = "/getTextDictionaryDatas/{parentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getTextDictionaryDatas(@PathVariable String parentId) {
        ResponseInfo res = this.formService.getDictionaryDatasByParentId(parentId);
        List<DictionaryDatasInfo> list = (List<DictionaryDatasInfo>) res.getData();
        List<String> list2 = new ArrayList<>();
        list.forEach(item -> list2.add(item.getName()));
        return new ResponseEntity<>(list2, HttpStatus.OK);
    }
}
