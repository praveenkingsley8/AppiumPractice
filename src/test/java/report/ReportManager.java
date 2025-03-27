package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ReportManager {

    private static ThreadLocal<ExtentTest> testThreadLocal = new ThreadLocal<>();

    public static ExtentTest getExtentTest() {
        return testThreadLocal.get();
    }
    public static void setExtentTest(ExtentTest test){
        testThreadLocal.set(test);
    }


}
