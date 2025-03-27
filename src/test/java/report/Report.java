package report;

import annotation.Author;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.AppiumDriver;

public class Report {

    private static ExtentReports extent;
    private static ExtentTest test;



    public static void init(){

        extent = new ExtentReports();
        ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/report.html");
        extent.attachReporter(reporter);

    }

    public static void flush(){
        extent.flush();
    }

    public static void createTest(String testName){
        test = extent.createTest(testName);
        ReportManager.setExtentTest(test);
    }

    public static void assignAuthor(Author author){
        ReportManager.getExtentTest().assignAuthor(String.valueOf(author));
    }



}
