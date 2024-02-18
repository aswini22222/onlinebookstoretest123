package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchPage {
    WebDriver driver;
    @FindBy(id = "twotabsearchtextbox")
    WebElement searchboxEl;
    @FindBy(linkText = "The Way of Life: Experiencing the Culture of Heaven on Earth")
    WebElement booktitleEl;
    @FindBy(linkText = " Bill Johnson ")
    WebElement AuthorEl;
    @FindBy(xpath = "//div[@class='a-column a-span12']//h1[1]")
    WebElement booknameEl;
    @FindBy(xpath = "//span[text()=' 4.8 ']")
    WebElement ratingEl;
    @FindBy(xpath = "(//span[@class='a-price-whole'])[2]")
    WebElement bookpriceEl;
    @FindBy(css = "div#contextualIngressPtLabel_deliveryShortLine>span")
    WebElement locationel;
    @FindBy(css = "span.a-size-base.a-color-price.a-text-bold")
    WebElement availabilityEl;
    @FindBy(xpath = "//span[text()='Quantity:']")
    WebElement quantityEl;
    @FindBy(xpath = "//a[@class='a-spacing-none a-link-normal']")
    WebElement addtoListEl;
    @FindBy(xpath = "//span[text()=' Add to Cart '])[2]")
    WebElement addtoCartEl;
    public SearchPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    public void enterbookname(String name){
        searchboxEl.sendKeys(name);
    }
    public void booktitle(){
       booktitleEl.click();
    }
    public String authorname(){
        return AuthorEl.getText();
    }
    public String bookname(){
        return booknameEl.getText();
    }
    public String rating(){
        return ratingEl.getText();
    }
    public String bookprice(){
        return bookpriceEl.getText();
    }
    public void location(){
        locationel.getText();
    }
    public void availability(){
        availabilityEl.getText();
    }
    public void quantity(){
        Select quantityel=new Select(quantityEl);
        quantityel.selectByIndex(2);
    }
    public void addtoList(){
        addtoListEl.click();
    }
    public void addtoCart(){
        addtoCartEl.click();
    }

 }
