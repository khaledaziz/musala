package tests;

import helper.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CareersPage;

import java.util.HashMap;


public class CareersTest extends TestBase {

    CareersPage careersPageObj;

    @BeforeClass
    public void initObj() throws InterruptedException {
        Thread.sleep(3000);
        initDriver();
        careersPageObj = new CareersPage(driver);


    }

    @BeforeMethod
    public void openUrl() {
        driver.get(baseUrl);
    }



    @Test
    public void testApplyWithInvalidEmail() {
        logger = extent.createTest("Test Apply to job with invalid email");

        careersPageObj.openCareersPage();
        careersPageObj.openPositions();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.musala.com/careers/join-us/";
        Assert.assertEquals(currentUrl, expectedUrl);
        careersPageObj.selectCity("Anywhere");
        careersPageObj.selectQaPosition();
        careersPageObj.verifyAvailableSection();
        careersPageObj.verifyApplyButton();
        careersPageObj.clickApply();
        careersPageObj.uploadCv("src\\test\\resources\\test.jpg");
        careersPageObj.setName("testUser");
        careersPageObj.setEmail("test.com");
        careersPageObj.setPhoneNum("09540545454");
        careersPageObj.setMsg("testMsg");
        careersPageObj.submit();
        String actualError = careersPageObj.getErrorText();
        String expectedError = "One or more fields have an error. Please check and try again.";
        Assert.assertEquals(actualError, expectedError);
    }

    @Test
    public void testApplyWithEmptyName() {
        logger = extent.createTest("Test Apply to job with empty name");
        careersPageObj.openCareersPage();
        careersPageObj.openPositions();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.musala.com/careers/join-us/";
        Assert.assertEquals(currentUrl, expectedUrl);
        careersPageObj.selectCity("Anywhere");
        careersPageObj.selectQaPosition();
        careersPageObj.verifyAvailableSection();
        careersPageObj.verifyApplyButton();
        careersPageObj.clickApply();
        careersPageObj.uploadCv("src\\test\\resources\\test.jpg");
        careersPageObj.setEmail("test.com");
        careersPageObj.setPhoneNum("09540545454");
        careersPageObj.setMsg("testMsg");
        careersPageObj.submit();
        String actualError = careersPageObj.getErrorText();
        String expectedError = "One or more fields have an error. Please check and try again.";
        Assert.assertEquals(actualError, expectedError);
    }

    @Test
    public void testSofiaJobs() throws InterruptedException {
        logger = extent.createTest("Test available jobs in Sofia");
        careersPageObj.openCareersPage();
        careersPageObj.openPositions();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.musala.com/careers/join-us/";
        Assert.assertEquals(currentUrl, expectedUrl);
        careersPageObj.selectCity("Sofia");
        careersPageObj.printJobs("Sofia");

        careersPageObj.selectCity("Skopje");
        careersPageObj.printJobs("Skopje");

    }

    @AfterTest(alwaysRun=true)
    public void finalizeTest(){
        driver.close();
    }
}
