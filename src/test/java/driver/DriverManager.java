package driver;

import data.ConfigData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import utils.Config;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    private static ThreadLocal<AppiumDriver> threadLocal =new ThreadLocal<>();
    private static AppiumDriver driver;


    public static AppiumDriver getDriver() {
        return threadLocal.get();
    }

    public static void setDriver(AppiumDriver driver) {
        threadLocal.set(driver);
    }



}
