package org.megaprint;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Baurz on 4/18/2017.
 */
public class AppiumBasicTest {
    DesiredCapabilities cap=new DesiredCapabilities();
    AndroidDriver<AndroidElement> adriver;
    @BeforeMethod
    public void init() throws MalformedURLException {
        File file=new File("data");
        File fileName=new File(file,"ApiDemos-debug.apk");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Demo");
        cap.setCapability(MobileCapabilityType.APP,fileName.getAbsolutePath());
        adriver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
    }
    @Test
    public void test1(){
        adriver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        adriver.findElementByXPath("//android.widget.TextView[@index='2']").click();
        adriver.findElementById("android:id/checkbox").click();
        adriver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
        adriver.findElementById("android:id/edit").sendKeys("NAME");
        adriver.findElementsByClassName("android.widget.Button").get(1).click();
    }


}
