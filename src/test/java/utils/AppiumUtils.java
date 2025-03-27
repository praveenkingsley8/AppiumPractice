package utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

public class AppiumUtils extends TestBase {


    public static void tap(AndroidDriver driver, WebElement element){
        Point location = element.getLocation();
        Dimension size = element.getSize();
        Point center =centerOfGravity(location,size);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH,"finger1");

        Sequence sequence=new Sequence(finger1,1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),center))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1,Duration.ofMillis(300)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
    }

    public static void doubleTap(AndroidDriver driver,WebElement element){
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

        driver.perform(Collections.singletonList(sequence));

    }

    public static void longPress(AndroidDriver driver,WebElement element){
        Point location = element.getLocation();
        Dimension size = element.getSize();

        Point center = centerOfGravity(location,size);

        PointerInput finger1= new PointerInput(PointerInput.Kind.TOUCH,"finger1");

        Sequence sequence = new Sequence(finger1,1)
                .addAction(finger1.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),center))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1,Duration.ofSeconds(1)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));


        driver.perform(Collections.singletonList(sequence));
    }

    public static void zoom(AndroidDriver driver,WebElement element){

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

        driver.perform(Arrays.asList(sequence1,sequence2));
    }

    public static void scroll(AndroidDriver driver){
        Dimension size = driver.manage().window().getSize();
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

        driver.perform(Collections.singletonList(sequence));
    }

    public static void dragAndDrop(AndroidDriver driver,WebElement source,WebElement destination){
        Point centerSource = centerOfGravity(source.getLocation(),source.getSize());
        Point centerDestination = centerOfGravity(destination.getLocation(),destination.getSize());


        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH,"finger1");

        Sequence sequence = new Sequence(finger1,1)
                .addAction(finger1.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),centerSource))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1,Duration.ofMillis(500)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(500),PointerInput.Origin.viewport(),centerDestination))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));


        driver.perform(Collections.singletonList(sequence));

    }

    public static Point centerOfGravity(Point location,Dimension size){
        return new Point(location.getX()+ size.width/2, location.getY()+size.height/2);
    }
}
