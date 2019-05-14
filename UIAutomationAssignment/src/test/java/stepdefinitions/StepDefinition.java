package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;

import java.io.IOException;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import resources.OpenWebsite;
import pageobjects.Signup;
import pageobjects.BuySummerDress;
import pageobjects.Login;

@RunWith(Cucumber.class)
public class StepDefinition extends OpenWebsite
{
	@Given("^Initialise browser and navigate to website$")
    public void initialise_browser_and_navigate_to_website() throws IOException
	{
        driver = initialisation();
        System.out.println("Browser and page launched.");
    }

	@When("^Register account with (.+) and (.+)$")
    public void register_account_with_and(String email, String password) throws InterruptedException
    {
    	Signup s = new Signup(driver);
    	s.signinLink().click();
    	s.email().sendKeys("woohoo");
    	s.submitEmail().click();
    	Thread.sleep(5000);
    	if(s.errorMessage().isDisplayed())
    	{
    		System.out.println("Error message is displayed: " + s.errorMessage().getText());
    	}
    	
    	Thread.sleep(5000);
    	
    	s.firstName().sendKeys("Bob");
    	s.lastName().sendKeys("the Builder");
    	s.password().sendKeys(password);
    	s.address().sendKeys("2 Nowhere street, Nowhere");
    	s.city().sendKeys("Nowhere");
    	s.stateDropdown().selectByVisibleText("Puerto Rico");
    	s.postcode().sendKeys("12345");
    	//s.countryDropdown().selectByVisibleText("United States");
    	s.mobileNumber().sendKeys("0123456789");
    	
    	s.submitButton().click();
    	System.out.println("Sign up done.");
    }

    @Then("^Buy dress$")
    public void buy_dress() throws InterruptedException
    {
        BuySummerDress bsd = new BuySummerDress(driver);
        bsd.dresses().moveToElement(driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(2) > a"))).perform();
        Thread.sleep(500);
        bsd.summerDresses().click();
        
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(driver.getTitle().equals("Summer Dresses - My Store"));
        System.out.println(driver.getTitle());
        
        //bsd.sortByDropdown().selectByVisibleText("Price: Lowest first");
        bsd.blueSummerDress().click();
        bsd.addCart().click();
        Thread.sleep(2000);
        
        String productName = bsd.productName();
        String selectedColour = bsd.selectedColour();
        String quantity = bsd.quantity();
        System.out.println(	"Add to cart page"		+
        					"\nProduct name: " 		+ productName +
        					"\nSelected colour: " 	+ selectedColour +
        					"\nQuantity: " 			+ quantity);
        
        bsd.checkout().click();
        //Thread.sleep(5000);
        
        String checkoutProductName = bsd.checkoutProductName();
        String checkoutSelectedColour = bsd.checkoutSelectedColour();
        String checkoutQuantity = bsd.checkoutQuantity();
        System.out.println(	"Cart summary page"		+
        					"\nProduct name: " 		+ checkoutProductName +
        					"\nSelected colour: " 	+ checkoutSelectedColour +
        					"\nQuantity: " 			+ checkoutQuantity);
        
        sa.assertEquals(checkoutProductName, productName);
        sa.assertEquals(checkoutSelectedColour, selectedColour);
        sa.assertEquals(checkoutQuantity, quantity);
        
        sa.assertAll();
        System.out.println("Dress bought.");
    }
    @When("^Login with (.+) and (.+)$")
    public void login_with_and(String email, String password)
    {
        Login l = new Login(driver);
        l.signinLink().click();
        l.email().sendKeys(email);
        l.password().sendKeys(password);
        l.signinButton().click();
        System.out.println("Login done.");
    }
}