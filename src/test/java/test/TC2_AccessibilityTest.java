package test;

import annotation.Author;
import annotation.FrameworkAnnotation;
import org.testng.annotations.Test;
import page.Page_Accessibility;
import page.Page_Home;
import page.Page_Login;
import utils.TestBase;

import java.util.List;

public class TC2_AccessibilityTest extends TestBase {


    @FrameworkAnnotation(author = Author.PRAVEEN_KINGSLEY)
    @Test
    public void accessibilityFunctionalityTest(){
        Page_Accessibility page_accessibility = new Page_Accessibility();
        page_accessibility.openAccessibilityNodeQuerying();

        //Checked Options
        List<String> list_selectedAccessibility = page_accessibility.getCheckedAccessibility();
        List<String> list_unselectedAccessibility = page_accessibility.getUncheckedAccessibility();

        //Uncheck checked option
        for (String option: list_selectedAccessibility){
            page_accessibility.disableAccessibility(option);
        }

        //Check checked option
        for (String option: list_unselectedAccessibility){
            page_accessibility.enableAccessibility(option);
        }



    }






}
