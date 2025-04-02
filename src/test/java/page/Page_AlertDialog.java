package page;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumUtils;
import utils.TestBase;

import java.util.List;

public class Page_AlertDialog extends TestBase {

    public Page_AlertDialog() {
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"App\"]")
    private WebElement option_app;
    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Alert Dialogs\"]")
    private WebElement option_alertDialog;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"OK Cancel dialog with a message\"]")
    public WebElement list_simpleDialog;
    @FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
    public WebElement button_ok;


    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Single choice list\"]")
    private WebElement list_singleChoice;
    @FindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\"]")
    private List<WebElement> list_optionsSingleChoice;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Text Entry dialog\"]")
    private WebElement list_textEntry;
    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"io.appium.android.apis:id/username_edit\"]")
    private WebElement input_name;
    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"io.appium.android.apis:id/password_edit\"]")
    private WebElement input_password;


    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Repeat alarm\"]")
    private WebElement list_repeatAlarm;
    @FindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\"]")
    private List<WebElement> list_optionRepeatAlarm;

    public Page_AlertDialog openAlertDialog(){
        SeleniumUtils.click(option_app,"App");
        SeleniumUtils.click(option_alertDialog,"Alert Dialog");

        m_assert.assertTrue(SeleniumUtils.waitForElementToBeDisplayed(list_simpleDialog,20),
                "Alert Dialog page opened");
        return new Page_AlertDialog();
    }

    public Page_AlertDialog openSimpleDialog(){
        SeleniumUtils.click(list_simpleDialog,"OK Cancel dialog with a message");
        return new Page_AlertDialog();
    }
    public void acceptAlert(){
        SeleniumUtils.click(button_ok,"OK button");
    }

    public Page_AlertDialog openSingleChoiceDialog(){
        SeleniumUtils.click(list_singleChoice,"Single choice list");
        return new Page_AlertDialog();
    }

    public Page_AlertDialog clickSingleChoiceOption(String option){

        for(WebElement e:list_optionsSingleChoice){
            if(SeleniumUtils.getTextInElement(e).equalsIgnoreCase(option)){
                SeleniumUtils.click(e,"Option - "+option);
                break;
            }
        }

        return new Page_AlertDialog();
    }

    public Page_AlertDialog openEntryDialog(){
        SeleniumUtils.click(list_textEntry,"Single choice list");
        return new Page_AlertDialog();
    }
    public Page_AlertDialog enterNameAndPassword(String name,String password){

        SeleniumUtils.sendKeys(input_name,name,"Name");
        SeleniumUtils.sendKeys(input_password,password,"Password");
        return new Page_AlertDialog();
    }

    public Page_AlertDialog openRepeatAlarm(){
        SeleniumUtils.click(list_repeatAlarm,"Repeat Alarm");
        return new Page_AlertDialog();
    }

    public Page_AlertDialog selectDaysInRepeatAlarm(String[] options){

        for(WebElement e:list_optionRepeatAlarm){
            boolean enable = false;
            String selectedDay ="";
            for(String option:options){
                selectedDay = SeleniumUtils.getTextInElement(e);
                enable =selectedDay.toLowerCase().contains(option.toLowerCase());
                if(enable){
                    break;
                }
            }

            if(enable){
                if(SeleniumUtils.isCheckboxSelected(e)){
                    m_assert.assertTrue(selectedDay+" is already selected");
                }else{
                    SeleniumUtils.click(e,selectedDay);
                }
            }else{
                if(SeleniumUtils.isCheckboxSelected(e)){
                    SeleniumUtils.click(e,selectedDay+" to uncheck");
                }else{
                    m_assert.assertTrue(selectedDay+" is unselected by default");
                }
            }

        }

        return new Page_AlertDialog();
    }
}
