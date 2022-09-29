package ashwani.Listeners;




import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;





public class RerunnerTest implements IRetryAnalyzer{
int count;
int maxCount=2;
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(count<maxCount) {
			count++;
		return	true;
		}
		
		
		return false;
	}

}
