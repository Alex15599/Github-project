package com.example.eqmsserver.controller;


import com.example.eqmsserver.model.User;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)

/**
 * @author longzhonghua
 * @data 2/24/2019 9:51 AM
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    //创建数据表
    @GetMapping("createUserTable")
    public void createUserTable() throws Exception {
        String sql = "CREATE TABLE `user` (\n" +
                "  `id` int(10) NOT NULL AUTO_INCREMENT,\n" +
                "  `username` varchar(100) DEFAULT NULL,\n" +
                "  `password` varchar(100) DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;\n" +
                "\n";

        jdbcTemplate.execute(sql);

    }

    @Test
    //saveUserTest
    //添加一个测试数据
    @GetMapping("saveUserTest")
    public void saveUserTest()throws Exception  {
        String sql = "INSERT INTO user (USERNAME,PASSWORD) VALUES ('longzhiran','123456')";
        int rows = jdbcTemplate.update(sql);
        System.out.println(rows);
    }


    @Test
    //updateUserPassword?id=1&passWord=12345678
    @GetMapping("updateUserPassword")
    public void updateUserPassword() throws Exception {
        Integer id=1;
        String passWord="999888";
        String sql = "UPDATE user SET PASSWORD = ? WHERE ID = ?";
        int rows = jdbcTemplate.update(sql, passWord, id);
        System.out.println(rows);
    }

    @Test
    //deleteUserById?id=1
    @GetMapping("deleteUserById")
    public void deleteUserById() throws Exception {
        String sql = "DELETE FROM  user  WHERE ID = ?";
        int rows = jdbcTemplate.update(sql, 1);
        System.out.println(rows);
    }


    @Test
    //getUserByName?userName=longzhiran
    @GetMapping("getUserByName")
    public void getUserByName()throws Exception {
        String name="longzhonghua";
        String sql = "SELECT * FROM user WHERE USERNAME = ?";
        List<User> list = jdbcTemplate.query(sql, new User(), new Object[]{name});
        for(User user:list){
            System.out.println(user);
        }
    }



    @Test
    //getAll
    @GetMapping("list")
    public void list() throws Exception {
        String sql = "SELECT * FROM user limit 1000";

        List<User> userList = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper(User.class));
        for(User userLists:userList){
            System.out.println(userLists);
        }
    }

}
