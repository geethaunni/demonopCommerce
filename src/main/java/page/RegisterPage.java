package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegisterPage extends BasePage
{

	WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		this.driver= driver;
	}
	
	// List of Elements
	@FindBy(how = How.XPATH, using = "//a[@class='ico-register']")
	WebElement registerFieldElement;
	@FindBy(how=How.ID,using="gender-male")
	WebElement selectGenderRadioButton;
	@FindBy(how = How.ID , using ="FirstName")
	WebElement fristNameElement;
	@FindBy (how = How.ID , using ="LastName")
	WebElement lastNameElement;
	@FindBy (how = How.NAME ,using="DateOfBirthDay")
	WebElement birthday;
	@FindBy (how = How.NAME , using = "DateOfBirthMonth")
	WebElement birthmonth;
	@FindBy (how = How.NAME , using = "DateOfBirthYear")
	WebElement birthyear;
	@FindBy (how =How.ID ,using="Email")
	WebElement emailElement;
	@FindBy (how = How.ID , using = "Company")
	WebElement companyNameElement;
	@FindBy (how = How.ID , using = "Newsletter")
	WebElement newLetterElement;
	@FindBy (how = How.ID, using = "Password")
	WebElement passwordElement;
	@FindBy (how = How.NAME  , using = "ConfirmPassword")
	WebElement confirmPasswordElement;
	@FindBy (how = How.ID, using = "register-button")
	WebElement registerButtonElement;
	@FindBy (how = How.XPATH, using = "//div[text() ='Your registration completed']")
	WebElement registrationCompletedElement;
	
	
	public void clickRegisterField() {// for click - no need parameters
	 registerFieldElement.click();
	 	}
	public void clickRadioButton()	{
		selectGenderRadioButton.click();
	}
	public void selectFirstName(String firstname){
		fristNameElement.sendKeys(firstname);
	}
	public void selectLastName(String lastname)	{
		lastNameElement.sendKeys(lastname);
	}
	
	public void selectDateOfBirth() {
		
		WebElement dayofBirth = driver.findElement((By.name("DateOfBirthDay")));
		WebElement dayofMonth = driver.findElement((By.name("DateOfBirthMonth")));
		WebElement birthYear = driver.findElement((By.name("DateOfBirthYear")));
		
		RegisterPage selDay = new RegisterPage(driver);
		selDay.selectFromDropdown(dayofBirth, "25");
		selDay.selectFromDropdown(dayofMonth, "April");
		selDay.selectFromDropdown(birthYear, "1974");
		
	
	}
	public void selectemail(String  email)	{
	emailElement.sendKeys(generateRandomNum(9999)+email);	
	}
	public void selectCompanyName(String companyName) {
		companyNameElement.sendKeys(generateRandomNum(9999)+companyName);
	}
	public void clickNewLettercheckbox() {
	newLetterElement.click();
	}
	public void selectPassword(String password) {
		passwordElement.sendKeys(password);
	}
	public void selectCofirmPassword(String confirmpassword) {
		confirmPasswordElement.sendKeys(confirmpassword);
	}
	public void clickRegisterButton() {
		registerButtonElement.click();
	}
	public void userAbleToRegister(String expectedText)	{
		Assert.assertEquals(registrationCompletedElement.getText(), expectedText, "message not found");
	}
}

	
	
	 
	
	

