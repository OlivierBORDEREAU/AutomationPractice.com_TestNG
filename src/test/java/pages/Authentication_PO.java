package pages;
 
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
public class Authentication_PO {
 
 WebDriver driver;
 
 //Constructor that will be automatically called as soon as the object of the class is created
 public Authentication_PO(WebDriver driver) {
          this.driver = driver;
 }
 
 //---------------------------------------------------------------------------------------------
 //Locator for email field
 By email = By.id("email");
 
 //Locator for email field
 By passwd = By.id("passwd");
 
 //Locator for submit field
 By SubmitLogin = By.id("SubmitLogin");
 
 //Locator for email - Account Creation field
 By emailCreation = By.id("email_create");
 
 //Locator for submit creation field
 By submitCreation = By.id("SubmitCreate");

 //error message when try to create an already existing account
 By errormessage = By.cssSelector("#create_account_error > ol > li");
 
 //-----------------------------------------------------------------------------------------
 //Function to click on Login button
 public void authenticate_user(String email_adress, String password) {
 	driver.findElement(email).sendKeys(email_adress);
    driver.findElement(passwd).sendKeys(password);
    driver.findElement(SubmitLogin).click();  
 }
 //Function to create User
 public void create_user(String email_adress) {
		driver.findElement(emailCreation).sendKeys(email_adress);
		driver.findElement(submitCreation).click();
 }
//Check Message
 public void check_message(String message) {
		String exp_message = message;
    	String actual = driver.findElement(errormessage).getText();
        Assert.assertEquals(actual, exp_message);
 }
 
}

