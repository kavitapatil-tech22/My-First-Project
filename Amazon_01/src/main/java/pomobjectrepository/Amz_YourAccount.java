package pomobjectrepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generics.ExcelUtilities;
import generics.PageUtility;
/**
 * 
 * @author Kavita
 *
 */
public class Amz_YourAccount extends PageUtility
{
	WebDriver driver;
	ExcelUtilities ex1=new ExcelUtilities();
	/* locating each element  */
	@FindBy(xpath="(//div[@class='a-column a-span9 a-span-last'])[4]")
	WebElement your_address;
	
	@FindBy(xpath="//a[@id='ya-myab-address-edit-btn-0']")
	WebElement edit_address;
	
	@FindBy(xpath="//select[@name='address-ui-widgets-countryCode']")
	WebElement country;
	
	@FindBy(id="address-ui-widgets-enterAddressFullName")
	WebElement full_name;
	
	@FindBy(xpath="//input[@id='address-ui-widgets-enterAddressPhoneNumber']")
	WebElement mobile_num;
	
	@FindBy(xpath="//input[@id='address-ui-widgets-enterAddressPostalCode']")
	WebElement pin_code;
	
	@FindBy(xpath="//input[@id='address-ui-widgets-enterAddressLine1']")
	WebElement flat_houseNum;
	
	@FindBy(xpath="//input[@id='address-ui-widgets-enterAddressLine2']")
	WebElement area_street;
	
	@FindBy(xpath="//input[@id='address-ui-widgets-landmark']")
	WebElement land_mark;
	
	@FindBy(id="address-ui-widgets-enterAddressCity")
	WebElement city;
	
	@FindBy(xpath="//select[@name='address-ui-widgets-enterAddressStateOrRegion']")
	WebElement state;
	
	@FindBy(xpath="//input[@id='address-ui-widgets-use-as-my-default']")
	WebElement defualt_chkbox;
	
	//@FindBy(xpath="//span[@id='address-ui-widgets-form-submit-button-announce']")
	//@FindBy(xpath="(//input[@type='submit'])[9]")
	@FindBy(xpath="//span[@id='address-ui-widgets-form-submit-button']")
	WebElement save_changes;
	
	public void clear_data() {
		selectbyindex(country,102);
		full_name.clear();
		mobile_num.clear();
		pin_code.clear();
		flat_houseNum.clear();
		area_street.clear();
		land_mark.clear();
		city.clear();
		selectbyindex(state,15);
	}
	
//	public void update_address() {
//		full_name.clear();
//		mobile_num.clear();
//		pin_code.clear();
//		flat_houseNum.clear();
//		area_street.clear();
//		land_mark.clear();
//		city.clear();
//		
//		//selectbyValue(country,"India");
//		full_name.sendKeys("Kavita K A");
//		mobile_num.sendKeys("8884431316");
//		pin_code.sendKeys("560098");
//		flat_houseNum.sendKeys("GF-06 Everest RR Nagar");
//		area_street.sendKeys("Channasandra 5th stage");
//		land_mark.sendKeys("Banglore one");
//		city.sendKeys("BENGALURU");		
//		//selectbyValue(state,"KARNATAKA");
//		defualt_chkbox.click();
//		save_changes.click();
//	}
//	
	
	public void update_adressdetails(String FN,String MNum,String PC,String Flat_HN,String Area_streat,String LM,String City,String State)	
	{
		
		//selectbyValue(country,Country);
		full_name.sendKeys(FN);
		mobile_num.sendKeys(MNum);
		pin_code.sendKeys(PC);
		flat_houseNum.sendKeys(Flat_HN);
		area_street.sendKeys(Area_streat);
		land_mark.sendKeys(LM);
		city.sendKeys(City);		
		//selectbyValue(state,State);
		defualt_chkbox.click();
		save_changes.click();
		
	}
	
	/* public void fullName()
	{
		full_name.sendKeys("Kavita K A");
	}
	public void mobileNum()
	{
		mobile_num.sendKeys("8884431316");
	}
	public void pinCode()
	{
		pin_code.sendKeys("560098");
	}
	public void flatHouseNum()
	{
		flat_houseNum.sendKeys("GF-06 RR Nagar");
	}
	public void areaStreet()
	{
		area_street.sendKeys("Channasandra 5th stage");
	}
	public void landMark()
	{
		land_mark.sendKeys("Banglore one");
	}
	*/
	
	/* creating the method for each component to perform its action  */
	public void yourAddress() {
		your_address.click();
	}
	
	public void editAddress() {
		edit_address.click();
	}
	
	// initializing each component page factory class
	public Amz_YourAccount(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
}
