package Tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;


import java.io.File;
import java.io.IOException;
import java.util.Date;


@Listeners(Tests.SpreeListener.class)
public class SpreeListener implements ITestListener {




    @Override
        public void onTestStart(ITestResult result) {
            System.out.println("The Test Case " + result.getName() + " has started");
            // BaseTest.takeScreenShot(driver);
        }

        @Override
        public void onTestSuccess(ITestResult result) {
            System.out.println("The Test Case " + result.getName() + " has successfully completed");
        }

        @Override
        public void onTestFailure(ITestResult result)
        {
            System.out.println("The Test Case " + result.getName() + " has failed");
            System.out.println("The Method name of the testcase failed is :"+result.getName());
            try {
                takeScreenshot(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
         public void takeScreenshot(ITestResult result) throws IOException
         {
             WebDriver driver = (WebDriver) result.getTestContext().getAttribute("webdriver");
             Date date = new Date();
                 TakesScreenshot ts = (TakesScreenshot) driver;
                    File sourceFile = ts.getScreenshotAs(OutputType.FILE);
                 File destinationFile = new File("/Users/chitra/Desktop/PageSpreeFactory/src/test/screenshots" + date + "_screenshot.png");
                    FileUtils.copyFile(sourceFile, destinationFile);
         }


        @Override
        public void onTestSkipped(ITestResult result) {
            System.out.println("The Test Case " + result.getName() + " is skipped");
        }
    }

