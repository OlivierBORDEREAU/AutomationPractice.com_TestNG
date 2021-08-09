package pages;
 
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
public class Homepage_PO {
 
 WebDriver driver;
 
 //Constructor that will be automatically called as soon as the object of the class is created
 public Homepage_PO(WebDriver driver) {
          this.driver = driver;
 }
 
 //Locator for username field
 By Sign_In_Link = By.linkText("Sign in");

 //Method to click on Login button
 public void click_sign_in() {
 driver.findElement(Sign_In_Link).click();
 }
 
 //Check the sign_in button is present
 public void check_sign_in() {
 	Boolean Display = driver.findElement(Sign_In_Link).isDisplayed();
 	Assert.assertTrue(Display, "Sign-In link is displayed");
 
 }
}

