package amazonUtils;

import java.util.ArrayList;
import java.util.List;

public class Search {

	List<String> productList;
	String productToSearch;

	public Search(String productName) {
		// TODO Auto-generated constructor stub
		this.productToSearch = productName;
	}

	private List<String> getProductList() {
		productList = new ArrayList<String>();

		// search logic here
		// use this.productToSearch to find the result
		// add the results into th eproductList

		productList.add("Apple");
		productList.add("Investment");
		productList.add("Intelligent");
		productList.add("Intelligent Investor");

		return productList;
	}

	public String displayProduct() {
		if (getProductList().contains(this.productToSearch)) {
			return this.productToSearch;
		} else {
			return null;
		}
	}

}
