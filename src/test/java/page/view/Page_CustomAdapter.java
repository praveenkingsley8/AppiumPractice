package page.view;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumUtils;

public class Page_CustomAdapter extends Page_View{

    public Page_CustomAdapter() {
        PageFactory.initElements(DriverManager.getDriver(),this);
        PageFactory.initElements(DriverManager.getDriver(),Page_View.class);
    }

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]")
    private WebElement option_customAdapter;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Cat Names\"]")
    public WebElement button_catNames;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Sample action\"]")
    public WebElement button_sampleAction;


    public void openCustomAdapter(){
        SeleniumUtils.click(option_views,"Views");
        SeleniumUtils.click(option_expandableList,"Expandable List");
        SeleniumUtils.click(option_customAdapter,"Custom Adapter");

        m_assert.assertTrue(SeleniumUtils.waitForElementToBeDisplayed(button_catNames,20),
                "Custom Adapter page opened");
    }

    public void clickSampleAction(){
        SeleniumUtils.click(button_sampleAction,"Sample Action");
    }

}
