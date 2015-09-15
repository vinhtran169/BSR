package brycen.salaryreport.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import brycen.salaryreport.mappers.UserMapper;
import brycen.salaryreport.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Transactional
	public void insertUser(User user) {
		userMapper.insertUser(user);
	}

	public boolean getUserByLogin(String userName, String password) {
		User user = userMapper.getUserByUserName(userName);
		if(user != null && user.getPassword().equals(password)) {
			return true;
		}
		
		return false;
	}

	public boolean getUserByUserName(String userName) {
		User user = userMapper.getUserByUserName(userName);
		if(user != null) {
			return true;
		}
		
		return false;
	}

	public List<User> getUserList() {
		List<User> ListUser = new ArrayList<User>();
		ListUser = userMapper.getUserList();
		return ListUser;
	}

	public void updateByPrimaryKey(User user) {
		// TODO Auto-generated method stub
		
	}

	public void DeleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		userMapper.DeleteByPrimaryKey(id);
	}

	


}
