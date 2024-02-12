package test_script;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generics.ExcelUtilities;
import generics.LaunchandQuit;
import generics.ListenerClass;
import pomobjectrepository.Amz_AddCart;
import pomobjectrepository.Amz_Home;
import pomobjectrepository.Amz_Login;
import pomobjectrepository.Amz_Navigation;
/**
 * 
 * @author Kavita
 *
 */
/* Assignment 8 : Login->searching he product->buy now->making the payment from CC->logout   */
@Listeners(ListenerClass.class)
public class Amz_Smoke_08 extends LaunchandQuit
{
	@Test(dataProvider="LoginData",dataProviderClass=ExcelUtilities.class)
	public void smoke_testcase_08(String UN,String PWD) throws IOException, InterruptedException 
	{
		Amz_Login amzlogin_obj=new Amz_Login(driver); 		
		amzlogin_obj.userName(UN);
		amzlogin_obj.un_submit();
		amzlogin_obj.password(PWD);
		amzlogin_obj.signin();		
		
		Amz_Home amzhome=new Amz_Home(driver);
		amzhome.seraching_the_product();
		amzhome.clickOnFirstShoes(driver);				  	
		amzhome.buynow(driver);
				
		Amz_AddCart amz_cart=new Amz_AddCart(driver);
		amz_cart.usethisaddress();			
		amz_cart.creditcard();
		amz_cart.entercard_details(driver);
		amz_cart.carddetails_entering();
		
		Amz_Navigation amz_navigation=new Amz_Navigation(driver);
    	amz_navigation.navigate_back();

		amzhome.mouseOver_account(driver);
		amzhome.logout();
		Assert.assertTrue(true);
	}
}
