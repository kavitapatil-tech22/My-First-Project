package pomobjectrepository;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import generics.PageUtility;
/**
 * 
 * @author Kavita
 *
 */
public class Amz_Home extends PageUtility
{
  WebDriver driver;
  //1. locating each components using @FindBy annotation
  /* search input box  */
  @FindBy(id="twotabsearchtextbox") 
  WebElement serach_tf;
  
  @FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']")
  WebElement account;
  
  /* sign out link */
  //@FindBy(id="nav-item-signout")
  @FindBy(xpath="//a[@id='nav-item-signout']")
  WebElement signout;
  
  @FindBy(xpath="(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")
  WebElement first_shoes;
  
  /* buy now button    */
  @FindBy(id="submit.buy-now")
  WebElement buy_now;
  
  /*   */
  @FindBy(xpath="//span[text()='Your Account']")
  WebElement your_account;
 
 //2. creating the method for each component to perform its action
  
 // search any product - shoes for women
  public void seraching_the_product()
  {
	  serach_tf.sendKeys("shoes for women");
	  serach_tf.sendKeys(Keys.ENTER);
  }
	// mouse over on the account
  public void mouseOver_account(WebDriver driver2) 
  {		
		 Actions actions=new Actions(driver2);		
		 actions.moveToElement(account).perform();
  }
  // click on first product shoes
  public void clickOnFirstShoes(WebDriver driver) {
	    first_shoes.click();    
	    switchtochildWindow(driver);//
  }   
  // click on buy now
  public void buynow(WebDriver driver) {
	  buy_now.click();
	  switchtochildWindow(driver);
  } 
  /* click on your account link  */
  public void yourAccount() {
	  your_account.click();
  }
  
  // click on logout
  public void logout() 
  {		
		signout.click(); 
  }   
//3. intilaizing each component using page factory class
  public Amz_Home(WebDriver driver)
  {
	  PageFactory.initElements(driver,this);
  }

}
