package brycen.salaryreport.service;

import brycen.salaryreport.model.User;;

public interface UserService {
	void insertUser(User user);
	boolean getUserByLogin(String userName, String password);
	boolean getUserByUserName(String userName);
}
