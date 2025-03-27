package test;

import annotation.Author;
import annotation.FrameworkAnnotation;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import page.Page_Home;
import page.Page_Login;
import utils.TestBase;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class TC1_LoginTest extends TestBase {


    @FrameworkAnnotation(author = Author.PRAVEEN_KINGSLEY)
    @Test
    public void loginTest(){
        final String userId = "helloworld@gmail.com",password = "testing1234";

        Page_Login page_login = new Page_Login();
        page_login.login(userId,password).verifyWhetherHomeScreenIsDisplayed();
    }

    @FrameworkAnnotation(author = Author.PRAVEEN_KINGSLEY)
    @Test
    public void registrationTest(){
        Page_Home page_home = new Page_Home();
        page_home.registerUserAndSubmit("Praveen","praveen.kingsley@w.in","9876543210");
    }




}
