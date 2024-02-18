package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(className = "popover__title heading")
    WebElement LogintomyaccountHeadingEl;
    @FindBy(className = "popover__legend")
    WebElement EnteruremailandpassowrdheadingEl;
    @FindBy(linkText = "Create your account")
    WebElement NewcustomerlinkEl;
    @FindBy(linkText = "Recover password")
    WebElement LostpasswordLinkEl;
    @FindBy(xpath = "//a[contains(text(),' My account ')]")
    WebElement MyAccountel;
    @FindBy(id = "login-customer[email]")
    WebElement emailEl;
    @FindBy(how= How.ID,using = "login-customer[password]")
    WebElement passwordEl;
    @FindBy(how = How.LINK_TEXT,using = "Login")
    WebElement loginButtonEl;
    @FindBy(how = How.CLASS_NAME,using = "login-form-error")
    WebElement errormsgEl;
    //Instatianting
    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public WebElement LogintoMyAccountHeading(){
        return LogintomyaccountHeadingEl;
    }
    public WebElement EnterYourMailandPasswordHeading(){
        return EnteruremailandpassowrdheadingEl;
    }
    public WebElement NewCustomerText(){
        return NewcustomerlinkEl;
    }
    public WebElement LostPasswordText(){
        return LostpasswordLinkEl;
    }
    public void clickMyaccount(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),' My account ')]")));
        MyAccountel.click();
    }
    public void enteremail(String user){
        emailEl.sendKeys(user);
    }
    public void enterpassword(String password){
        passwordEl.sendKeys(password);
    }

    public void clickloginButton(){
        loginButtonEl.click();
    }
    public void loginToApplication(String user,String password){
        enteremail(user);
        enterpassword(password);
        clickloginButton();
    }
    public String geterrormessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        String errormessage=errormsgEl.getText();
        return errormessage;
    }
}




