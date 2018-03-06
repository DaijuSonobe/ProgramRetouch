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
import util.Util;

public class MyUserDao {

	public MyUser findByLoginInfo(String loginId, String password) {

		Connection conn = null;

		try {

			conn = MyDBManager.getConnection();

			String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginId);
			pStmt.setString(2, Util.convertMD5(password));
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

	public MyUser findByLoginInfo(String idData) {

		Connection conn = null;

		try {

			conn = MyDBManager.getConnection();

			String sql = "SELECT * FROM user WHERE id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, idData);
			ResultSet rs = pStmt.executeQuery();

			if(!rs.next()) {
				return null;
			}

			int id = rs.getInt("id");
			String loginId = rs.getString("login_id");
			String name = rs.getString("name");
			Date birthDate = rs.getDate("birth_date");
			String password = rs.getString("password");
			String createDate = rs.getString("create_date");
			String updateDate = rs.getString("update_date");

			return new MyUser(id, loginId, name, birthDate, password, createDate, updateDate);

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
			String sql = "SELECT * FROM user WHERE login_id NOT IN ('admin')";

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

	public List<MyUser> findSearch(String loginIdData, String nameData, String birthDate1, String birthDate2){

		Connection conn = null;
		List<MyUser> userList = new ArrayList<>();

		try {

			conn = MyDBManager.getConnection();
			String sql = "SELECT * FROM user WHERE login_id NOT IN ('admin')";

			if(!loginIdData.equals("")) {
				sql += " AND login_id = '" + loginIdData + "'";
			}

			if(!nameData.equals("")) {
				sql += " AND name LIKE '%" + nameData + "%'";
			}

			if(!birthDate1.equals("") || !birthDate2.equals("")) {
				sql += " AND birth_date >= '" + birthDate1 + "' AND birth_date <= '" + birthDate2 + "'";
			}

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




	public boolean findByLoginIdInfo(String loginId) {

		Connection conn = null;

		try {

			conn = MyDBManager.getConnection();

			String sql = "SELECT * FROM user WHERE login_id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginId);
			ResultSet rs = pStmt.executeQuery();

			if(!rs.next()) {
				return false;
			}

			return true;

		}catch(SQLException e){

			e.printStackTrace();
			return false;

		}finally {

			if(conn != null) {

				try {

					conn.close();

				}catch(SQLException e) {

					e.printStackTrace();
					return false;
				}
			}
		}

	}


	public void registerUser(String loginId, String name, String birthDate, String password) {

		Connection conn = null;

		try {

			conn = MyDBManager.getConnection();

			String sql = "INSERT INTO user (login_id, name, birth_date, password, create_date, update_date) VALUE(?, ?, ?, ?, now(), now())";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginId);
			pStmt.setString(2, name);
			pStmt.setString(3, birthDate);
			pStmt.setString(4, Util.convertMD5(password));

			int rs = pStmt.executeUpdate();
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


	public void updateUserInfo(String id, String password, String name, String birthDate) {

		Connection conn = null;



		try {

			conn = MyDBManager.getConnection();

			String sql = "UPDATE user SET name = ?, birth_date = ?, password = ?, update_date = now() WHERE id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, name);
			pStmt.setString(2, birthDate);
			pStmt.setString(3, Util.convertMD5(password));
			pStmt.setString(4, id);

			int rs = pStmt.executeUpdate();
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

			System.out.println(rs);

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