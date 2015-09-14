package brycen.salaryreport.mappers;


import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import brycen.salaryreport.model.User;

public interface UserMapper {
	@Insert("INSERT INTO user(username, password,email) VALUE(#{userName},#{password},#{email})")
	@Options(useGeneratedKeys=true, keyProperty="id", flushCache=true, keyColumn="id")
	public void insertUser(User user);
		
	@Select("SELECT USERNAME as userName, PASSWORD as password, "
			+ " EMAIL as email "
			+ "FROM user WHERE userName = #{userName}")
	public User getUserByUserName(String userName);
	int updateByPrimaryKey(User record);
	@Select("SELECT * FROM user")
	public List<User> getUserList();
}