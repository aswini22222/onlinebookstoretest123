package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserRegistrationPage {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(linkText = "Create your account")
    WebElement createyouraccountlinkEl;
    @FindBy(className = "form__title heading h1")
    WebElement createyourAccountHeadingEl;
    @FindBy(className = "form__legend")
    WebElement pleasefilldetailssentenceEl;
    @FindBy(id = "customer[first_name]")
    WebElement firstnameEl;
    @FindBy(id = "customer[last_name]")
    WebElement lastnameel;
    @FindBy(id = "customer[email]")
    WebElement EmailEl;
    @FindBy(id = "customer[password]")
    WebElement passwordEl;
    @FindBy(linkText = "Create my account")
    WebElement CreateMyAccountButtonEl;
    @FindBy(className = "shopify-challenge__message")
    WebElement RobotMessageel;
    @FindBy(className = "recaptcha-checkbox-border")
    WebElement checkBoxEl;
    @FindBy(className = "shopify-challenge__button btn")
    WebElement submitButtonel;
    public UserRegistrationPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public WebElement CreateYourAccountHeadText(){
        return createyourAccountHeadingEl;
    }
    public WebElement pleasefilldetails(){
        return pleasefilldetailssentenceEl;
    }
    public void enterfirstName(String FirstName){
        firstnameEl.sendKeys(FirstName);
    }
    public void enterLastName(String LastName){
        lastnameel.sendKeys(LastName);
    }
    public void enteremail(String Email){
        EmailEl.sendKeys(Email);
    }
    public void enterpassword(String password){
        passwordEl.sendKeys(password);
    }

    public void clickcreatemyAccountButton(){
        CreateMyAccountButtonEl.click();
    }
    public void SubmitToApplication(String FirstName,String LastName,String Email,String password){
        enterfirstName(FirstName);
        enterLastName(LastName);
        enteremail(Email);
        enterpassword(password);
        clickcreatemyAccountButton();
    }
    public WebElement RobotmessageText(){
        return RobotMessageel;
    }
    public void clickCheckBox(){
        checkBoxEl.click();
    }
    public void clickSubmitButton(){
        submitButtonel.click();
    }


}
