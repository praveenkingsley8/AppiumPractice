package page.view;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumUtils;

public class Page_DragDrop extends Page_View{

    public Page_DragDrop() {
        PageFactory.initElements(DriverManager.getDriver(),this);
        PageFactory.initElements(DriverManager.getDriver(),Page_View.class);
    }

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Drag and Drop\"]")
    private WebElement option_dragAndDrop;

    @FindBy(xpath = "//android.view.View[@resource-id=\"io.appium.android.apis:id/drag_dot_2\"]")
    public WebElement button_source;

    @FindBy(xpath = "//android.view.View[@resource-id=\"io.appium.android.apis:id/drag_dot_3\"]")
    public WebElement button_destination;




    public void openDragAndDrop(){
        SeleniumUtils.click(option_views,"Views");
        SeleniumUtils.click(option_dragAndDrop,"Drag and Drop");

        m_assert.assertTrue(SeleniumUtils.waitForElementToBeDisplayed(button_destination,20),
                "Drag and Drop page opened");
    }


}
