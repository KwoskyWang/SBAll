package com.dao;

import com.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by moooke on 2019/4/23.
 */
@Mapper
public interface UserDao {

    /**
     * 通过名字查询用户信息
     */
    @Select("SELECT * FROM user WHERE name = #{name}")
    List<User> findUserByName(@Param("name") String name);


    /**
     * 通过名字更新用户信息
     */
    @Select("update user set salary=5000 where name = #{name}")
    List<User> updateUserByName(@Param("name") String name);

    /**
     * 查询所有用户信息
     */
    @Select("SELECT * FROM user")
    List<User> findAllUser();

    /**
     * 插入用户信息
     */
    @Insert("INSERT INTO user(name, age,salary) VALUES(#{name}, #{age}, #{salary})")
    void insertUser(@Param("name") String name, @Param("age") Integer age, @Param("salary") Double salary);

    /**
     * 根据姓名 更新用户工资
     */
    @Update("UPDATE user SET salary= salary - #{salary} WHERE name = #{name}")
    void updateUser(@Param("name") String name,  @Param("salary") Double salary);

    /**
     * 根据姓名 更新用户工资
     */
    @Update("UPDATE user SET salary= salary + #{salary} WHERE name = #{name}")
    void updateReceiverUser(@Param("name") String name,  @Param("salary") Double salary);

    /**
     * 根据 id 删除用户信息
     */
    @Delete("DELETE from user WHERE id = #{id}")
    void deleteUser(@Param("id") int id);
}