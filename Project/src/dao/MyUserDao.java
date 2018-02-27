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

			int idData = rs.getInt("id");
			String loginId = rs.getString("login_id");
			String name = rs.getString("name");
			Date birthDate = rs.getDate("birth_date");
			String password = rs.getString("password");
			String createDate = rs.getString("create_date");
			String updateDate = rs.getString("update_date");

			return new MyUser(idData, loginId, name, birthDate, password, createDate, updateDate);

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


	public void registerUser(String loginId, String name, String birthDate, String password, String createDate, String updateDate) {

		Connection conn = null;

		try {

			conn = MyDBManager.getConnection();

			String sql = "INSERT INTO user (login_id, name, birth_date, password, createDate, updateDate) VALUE(?, ?, ?, ?, ?, ?)";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginId);
			pStmt.setString(2, name);
			pStmt.setString(3, birthDate);
			pStmt.setString(4, password);
			pStmt.setString(5, createDate);
			pStmt.setString(6, updateDate);

			int rs = pStmt.executeUpdate(sql);
			System.out.println(rs);

			pStmt.close();

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


	public void updateUserInfo(String id, String password, String name, String birthDate, String updateDate) {

		Connection conn = null;

		try {

			conn = MyDBManager.getConnection();

			String sql = "UPDATE user SET name = ?, birth_date = ?, password = ?, update_date = ? WHERE id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, name);
			pStmt.setString(2, birthDate);
			pStmt.setString(3, password);
			pStmt.setString(4, updateDate);
			pStmt.setString(5, id);

			int rs = pStmt.executeUpdate(sql);
			System.out.println(rs);

			pStmt.close();

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

	public void deleteUserInfo(String id) {

		Connection conn = null;

		try {

			conn = MyDBManager.getConnection();

			String sql = "DELETE FROM user WHERE id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			int rs = pStmt.executeUpdate();

			return;

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