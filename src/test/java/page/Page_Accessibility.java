package page;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumUtils;
import utils.TestBase;

import java.util.ArrayList;
import java.util.List;

public class Page_Accessibility extends TestBase {

    public Page_Accessibility() {
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Accessibility\"]")
    public WebElement option_accessibility;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Accessibility Node Querying\"]")
    private WebElement option_accessibilityNodeQuerying;

    @FindBy(xpath = "//android.widget.CheckBox[@resource-id=\"io.appium.android.apis:id/tasklist_finished\"]")
    private List<WebElement> list_checkboxAccessibility;

    @FindBy(xpath = "//android.widget.ListView[@resource-id=\"android:id/list\"]//android.widget.TextView")
    private List<WebElement> list_labelAccessibility;

    public void openAccessibilityNodeQuerying(){
        SeleniumUtils.waitForElementToBeDisplayed(option_accessibility,20);
        SeleniumUtils.click(option_accessibility,"Accessibility");

        SeleniumUtils.waitForElementToBeDisplayed(option_accessibilityNodeQuerying,20);
        SeleniumUtils.click(option_accessibilityNodeQuerying,"Accessibility Node Querying");

        m_assert.assertTrue(SeleniumUtils.waitForElementsToBeDisplayed(list_checkboxAccessibility,20),
                "Accessibility Node Querying page opened");
    }

    public List<String> getCheckedAccessibility(){
        List<String> listCheckedOptions=new ArrayList<>();

        for(WebElement element:list_checkboxAccessibility){
            if(SeleniumUtils.isCheckboxSelected(element)){
                String option = SeleniumUtils.getTextInElement(list_labelAccessibility.get(list_checkboxAccessibility.indexOf(element)));
                listCheckedOptions.add(option);
            }

        }
        return listCheckedOptions;
    }

    public List<String> getUncheckedAccessibility(){
        List<String> listUncheckedOptions =new ArrayList<>();

        for(WebElement element:list_checkboxAccessibility){
            if(!SeleniumUtils.isCheckboxSelected(element)){
                String option = SeleniumUtils.getTextInElement(list_labelAccessibility.get(list_checkboxAccessibility.indexOf(element)));
                listUncheckedOptions.add(option);
            }

        }
        return listUncheckedOptions;
    }

    public List<String> getAllAccessibilityLabel(){
        List<String> listOptions =new ArrayList<>();

        for(WebElement element:list_checkboxAccessibility){
            String option = SeleniumUtils.getTextInElement(list_labelAccessibility.get(list_checkboxAccessibility.indexOf(element)));
            listOptions.add(option);
        }
        return listOptions;
    }

    public void enableAccessibility(String value){
        for(WebElement element:list_checkboxAccessibility){
            String option = SeleniumUtils.getTextInElement(list_labelAccessibility.get(list_checkboxAccessibility.indexOf(element)));

            if(option.equalsIgnoreCase(value)){
                if(SeleniumUtils.isCheckboxSelected(element)){
                    m_assert.assertTrue(value+" option is already selected");
                }else{
                    SeleniumUtils.click(element,value+" checkbox");
                }
                break;
            }
        }
    }

    public void disableAccessibility(String value){
        for(WebElement element:list_checkboxAccessibility){
            String option = SeleniumUtils.getTextInElement(list_labelAccessibility.get(list_checkboxAccessibility.indexOf(element)));

            if(option.equalsIgnoreCase(value)){
                if(SeleniumUtils.isCheckboxSelected(element)){
                    SeleniumUtils.click(element,value+" checkbox disable option");
                }
                break;
            }
        }
    }




}
