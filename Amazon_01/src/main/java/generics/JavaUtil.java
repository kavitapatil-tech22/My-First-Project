package generics;
import java.util.Date;
/**
 * author kavita
 */
import java.util.Random;
/**
 * 
 * @author kavita
 *
 */
public class JavaUtil {
	/**
	 * to get random number
	 * @return random number in the range of 1to 1000
	 */
	public int randomvalue() {
		Random ran=new Random();
		int num=ran.nextInt(1000);
		return num;
	}
	
	/**
	 * 
	 */
	public String currentdate() {
		Date date=new Date();
		String strDate = date.toString();
		return strDate;
	}

	

	
}
