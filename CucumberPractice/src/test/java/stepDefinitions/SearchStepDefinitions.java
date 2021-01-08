package stepDefinitions;

import static org.junit.Assert.assertEquals;

import amazonUtils.Product;
import amazonUtils.Search;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchStepDefinitions {

	Product product;
	Search search;

	@Given("I have a search field on Amazon page")
	public void i_have_a_search_field_on_amazon_page() {
		// open browser and open amazon website
		// check for the search field object
		System.out.println("Step1: I have a search field on Amazon page");
	}

//	@When("^I search for a product \"(.*?)\"$")
	@When("^I search for a product \"([^\"]*)\"$")
	public void i_search_for_a_product(String productName) {
		// search for the product name
		System.out.println("Step2: Searching for the product:" + productName);
		product = new Product(productName);
	}

	@Then("Product with name {string} is displayed")
	public void product_with_name_is_displayed(String productName) {
		// product should be displayed in the result
		System.out.println("Step3: Product: " + productName + " should be displayed");
		search = new Search(productName);
		assertEquals(productName, search.displayProduct());

	}

}
