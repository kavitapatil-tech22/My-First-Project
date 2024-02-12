package test_script;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generics.ExcelUtilities;
import generics.LaunchandQuit;
import generics.ListenerClass;
import pomobjectrepository.Amz_Home;
import pomobjectrepository.Amz_Login;
import pomobjectrepository.Amz_WishList;
/** 
 * author : Kavita
 * 
 */

/* Amz_Smoke_03 :Login->seraching->adding the product to wishlist->removing the product from wishlist->adding the product to cart->removong the product from cart->logout */
@Listeners(ListenerClass.class)
public class Amz_Smoke_03 extends LaunchandQuit
{
	@Test(dataProvider="LoginData",dataProviderClass=ExcelUtilities.class)
	public void smoke_testcase_03(String UN,String PWD) throws InterruptedException, IOException
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
		wishlist.view_your_list();			
		wishlist.delete_WishlistItem();	
		wishlist.add_to_cart();		
		wishlist.viewcart();				
		wishlist.deletefromcart();			
		amzhome.mouseOver_account(driver);
		amzhome.logout();
		Assert.assertTrue(true);
				
	}		
}
