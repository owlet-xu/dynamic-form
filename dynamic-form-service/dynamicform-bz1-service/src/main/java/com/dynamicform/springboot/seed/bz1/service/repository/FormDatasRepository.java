package com.dynamicform.springboot.seed.bz1.service.repository;

import com.dynamicform.springboot.seed.bz1.service.entity.FormDatasEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author xgy
 * @description
 * @date 2018/9/30
 */
public interface FormDatasRepository  extends CrudRepository<FormDatasEntity, String> {

}
