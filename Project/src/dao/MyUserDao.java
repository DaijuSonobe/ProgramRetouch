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

			retrun new MyUser(loginIdData, nameData);

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
			}

		}

	}

}

//public List<User> findAll() {
//    Connection conn = null;
//    List<User> userList = new ArrayList<User>();
//
//    try {
//        // データベースへ接続
//        conn = DBManager.getConnection();
//
//        // SELECT文を準備
//        // TODO: 未実装：管理者以外を取得するようSQLを変更する
//        String sql = "SELECT * FROM user";
//
//         // SELECTを実行し、結果表を取得
//        Statement stmt = conn.createStatement();
//        ResultSet rs = stmt.executeQuery(sql);
//
//        // 結果表に格納されたレコードの内容を
//        // Userインスタンスに設定し、ArrayListインスタンスに追加
//        while (rs.next()) {
//            int id = rs.getInt("id");
//            String loginId = rs.getString("login_id");
//            String name = rs.getString("name");
//            Date birthDate = rs.getDate("birth_date");
//            String password = rs.getString("password");
//            String createDate = rs.getString("create_date");
//            String updateDate = rs.getString("update_date");
//            User user = new User(id, loginId, name, birthDate, password, createDate, updateDate);
//
//            userList.add(user);
//        }
//    } catch (SQLException e) {
//        e.printStackTrace();
//        return null;
//    } finally {
//        // データベース切断
//        if (conn != null) {
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//                return null;
//            }
//        }
//    }
//    return userList;
//}
//}


