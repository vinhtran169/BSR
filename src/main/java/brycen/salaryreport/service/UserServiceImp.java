package brycen.salaryreport.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
}
