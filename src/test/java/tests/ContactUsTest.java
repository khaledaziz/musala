package tests;

import helper.ExcelRead;
import helper.TestBase;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.ContactUsPage;

import java.io.IOException;

public class ContactUsTest extends TestBase {

    ContactUsPage contactUsPageObj;

    @BeforeClass
    public void initObj() throws InterruptedException {
        Thread.sleep(4000);
        initDriver();
        contactUsPageObj = new ContactUsPage(driver);

    }

    @BeforeMethod
    public void openUrl(){
        driver.get(baseUrl);
    }


    @Test(dataProvider = "invalidEmails")
    public void contactUsTest(String invalidEmails){
        logger = extent.createTest("Test contact us");
        contactUsPageObj.openContactUsPage();
        contactUsPageObj.setName(invalidEmails);
        contactUsPageObj.setEmail("fdfd");
        contactUsPageObj.setPhoneNum("+359 (2) 969 5821");
        contactUsPageObj.setSubject("test subject");
        contactUsPageObj.setMsg("test message");
        contactUsPageObj.submit();
        String actualError = contactUsPageObj.getErrorText();
        String expectedError = "The e-mail address entered is invalid.";
        Assert.assertEquals(actualError, expectedError);

    }
    @DataProvider (name = "invalidEmails" )
    public Object[][] successSignupData() throws IOException {
        String path = System.getProperty("user.dir") + "/data/RegisterTest.xlsx";
        String mySheet = "invalidEmails";
        ExcelRead testData = new ExcelRead();
        String data[][] = testData.retrieveMyData(path, mySheet);
        return data;
    }

    @AfterTest()
    public void finalizeTest(){
        driver.close();
    }
}
