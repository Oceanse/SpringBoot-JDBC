package com.springboot.jdbc.controller;

import java.sql.*;


/**
 * 原生JDBC操作数据库
 */
public class NativeDBCTest {

    public static final String URL = "jdbc:mysql://localhost:3306/testDB";
    public static final String USER = "root";
    public static final String PASSWORD = "123123";

    public static void main(String[] args) throws Exception {
        //1.加载驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2. 获得数据库连接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        //3.操作数据库，实现增删改查
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from department");
        //如果有数据，rs.next()返回true
        while(rs.next()){
            System.out.println(rs.getInt("id")+"："+rs.getString("departmentName"));
        }
    }


}
