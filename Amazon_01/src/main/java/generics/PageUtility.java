package generics;
import java.io.File;
import java.io.IOException;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;
/**
 * 
 * @author Kavita
 *
 */
public class PageUtility extends LaunchandQuit
{
	//public static WebDriver driver=null;
	
	/**
	 * to wait implicitly
	 */
//	public void implicitwait(WebDriver driver) {		
//		//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
//	}
	/**
	 * Used to take screenshot
	 * @param driver
	 * @param methodName
	 * @throws IOException
	 */
	
	public String takeScreenShot(String methodName,boolean status) throws IOException  {
		//TakesScreenshot ts = (TakesScreenshot) this.driver;
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		//String path=AutoConstant.Pass_screenshotpath+methodName+"+Math.random()+"+".PNG";
		//String path=AutoConstant.screenshotpath+methodName+"+Math.random()+"+".PNG";
		String path;
		if(status==true)
		{
		    path=".//ScreenShot-All//Pass_ScreenShot//"+methodName+"-"+Math.random()+".PNG" ;
		}
		else {
			 path=".//ScreenShot-All//Fail_ScreenShot//"+methodName+"-"+Math.random()+".PNG" ;
		}
		File dest=new File(path);
		Files.copy(src, dest);
		return path;
	}
	/**
	 * to select from drop down by visible Text
	 * @param element
	 * @param text
	 */
	public void selectbyvisibletext(WebElement element,String text) {
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * to select from drop dowm by value
	 * @param element
	 * @param text
	 */
	public void selectbyValue(WebElement element,String text) {
		Select sel=new Select(element);
		sel.selectByValue(text);
	}
	/**
	 * to select from drop down by index
	 * @param element
	 * @param index
	 */
	public void selectbyindex(WebElement element,int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * to switch to child window
	 * @param driver
	 * @param sessionid
	 */
	public static void switchtochildWindow(WebDriver driver) {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> winpop = windows.iterator();
		String parentid = winpop.next();
		String childid = winpop.next();
		driver.switchTo().window(childid);
	}
	/**
	 * to switch to parent window
	 * @param driver
	 */
	public static void switchtoparentwindow(WebDriver driver) {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> winpop = windows.iterator();
		String parentid = winpop.next();
		driver.switchTo().window(parentid);
	}
	/**
	 * to scroll till element is visible
	 * @param driver
	 * @param element
	 */
	public void scrollBar(WebDriver driver, WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

}
