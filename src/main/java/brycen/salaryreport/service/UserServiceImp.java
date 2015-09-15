package brycen.salaryreport.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import brycen.salaryreport.mappers.UserMapper;
import brycen.salaryreport.model.User;

@Service("userLogin")
public class UserServiceImp implements UserService {
	@Autowired
	private UserMapper userMapper;
	public boolean getUserByUserName(String username) {
		User user = userMapper.getUserByUserName(username);
		if (user != null) {
			return true;
		} else{
			return false;
		}
	}
	public boolean getUserByLogin(String username, String password) {
		User user = userMapper.getUserByUserName(username);
		if (user != null && user.getPassword().equals(password)) {
			return true;
		} else{
			return false;
		}
	}
	public void insertUser(User user) {		
		userMapper.insertUser(user);
	}
	public List<User> getAllUser() {
		List<User> lst = new ArrayList<User>();
		lst = userMapper.getAllUser();
		return lst;
	}
	public User getUserByID(Long id) {
		User user = userMapper.getUserByID(id);
		if (user != null) {
			return user;
		} else{
			return null;
		}
	}
	public void updateUser(User user) {
		userMapper.updateUser(user);		
	}
	public void deleteUser(User user) {
		userMapper.deleteUser(user);	
	}
}
