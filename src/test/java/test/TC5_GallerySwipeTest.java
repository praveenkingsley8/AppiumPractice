package test;

import annotation.Author;
import annotation.FrameworkAnnotation;
import org.openqa.selenium.Point;
import org.testng.annotations.Test;
import page.view.Page_Gallery;
import page.view.Page_View;
import utils.AppiumUtils;
import utils.TestBase;

public class TC5_GallerySwipeTest extends TestBase {


    @FrameworkAnnotation(author = Author.PRAVEEN_KINGSLEY)
    @Test
    public void swipeFunctionalityTest(){

        Page_Gallery page_gallery = new Page_Gallery();
        page_gallery.openGalleryPhotos();

        Point photo1 = page_gallery.option_photos1.getLocation();


        for (int i=0;i<4;i++){
            AppiumUtils.swipeLeft(photo1);
        }
        m_assert.assertTrue("Swipe to Photo 5");

    }






}
