package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vastika.userInfo_system.User;

import dbUtil.DBUtil;

public  class UserDaoImpl implements UserDao{
 public static final String INSERT_SQL= "insert into user_tbl(user_name, password, email, mobile_n0, dob) values(?,?,?,?,?";
 public static final String UPDATE_SQL= "update user_tbl set user_name=?, password=?, email=?, mobile_n0=?, dob=?) where id=?";
 public static final String DELETE_SQL= "delete from user_tbl where id=?";
 public static final String LIST_SQL= "select * from user_tbl";
 public static final String GET_BY_ID_SQL= "select * from user_tbl where id=?";
private static final User user = null;
	@Override
	public int SaveUserInfo(User user) {
		int saved = 0;
		try(
				Connection con  = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(INSERT_SQL);){
			   ps.setString(1,  user.getUsername());
			   ps.setString(2,  user.getPassword());
			   ps.setString(3,  user.getEmail());
			   ps.setString(4,  user.getMobileNo());
			   ps.setDate(5,  new Date(user.getDob().getTime()));
			   saved = ps.executeUpdate();
		} catch(ClassNotFoundException | SQLException e) {
		   e.printStackTrace();
		}
		return saved;
	}

	@Override
	public int updateUserInfo(User user) {
		int updated = 0;
		try(
				Connection con  = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(UPDATE_SQL);){
			   ps.setString(1,  user.getUsername());
			   ps.setString(2,  user.getPassword());
			   ps.setString(3,  user.getEmail());
			   ps.setString(4,  user.getMobileNo());
			   ps.setDate(5,  new Date(user.getDob().getTime()));
			   ps.setInt(6, user.getId());
			   updated = ps.executeUpdate();
		} catch(ClassNotFoundException | SQLException e) {
		   e.printStackTrace();
		}
		return updated;
		
	}

	@Override
	public int deleteUserInfo(int id) {
		int deleted = 0;
		try(
				Connection con  = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(DELETE_SQL);){
			  
			   ps.setInt(1, id());
			   deleted = ps.executeUpdate();
		} catch(ClassNotFoundException | SQLException e) {
		   e.printStackTrace();
		}
		return deleted;
	
	}

	private int id() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User getUserById(int id) {
		try(
				Connection con  = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(GET_BY_ID_SQL);){
			  ps.setInt(1, id);
			   ResultSet rs = ps.executeQuery();
			   if(rs.next()) {
				   User user = new User();
				   user.setId(rs.getInt("id"));
				   user.setUsername(rs.getString("user_name"));
				   user.setPassword(rs.getString("password"));
				   user.setEmail(rs.getString("email"));
				   user.setMobileNo(rs.getString("MobileNo"));
				   user.setDob(rs.getDate("dob"));
				   
			   }
			  
		} catch(ClassNotFoundException | SQLException e) {
		   e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public List<User> getAllUser() {
		List<User> userList = new ArrayList<>();
		try(
				Connection con  = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(LIST_SQL);){
			  
			   ResultSet rs = ps.executeQuery();
			   while(rs.next()) {
				   User user = new User();
				   user.setId(rs.getInt("id"));
				   user.setUsername(rs.getString("user_name"));
				   user.setPassword(rs.getString("password"));
				   user.setEmail(rs.getString("email"));
				   user.setMobileNo(rs.getString("MobileNo"));
				   user.setDob(rs.getDate("dob"));
				   userList.add(user);
			   }
			  
		} catch(ClassNotFoundException | SQLException e) {
		   e.printStackTrace();
		}
		return userList;
		
	}

}
