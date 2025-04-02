package test;

import annotation.Author;
import annotation.FrameworkAnnotation;
import org.testng.annotations.Test;
import page.view.Page_DragDrop;
import utils.AppiumUtils;
import utils.TestBase;

public class TC6_DragAndDropTest extends TestBase {


    @FrameworkAnnotation(author = Author.PRAVEEN_KINGSLEY)
    @Test
    public void dragAndDropFunctionalityTest(){

        Page_DragDrop page_dragDrop = new Page_DragDrop();
        page_dragDrop.openDragAndDrop();

        AppiumUtils.dragAndDrop(page_dragDrop.button_source,page_dragDrop.button_destination);

    }






}
