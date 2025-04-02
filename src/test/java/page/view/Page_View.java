package page.view;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumUtils;
import utils.TestBase;

import java.util.List;

public class Page_View extends TestBase {

    public Page_View() {
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Views\"]")
    public WebElement option_views;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Expandable Lists\"]")
    public WebElement option_expandableList;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"WebView3\"]")
    public WebElement option_webView3;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Animation\"]")
    public WebElement option_animation;






    public void clickView(){
        SeleniumUtils.click(option_views,"View");
    }








}
