package brycen.salaryreport.mappers;

import org.apache.ibatis.annotations.Select;

import brycen.salaryreport.model.User;

public interface UserMapper {
	@Select("SELECT * FROM user WHERE username = #{username}")
	public User getUserByUserName(String username);
}
