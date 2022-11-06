package com.springboot.jdbc.controller;

import com.alibaba.druid.pool.DruidDataSource;
import com.springboot.jdbc.Department;
import com.springboot.jdbc.DepartmentServiceImpl;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author epanhai
 */
@RestController
public class SpringdataJDBCController {
    @Autowired
    DataSource dataSource;

    @Autowired
    DepartmentServiceImpl departmentService;

    Logger logger = LogManager.getLogger(SpringdataJDBCController.class);

    /**
     * DataSource 翻译过来为数据源，它是 jdk 提供的一个接口，然后只提供了两个 getConnection 方法，分别是无参数和需要传入用户名和密码
     * 可以理解为是跟数据库连接有关的东西，大多数数据源的实现包含了最基本的连接四要素：数据库地址，数据库驱动，用户名，密码；
     * 另外还可能包含和数据库连接池的相关信息(管理连接)，比如最大连接数，初始连接数，所以数据源又多了连接池的含义；
     * 常见的连接池实现：HikariDataSource， DruidDataSource等
     * spring-boot-starter-jdbc模块默认使用HikariCP作为数据源,HikariCP的作者是日本人
     * @throws SQLException
     */
   @GetMapping("/testConnect")
    private void showConnection() throws SQLException {
       String dataSourceName = dataSource.getClass().getName();
       System.out.println("dataSourceName = " + dataSourceName);

       if(dataSource instanceof HikariDataSource){
           HikariDataSource hikariDataSource=(HikariDataSource)dataSource;
           String jdbcUrl = hikariDataSource.getJdbcUrl();
           String driverClassName = hikariDataSource.getDriverClassName();
           String username = hikariDataSource.getUsername();
           String password = hikariDataSource.getPassword();
           int maximumPoolSize = hikariDataSource.getMaximumPoolSize();
           System.out.println("jdbcUrl = " + jdbcUrl);
           System.out.println("driverClassName = " + driverClassName);
           System.out.println("username = " + username);
           System.out.println("password = " + password);
           System.out.println("maximumPoolSize = " + maximumPoolSize);
       }

       if(dataSource instanceof DruidDataSource){
           DruidDataSource druidDataSource=(DruidDataSource)dataSource;
           String jdbcUrl = druidDataSource.getUrl();
           String driverClassName = druidDataSource.getDriverClassName();
           String username = druidDataSource.getUsername();
           String password = druidDataSource.getPassword();
           int maxActive = druidDataSource.getMaxActive();
           int initialSize = druidDataSource.getInitialSize();
           System.out.println("jdbcUrl = " + jdbcUrl);
           System.out.println("driverClassName = " + driverClassName);
           System.out.println("username = " + username);
           System.out.println("password = " + password);
           System.out.println("maxActive = " + maxActive);
           System.out.println("initialSize = " + initialSize);
       }
    }


    @GetMapping("/addDepartment/{id}/{departmentName}")
    private void addDepartment(@PathVariable int id,@PathVariable String departmentName)   {
        Department department=new Department();
        department.setId(id);
        department.setDepartmentName(departmentName);
        departmentService.addDepartmentService(department);
    }


    @GetMapping("/getDepartmentById/{id}")
    private String getDepartmentById(@PathVariable int id)   {
        logger.info(departmentService.queryDepartmentByIdService(id));
        return departmentService.queryDepartmentByIdService(id);
    }


    @GetMapping("/getAllDepartment")
    private List<Department> getAllDepartment()   {
        logger.info(departmentService.queryAllDepartmentService());
        return departmentService.queryAllDepartmentService();
    }



}
