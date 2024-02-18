package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Shoppingcartpage {

    public WebDriver driver;
    @FindBy(xpath = "//span[@class='nav-cart-icon nav-sprite']")
    WebElement addtocartEl;
    @FindBy(name = "proceedToRetailCheckout")
    WebElement proceedtoCheckoutbuttonel;
    @FindBy(xpath = "(//input[@type='checkbox']/following-sibling::i)[2]")
    WebElement checkboxel;
    @FindBy(xpath = "//a[@class='a-size-medium a-link-normal']")
    WebElement quantityel;
    @FindBy(linkText= "Skip for now")
    WebElement skipforNowEl;
    @FindBy(className = "a-button-input")
    WebElement continueButtonel;
    @FindBy(className = "continue-button-text")
    WebElement continueButtonNextEl;
    @FindBy(linkText = "order-successfully")
    WebElement ordersuccessEl;
    public Shoppingcartpage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    public void clickaddtocart(){
        addtocartEl.click();
    }
    public void proceedtocheckbuttonEl(){
        proceedtoCheckoutbuttonel.click();
    }
    public void checkboxselect(){
        checkboxel.isEnabled();
    }
    public void setQuantityel(){
        quantityel.isSelected();
    }
    public void clickskipforNowEl(){
        skipforNowEl.click();
    }
    public void clickcontinueButton(){
        continueButtonel.click();
    }
    public void clickcontinuenext(){
        continueButtonNextEl.click();
    }
    public void ordersuccessmessage(){
        ordersuccessEl.isDisplayed();
    }


}




