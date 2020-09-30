package com.wangyuxuan.service;

import com.wangyuxuan.bean.Depart;

import java.util.List;

/**
 * @author wangyuxuan
 * @date 2020/9/23 10:52 下午
 * @description
 */
public interface DepartService {
    boolean saveDepart(Depart depart);

    boolean removeDepartById(Integer id);

    boolean modifyDepart(Depart depart);

    Depart getDepartById(int id);

    List<Depart> listAllDeparts();
}
