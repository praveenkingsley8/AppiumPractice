package test;

import annotation.Author;
import annotation.FrameworkAnnotation;
import org.testng.annotations.Test;
import page.Page_Animation;
import page.view.Page_DragDrop;
import utils.AppiumUtils;
import utils.TestBase;

public class TC7_FlipTapTest extends TestBase {


    @FrameworkAnnotation(author = Author.PRAVEEN_KINGSLEY)
    @Test
    public void tapFunctionalityTest(){

        Page_Animation page_animation = new Page_Animation();
        page_animation.openViewFlip();

        AppiumUtils.tap(page_animation.button_flip,"Flip");

    }






}
