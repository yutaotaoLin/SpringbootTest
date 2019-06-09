package gupt.taotao.springbootmybatishomework.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gupt.taotao.springbootmybatishomework.common.User;
import gupt.taotao.springbootmybatishomework.mapper.UserMapper;



@Service
public class UserService {
	
	@Autowired
	UserMapper userMapper;
	
	
	public User selectUser(User user){
		return  userMapper.selectUser(user.getUserName(), user.getPassword());
	}
	
	public User selectUsername(User user){
		return userMapper.selectByPrimaryKey(user.getUserName());
	}
	
	public int insert(User user){
		return userMapper.insertSelective(user);
	}

	
}
