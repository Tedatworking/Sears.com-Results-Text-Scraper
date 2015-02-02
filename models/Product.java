package models;

/*
 * This is the model of product.
 * It consist of three parts: name of product, price of product and the information of vendor
 */
public class Product {
	private String productName;
	private String productPrice;
	private String productVendor;
	
	public Product(){}
	public Product(String name, String price, String vendor){
		this.productName = name;
		this.productPrice = price;
		this.productVendor = vendor;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductVendor() {
		return productVendor;
	}
	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}
}
