package listener;

import annotation.FrameworkAnnotation;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import report.Report;
import report.ReportLogger;

import java.util.Arrays;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        Report.createTest(result.getName());
        Report.assignAuthor(result.getMethod().getConstructorOrMethod().getMethod()
                .getAnnotation(FrameworkAnnotation.class).author());
    }


    @Override
    public void onTestFailure(ITestResult result) {
        ReportLogger.fail(result.getThrowable().getMessage());
        ReportLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
    }



    @Override
    public void onStart(ITestContext context) {
        Report.init();
    }

    @Override
    public void onFinish(ITestContext context) {
        Report.flush();
    }
}
