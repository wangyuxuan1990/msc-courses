package com.wangyuxuan.controller;

import com.wangyuxuan.bean.Depart;
import com.wangyuxuan.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author wangyuxuan
 * @date 2020/9/25 9:40 下午
 * @description
 */
@RestController
@RequestMapping("/provider/depart")
public class DepartController {
    @Autowired
    private DepartService service;
    // 声明服务发现客户端
    @Autowired
    private DiscoveryClient client;

    @PostMapping("/save")
    public boolean saveHandler(@RequestBody Depart depart) {
        return service.saveDepart(depart);
    }

    @DeleteMapping("/del/{id}")
    public boolean delHandler(@PathVariable("id") Integer id) {
        return service.removeDepartById(id);
    }

    @PutMapping("/update")
    public boolean updateHandler(@RequestBody Depart depart) {
        return service.modifyDepart(depart);
    }

    @GetMapping("/get/{id}")
    public Depart getHandler(@PathVariable("id") Integer id) {
        return service.getDepartById(id);
    }

    @GetMapping("/list")
    public List<Depart> listHandler() {
        return service.listAllDeparts();
    }

    @GetMapping("/discovery")
    public List<String> discoveryHandler() {
        List<String> services = client.getServices();
        for (String name : services) {
            // 获取当前遍历微服务名称的所有提供者主机
            List<ServiceInstance> instances = client.getInstances(name);
            // 遍历所有提供者主机的详情
            for (ServiceInstance instance : instances) {
                // 获取当前提供者的唯一标识，instance id
                String serviceId = instance.getServiceId();
                String instanceId = instance.getInstanceId();
                // 获取当前提供者主机的host
                String host = instance.getHost();
                Map<String, String> metadata = instance.getMetadata();
                System.out.println("serviceId = " + serviceId);
                System.out.println("instanceId = " + instanceId);
                System.out.println("host = " + host);
                System.out.println("metadata = " + metadata);
            }
        }
        return services;
    }
}
