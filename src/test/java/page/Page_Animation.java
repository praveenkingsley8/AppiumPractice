package page;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumUtils;
import utils.TestBase;

import java.util.ArrayList;
import java.util.List;

public class Page_Animation extends TestBase {

    public Page_Animation() {
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Animation\"]")
    private WebElement option_animation;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"View Flip\"]")
    private WebElement option_viewFlip;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Flip\"]")
    public WebElement button_flip;

    public void openViewFlip(){
        SeleniumUtils.click(option_animation,"Animation");
        SeleniumUtils.click(option_viewFlip,"View Flip");

        m_assert.assertTrue(SeleniumUtils.waitForElementToBeDisplayed(button_flip,20),
                "View flip page opened");
    }





}
