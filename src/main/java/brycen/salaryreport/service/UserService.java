package brycen.salaryreport.service;

import java.util.List;

import brycen.salaryreport.model.User;;

public interface UserService {
	void insertUser(User user);
	boolean getUserByLogin(String userName, String password);
	boolean getUserByUserName(String userName);
	List<User> getUserList();
	void updateByPrimaryKey(User user);
	void DeleteByPrimaryKey(Long id);
	
}
