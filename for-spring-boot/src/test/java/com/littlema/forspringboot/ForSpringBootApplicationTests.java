package com.littlema.forspringboot;

import com.littlema.forspringboot.Dao.EmployeeDao;
import com.littlema.forspringboot.Mapper.EmployeesMapper;
import com.littlema.forspringboot.Mapper.OtherMapper;
import com.littlema.forspringboot.bean.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SpringBootTest
class ForSpringBootApplicationTests {

	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	EmployeesMapper employeesMapper;
	@Autowired
	OtherMapper otherMapper;
	@Autowired
	EmployeeDao employeeDao;

	@Test
	void contextLoads() throws SQLException {
		List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from person_list");
		for (Map map:maps) {
			for (Object str:map.keySet()) {
				System.out.println(map.get(str));
			}
		}
	}

	@Test
	void getConnect() throws SQLException {
		System.out.println(dataSource.getClass());
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
		connection.close();
	}

	@Test
	void empText(){
		List<String> employees = otherMapper.countryOptions();
		employees.forEach(emp->{
			System.out.println(emp.toString());
		});
	}

	@Test
	void selectEmp(){
		System.out.println(employeesMapper.selectEmployeeByCode("0008"));
	}
}
