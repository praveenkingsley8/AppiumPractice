package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import utils.Config;
import data.ConfigData;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {


    private static AppiumDriver driver;

    public static void launchAndroidDriver() throws MalformedURLException {


        String appName = Config.getProperty(ConfigData.APP);
        String platform = Config.getProperty(ConfigData.PLATFORM);

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName(platform);
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setDeviceName(Config.getProperty(ConfigData.DEVICE_NAME));
        options.setApp(System.getProperty("user.dir")+"/apps/"+appName);
        driver =new AndroidDriver(new URL("http://127.0.0.1:4723"),options);

        DriverManager.setDriver(driver);
    }

    public static void closeDriver(){
        DriverManager.getDriver().quit();
    }

}
