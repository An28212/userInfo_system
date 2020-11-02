package dao;

import java.util.List;

import com.vastika.userInfo_system.User;

public interface UserDao {
 int SaveUserInfo(User user);
 int updateUserInfo(User user);
 int deleteUserInfo(int id);
 User getUserById(int id);
 List<User> getAllUser();
}
