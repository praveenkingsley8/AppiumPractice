package page.view;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumUtils;

public class Page_Gallery extends Page_View{

    public Page_Gallery() {
        PageFactory.initElements(DriverManager.getDriver(),this);
        PageFactory.initElements(DriverManager.getDriver(),Page_View.class);
    }

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Gallery\"]")
    private WebElement option_gallery;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"1. Photos\"]")
    public WebElement option_photos;

    @FindBy(xpath = "//android.widget.Gallery[@resource-id=\"io.appium.android.apis:id/gallery\"]/android.widget.ImageView[1]")
    public WebElement option_photos1;




    public void openGalleryPhotos(){
        SeleniumUtils.click(option_views,"Views");
        SeleniumUtils.click(option_gallery,"Custom Adapter");
        SeleniumUtils.click(option_photos,"Photos");

        m_assert.assertTrue(SeleniumUtils.waitForElementToBeDisplayed(option_photos1,20),
                "Gallery Photo page opened");
    }


}
