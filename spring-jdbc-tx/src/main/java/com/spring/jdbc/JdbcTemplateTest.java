package com.spring.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig(locations = "classpath:bean.xml")
public class JdbcTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testUpdate() {
        String sql = "INSERT INTO t_emp values(NULL,?,?,?)";
//        int rows = jdbcTemplate.update(sql, "Jony", 20, "M");
        int rows = jdbcTemplate.update(sql, "Lucy", 20, "F");
        System.out.println(rows);
    }

    @Test
    public void testSelect() {
        // 写法一：
//        String sql = "SELECT * from t_emp where id=?";
//        Employee employee = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
//            Employee employee = new Employee();
//            employee.setId(rs.getInt("id"));
//            employee.setName(rs.getString("name"));
//            employee.setAge(rs.getInt("age"));
//            employee.setSex(rs.getString("sex"));
//            return employee;
//        }, 1);
//        System.out.println(employee);

        // 写法二
        String sql = "SELECT * from t_emp where id=?";
        Employee employee = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Employee.class), 1);
        System.out.println(employee);
    }

    @Test
    public void testSelectList() {
        String sql = "SELECT * from t_emp";
        List<Employee> rows = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class));
        System.out.println(rows);
    }

    @Test
    public void testSelectValue() {
        String sql = "SELECT count(*) from t_emp";
        int value = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(value);
    }
}
