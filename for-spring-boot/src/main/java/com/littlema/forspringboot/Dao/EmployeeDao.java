package com.littlema.forspringboot.Dao;

import com.littlema.forspringboot.bean.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDao {
    private static List<Employee> employees;
    private static List<String> countrys;

    static {
        //员工列表
        employees = new ArrayList<>();
        employees.add(new Employee("梅九",false,"0009","meininth@666.com","French"));
        employees.add(new Employee("高十",true,"0010","highten@666.com","Spain"));
        employees.add(new Employee("马二",true,"0002","horsetwo@666.com","Portugal"));
        employees.add(new Employee("石一",true,"0001","numberone@666.com","Brazil"));
        //国家列表
        countrys = new ArrayList<>();
        countrys.add("China");
        countrys.add("Russia");
        countrys.add("Canada");
        countrys.add("English");
        countrys.add("French");
        countrys.add("Japan");
        countrys.add("Spain");
        countrys.add("Brazil");
        countrys.add("Portugal");
        countrys.add("America");
    }
    //获取所有员工
    public List<Employee> getEmployees() {
        return employees;
    }
    //获取所有国家
    public List<String> getCountrys(){
        return countrys;
    }
    //添加员工
    public void addEmployee(Employee employee){
        deleteEmployee(employee.getEmployeeCode());
        employees.add(employee);
    }
    //删除员工
    public void deleteEmployee(String employeeCode){
        if(StringUtils.isEmpty(employeeCode)){
            return;
        }
        int n = 0;
        for (Employee emp:employees) {
            if(employeeCode.equals(emp.getEmployeeCode())){
                employees.remove(n);
                return;
            }
            n++;
        }
    }
    //获取单个员工
    public Employee getEmployee(String employeeCode){
        for (Employee emp:employees) {
            if(employeeCode.equals(emp.getEmployeeCode())){
                return emp;
            }
        }
        return null;
    }
}
