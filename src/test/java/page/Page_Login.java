package page;

import driver.DriverManager;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumUtils;

public class Page_Login {

    public Page_Login() {
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"com.qatestapp:id/emailTextField1\"]")
    private WebElement input_userid;

    @FindBy(id = "com.qatestapp:id/passwordTextField")
    private WebElement input_password;

    @FindBy(id = "com.qatestapp:id/LoginButton")
    private WebElement button_startTest;

    @FindBy(className = "android.widget.Toast")
    private WebElement text_loginFailed;


    private void enterUserid(String username){
        SeleniumUtils.sendKeys(input_userid,username,"User ID");
    }
    private void enterPassword(String password){
        SeleniumUtils.sendKeys(input_password,password,"Password");
    }

    public Page_Home login(String userid, String password){
        if(SeleniumUtils.waitForElementToBeDisplayed(input_userid,20)){
            enterUserid(userid);
            enterPassword(password);
            SeleniumUtils.click(button_startTest,"Start Test");
            return new Page_Home();
        }
        return null;
    }





}
