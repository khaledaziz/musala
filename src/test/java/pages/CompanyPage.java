package pages;

import helper.Actions;
import helper.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompanyPage extends TestBase {

    @FindBy(xpath ="((//*[@href ='https://www.musala.com/company/'])[5])")
    WebElement companyITM;


    @FindBy(xpath ="(//span[@class='musala musala-icon-facebook'])")
    WebElement facebookICN;

    @FindBy(xpath ="(//section[@class='company-members']//h2)")
    WebElement leadersSection;

    @FindBy(xpath ="(//img[@class='_6tb5 img'])")
    WebElement profileImage;

    public CompanyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openCompanyPage(){
        Actions.seleniumClick(companyITM);
    }

    public void openFacebookPage(){
        Actions.seleniumScrollToElement(facebookICN);
        Actions.seleniumClick(facebookICN);
    }

    public String getSectionText(){
        Actions.seleniumScrollToElement(leadersSection);
        String sectionTitle = Actions.seleniumGetText(leadersSection);
        return sectionTitle;
    }

    public boolean assertImage(){
        boolean imagePresence;
        imagePresence = Actions.imagePresence(profileImage);
        return imagePresence;
    }

}
