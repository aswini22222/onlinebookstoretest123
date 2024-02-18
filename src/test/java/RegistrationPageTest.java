import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.UserRegistrationPage;

import java.time.Duration;

public class RegistrationPageTest {
    public WebDriver driver;
    LoginPage loginPage;
    UserRegistrationPage userregistrationpage;
    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\Selenium\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.vikrambooks.com/account/login");
        loginPage=new LoginPage(driver);
        userregistrationpage=new UserRegistrationPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
                {"Aswini", "Thammuthaka","ashwinipitti.1@gmail.com","Ashwini@222"}
        };
    }
    @Test(priority = 1,dataProvider = "loginData")
    public void registrationpage(String FirstName,String LastName,String Email,String password){
        loginPage.clickMyaccount();
        loginPage.NewCustomerText();
        userregistrationpage.clickcreatemyAccountButton();
        userregistrationpage.SubmitToApplication(FirstName,LastName,Email,password);
    }
    @Test(priority = 2)
    public void registrationpageUI(){
        Assert.assertTrue(userregistrationpage.CreateYourAccountHeadText().isDisplayed());
        System.out.println(userregistrationpage.CreateYourAccountHeadText().getText());
        Assert.assertTrue(userregistrationpage.pleasefilldetails().isDisplayed());
        System.out.println(userregistrationpage.pleasefilldetails().getText());
        String expLoginUrl="https://www.vikrambooks.com/account/login";
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expLoginUrl));
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expLoginUrl,"Login Urls do not matched as expected ");
    }

}
