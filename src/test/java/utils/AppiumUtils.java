package utils;

import driver.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import report.ReportLogger;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

public class AppiumUtils extends TestBase {


    public static void tap(WebElement element,String elementName){
        try {
            Point location = element.getLocation();
            Dimension size = element.getSize();
            Point center =centerOfGravity(location,size);

            PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH,"finger1");

            Sequence sequence=new Sequence(finger1,1)
                    .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),center))
                    .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(new Pause(finger1,Duration.ofMillis(300)))
                    .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            DriverManager.getDriver().perform(Collections.singletonList(sequence));

            ReportLogger.pass("Tapped on "+elementName);
            logger.info("Tapped successfully: " + element.toString());

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error while trying to tap element: " + e.getMessage());
            ReportLogger.fail("Unable to tap on "+elementName);
        }
    }

    public static void doubleTap(WebElement element){
        Point location = element.getLocation();
        Dimension size =element.getSize();

        Point center = centerOfGravity(location,size);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH,"finger1");

        Sequence sequence=new Sequence(finger1,1)
                .addAction(finger1.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),center))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1,Duration.ofMillis(100)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1,Duration.ofMillis(100)))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1,Duration.ofMillis(100)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        DriverManager.getDriver().perform(Collections.singletonList(sequence));

    }

    public static void longPress(WebElement element,String elementName){
        try {
            Point location = element.getLocation();
            Dimension size = element.getSize();

            Point center = centerOfGravity(location,size);

            PointerInput finger1= new PointerInput(PointerInput.Kind.TOUCH,"finger1");

            Sequence sequence = new Sequence(finger1,1)
                    .addAction(finger1.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),center))
                    .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(new Pause(finger1,Duration.ofSeconds(1)))
                    .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));


            DriverManager.getDriver().perform(Collections.singletonList(sequence));
            ReportLogger.pass("Long pressed on "+elementName);
            logger.info("Long pressed successfully: " + element.toString());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error while trying to Long press element: " + e.getMessage());
            ReportLogger.fail("Unable to Long press on "+elementName);
        }
    }

    public static void zoom(WebElement element){

        Point location = element.getLocation();
        Dimension size = element.getSize();

        Point center = centerOfGravity(location,size);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH,"finger1");

        Sequence sequence1 = new Sequence(finger1,1)
                .addAction(finger1.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),center))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1,Duration.ofMillis(200)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(200),PointerInput.Origin.viewport(),center.getX()+100,center.getY()-100))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));


        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH,"finger2");

        Sequence sequence2 = new Sequence(finger2,1)
                .addAction(finger2.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),center))
                .addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger2,Duration.ofMillis(200)))
                .addAction(finger2.createPointerMove(Duration.ofMillis(200),PointerInput.Origin.viewport(),center.getX()-100,center.getY()+100))
                .addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        DriverManager.getDriver().perform(Arrays.asList(sequence1,sequence2));
    }

    public static void scroll(){
        Dimension size = DriverManager.getDriver().manage().window().getSize();
        int startX = size.getWidth()/2;
        int startY = size.getHeight()/2;
        int endX =startX;
        int endY = (int)(size.getHeight()*0.25);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH,"finger1");

        Sequence sequence = new Sequence(finger1,1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),startX,startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1,Duration.ofMillis(200)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(200),PointerInput.Origin.viewport(),endX,endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        DriverManager.getDriver().perform(Collections.singletonList(sequence));
    }

    public static void scrollDownToElement(WebElement element, String elementName) {
        int maxScroll = 0;
        boolean bElementNotFound = true;

        try {
            while (bElementNotFound && maxScroll < 10) {
                Dimension size = DriverManager.getDriver().manage().window().getSize();
                int startX = size.getWidth() / 2;
                int startY = size.getHeight() / 2;
                int endX = startX;
                int endY = (int) (size.getHeight() * 0.25);

                PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

                Sequence sequence = new Sequence(finger1, 1)
                        .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                        .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                        .addAction(new Pause(finger1, Duration.ofMillis(200)))
                        .addAction(finger1.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), endX, endY))
                        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

                DriverManager.getDriver().perform(Collections.singletonList(sequence));

                try {
                    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(1));
                    wait.until(ExpectedConditions.visibilityOf(element));
                    bElementNotFound = !element.isDisplayed();
                } catch (Exception e) {
                    maxScroll++;
                    bElementNotFound = true;
                }
            }

            if (!bElementNotFound) {
                ReportLogger.pass("Scrolled to " + elementName);
                logger.info("Scroll to element successfully: " + element.toString());
            } else {
                logger.warn("Failed to scroll to the element: " + elementName);
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error while scrolling to element: " + elementName, e);
        }
    }

    public static void scrollUpToElement(WebElement element, String elementName) {
        int maxScroll = 0;
        boolean bElementNotFound = true;

        try {
            while (bElementNotFound && maxScroll < 10) {
                Dimension size = DriverManager.getDriver().manage().window().getSize();
                int startX = size.getWidth() / 2;
                int startY = size.getHeight() / 2;
                int endX = startX;
                int endY = (int) (size.getHeight() * 0.75);

                PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

                Sequence sequence = new Sequence(finger1, 1)
                        .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                        .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                        .addAction(new Pause(finger1, Duration.ofMillis(200)))
                        .addAction(finger1.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), endX, endY))
                        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

                DriverManager.getDriver().perform(Collections.singletonList(sequence));

                try {
                    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(1));
                    wait.until(ExpectedConditions.visibilityOf(element));
                    bElementNotFound = !element.isDisplayed();
                } catch (Exception e) {
                    maxScroll++;
                    bElementNotFound = true;
                }
            }

            if (!bElementNotFound) {
                ReportLogger.pass("Scrolled up to " + elementName);
                logger.info("Scroll up to element successfully: " + element.toString());
            } else {
                logger.warn("Failed to scroll up to the element: " + elementName);
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error while scrolling up to element: " + elementName, e);
        }
    }

    public static void swipeLeft(Point point) {



        try {
            PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

            Sequence sequence = new Sequence(finger1, 1)
                    .addAction(finger1.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), point.getX(), point.getY()))
                    .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(new Pause(finger1, Duration.ofMillis(100)))
                    .addAction(finger1.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), 0, point.getY()))
                    .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            DriverManager.getDriver().perform(Collections.singletonList(sequence));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void dragAndDrop(WebElement source,WebElement destination){
        try {
            Point centerSource = centerOfGravity(source.getLocation(),source.getSize());
            Point centerDestination = centerOfGravity(destination.getLocation(),destination.getSize());


            PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH,"finger1");

            Sequence sequence = new Sequence(finger1,1)
                    .addAction(finger1.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),centerSource))
                    .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(new Pause(finger1,Duration.ofMillis(500)))
                    .addAction(finger1.createPointerMove(Duration.ofMillis(500),PointerInput.Origin.viewport(),centerDestination))
                    .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));


            DriverManager.getDriver().perform(Collections.singletonList(sequence));

            ReportLogger.pass("Drag and Drop performed successfully " );
            logger.info("Drag and Drop performed successfully ");

        } catch (Exception e) {
            logger.error("Error while performing Drag and Drop", e);

            e.printStackTrace();
        }

    }

    public static Point centerOfGravity(Point location,Dimension size){
        return new Point(location.getX()+ size.width/2, location.getY()+size.height/2);
    }

















    public static void tap2(AndroidDriver driver,WebElement element){

        Point location = element.getLocation();
        Dimension size = element.getSize();

        Point center = new Point(location.getX()+size.width/2,location.getY()+size.height/2);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH,"finger1");

        Sequence seq=new Sequence(finger1,1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),center))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1,Duration.ofMillis(100)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));


        driver.perform(Collections.singletonList(seq));
    }
}
