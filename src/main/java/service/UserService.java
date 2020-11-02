package service;

import java.util.List;

import com.vastika.userInfo_system.User;

public interface UserService {
	
		 int SaveUserInfo(User user);
		 int updateUserInfo(User user);
		 int deleteUserInfo(int id);
		 User getUserById(int id);
		 List<User> getAllUser();
}
