package com.zy.spring.jdbc.service;

import com.zy.spring.jdbc.dao.EmployeeDao;
import com.zy.spring.jdbc.entity.Employee;

import java.util.Date;

public class EmployeeService {
    private EmployeeDao employeeDao;

    public void batchImport(){
        for (int i = 0; i < 10; i++) {
            Employee employee = new Employee();
            employee.setEno(8000+i);
            employee.setEname("员工"+i);
            employee.setSalary(4000f);
            employee.setDname("研发部");
            employee.setHiredate(new Date());
        }

    }
    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
