package com.littlema.forspringboot.Mapper;

import com.littlema.forspringboot.bean.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeesMapper {

    //查询全部员工
    @Select("select * from employees")
    public List<Employee> selectAll();

    //查询通过id查询单个员工
    @Select("select * from employees where id=#{id}")
    public Employee selectEmployee(@Param("id") int id);

    //通过employeeCode查询有没有这个员工，返回一个id
    public Integer selectEmployeeByCode(@Param("code") String code);

    //编辑员工信息
    @Update("update employees set name = #{name},gender = #{gender},email = #{email}," +
            "employeeCode = #{employeeCode},country = #{country} where id = #{id}")
    public int updateEmployee(
            @Param("name") String name,
            @Param("gender")boolean gender,
            @Param("email")String email,
            @Param("employeeCode")String employeeCode,
            @Param("country")String country,
            @Param("id")int id);

    //新增一个员工
    @Insert("insert into employees(name,gender,email,employeeCode,country) " +
            "values(#{name},#{gender},#{email},#{employeeCode}," +
            "#{country})")
    public int insertEmployee(
            @Param("name") String name,
            @Param("gender")boolean gender,
            @Param("email")String email,
            @Param("employeeCode")String employeeCode,
            @Param("country")String country);

    //删除一个员工
    @Delete("delete from employees where id = #{id}" )
    public int deleteEmployee(int id);
}
