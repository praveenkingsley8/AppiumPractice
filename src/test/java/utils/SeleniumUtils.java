package utils;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import report.ReportLogger;
import report.ReportManager;

import java.time.Duration;
import java.util.List;

public class SeleniumUtils extends TestBase {


    /**
     * Attempts to click on the given WebElement.
     * Waits for the element to be clickable and handles exceptions.
     *
     * @param element The WebElement to click.
     * @return true if the element was successfully clicked, false otherwise.
     */
    public static boolean click(WebElement element,String elementName) {
        boolean status = false;

        if (element == null) {
            logger.error("Element is null, cannot click.");
            ReportLogger.fail("Unable to click "+elementName);
            return false;
        }

        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element));

            // Click the element
            element.click();
            status = true;

            ReportLogger.pass("Clicked on "+elementName);
            logger.info("Element clicked successfully: " + element.toString());
        } catch (Exception e) {
            logger.error("Error clicking the element: " + e.getMessage());
            ReportLogger.fail("Unable to click "+elementName);

        }

        return status;
    }

    /**
     * Waits for the given element to be displayed within the specified time.
     *
     * @param element The WebElement to wait for.
     * @param seconds The maximum time to wait in seconds.
     * @return true if the element is displayed, false otherwise.
     */
    public static boolean waitForElementToBeDisplayed(WebElement element, int seconds) {
        try {

            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.visibilityOf(element));

            boolean status = element.isDisplayed();
            if(status){
                logger.info("Element is displayed within " + seconds + " seconds");
            }

            return status;

        } catch (Exception e) {
            logger.error("Element not displayed within " + seconds + " seconds");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Sends the specified text to the given WebElement.
     * Waits for the element to be clickable and handles exceptions.
     *
     * @param element The WebElement to send keys to.
     * @param text    The text to send to the element.
     * @return true if the text was successfully sent, false otherwise.
     */
    public static boolean sendKeys(WebElement element, String text , String elementName) {
        boolean status = false;

        if (element == null || text == null) {
            logger.error("Element or text is null, cannot send keys.");
            ReportLogger.fail("Unable to Enter "+text+" into the "+elementName);
            return false;
        }

        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element));

            element.clear();
            element.sendKeys(text);
            status = true;
            ReportLogger.pass("Entered " + text + " into the " + elementName);
            logger.info("Text ("+text+") sent successfully to element: " + element.toString());
        } catch (Exception e) {
            logger.error("Error sending keys to the element: " + e.getMessage());
            ReportLogger.fail("Unable to Enter "+text+" into the "+elementName);
        }

        return status;
    }

    public static boolean waitForElementsToBeDisplayed(List<WebElement> elements, int maxSecondTimeoutInSecs) {
        boolean flag = false;
        logger.info("INTO waitForElementsToBeDisplayed method for " + elements + " with timeout = " + maxSecondTimeoutInSecs + " seconds.");

        for (int i = 0; i < maxSecondTimeoutInSecs; i++) {
            try {
                flag = true;
                for (WebElement element : elements) {
                    if (!element.isDisplayed()) {
                        flag = false;
                        break; // If one element isn't displayed, flag becomes false
                    }
                }

                if (flag) {
                    logger.info("All elements are displayed after " + i + " seconds.");
                    break;
                } else {
                    // Wait for 1 second before retrying
                    customWait(1);
                }
            } catch (Exception e) {
                logger.error("Error while waiting for elements to be displayed. Exception: ", e);
                break; // Exit loop if an exception occurs
            }
        }

        if (!flag) {
            logger.error("List of elements are not displayed within " + maxSecondTimeoutInSecs + " seconds.");
        }

        return flag;
    }

    public static boolean customWait(int... maxSecondTimeoutInSecs) throws InterruptedException {
        boolean waitSuccess = false;

        if (maxSecondTimeoutInSecs.length > 0) {
            logger.info("INTO customWait method with " + maxSecondTimeoutInSecs[0]);
            maxSecondTimeoutInSecs[0] = maxSecondTimeoutInSecs[0] * 1000;
            Thread.sleep(maxSecondTimeoutInSecs[0]);
            logger.info("Waited for " + maxSecondTimeoutInSecs[0] / 1000 + " secs");
            waitSuccess = true;
        } else {
            logger.info("INTO customWait method");
            Thread.sleep(2000);
            logger.info("Waited for 2 secs");
            waitSuccess = true;
        }

        return waitSuccess;
    }

    public static String getTextInElement(WebElement element) {
        logger.info("INTO getTextInElement method for element: " + element);
        String returnElementString = null;

        // Check if the element is not null and visible before getting the text
        if (element != null && element.isDisplayed()) {
            try {
                returnElementString = element.getText().trim(); // Directly get and trim the text
                logger.info("Successfully retrieved text from element: " + returnElementString);
            } catch (Exception e) {
                logger.error("Error while getting text from element: " + element, e);
            }
        } else {
            logger.warn("Element is either null or not displayed.");
        }

        return returnElementString;
    }

    public static boolean isCheckboxSelected(WebElement element) {
        try {
            String attr = element.getDomAttribute("checked");

            return attr != null && attr.equalsIgnoreCase("true");
        } catch (Exception e) {
            logger.error("Error while checking if checkbox is selected: ", e);
            return false;
        }
    }

}
