package com.kannanrameshrk.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.kannanrameshrk.dto.Branch;
import com.kannanrameshrk.dto.Medicine;
import com.kannanrameshrk.dto.Purchase;
import com.kannanrameshrk.dto.User;

public class Repository {
	private static Repository repository;
	List<Branch> branchData = new ArrayList<>();

	private Repository() {

	}

	public static Repository getInstance() {
		if (repository == null) {
			repository = new Repository();
		}
		return repository;
	}

	public boolean registerBranch(Branch branch) {
		PreparedStatement pstmt = null;
		Connection con;

		String query = "insert into medical_branches(name,address,phoneNumber)values(?,?,?)";
		con = DataConnection.getConnection();

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, branch.getName());
			pstmt.setString(2, branch.getAddress());
			pstmt.setString(3, branch.getPhoneNumber());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Sql Connection Err.." + e);
			return false;
		}
		return true;
	}

	public List<Branch> getBranchData() {
		PreparedStatement pstmt = null;
		Connection con;
		ResultSet rs = null;

		String query = "select * from medical_branches";
		con = DataConnection.getConnection();

		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Branch branch = new Branch();
				branch.setId(rs.getInt("id"));
				branch.setName(rs.getString("name"));
				branch.setAddress(rs.getString("address"));
				branch.setPhoneNumber(rs.getString("phoneNumber"));
				branchData.add(branch);
			}
		} catch (SQLException e) {
			System.out.println("Sql Connection Err.." + e);
		}
		return branchData;
	}

	public boolean registerMedichine(Medicine mede) {
		PreparedStatement pstmt = null;
		Connection con;

		String query = "insert into medicines(name,category,price,quantity,branch_id) values(?,?,?,?,?)";
		con = DataConnection.getConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, mede.getName());
			pstmt.setString(2, mede.getCategory());
			pstmt.setDouble(3, mede.getPrice());
			pstmt.setInt(4, mede.getQuentity());
			pstmt.setInt(5, mede.getBranchId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Sql Connection Err.." + e);
			return false;
		}

		return true;
	}

	public List<String> getGategoryData() {
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		List<String> categoryList = new ArrayList<>();

		con = DataConnection.getConnection();

		String query = "select DISTINCT category from medicines";

		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String category = rs.getString("category");
				categoryList.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return categoryList;
	}

	public int addUser(User user) {
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		int userId = 0;

		String query = "insert into users(name,address,phoneNumber,branch_id)values(?,?,?,?)";
		con = DataConnection.getConnection();

		try {
			pstmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getAddress());
			pstmt.setString(3, user.getPhoneNumber());
			pstmt.setInt(4, user.getBranch_id());
			pstmt.executeUpdate();

			int affectedRows = pstmt.executeUpdate();

			if (affectedRows > 0) {
				rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					userId = rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userId;
	}

	public double getMedicinePrice(int medicineId) {
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		double price = -1;

		con = DataConnection.getConnection();
		String query = "select price from medicines WHERE id=?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, medicineId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				price = rs.getDouble("price");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return price;
	}

	public boolean savePurchasedata(Purchase purchase) {
		PreparedStatement pstmt = null;
		Connection con = null;
		String query = "insert into purchases(userId,medicineId,dateTime,quantity,totalPrice,branch_id)values(?,?,?,?,?,?)";
		con = DataConnection.getConnection();

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, purchase.getUserId());
			pstmt.setInt(2, purchase.getMedicineId());

			LocalDateTime dateTime = purchase.getDateTime();
			Timestamp timestamp = Timestamp.valueOf(dateTime);

			pstmt.setTimestamp(3, timestamp);
			pstmt.setInt(4, purchase.getQuantity());
			pstmt.setDouble(5, purchase.getTotalPrice());
			pstmt.setInt(6, purchase.getBranchId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<Purchase> getPurchaseData() {
		List<Purchase> purchaseData = new ArrayList<>();
		PreparedStatement pstmt = null;
		Connection con;
		ResultSet rs = null;
		con = DataConnection.getConnection();

		String query = "SELECT " + "    p.dateTime AS Purchase_Date, " + "    p.quantity AS Quantity, "
				+ "    p.totalPrice AS Total_Price, " + "    u.name AS User_Name, " + "    u.address AS User_Address, "
				+ "    u.phoneNumber AS User_PhoneNumber, " + "    m.name AS Medicine_Name, "
				+ "    m.category AS Medicine_Category, " + "    mb.name AS Branch_Name, "
				+ "    mb.address AS Branch_Address, " + "    mb.phoneNumber AS Branch_PhoneNumber " + "FROM "
				+ "    purchases p " + "JOIN " + "    users u ON p.userId = u.id " + "JOIN "
				+ "    medicines m ON p.medicineId = m.id " + "JOIN "
				+ "    medical_branches mb ON u.branch_id = mb.id;";

		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Purchase purchase = new Purchase();

				purchase.setDateTime(rs.getTimestamp("Purchase_Date").toLocalDateTime());
				purchase.setQuantity(rs.getInt("Quantity"));
				purchase.setTotalPrice(rs.getDouble("Total_Price"));

				User user = new User();
				user.setUserName(rs.getString("User_Name"));
				user.setAddress(rs.getString("User_Address"));
				user.setPhoneNumber(rs.getString("User_PhoneNumber"));
				purchase.setUser(user);

				Medicine medicine = new Medicine();
				medicine.setName(rs.getString("Medicine_Name"));
				medicine.setCategory(rs.getString("Medicine_Category"));
				purchase.setMedicine(medicine);

				Branch branch = new Branch();
				branch.setName(rs.getString("Branch_Name"));
				branch.setAddress(rs.getString("Branch_Address"));
				branch.setPhoneNumber(rs.getString("Branch_PhoneNumber"));
				purchase.setBranch(branch);

				purchaseData.add(purchase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return purchaseData;
	}

	public List<Purchase> userOrderData(String phoneNumber) {
		List<Purchase> userOrders = new ArrayList<>();

		List<Purchase> allPurchases = getPurchaseData();

		for (Purchase purchase : allPurchases) {
			if (purchase.getUser().getPhoneNumber().equals(phoneNumber)) {
				userOrders.add(purchase);
			}
		}
		return userOrders;
	}
}