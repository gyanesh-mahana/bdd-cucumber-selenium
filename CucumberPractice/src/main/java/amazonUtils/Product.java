package amazonUtils;

public class Product {
	private String name;
	private int price;

	public Product(String productName) {
		this.name = productName;
		this.price = 0; // TBD
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
