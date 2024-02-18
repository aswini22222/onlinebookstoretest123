import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class SearchPageTest {
    public WebDriver driver;
    UserRegistrationPage userRegistrationPage;
    LoginPage loginPage;
    SearchPage searchPage;
    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
                {"ashwinipitti.1@gmail.com", "Ashwini@222"}
        };
    }

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\Selenium\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.vikrambooks.com/account/login");
        loginPage=new LoginPage(driver);
        userRegistrationPage=new UserRegistrationPage(driver);
        searchPage=new SearchPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test(priority = 1,dataProvider = "loginData()")
    public void searchFunctionality(String user,String password){

        loginPage.loginToApplication(user,password);
        String expurl="https://www.amazon.com/gp/aw/ya?ref_=navm_accountmenu_account&from=hz&isInternal=false";
        String actualurl=driver.getCurrentUrl();
        Assert.assertEquals(expurl,actualurl,"Urls do not match as expected");
        searchPage.enterbookname("The way of Life");
        String bookpageexpurl="https://www.amazon.com/s?k=way+of+life+book&crid=9QTYO53KCGMU&sprefix=way+of+life+boo%2Caps%2C553&ref=nb_sb_noss_2";
        String actualsearchpageurl="https://www.amazon.com/gp/aw/ya?ref_=navm_accountmenu_account&from=hz&isInternal=false";
        if(bookpageexpurl.equals(actualsearchpageurl)){
            System.out.println("Navigation to book page was successful");
        }else{
            System.out.println("Navigation to book page was failed");
        }
        searchPage.booktitle();
        System.out.println(searchPage.authorname());
        searchPage.bookname();
        searchPage.rating();
        searchPage.bookprice();
        searchPage.location();
        searchPage.availability();
        searchPage.quantity();
        searchPage.addtoList();
        searchPage.addtoCart();
        String expCarturl="https://www.amazon.com/cart/smart-wagon?newItems=ca376aed-762f-435c-ba1c-a82b357746af,1&ref_=sw_refresh";
        String actualCarturl="https://www.amazon.com/Way-Life-According-Laotzu/dp/0399512985/ref=mp_s_a_1_1?crid=1YMU4LCV2FTGE&dib=eyJ2IjoiMSJ9.IGiBs0xGlWxns-fzqDLQocdeDTJNSpIM8BJ-XuoJE76YitQSJFJlUSL0tV7MBx9BjSiIr36mhS9obWEt_gG5JvTlYU-ECg1e1oaSPpI5EgDgYojql8Zc7GsVvRtMVK4GbvXMl57qhR3YFEWvZEz5zQ9XUb-7r2965biJ0lo1JMAwwQHNZ8cB8k_AvUI0MhSxr95djE9NNzxQmWEZQGidng.8GSWQQLZdCZyOMIl0x5EGv_QdqqAyVZkjcKA-QouiSc&dib_tag=se&keywords=way+of+life&qid=1708166074&sprefix=way+of+life%2Caps%2C619&sr=8-1";
        Assert.assertEquals(expCarturl,actualCarturl,"Cart Urls does not matched as expected");

    }


}
