package report;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.TakesScreenshot;
import utils.ScreenShotUtils;

public class ReportLogger {

    public static void pass(String message){
        ReportManager.getExtentTest().pass(message,
                MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.takeScreenShot()).build());
    }
    public static void fail(String message){
        ReportManager.getExtentTest().fail(message,
                MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.takeScreenShot()).build());
    }
    public static void info(String message){
        ReportManager.getExtentTest().info(message);
    }
    public static void warn(String message){
        ReportManager.getExtentTest().warning(message,
                MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.takeScreenShot()).build());
    }

}
