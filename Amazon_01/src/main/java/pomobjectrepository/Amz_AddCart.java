package pomobjectrepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import generics.PageUtility;
/**
 * 
 * @author Kavita
 *
 */
public class Amz_AddCart extends PageUtility
{
	 WebDriver driver;
	 	 
	 //@FindBy(id="add-to-cart-button")
	// @FindBy(xpath="//i[@class='a-icon a-icon-cart']")
	 @FindBy(xpath="//span[@id='submit.add-to-cart']")
	 WebElement addtocart;
	  //1. locating each components using @FindBy annotation
	 
	 //locating proceed to checkout button
	// @FindBy(xpath="//input[@value='Proceed to checkout']")
	 @FindBy(id="sw-ptc-form")
	 ////form[@id='sw-ptc-form']
	 WebElement proceed_to_buy;
	 
	 @FindBy(xpath="//span[@id='orderSummaryPrimaryActionBtn']")
	 WebElement use_this_address;
	 
	 //cash on delivery
	 @FindBy(xpath="(//input[@name='ppw-instrumentRowSelection'])[5]")
	 WebElement cash_on_delivery_radio_btn;
	 
	 //credit card
	 @FindBy(xpath="(//input[@name='ppw-instrumentRowSelection'])[1]")
	 WebElement cradit_card_radio_btn;
	 
	 // click on enter credit card details
	 @FindBy(xpath="//div[@class='a-row pmts-add-cc-default-trigger']")
	 WebElement enter_card_details;
	 
	 //emi 
	 @FindBy(xpath="(//input[@name='ppw-instrumentRowSelection'])[4]")
	 WebElement emi_radio_btn;
	 
	 //netbanking 
	 @FindBy(xpath="(//input[@name='ppw-instrumentRowSelection'])[2]")
	 WebElement netbanking_radio_btn;
	 
	 //others upi 
	 @FindBy(xpath="(//input[@name='ppw-instrumentRowSelection'])[3]")
	 WebElement othersUPI_radio_btn;
	 
	 /* card number */
	 @FindBy(xpath="//input[@class='a-input-text a-form-normal pmts-account-Number']")
	 WebElement card_num;
	 
	 /* month list */
	 @FindBy(xpath="//select[@name='ppw-expirationDate_month']")
	 WebElement month_list;
	 
	 /* year list */
	 @FindBy(xpath="//select[@name='ppw-expirationDate_year']")
	 WebElement year_list;
	 
	 /* enter card details button */
	 @FindBy(xpath="//span[@class='a-button a-button-primary pmts-button-input']")
	 WebElement entercarddetails_btn;
	 
	 /*  cancel button  */
	 @FindBy(xpath="//span[@class='a-button a-button-base pmts-button-input']")
	 WebElement cancel_btn;
	 
	//2. intilaizing each component using page factory class
	 public void addtocart(WebDriver driver) 
	 {
		 addtocart.click();		 
	 }
	 
	 // click on proceed to buy 
	 public void proceed_to_checkout() {
		 proceed_to_buy.click();
	 }
	 //click on use this address button
	 public void usethisaddress()
	 {
		 use_this_address.click();
	 }
	 // selecting cash on delivery
	 public void cashondelivery() {
		 cash_on_delivery_radio_btn.click();
	 }
	 // selecting cradit card
	 public void creditcard() {
		 cradit_card_radio_btn.click();
		
	 }
	 
	 public void entercard_details(WebDriver driver)
	 {
		 enter_card_details.click();
		// switch to frame
					driver.switchTo().frame(0);
	 }
	 
	 public void carddetails_entering()
	 {
		 card_num.sendKeys("4725 2589 6325 4152");	
		 selectbyindex(month_list,04);
		 selectbyValue(year_list,"2026");
		// entercarddetails_btn.click();
		 cancel_btn.click();
	 }
	 
	// selecting EMI
	public void emi_payment() {
			 emi_radio_btn.click();
	}
		 
	// selecting netbanking
	public void netbanking_payment() {
		netbanking_radio_btn.click();
		}
	
	// selecting others UPI
		public void others_UPI_payment() {
			othersUPI_radio_btn.click();
			//switchtoparentwindow(driver);
			}
	  
	//3. intilaizing each component using page factory class
	 
	 public Amz_AddCart(WebDriver driver)
	  {
		  PageFactory.initElements(driver,this);
	  }
	  
	 
	  
	  
	 
}
