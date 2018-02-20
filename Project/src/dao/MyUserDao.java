package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.MyUser;

public class MyUserDao {

	public MyUser findByLoginInfo(String loginId, String password) {

		Connection conn = null;

		try {

			conn = MyDBManager.getConnection();

			String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginId);
			pStmt.setString(2, password);
			ResultSet rs = pStmt.executeQuery();

			if(!rs.next()) {
				return null;
			}

			String loginIdData = rs.getString("login_id");
			String nameData = rs.getString("name");

			return new MyUser(loginIdData, nameData);

		}catch(SQLException e){

			e.printStackTrace();
			return null;

		}finally {

			if(conn != null) {

				try {

					conn.close();

				}catch(SQLException e) {

					e.printStackTrace();
					return null;
				}
			}
		}
	}

	public List<MyUser> findAll(){

		Connection conn = null;
		List<MyUser> userList = new ArrayList<>();

		try {

			conn = MyDBManager.getConnection();
			String sql = "SELECT * FROM user";

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {

				int id = rs.getInt("id");
				String loginId = rs.getString("login_id");
				String name = rs.getString("name");
				Date birthDate = rs.getDate("birth_date");
				String password = rs.getString("password");
				String createDate = rs.getString("create_date");
				String updateDate = rs.getString("update_date");
				MyUser user = new MyUser(id, loginId, name, birthDate, password, createDate, updateDate);

				userList.add(user);

			}

		}catch(SQLException e) {

			e.printStackTrace();
			return null;

		}finally {

			if(conn != null) {

				try {

					conn.close();

				}catch(SQLException e) {

					e.printStackTrace();
					return null;

				}
			}
		}

		return userList;

	}

	public MyUser findByLoginInfo(String id) {

		Connection conn = null;

		try {

			conn = MyDBManager.getConnection();

			String sql = "SELECT * FROM user WHERE id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			ResultSet rs = pStmt.executeQuery();

			if(!rs.next()) {
				return null;
			}

			String loginId = rs.getString("login_id");
			String name = rs.getString("name");
			Date birthDate = rs.getDate("birth_date");
			String password = rs.getString("password");
			String createDate = rs.getString("create_date");
			String updateDate = rs.getString("update_date");

			return new MyUser(loginId, name, birthDate, password, createDate, updateDate);

		}catch(SQLException e){

			e.printStackTrace();
			return null;

		}finally {

			if(conn != null) {

				try {

					conn.close();

				}catch(SQLException e) {

					e.printStackTrace();
					return null;
				}
			}
		}

	}

	public void updateUserInfo(String id, String loginId, String password, String name, Date birthDate, String updateDate) {

		Connection conn = null;

		try {

			conn = MyDBManager.getConnection();

			String sql = "UPDATE user SET login_id= 'loginId' name = 'name' birth_date = 'birthDate' password = 'password' updateDate = 'updateDate' WHERE id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			ResultSet rs = pStmt.executeQuery();

			if(!rs.next()) {
				return;
			}

		}catch(SQLException e){

			e.printStackTrace();
			return;

		}finally {

			if(conn != null) {

				try {

					conn.close();

				}catch(SQLException e) {

					e.printStackTrace();
					return;
				}
			}
		}

	}

}