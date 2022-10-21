package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListener implements IRetryAnalyzer {
    public static int counter = 0;
    int retryLimit = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(counter < retryLimit){
            counter++;
            return true;
        }
        return false;
    }
}
