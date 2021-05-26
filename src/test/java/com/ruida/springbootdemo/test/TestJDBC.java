package com.ruida.springbootdemo.test;

import com.ruida.springbootdemo.entity.User;

import java.sql.*;

/**
 * 插入数据并返回主键
 *
 * @author chenjy
 * @date 2021/3/15
 */
public class TestJDBC {

    private static final String URL = "";
    private static final String USER_NAME = "";
    private static final String PASSWORD = "";

    private Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public int insert(User user) {
        Connection connection = getConnection();
        PreparedStatement ps;
        ResultSet rs;
        int id = -1;
        try {
            ps = connection.prepareStatement("insert into t_user(user_name,gender,age) values (?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setObject(1, user.getUsername());
            ps.setObject(2, user.getGender());
            ps.setObject(3, user.getAge());
            int i = ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public static void main(String[] args) {
        TestJDBC jdbc = new TestJDBC();
        User user = new User("liuxiaoyu", 22);
        user.setGender(2);
        System.out.println(jdbc.insert(user));
    }
}
