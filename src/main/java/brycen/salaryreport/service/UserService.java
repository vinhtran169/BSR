package brycen.salaryreport.service;
import java.util.List;
import brycen.salaryreport.model.User;

public interface UserService {
	void insertUser(User user);
	boolean getUserByUserName(String username);
	boolean getUserByLogin(String username, String password);
	List<User> getAllUser();
	User getUserByID(Long id);
	void updateUser(User user);
	void deleteUser(User user);
}
