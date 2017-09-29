package prs.db.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import prs.business.Product;
import prs.business.User;
import prs.db.DBUtil;

public class ProductDB implements ProductDAO {
	Connection connection = null;
	
	public ProductDB() {
		try {
			connection = DBUtil.getConnection();
		}
		catch (SQLException sqle) {
			System.out.print("Error getting connection: ");
			sqle.printStackTrace();
		}
	}
	
	private Product getProductFromResultSet(ResultSet rs) throws SQLException{
		Product p = new Product();
		p.setId(rs.getInt(1));
		p.setVendorId(rs.getInt(2));
		p.setPartNumber(rs.getString(3));
		p.setName(rs.getString(4));
		p.setPrice(rs.getDouble(5));
		p.setUnit(rs.getString(6));
		p.setPhotoPath(rs.getString(7));
		return p;
	}
	
	private ResultSet getResultSetFromQuery(String sqlStmt) throws SQLException{
		
		try
		{
			Connection connection = DBUtil.getConnection();
			PreparedStatement ps = connection.prepareStatement(sqlStmt);
			ResultSet rs = ps.executeQuery();
			return rs;
		}
		catch (SQLException sqle) {
			throw sqle;
		}

	}


	@Override
	public Product getProductByVendorIdAndPartNbr(int inVId, String inPartNbr) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean addProduct(Product p) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public ArrayList<Product> getAllProducts() {
		ArrayList<Product> products= new ArrayList<Product>();
		String sql = "Select * FROM Product ";
		try
		{
			ResultSet rs = getResultSetFromQuery(sql);
			while (rs.next()) {
				Product pdt = getProductFromResultSet(rs);
				products.add(pdt);
			}
			DBUtil.closeConnection();
		}
		catch (SQLException sqle) {
			System.out.println("Error retrieving all products!");
			sqle.printStackTrace();
		}

		return products;
	}

}
