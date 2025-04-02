package test;

import annotation.Author;
import annotation.FrameworkAnnotation;
import org.testng.annotations.Test;
import page.Page_AlertDialog;
import utils.TestBase;

public class TC11_RepeatAlertTest extends TestBase {


    @FrameworkAnnotation(author = Author.PRAVEEN_KINGSLEY)
    @Test
    public void repeatAlarmFunctionalityTest(){

        String[] daysToSelect = {"Monday","Tuesday","Wednesday","Thursday","Friday"};

        Page_AlertDialog page_alertDialog = new Page_AlertDialog();
        page_alertDialog.openAlertDialog().openRepeatAlarm()
                .selectDaysInRepeatAlarm(daysToSelect).acceptAlert();



    }






}
