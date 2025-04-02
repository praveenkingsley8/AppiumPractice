package test;

import annotation.Author;
import annotation.FrameworkAnnotation;
import org.testng.annotations.Test;
import page.view.Page_CustomAdapter;
import utils.AppiumUtils;
import utils.SeleniumUtils;
import utils.TestBase;

public class TC3_CustomAdapterLongPressTest extends TestBase {


    @FrameworkAnnotation(author = Author.PRAVEEN_KINGSLEY)
    @Test
    public void longPressFunctionalityTest(){

        Page_CustomAdapter page_customAdapter = new Page_CustomAdapter();
        page_customAdapter.openCustomAdapter();

        //Long Press on Cat Names
        AppiumUtils.longPress(page_customAdapter.button_catNames,"Cat Names");

        boolean bSampleOptionDisplayed = SeleniumUtils.waitForElementToBeDisplayed(page_customAdapter.button_sampleAction,3);
        m_assert.assertTrue(bSampleOptionDisplayed,"Sample Action option displayed after long press on cat names");

        page_customAdapter.clickSampleAction();



    }






}
