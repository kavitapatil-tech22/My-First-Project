package pomobjectrepository;
import org.openqa.selenium.WebDriver;
/**
 * 
 * @author Kavita
 *
 */
public class Amz_Navigation 
{
	WebDriver driver;
	String pagetitle;

	public void navigate_back() {
		driver.navigate().back();
	}
	public void switch_to_frame()
	{
		driver.switchTo().frame(0);
	}

	public void get_title(String pagetitle) {
		pagetitle = driver.getTitle();
		this.pagetitle = pagetitle;
		System.out.println(pagetitle);
	}

	public void checkout_page() {
		driver.getTitle();

		while (!(driver.getTitle().equals(pagetitle))) {
			driver.navigate().back();
		}
	}
	
   public Amz_Navigation(WebDriver driver) {
		this.driver = driver;
    }
}
