package pages;

import helper.Actions;
import helper.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends TestBase {
    @FindBy(xpath ="(//*[contains (text(), 'Contact us')])")
    WebElement contactUsBTN;

    @FindBy(name ="your-name")
    WebElement nameTXT;

    @FindBy(name ="your-email")
    WebElement emailTXT;

    @FindBy(name ="mobile-number")
    WebElement phoneNumTXT;

    @FindBy(name ="your-subject")
    WebElement subjectTXT;

    @FindBy(name ="your-message")
    WebElement msgTXT;


    @FindBy(xpath ="(//input[@value= 'Send'])")
    WebElement submitBTN;

    @FindBy(xpath ="(//span[@class= 'wpcf7-not-valid-tip'])")
    WebElement errorMSG;


    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openContactUsPage(){
        Actions.seleniumScrollToElement(contactUsBTN);
        Actions.seleniumClick(contactUsBTN);
    }

    public void setName(String name){

        Actions.seleniumTypeText(nameTXT , name);
    }

    public void setEmail(String email){

        Actions.seleniumTypeText(emailTXT , email);
    }

    public void setPhoneNum(String phoneNum){

        Actions.seleniumTypeText(phoneNumTXT , phoneNum);
    }


    public void setSubject(String subject){

        Actions.seleniumTypeText(subjectTXT , subject);
    }

    public void setMsg(String msg){

        Actions.seleniumTypeText(msgTXT , msg);
    }

    public void submit(){
        Actions.seleniumScrollToElement(submitBTN);
        Actions.seleniumClick(submitBTN);
    }

    public String getErrorText(){
        Actions.seleniumScrollToElement(emailTXT);
        String errorText = Actions.seleniumGetText(errorMSG);
        return errorText;
    }

}
