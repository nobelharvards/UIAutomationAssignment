package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BuySummerDress
{
	WebDriver driver;
	public BuySummerDress(WebDriver driver)
	{
		this.driver = driver;
	}
	By dresses					= By.cssSelector("#block_top_menu > ul > li:nth-child(2) > a");
	By summerDresses 			= By.cssSelector("#block_top_menu > ul > li:nth-child(2) > ul > li:nth-child(3) > a");
	By sortBy 					= By.id("selectProductSort");
	By blueSummerDress 			= By.id("color_20");
	By productName				= By.id("layer_cart_product_title");
	By selectedColour			= By.id("layer_cart_product_attributes");
	By quantity					= By.id("layer_cart_product_quantity");
	By addCart 					= By.name("Submit");
	By checkout 				= By.linkText("Proceed to checkout");
	By checkoutProductName		= By.linkText("Printed Summer Dress");
	By checkoutSelectedColour 	= By.cssSelector("a[title = 'Product detail']");
	By checkoutQuantity 		= By.cssSelector("span[class = 'quantity']");
	
	public Actions dressesHover()
	{
		Actions dressHover = new Actions(driver);
		return dressHover;
	}
	public WebElement dresses()
	{
		return driver.findElement(dresses);
	}
	public WebElement summerDresses()
	{
		return driver.findElement(summerDresses);
	}
	public Select sortByDropdown()
	{
		WebElement sortBywb = driver.findElement(sortBy);
		Select sortByDropdown = new Select(sortBywb);
		return sortByDropdown;
	}
	public WebElement blueSummerDress()
	{
		return driver.findElement(blueSummerDress);
	}
	public String productName()
	{
		return driver.findElement(productName).getText();
	}
	public String selectedColour()
	{
		return driver.findElement(selectedColour).getText();
	}
	public String quantity()
	{
		return driver.findElement(quantity).getText();
	}
	public WebElement addCart()
	{
		return driver.findElement(addCart);
	}
	public WebElement checkout()
	{
		return driver.findElement(checkout);
	}
	public String checkoutProductName()
	{
		return driver.findElement(checkoutProductName).getText();
	}
	public String checkoutSelectedColour()
	{
		return driver.findElement(checkoutSelectedColour).getAttribute("textContent");
	}
	public String checkoutQuantity()
	{
		return driver.findElement(checkoutQuantity).getAttribute("textContent");
	}
}
