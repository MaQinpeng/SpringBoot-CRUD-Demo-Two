package com.littlema.forspringboot.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OtherMapper {
    @Select("select name from countryOption")
    public List<String> countryOptions();
    @Insert("insert into countryOption(name) values(#{name})")
    public int insertCountryOption(@Param("name")String name);

}
