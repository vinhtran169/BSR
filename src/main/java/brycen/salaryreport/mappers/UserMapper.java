package brycen.salaryreport.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import brycen.salaryreport.model.User;

public interface UserMapper {
	@Select("SELECT * FROM user WHERE username = #{username}")
	public User getUserByUserName(String username);
	@Insert("INSERT INTO user(username, password, email) VALUE (#{username}, #{password}, #{email})")
	@Options(useGeneratedKeys = true, keyProperty="id", flushCache = true, keyColumn ="id")
	public void insertUser(User user);
}
