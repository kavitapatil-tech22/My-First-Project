package pomobjectrepository;
//import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import generics.ExcelUtilities;
//import generics.LaunchandQuit;
public class Amz_Login
{
	 WebDriver driver;
	  ExcelUtilities ex1=new ExcelUtilities();
//	  String username1 = null;
//	  String password1 = null;
		 
  //1. locating each components using @FindBy annotation
  @FindBy(id="ap_email") 
  WebElement username;
  
  @FindBy(id="continue") 
  WebElement username_submit;
  
  @FindBy(name="password") 
  WebElement password;

  @FindBy(xpath="//input[@id='signInSubmit']") 
  WebElement signin_button;

 
  
  //2. creating the method for each componenet to perform its action
  
  public void userName(String un) 
  {
	  
	  //username.sendKeys(file.getPropertyData("username"));	// using data properties file is  old fashion to write so commented
	  
	 // username.sendKeys(excedata.getusername("username"));
	  
	  //username.sendKeys(ex1.getusername(username1));   // getting data from data.properties file - its working
	  
	  username.sendKeys(un);
  }
  public void un_submit()
  {
	  username_submit.click();
  }
  public void password(String pwd) 
  {
	  //password.sendKeys(file.getPropertyData("password"));
	  //password is mentioned below
	 // password.sendKeys(ex1.getpwd(password1)); //// getting data from data.properties file - its working
	  
	  password.sendKeys(pwd);
  }
  public void signin()
  {
	  signin_button.click();
  }
  //3. initilizaing each component using page factory class
  
  public Amz_Login(WebDriver driver)
  {
	  PageFactory.initElements(driver,this);
  }
  
  
}
