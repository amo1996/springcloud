package com.lz.springcloud.usereurekaclient.dao;


import com.lz.springcloud.usereurekaclient.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {

    @Select("select * from user where id = #{id}")
    User getUserById(Long id);
}
