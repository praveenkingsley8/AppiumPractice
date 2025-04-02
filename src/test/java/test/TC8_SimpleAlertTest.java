package test;

import annotation.Author;
import annotation.FrameworkAnnotation;
import org.testng.annotations.Test;
import page.Page_AlertDialog;
import utils.TestBase;

public class TC8_SimpleAlertTest extends TestBase {


    @FrameworkAnnotation(author = Author.PRAVEEN_KINGSLEY)
    @Test
    public void simpleAlertFunctionalityTest(){

        Page_AlertDialog page_alertDialog = new Page_AlertDialog();
        page_alertDialog.openAlertDialog().openSimpleDialog().acceptAlert();




    }






}
