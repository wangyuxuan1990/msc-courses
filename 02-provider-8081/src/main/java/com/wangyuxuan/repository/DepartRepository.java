package com.wangyuxuan.repository;

import com.wangyuxuan.bean.Depart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wangyuxuan
 * @date 2020/9/23 10:49 下午
 * @description 第一个泛型是，当前Repository所操作的对象的类型
 *              第二个泛型是，当前Repository所操作的对象的id类型
 */
public interface DepartRepository extends JpaRepository<Depart, Integer> {
}
