package com.springboot.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl {
    @Autowired
    DepartmentDaoImpl departmentDao;

    /**
     * 新增数据
     * @param department
     */
    public void addDepartmentService(Department department) {
        departmentDao.addDepartmentDao(department);
    }

    /**
     * 条件查询
     * @param id
     * @return
     */
    public String queryDepartmentByIdService(int  id) {
        String departmentInfo = departmentDao.queryDepartmentByIdDao(id);
        return departmentInfo;
    }


    /**
     * 查询所有
     * @return
     */
    public List<Department> queryAllDepartmentService() {
        return departmentDao.queryAllDepartmentDao();
    }

}
