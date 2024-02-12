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
import pomobjectrepository.Amz_WishList;
/**
 * 
 * @author Kavita
 *
 */
/*  Login->searching->adding the product to wishlist->adding the product to cart->reaching till payment option DC->logout */
@Listeners(ListenerClass.class)
public class Amz_Smoke_06 extends LaunchandQuit
{
	@Test(dataProvider="LoginData",dataProviderClass=ExcelUtilities.class)
	public void smoke_testcase_06(String UN,String PWD) throws IOException, InterruptedException 
	{
		Amz_Login amzlogin_obj=new Amz_Login(driver); 		
		amzlogin_obj.userName(UN);
		amzlogin_obj.un_submit();
		amzlogin_obj.password(PWD);
		amzlogin_obj.signin();		
		
		Amz_Home amzhome=new Amz_Home(driver);
		amzhome.seraching_the_product();
		amzhome.clickOnFirstShoes(driver);			
		Amz_WishList wishlist=new Amz_WishList(driver);
		wishlist.addtowishlist();		
        wishlist.wishlist_window_close();
       
        Amz_Navigation amz_navigation=new Amz_Navigation(driver);
    	amz_navigation.get_title("title");
        
		Amz_AddCart amz_cart=new Amz_AddCart(driver);
		amz_cart.addtocart(driver);
		amz_cart.proceed_to_checkout();
		amz_cart.usethisaddress();
		amz_cart.creditcard();
		amz_cart.entercard_details(driver);
			
		amz_navigation.checkout_page();		
		amzhome.mouseOver_account(driver);
		amzhome.logout();		
		Assert.assertTrue(true);
	}
}
