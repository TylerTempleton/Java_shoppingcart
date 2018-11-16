package ca.sheridancollege.DAO;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.mysql.jdbc.Connection;

import ca.sheridancollege.controllers.AddToCart;
import ca.sheridancollege.beans.Item;

/**
 * Servlet implementation class Dao
 */
@WebServlet("/Dao")
public class DAO {
	Double x= 0.0 ;
	@SuppressWarnings("unused")
	private Connection conn;
	private String user = "root";
	private String password = "1234";

	public DAO(String databaseName) {
		String dbURL = "jdbc:mysql://localhost/" + databaseName;
		try {
			conn = (Connection) DriverManager.getConnection(dbURL, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public DAO(String databaseAddress, String databaseName) {
		String dbURL = "jdbc:mysql://" + databaseAddress + "/" + databaseName;
		try {
			conn = (Connection) DriverManager.getConnection(dbURL, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public DAO(String databaseName, String user, String password) {
		String dbURL = "jdbc:mysql://localhost/" + databaseName;
		try {
			conn = (Connection) DriverManager.getConnection(dbURL, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}}
		

	
	
	public List<Item> selectItemList() {
		Connection con = null;
		java.sql.PreparedStatement ps;
		ResultSet rs;

		ArrayList<Item> list = new ArrayList<Item>();

		String sql = "SELECT * FROM final.items";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment2", "root", "1234");
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery("select * from final.items");

			while (rs.next()) {
				Item item = new Item();

				item.setItemId(rs.getInt("itemId"));
                item.setItemName(rs.getString("itemName"));
                item.setItemPrice(rs.getDouble("itemPrice"));
                list.add(item);
			}
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		} finally {
			System.out.close();
		}
		System.out.println(list);
		return list;
	}

	public List<Item> addShoppingItemList() {
		// TODO Auto-generated method stub
		Connection con = null;
		java.sql.PreparedStatement ps;
		ResultSet rs;

		ArrayList<Item> list2 = new ArrayList<Item>();
		String cartid=AddToCart.addToCartId;
		String sql = "SELECT * FROM final.items WHERE itemId='"+cartid+"'";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment2", "root", "1234");
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
			Item item2 = new Item();
			
			item2.setItemId(rs.getInt("itemId"));

			item2.setItemName(rs.getString("itemName"));

			item2.setItemPrice(rs.getDouble("itemPrice"));

			list2.add(item2);
			
			}
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		} finally {
			System.out.close();
		}
		System.out.println(list2);
		return list2;
	
	}
	
	
	
	public void purchaselog(String message) {  
		
		
		String sql = "INSERT INTO final.purchases(cardNum, amount) VALUES (?, ?)";

		PreparedStatement ps = null;
		try {
			ps.setCardNum(1,(getCardNum()));
			ps.setAmount(2, (getDouble(amount));
		try {

			ps = conn.prepareStatement(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}
	@SuppressWarnings("unused")
	private void close(PreparedStatement ps) {
		try {
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private void close(Statement s) {
		try {
			s.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}