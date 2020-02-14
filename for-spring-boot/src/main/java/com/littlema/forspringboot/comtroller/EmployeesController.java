package com.littlema.forspringboot.comtroller;

import com.littlema.forspringboot.Dao.EmployeeDao;
import com.littlema.forspringboot.Mapper.EmployeesMapper;
import com.littlema.forspringboot.bean.Employee;
import com.littlema.forspringboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/employee")
@Controller
public class EmployeesController {

    @Autowired
    EmployeesMapper employeesMapper;
    @Autowired
    EmployeeService employeeService;


    @GetMapping("/employees")
    public String employees(Model model){
        List<Employee> employees = employeeService.getEmployees();
        model.addAttribute("employees",employees);
        return "empsList";
    }

    @GetMapping("/employee")
    public String employee(Model model){
        model.addAttribute("country",employeeService.getCountryOption());
        return "empAdd";
    }

    @GetMapping("/employee/{id}")
    public String employee(Model model,@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("country",employeeService.getCountryOption());
        model.addAttribute("employee",employee);
        return "empAdd";
    }

    @PostMapping("/employee")
    public String addEmployee(Employee employee){
        employeeService.insertEmployee(employee);
        return "redirect:/employee/employees";
    }

    @PutMapping("/employee")
    public String editEmployee(Employee employee){
        employeeService.updateEmployee(employee);
        return "redirect:/employee/employees";
    }

    @DeleteMapping("/employeeDelete/{id}")
    public String deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
        return "redirect:/employee/employees";
    }

    @ResponseBody
    @GetMapping("/haveEmployee/{code}")
    public Map haveEmployee(@PathVariable String code){
        Map result = new HashMap<String,Object>();
        boolean haveEmployee = employeeService.haveEmployee(code);
        result.put("haveEmployee",haveEmployee);
        return result;
    }
}
