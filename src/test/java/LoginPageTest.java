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

import java.time.Duration;

public class LoginPageTest {
    public WebDriver driver;
    LoginPage loginPage;
    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\Selenium\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.vikrambooks.com/account/login");
        loginPage=new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
                {"ashwinipitti.1@gmail.com", "Ashwini@222"}
        };
    }
    @Test(priority = 1)
    public void loginpageUI(){
        Assert.assertTrue(loginPage.LogintoMyAccountHeading().isDisplayed());
        System.out.println(loginPage.LogintoMyAccountHeading().getText());
        Assert.assertTrue(loginPage.EnterYourMailandPasswordHeading().isDisplayed());
        System.out.println(loginPage.EnterYourMailandPasswordHeading().getText());
        Assert.assertTrue(loginPage.NewCustomerText().isDisplayed());
        System.out.println(loginPage.NewCustomerText().getText());
        Assert.assertTrue(loginPage.LostPasswordText().isDisplayed());
        System.out.println(loginPage.LostPasswordText().getText());

    }
    @Test(priority = 1,dataProvider = "loginData")
    public void testwithvalidcredentials(String user,String password){
        loginPage.clickMyaccount();
        loginPage.loginToApplication(user,password);
        String expurl="https://www.vikrambooks.com/account";
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expurl));
        String actualurl=driver.getCurrentUrl();
        Assert.assertEquals(expurl,actualurl,"Urls Do not Match as expected");
    }
    @Test(priority = 2)
    public void testwithinvalidcredentials(){
        loginPage.loginToApplication("ashwinipitti@gmail.com","Ashwini@222");
        loginPage.geterrormessage();
        System.out.println(loginPage.geterrormessage());
        String expErrorMsg="Incorrect email or password.";
        String actualErrMsg=loginPage.geterrormessage();
        Assert.assertEquals(expErrorMsg,actualErrMsg,"Error Messages are not displayed as expected");
    }




}



