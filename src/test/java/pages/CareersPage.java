package pages;

import helper.Actions;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CareersPage extends TestBase {

    @FindBy(xpath ="((//*[@href ='https://www.musala.com/careers/'])[5])")
    WebElement careersITM;


    @FindBy(xpath ="(//span[@data-alt ='Check our open positions'])")
    WebElement openPositionBTN;

    @FindBy(id ="get_location")
    WebElement locationDDL;

    @FindBy(xpath ="(//h2[text() = 'General description'])")
    WebElement desSection;

    @FindBy(xpath ="//h2[text() = 'Requirements']")
    WebElement reqSection;

    @FindBy(xpath ="//h2[text() = 'Responsibilities']")
    WebElement resSection;

    @FindBy(xpath ="//h2[text() = 'What we offer']")
    WebElement offerSection;

    @FindBy(xpath ="(//img[@alt ='Experienced Automation QA Engineer'])[1]")
    WebElement qaPosition;

    @FindBy(xpath ="//input[@value = 'Apply']")
    WebElement applyBtn;

    @FindBy(name ="your-name")
    WebElement nameTXT;

    @FindBy(name ="your-email")
    WebElement emailTXT;

    @FindBy(name ="mobile-number")
    WebElement phoneNumTXT;

    @FindBy(name ="uploadtextfield")
    WebElement cvField;

    @FindBy(name ="your-message")
    WebElement msgTXT;

    @FindBy(xpath ="(//input[@value= 'Send'])")
    WebElement submitBTN;

    @FindBy(xpath ="//div[@class='wpcf7-response-output']")
    WebElement errorMSG;

    @FindBy(xpath ="//h2[@class = 'card-jobsHot__title']")
    WebElement jobTitle;

    public CareersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openCareersPage(){
        Actions.seleniumClick(careersITM);
    }

    public void openPositions(){
        Actions.seleniumClick(openPositionBTN);
    }

    public void selectCity(String city){
        Actions.seleniumSelectDDLByValue(locationDDL, city);
    }

    public void selectQaPosition(){
        Actions.seleniumScrollToElement(qaPosition);
        Actions.seleniumClick(qaPosition);
    }

    public void verifyAvailableSection(){
        Actions.seleniumScrollToElement(desSection);
        Assert.assertTrue(desSection.isDisplayed());
        Assert.assertTrue(reqSection.isDisplayed());
        Assert.assertTrue(resSection.isDisplayed());
        Assert.assertTrue(offerSection.isDisplayed());
    }

    public void verifyApplyButton(){
        Actions.seleniumScrollToElement(applyBtn);
        applyBtn.isDisplayed();
    }

    public void clickApply(){
        Actions.seleniumClick(applyBtn);
    }

    public void setName(String name){
        Actions.seleniumScrollToElement(nameTXT);
        Actions.seleniumTypeText(nameTXT , name);
    }

    public void setEmail(String email){
        Actions.seleniumScrollToElement(emailTXT);
        Actions.seleniumTypeText(emailTXT , email);
    }

    public void setPhoneNum(String phoneNum){
        Actions.seleniumScrollToElement(phoneNumTXT);
        Actions.seleniumTypeText(phoneNumTXT , phoneNum);
    }

    public void uploadCv(String path){
        Actions.seleniumScrollToElement(cvField);
        Actions.seleniumUploadFile(cvField, path);
    }

    public void setMsg(String msg){

        Actions.seleniumTypeText(msgTXT , msg);
    }

    public void submit(){
        Actions.seleniumScrollToElement(submitBTN);
        Actions.seleniumClick(submitBTN);
    }

    public String getErrorText(){
        //Actions.seleniumScrollToElement(emailTXT);
        String errorText = Actions.seleniumGetText(errorMSG);
        return errorText;
    }

    public void printJobs(String city) throws InterruptedException {
        List<WebElement> allJobsElements= driver.findElements(By.xpath("//h2[@class = 'card-jobsHot__title']"));
        List<String> allJobs = new ArrayList<>();
        List<WebElement> jobsInfoElements= driver.findElements(By.xpath("//a[@class = 'card-jobsHot__link']"));
        List<String> jobsInfo = new ArrayList<>();
        for(int i =0; i<allJobsElements.size(); i++){
            String x = allJobsElements.get(i).getText();
            allJobs.add(x);
            x= jobsInfoElements.get(i).getAttribute("href");
            jobsInfo.add(x);
        }
        System.out.println(city);
        for(int i =0; i<allJobsElements.size(); i++){

            System.out.println("Position: " +allJobs.get(i));
            System.out.println("More info: " +jobsInfo.get(i));
        }
    }
}
