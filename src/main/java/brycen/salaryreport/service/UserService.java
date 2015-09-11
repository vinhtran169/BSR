package brycen.salaryreport.service;
import brycen.salaryreport.model.User;

public interface UserService {
	void insertUser(User user);
	boolean getUserByUserName(String username);
	boolean getUserByLogin(String username, String password);
}
