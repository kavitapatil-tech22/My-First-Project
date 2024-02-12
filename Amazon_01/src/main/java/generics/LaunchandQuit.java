package generics;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
/**
 * 
 * @author Kavita
 *
 */
/*  Launch and quit browser  */
public class LaunchandQuit
{
	public static WebDriver driver;
	FileUtility file=new FileUtility();
	//@Parameters("browser")
	@BeforeMethod
	public void precondition(String nameofBrowser) throws IOException
	{
		if (nameofBrowser.equals("Chrome")) {
			driver=new ChromeDriver();			
		}
		if (nameofBrowser.equals("Firefox")) {
			driver = new FirefoxDriver();
		}	
		driver=new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		//pageutility.implicitwait(driver);
		//driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fb%2F%3F_encoding%3DUTF8%26_encoding%3DUTF8%26content-id%3Damzn1.sym.3bf9a838-7e28-4b13-a18e-f7ac86a62da7%26node%3D15325111031%26pd_rd_r%3D29a26012-88f2-478f-bcbe-e83d40b9c532%26pd_rd_w%3DBp7Ew%26pd_rd_wg%3DeBfxJ%26pf_rd_p%3D3bf9a838-7e28-4b13-a18e-f7ac86a62da7%26pf_rd_r%3DQJXRSSQ4JAS7Z1BG1TZF%26ref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		driver.navigate().to(file.getPropertyData("url"));
	}
	
	@AfterMethod
	public void quit() throws InterruptedException, IOException
	{
		driver.quit();
	}
	
}
