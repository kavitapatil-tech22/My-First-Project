package test_script;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import generics.ListenerClass;
import generics.ExcelUtilities;
import generics.LaunchandQuit;
import pomobjectrepository.Amz_Home;
import pomobjectrepository.Amz_Login;

/**
 * 
 * @author Kavita
 *   
 */
/* Amz_Smoke_01: Login->searching the any product->logout */
@Listeners(ListenerClass.class)
public class Amz_Smoke_01 extends LaunchandQuit
{
	@Test(dataProvider="LoginData",dataProviderClass=ExcelUtilities.class,retryAnalyzer=generics.RetryLogic_1.class)
	public void login_with_valid_credentials(String UN,String PWD) throws InterruptedException,IOException
	{	
		Amz_Login amzlogin_obj=new Amz_Login(driver); //remember scanner and actions class
		amzlogin_obj.userName(UN);
		amzlogin_obj.un_submit();
		amzlogin_obj.password(PWD);
		amzlogin_obj.signin();		
		Amz_Home a2=new Amz_Home(driver);
		a2.seraching_the_product();
		a2.mouseOver_account(driver);
		a2.logout();
		Assert.assertTrue(true);    
		
	}
	
}
