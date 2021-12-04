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
import pages.CompanyPage;
import pages.ContactUsPage;

import java.util.ArrayList;
import java.util.HashMap;

public class CompanyTest extends TestBase {
    CompanyPage companyPageObj;

    @BeforeClass
    public void initObj() throws InterruptedException {
        Thread.sleep(2000);
        initDriver();
        companyPageObj = new CompanyPage(driver);
    }

    @BeforeMethod
    public void openUrl(){
        driver.get(baseUrl);
    }

    @Test
    public void testCompany(){
        logger = extent.createTest("Test company page");
        companyPageObj.openCompanyPage();

        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.musala.com/company/";
        Assert.assertEquals(currentUrl, expectedUrl);

        String actualSectionTitle= companyPageObj.getSectionText();
        String expectedSectionTitle = "Leadership";
        Assert.assertEquals(actualSectionTitle, expectedSectionTitle);
        System.out.println(actualSectionTitle);
        companyPageObj.openFacebookPage();


        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        currentUrl = driver.getCurrentUrl();
        expectedUrl = "https://www.facebook.com/MusalaSoft?fref=ts";
        Assert.assertEquals(currentUrl, expectedUrl);

        Assert.assertTrue(companyPageObj.assertImage());
    }

    @AfterTest(alwaysRun=true)
    public void finalizeTest(){
        driver.close();
    }

}
