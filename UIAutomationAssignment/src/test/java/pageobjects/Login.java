package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login
{
	WebDriver driver;
	public Login(WebDriver driver)
	{
		this.driver = driver;
	}
	By signinLink 		= By.linkText("Sign in");
	By email 			= By.id("email");
	By password			= By.id("passwd");
	By signinButton 	= By.id("SubmitLogin");
	
	public WebElement signinLink()
	{
		return driver.findElement(signinLink);
	}
	public WebElement email()
	{
		return driver.findElement(email);
	}
	public WebElement password()
	{
		return driver.findElement(password);
	}
	public WebElement signinButton()
	{
		return driver.findElement(signinButton);
	}
}
