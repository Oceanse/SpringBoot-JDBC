package com.springboot.jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author epanhai
 */
@Repository
public class DepartmentDaoImpl {
    private Logger logger =  LogManager.getLogger(DepartmentDaoImpl.class);

    //spring-boot-starter-jdbc中自带的JdbcTemplate是对JDBC的轻度封装
    @Autowired
    private JdbcTemplate template;


    /**
     * 新增数据
     * @param department
     */
    public void addDepartmentDao(Department department) {
        String sql = "insert into department values (" + department.getId() + ",'" + department.getDepartmentName() + "')";
        logger.info("sql:{}", sql);//insert into department values (1,'dev')
        template.execute(sql);
    }


    /**
     * 查询数据
     * @param id
     * @return
     */
    public String queryDepartmentByIdDao(int  id ) {
        String sql = "select * from department where id="+ id;
        RowMapper<Department> mapper = new BeanPropertyRowMapper<>(Department.class);
        //List<Department> d = template.query(sql, data);//返回List<Department>
        Department department = template.queryForObject(sql, mapper);
        return department.toString();
    }

    /**
     * 查询所有
     * @return
     */
    public List<Department> queryAllDepartmentDao(){
        RowMapper<Department> mapper = new BeanPropertyRowMapper<>(Department.class);
        List<Department> list=template.query("select * from department",mapper);
        return  list;
    }


}
