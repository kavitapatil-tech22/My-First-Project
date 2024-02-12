package generics;
import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass extends PageUtility implements ITestListener
{
//	String date=new JavaUtil().currentdate().replace(" ", "_").replace(":", "_");
//	String methodname="";
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);	
		String date=new JavaUtil().currentdate().replace(" ", "_").replace(":", "_");
		String methodname = result.getMethod().getMethodName()+"-"+date;
		boolean status=result.isSuccess();
		System.out.println("Method Name : "+methodname);
		System.out.println("Success-Status :  "+status);
		System.out.println("Current Date : "+date);
		try {
			takeScreenShot(methodname,status);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	}
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		String date=new JavaUtil().currentdate().replace(" ", "_").replace(":", "_");
		String methodname = result.getMethod().getMethodName()+"-"+date;
		boolean status=result.isSuccess();
		System.out.println("Method Name : "+methodname);
		System.out.println("Success-Status :  "+status);
		System.out.println("Current Date : "+date);
		try {
			takeScreenShot(methodname,status);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

}
