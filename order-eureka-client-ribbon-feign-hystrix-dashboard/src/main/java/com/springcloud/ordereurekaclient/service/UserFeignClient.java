package com.springcloud.ordereurekaclient.service;


import com.springcloud.ordereurekaclient.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * liZhi
 * 2019年4月25日21:40:13
 * name属性指定了要调用的客户端虚拟主机名，已经默认配置了ribbon 负载均衡
 */
@FeignClient(name="user-provider",fallback = UserFeignClient.FeignClientFallback.class)
public interface UserFeignClient {

    /**
     * 注意只能用第二种方法，不然会提示我们没有指定HTTP方法
     * 而且@PathVariable 必须注定参数 不然会报
     * Caused by: java.lang.IllegalStateException: PathVariable annotation was empty on param 0.
     * 多参数的时候也需要指定@RequestParam("");
     * */
    // @GetMapping("/{id}"
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);

    /**
     * 回退类需实现feign Client 接口
     */
    @Component
    class FeignClientFallback implements  UserFeignClient{

        @Override
        public User findById(Long id) {
            User user=new User();
            user.setId(-1L);
            user.setName("游客");
            user.setAge(1);
            user.setUsername("小王");
            return user;
        }
    }
}
