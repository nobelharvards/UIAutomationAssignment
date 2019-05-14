package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Signup
{
	WebDriver driver;
	public Signup (WebDriver driver)
	{
		this.driver = driver;
	}
	By signinLink 		= By.linkText("Sign in");
	By email 			= By.id("email_create");
	By submitEmail 		= By.name("SubmitCreate");
	By errorMessage 	= By.id("create_account_error");
	
	By firstName 		= By.id("customer_firstname");
	By lastName 		= By.id("customer_lastname");
	By password 		= By.id("passwd");
	By address 			= By.id("address1");
	By city 			= By.id("city");
	By stateDropdown 	= By.id("id_state");
	By postcode 		= By.id("postcode");
	By countryDropdown 	= By.id("id_country");
	By mobileNumber 	= By.id("phone_mobile");
	
	By submitButton 	= By.id("submitAccount");
	
	public WebElement signinLink()
	{
		return driver.findElement(signinLink);
	}
	public WebElement email()
	{
		return driver.findElement(email);
	}
	public WebElement submitEmail()
	{
		return driver.findElement(submitEmail);
	}
	public WebElement errorMessage()
	{
		return driver.findElement(errorMessage);
	}
	public WebElement firstName()
	{
		return driver.findElement(firstName);
	}
	public WebElement lastName()
	{
		return driver.findElement(lastName);
	}
	public WebElement password()
	{
		return driver.findElement(password);
	}
	public WebElement address()
	{
		return driver.findElement(address);
	}
	public WebElement city()
	{
		return driver.findElement(city);
	}
	public Select stateDropdown()
	{
		WebElement statewb = driver.findElement(stateDropdown);
		Select stateDropdown = new Select(statewb);
		return stateDropdown;
	}
	public WebElement postcode()
	{
		return driver.findElement(postcode);
	}
	public Select countryDropdown()
	{
		WebElement countrywb = driver.findElement(countryDropdown);
		Select countryDropdown = new Select(countrywb);
		return countryDropdown;
	}
	public WebElement mobileNumber()
	{
		return driver.findElement(mobileNumber);
	}
	public WebElement submitButton()
	{
		return driver.findElement(submitButton);
	}
}
