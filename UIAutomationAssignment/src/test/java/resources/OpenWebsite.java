package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenWebsite
{
	public WebDriver driver;
	public WebDriver initialisation() throws IOException
	{
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream("src\\test\\java\\resources\\data.properties");
		p.load(fis);
		
		String url = p.getProperty("url");
		String browser = p.getProperty("browser");
		// Change browser variable in data.properties to switch between Firefox and Chrome
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","..\\..\\Downloads\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(url);
		}
		else if(browser.equals("firefox"))
		{// Firefox has a "Could not be scrolled into view" error.
			System.setProperty("webdriver.gecko.driver", "..\\..\\Downloads\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(url);
		}
		return driver;
	}
}
