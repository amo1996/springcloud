package com.springcloud.ordereurekaclient.service;


import com.springcloud.ordereurekaclient.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="user-provider")
@Service
public interface UserFeignClient {

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id);
}
