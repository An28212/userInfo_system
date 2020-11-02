package service;

import java.util.List;

import com.vastika.userInfo_system.User;

import dao.UserDao;
import dao.UserDaoImpl;

public class UserServiceImpl implements UserService{
   UserDao userDao = new UserDaoImpl();
	@Override
	public int SaveUserInfo(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUserInfo(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUserInfo(user);
	}

	@Override
	public int deleteUserInfo(int id) {
		return userDao.deleteUserInfo( id);
		
	}

	@Override
	public User getUserById(int id) {
		return userDao.getUserById( id);
		
	}

	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser( );
		
	}

}
