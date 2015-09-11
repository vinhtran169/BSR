package brycen.salaryreport.service;

public interface UserService {
	boolean getUserByUserName(String username);
	boolean getUserByLogin(String username, String password);
}
