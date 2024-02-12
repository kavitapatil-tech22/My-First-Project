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
import pomobjectrepository.Amz_YourAccount;

/**
 * 
 * @author Kavita
 *
 */
/* Assignment 9 Login->update your default address->trying to reach till payments page with new address->logout  */
@Listeners(ListenerClass.class)
public class Amz_Smoke_09 extends LaunchandQuit
{
	@Test(dataProvider="EditProfileData",dataProviderClass=ExcelUtilities.class)
	public void smoke_testcase_09(String UN,String PWD,String Country,String FN,String MNum,String PC,String Flat_HN,String Area_streat,String LM,String City,String State) throws IOException, InterruptedException 
	{
		Amz_Login amzlogin_obj=new Amz_Login(driver); 		
		amzlogin_obj.userName(UN);
		amzlogin_obj.un_submit();
		amzlogin_obj.password(PWD);
		amzlogin_obj.signin();		
		
		Amz_Home amzHome=new Amz_Home(driver);
		amzHome.mouseOver_account(driver);
		amzHome.yourAccount();
		
		Amz_YourAccount amz_youraccount=new Amz_YourAccount(driver);
		amz_youraccount.yourAddress();
		amz_youraccount.editAddress();
		//amz_youraccount.update_address();
		amz_youraccount.update_adressdetails(FN,MNum,PC,Flat_HN,Area_streat,LM,City,State);
		
		Assert.assertTrue(true);
		
	}
}
