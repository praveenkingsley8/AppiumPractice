package utils;

import data.ConfigData;
import driver.Driver;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.annotations.*;
import report.CustomSoftAssert;
import report.Report;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class TestBase {
    public static Logger logger;
    public static CustomSoftAssert m_assert;

    @BeforeSuite
    public void setupSuite(){
        logger = LogManager.getLogger(this.getClass());
        m_assert=new CustomSoftAssert();
    }

    @BeforeTest
    public void setupTest() throws MalformedURLException {

        String platform = Config.getProperty(ConfigData.PLATFORM);

        if(platform.equalsIgnoreCase("Android")){
            Driver.launchAndroidDriver();
        }else{
            System.out.println("Not Implemented");
        }

        logger.info("************* DRIVER STARTED *************");
        logger.info("************* PLATFORM -> "+platform.toUpperCase());
        logger.info("************* INSTALLING APP -> "+ Config.getProperty(ConfigData.APP));

    }

    @BeforeMethod
    public void setUp(Method m){


    }

    @AfterMethod
    public void assertAll(Method m){
        m_assert.assertAll();
    }

    public void tearDown(){
        Driver.closeDriver();
    }


    @AfterSuite
    public void after(){
    }






}
