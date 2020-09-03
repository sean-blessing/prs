package prs.business;

import java.io.Serializable;

import prs.util.StringUtil;

public class Product implements Serializable {
	private int id;
	private int vendorId;
	private String partNumber;
	private String name;
	private double price;
	private String unit;
	private String photoPath;

	public Product() {
		
	}
	
	public Product(int inId, int inVId, String inPartNbr, String inName, double inPrice, 
					String inUnit, String inPhotoPath) {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	
	public String getPriceFormatted() {
		return StringUtil.getCurrencyFormat(getPrice());
	}
}
