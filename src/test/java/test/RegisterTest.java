package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.RegisterPage;
import util.BrowserFactory;

public class RegisterTest 
{
	WebDriver driver;
	
	//Test  Data
	
	String firstname = "George";
	String lastname = "Thomas";
	String email = "abc123@gmail.com";
	String companyname = "Amazon";
	String password ="abc1234";
	String confirmpwd ="abc1234";
	String expectedText ="Your registration completed";
	
	
	@Test
	public void validateUserSHouldBeAbleToRegister()
	{
		driver = BrowserFactory.init();
		RegisterPage registerpage=PageFactory.initElements(driver, RegisterPage.class);
		
		registerpage.clickRegisterField();
		registerpage.clickRadioButton();
		registerpage.selectFirstName(firstname);
		registerpage.selectLastName(lastname);
		registerpage.selectDateOfBirth();
		registerpage.selectemail(email);
		registerpage.selectCompanyName(companyname);
		registerpage.clickNewLettercheckbox();
		registerpage.selectPassword(password);
		registerpage.selectCofirmPassword(confirmpwd);
		registerpage.clickRegisterButton();
		registerpage.userAbleToRegister(expectedText);
		
		
		BrowserFactory.tearDown();
	}
	
	
}
