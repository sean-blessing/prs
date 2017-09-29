package prs.db.product;

import java.util.ArrayList;

import prs.business.Product;

public interface ProductReader {
	public Product getProductByVendorIdAndPartNbr(int inVId, String inPartNbr);
	public ArrayList<Product> getAllProducts();
}
