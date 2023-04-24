package com.example.eqmsserver.model;

import lombok.Data;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class User implements RowMapper<User> {
    private int id;
    private String username;
    private String password;
    //必须重写mapRow方法
    @Override

    public User mapRow(ResultSet resultSet,int i) throws SQLException{
        User user=new User();
        user.setId(resultSet.getInt("id"));
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        return  user;
    }
}

