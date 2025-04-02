package test;

import annotation.Author;
import annotation.FrameworkAnnotation;
import org.testng.annotations.Test;
import page.Page_AlertDialog;
import utils.TestBase;

public class TC9_SingleChoiceAlertTest extends TestBase {


    @FrameworkAnnotation(author = Author.PRAVEEN_KINGSLEY)
    @Test
    public void choiceAlertFunctionalityTest(){

        String optionToSelect ="Street View";
        Page_AlertDialog page_alertDialog = new Page_AlertDialog();
        page_alertDialog.openAlertDialog().openSingleChoiceDialog()
                .clickSingleChoiceOption(optionToSelect).acceptAlert();




    }






}
