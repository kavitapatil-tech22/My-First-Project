package generics;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * 
 * @author Kavita
 *
 */
public class FileUtility {
	/**
	 * To read the data from property file
	 * @param Key
	 * @return
	 * @throws IOException
	 */
	public String getPropertyData(String key) throws IOException {
		Properties p=new Properties();
		p.load(new FileInputStream(AutoConstant.propertyFilePath));
		return p.getProperty(key);
	}
	
	
}
