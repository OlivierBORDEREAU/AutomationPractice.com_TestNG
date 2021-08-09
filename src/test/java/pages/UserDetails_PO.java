package pages;
 
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
public class UserDetails_PO {
 
 WebDriver driver;
 
 //Constructor that will be automatically called as soon as the object of the class is created
 public UserDetails_PO(WebDriver driver) {
          this.driver = driver;
 }
 
 //---------------------------------------------------------------------------------------------
 //Locator for account creation form title 
 By form_title = By.cssSelector(".info-account");

 
 //-----------------------------------------------------------------------------------------
 
 //Check Email is displayed
public void check_page(String message) {
	String exp_message = message;
	String actual = driver.findElement(form_title).getText();
    Assert.assertEquals(actual,exp_message);  
}

}