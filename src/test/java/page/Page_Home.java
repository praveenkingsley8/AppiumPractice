package page;

import driver.DriverManager;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import utils.SeleniumUtils;
import utils.TestBase;

public class Page_Home extends TestBase {

    public Page_Home() {
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    @FindBy(id = "com.qatestapp:id/nameTextField")
    private WebElement input_fullName;

    @FindBy(id = "com.qatestapp:id/emailTextField")
    private WebElement input_email;

    @FindBy(id = "com.qatestapp:id/phoneNumberTextField")
    private WebElement input_phoneNo;

    @FindBy(id = "com.qatestapp:id/button2")
    private WebElement button_submit;

    public void verifyWhetherHomeScreenIsDisplayed(){
        m_assert.assertTrue(SeleniumUtils.waitForElementToBeDisplayed(input_fullName,20),"User logged in successfully");
    }

    public void registerUserAndSubmit(String full_name,String email_id,String phoneNo){
        SeleniumUtils.sendKeys(input_fullName,full_name,"Full Name");
        SeleniumUtils.sendKeys(input_email,email_id,"Email ID");
        SeleniumUtils.sendKeys(input_phoneNo,phoneNo,"Phone No");
        SeleniumUtils.click(button_submit,"Submit");
    }





}
