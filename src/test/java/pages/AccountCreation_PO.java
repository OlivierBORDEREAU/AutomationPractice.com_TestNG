package pages;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountCreation_PO {
	 WebDriver driver;
	 
	 //Constructor that will be automatically called as soon as the object of the class is created
	 public AccountCreation_PO(WebDriver driver) {
	          this.driver = driver;
	 }
 
//---------------------------------------------------------------------------------------------
//Locator for account creation form title 
By form_title = By.cssSelector("#account-creation_form > div:nth-child(1) > h3");

 
//Mr-Ms checkbox 
By Mr_radio = By.id("id_gender1");
By Ms_radio = By.id("id_gender2");

//FirstName
By firstname_field = By.id("customer_firstname");

//Lastname
By lastname_field = By.id("customer_lastname");

//Email field
By email_field = By.id("email");
 
//Password
By Password_field = By.id("passwd");

//Date of Birth
By Day_Birth_List = By.id("days");
By Month_Birth_List = By.id("months");
By Year_Birth_List = By.id("years");

//Advertising
By Newsletter_checkbox = By.id("newsletter");
By Offers_checkbox = By.id("uniform-optin");

//Address
By firstname_address_field = By.id("firstname");
By lastname_address_field = By.id("lastname");
By company_address_field = By.id("company");
By address1_address_field = By.id("address1");
By address2_address_field = By.id("address2");
By city_address_field = By.id("city");
By state_address_list = By.id("id_state");
By postcode_address_field = By.id("postcode");
By country_address_list = By.id("id_country");
By additional_address_field = By.id("other");
By landline_address_field = By.id("phone");
By mobile_address_field = By.id("phone_mobile");
By alias_address_field = By.id("alias");

//Register
By Register_button = By.id("submitAccount");


//-----------------------------------------------------------------------------------------
//Check the message on the page
public void check_page(String expected_message) {
		String exp_message = expected_message;
		String actual = driver.findElement(form_title).getText();
			Assert.assertEquals(actual, exp_message);
}

//Check the email string is correct
public void check_mail(String email) {
		String exp_message = email;
		String actual = driver.findElement(email_field).getAttribute("value");
			Assert.assertEquals(actual, exp_message);
}

}
