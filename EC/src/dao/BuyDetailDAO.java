package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import base.DBManager;
import beans.BuyDataBeans;
import beans.BuyDetailDataBeans;
import beans.ItemDataBeans;

public class BuyDetailDAO {
	//インスタンスオブジェクトを返却させてコードの簡略化
	public static BuyDetailDAO getInstance() {
		return new BuyDetailDAO();
	}

	/**
	 * 購入詳細登録処理
	 * @param bddb BuyDetailDataBeans
	 * @throws SQLException
	 * 			呼び出し元にスローさせるため
	 */
	public static void insertBuyDetail(BuyDetailDataBeans bddb) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement(
					"INSERT INTO t_buy_detail(buy_id,item_id) VALUES(?,?)");
			st.setInt(1, bddb.getBuyId());
			st.setInt(2, bddb.getItemId());
			st.executeUpdate();
			System.out.println("inserting BuyDetail has been completed");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	/**
	 * 購入IDによる購入情報検索
	 * @param buyId
	 * @return {BuyDataDetailBeans}
	 * @throws SQLException
	 */
	public ArrayList<BuyDetailDataBeans> getBuyDataBeansListByBuyId(int buyId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement("SELECT * FROM t_buy_detail WHERE buy_id = ?");
			st.setInt(1, buyId);

			ResultSet rs = st.executeQuery();
			ArrayList<BuyDetailDataBeans> buyDetailList = new ArrayList<BuyDetailDataBeans>();

			while (rs.next()) {
				BuyDetailDataBeans bddb = new BuyDetailDataBeans();
				bddb.setId(rs.getInt("id"));
				bddb.setBuyId(rs.getInt("buy_id"));
				bddb.setItemId(rs.getInt("item_id"));
				buyDetailList.add(bddb);
			}

			System.out.println("searching BuyDataBeansList by BuyID has been completed");
			return buyDetailList;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	 /**
     * 購入IDによる購入詳細情報検索
     * @param buyId
     * @return buyDetailItemList ArrayList<ItemDataBeans>
     *             購入詳細情報のデータを持つJavaBeansのリスト
     * @throws SQLException
     */
	public static ArrayList<ItemDataBeans> getItemDataBeansListByBuyId(int buyId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement(
					"SELECT m_item.id,"
					+ " m_item.name,"
					+ " m_item.price"
					+ " FROM t_buy_detail"
					+ " JOIN m_item"
					+ " ON t_buy_detail.item_id = m_item.id"
					+ " WHERE t_buy_detail.buy_id = ?");
			st.setInt(1, buyId);

			ResultSet rs = st.executeQuery();
			ArrayList<ItemDataBeans> buyDetailItemList = new ArrayList<ItemDataBeans>();

			while (rs.next()) {
				ItemDataBeans idb = new ItemDataBeans();
				idb.setId(rs.getInt("id"));
				idb.setName(rs.getString("name"));
				idb.setPrice(rs.getInt("price"));


				buyDetailItemList.add(idb);
			}

			System.out.println("searching ItemDataBeansList by BuyID has been completed");
			return buyDetailItemList;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

//	以下追加するメソッド*2
	 /**
    * userIDによる購入履歴情報検索
    * @param buyId
    * @return buyDetailItemList ArrayList<ItemDataBeans>
    *             購入履歴情報のデータを持つJavaBeansのリスト
    * @throws SQLException
    */
	public static ArrayList<BuyDataBeans> getItemDataBeansListByUserId(int userId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

//			st = con.prepareStatement(
//					"SELECT buy_id, create_date, total_price, m_delivery_method.name FROM t_buy"
//					+ " JOIN t_buy_detail"
//					+ " ON t_buy.id = t_buy_detail.buy_id"
//					+ " JOIN m_item"
//					+ " ON t_buy_detail.item_id = m_item.id"
//					+ " JOIN m_delivery_method"
//					+ " ON t_buy.delivery_method_id = m_delivery_method.id"
//					+ " WHERE t_buy.user_id = ?");
//			st.setInt(1, userId);

			ResultSet rs = st.executeQuery();
			ArrayList<BuyDataBeans> buyDetailItemList = new ArrayList<>();

			while (rs.next()) {
				BuyDataBeans bdb = new BuyDataBeans();
				bdb.setBuyId(rs.getInt("buy_id"));
				bdb.setItemNm(rs.getString("m_item.name"));
				bdb.setPrice(rs.getInt("price"));
				bdb.setTotalPrice(rs.getInt("total_price"));
				bdb.setDetail(rs.getString("detail"));
				bdb.setDeliveryMethodName(rs.getString("m_delivery_method.name"));
				bdb.setBuyDate(rs.getDate("create_date"));

				buyDetailItemList.add(bdb);
			}

			System.out.println("searching ItemDataBeansList by BuyID has been completed");
			return buyDetailItemList;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public static ArrayList<BuyDataBeans> getAllItemDataBeansListByBuyId(String buyId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement(
					"SELECT * FROM t_buy"
					+ " JOIN t_buy_detail"
					+ " ON t_buy.id = t_buy_detail.buy_id"
					+ " JOIN m_item"
					+ " ON t_buy_detail.item_id = m_item.id"
					+ " JOIN m_delivery_method"
					+ " ON t_buy.delivery_method_id = m_delivery_method.id"
					+ " WHERE t_buy_detail.buy_id = ?");
			st.setString(1, buyId);

			ResultSet rs = st.executeQuery();
			ArrayList<BuyDataBeans> buyDetailItemList = new ArrayList<>();

			while (rs.next()) {
				BuyDataBeans bdb = new BuyDataBeans();
				bdb.setItemNm(rs.getString("m_item.name"));
				bdb.setPrice(rs.getInt("price"));
				bdb.setTotalPrice(rs.getInt("total_price"));
				bdb.setDetail(rs.getString("detail"));
				bdb.setDeliveryMethodName(rs.getString("m_delivery_method.name"));
				bdb.setDeliveryMethodPrice(rs.getInt("m_delivery_method.price"));
				bdb.setBuyDate(rs.getDate("create_date"));

				buyDetailItemList.add(bdb);
			}

			System.out.println("searching ItemDataBeansList by BuyID has been completed");
			return buyDetailItemList;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}
}
