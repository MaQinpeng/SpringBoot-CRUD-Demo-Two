package com.littlema.forspringboot.service;

import com.littlema.forspringboot.Mapper.EmployeesMapper;
import com.littlema.forspringboot.Mapper.OtherMapper;
import com.littlema.forspringboot.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeesMapper employeesMapper;
    @Autowired
    OtherMapper otherMapper;

    //获取所有员工
    public List<Employee> getEmployees(){
        List<Employee> employees = employeesMapper.selectAll();
        return employees;
    }

    //获取一个员工
    public Employee getEmployee(int id){
        return employeesMapper.selectEmployee(id);
    }

    //新增一个员工
    public void insertEmployee(Employee employee){
        employeesMapper.insertEmployee(
                employee.getName(),
                employee.getGender(),
                employee.getEmail(),
                employee.getEmployeeCode(),
                employee.getCountry());
    }

    //更新一个员工信息
    public void updateEmployee(Employee employee){
        employeesMapper.updateEmployee(
                employee.getName(),
                employee.getGender(),
                employee.getEmail(),
                employee.getEmployeeCode(),
                employee.getCountry(),
                employee.getId());
    }

    //删除一个员工
    public void deleteEmployee(int id){
        employeesMapper.deleteEmployee(id);
    }

    //获取所有国家选项
    public List<String> getCountryOption(){
        return otherMapper.countryOptions();
    }

    //查询有没有对应Code的员工
    public boolean haveEmployee(String code){
        Integer integer = employeesMapper.selectEmployeeByCode(code);
        return integer!=null;
    }
}
