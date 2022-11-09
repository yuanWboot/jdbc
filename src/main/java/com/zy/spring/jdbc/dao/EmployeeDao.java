package com.zy.spring.jdbc.dao;

import com.zy.spring.jdbc.entity.Employee;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class EmployeeDao {
    private JdbcTemplate jdbcTemplate;

   //查询单条数据
    public Employee findById(Integer eno){
        String sql = "select * from employee where eno = ?";
        Employee employee = jdbcTemplate.queryForObject(sql, new Object[]{eno}, new BeanPropertyRowMapper<Employee>(Employee.class));
        return  employee;
    }
    //查询复合数据
    public List<Employee> findByDname(String dname){
        //将具体值转变参数
        String sql = "select * from employee where dname = ?";
        List<Employee> list = jdbcTemplate.query(sql, new Object[]{dname}, new BeanPropertyRowMapper<Employee>(Employee.class));
        return list;
    }

    //对查询结果进行封装
    public List findMapByDname(String dname){
        String sql = "select eno as empo,salary as s  from employee where dname= ?";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, new Object[]{dname});
        return maps;

    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
