package test;

import annotation.Author;
import annotation.FrameworkAnnotation;
import org.testng.annotations.Test;
import page.view.Page_View;
import utils.AppiumUtils;
import utils.TestBase;

public class TC4_ScrollTest extends TestBase {


    @FrameworkAnnotation(author = Author.PRAVEEN_KINGSLEY)
    @Test
    public void scrollFunctionalityTest(){

        Page_View page_view = new Page_View();
        page_view.clickView();

        AppiumUtils.scrollDownToElement(page_view.option_webView3,"Web View 3");

        AppiumUtils.scrollUpToElement(page_view.option_animation,"Animation");

    }






}
