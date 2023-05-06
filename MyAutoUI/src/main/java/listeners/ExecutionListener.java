package listeners;

import reporting.Reporter;
import utils.common.CommonUtils;
import org.testng.IExecutionListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExecutionListener implements IExecutionListener, ITestListener {
//This listner class works at Suite Level.
    public void onExecutionStart() {
        // not implemented
        Reporter.init();
    }

    /** Invoked once all the suites have been run. */
    public void onExecutionFinish() {
        // not implemented
        Reporter.generateReport();
    }

    public void onTestFailure(ITestResult result) {
        // not implemented
        try {
            CommonUtils.takeScreenshot(result.getName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
