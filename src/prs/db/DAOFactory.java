package prs.db;

import prs.db.user.UserDAO;
import prs.db.user.UserDB;
import prs.db.product.ProductDAO;
import prs.db.product.ProductDB;


public class DAOFactory {
	public static UserDAO getUserDAO() {
		UserDAO uDAO = new UserDB();
		return uDAO;
	}

	public static ProductDAO getProductDAO() {
		ProductDAO pDAO = new ProductDB();
		return pDAO;
	}
}