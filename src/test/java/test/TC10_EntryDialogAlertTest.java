package test;

import annotation.Author;
import annotation.FrameworkAnnotation;
import org.testng.annotations.Test;
import page.Page_AlertDialog;
import utils.TestBase;

public class TC10_EntryDialogAlertTest extends TestBase {


    @FrameworkAnnotation(author = Author.PRAVEEN_KINGSLEY)
    @Test
    public void entryDialogFunctionalityTest(){

        String name ="god",password="password";
        Page_AlertDialog page_alertDialog = new Page_AlertDialog();
        page_alertDialog.openAlertDialog().openEntryDialog()
                .enterNameAndPassword(name,password).acceptAlert();




    }






}
