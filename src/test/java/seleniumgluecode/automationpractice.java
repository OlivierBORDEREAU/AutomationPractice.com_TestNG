package seleniumgluecode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import data.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import pages.Homepage_PO;
import pages.Authentication_PO;
import pages.AccountCreation_PO;
import pages.UserDetails_PO;


public class automationpractice {
    public WebDriver driver;
    public Homepage_PO homePage;
    public Authentication_PO authenticationPage;
    public AccountCreation_PO creationPage;
    public UserDetails_PO userPage;

    
    String email;

    String userName = ""+(int)(Math.random()*Integer.MAX_VALUE);
    String emailID = "User"+userName+"@example.com";
    String password = "User" + userName;

  
@Before
public void setup(){
	ChromeOptions options = new ChromeOptions();
	driver = new ChromeDriver(options);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(Constants.URL);
	
	//Creating object of pages
	homePage = new Homepage_PO(driver);
	authenticationPage = new Authentication_PO(driver);
	creationPage = new AccountCreation_PO(driver);
	userPage = new UserDetails_PO(driver);

}

    @Given("^user is on homepage$")
    public void user_is_on_homepage() throws Throwable {   
    	homePage.check_sign_in();
    }
        
    @When("^(.*) user navigates to Login Page$")
    public void user_navigates_to_Login_Page(String userType) throws Throwable {
    	switch (userType) {
        case "an already known":  email = Constants.email_existing;break;
        case "a new" : email = emailID;break;
    	}
    	homePage.click_sign_in();
    }
    
    @And("^user enters email and Password$")
    public void user_enters_email_and_Password() throws Throwable {
    	authenticationPage.authenticate_user(email, Constants.password_existing);
    }
    
    @Then("success message {string} is displayed")
    public void success_message_is_displayed(String message) throws Throwable {
    	userPage.check_page(message);
    } 
      	
    @When("enters his e-mail")
   	public void enters_his_e_mail() {
    	authenticationPage.create_user(email);
    }
     	
	@Then("^user is sent to the account creation page$")
	public void user_is_sent_to_the_account_creation_page() throws Throwable {
		creationPage.check_page("YOUR PERSONAL INFORMATION");
	}

	@And("the e-mail matches")
	public void the_e_mail_matches_the_one_entered_previously() {
		creationPage.check_mail(email);
    }
	
	@And("enters an already used email")
	public void enters_an_already_used_email() {
		authenticationPage.create_user(email);
	}
	
	@Then("the error message {string} appears because the account already exists")
	public void the_error_message_appears_because_the_account_already_exists(String message) {
		authenticationPage.check_message(message);
	}
	
@After
public void tearDown(Scenario scenario) {
    if (scenario.isFailed()) {
      // Take a screenshot...
      final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
      scenario.attach(screenshot, "image/png", "Failure");
      }
    driver.quit();
}   

}