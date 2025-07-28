package BaseClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

import POM.HomePage;
import POM.LoginPage;
import PropertiesFileUtility.PropertiesUtility;

public class baseClass {

    public WebDriver driver = null;
    public static WebDriver sdriver = null;
    public PropertiesUtility putil = new PropertiesUtility();

    @BeforeSuite(groups = {"smoke","sanity"})
    public void beforeSuite() {
        Reporter.log("DB Connectivity open", true);
    }

    @BeforeTest(groups = {"smoke","sanity"})
    public void beforeTest() {
        System.out.println("Preconditions");
    }

    
//    @Parameters("BROWSER")
    @BeforeClass(groups = {"smoke","sanity"})
    public void beforeClass() throws IOException {
        String BROWSER = putil.getdatafrompropertiesfile("Browser");
//        driver = new FirefoxDriver();

        if (BROWSER.equals("Edge")) {
            driver = new EdgeDriver();
        } else if (BROWSER.equals("Chrome")) {
            driver = new ChromeDriver();
        } else  {
            driver = new FirefoxDriver();
        } 
         
        sdriver = driver;
        System.out.println("Launching Browser");
        driver.manage().window().maximize();
         }

    @BeforeMethod(groups = {"smoke","sanity"})
    public void beforeMethod() throws IOException {
        String URL = putil.getdatafrompropertiesfile("URL");
        String USERNAME = putil.getdatafrompropertiesfile("Usr");
        String PASSWORD = putil.getdatafrompropertiesfile("pwd");

        driver.get(URL);

        LoginPage lp = new LoginPage(driver);
        lp.getUN().sendKeys(USERNAME);
        lp.getPass().sendKeys(PASSWORD);
        lp.getLoginBtn().click();

        System.out.println("LOGIN DONE");
    }

    @AfterMethod(groups = {"smoke","sanity"})
    public void afterMethod() {
        HomePage hp = new HomePage(driver);
        hp.getuserIcon().click();
        hp.getLogout().click();

        System.out.println("LOGOUT DONE");
    }

    @AfterClass(groups = {"smoke","sanity"})
    public void afterClass() {
        driver.quit();
        System.out.println("Closing browser");
    }

    @AfterTest(groups = {"smoke","sanity"})
    public void afterTest() {
        System.out.println("Post conditions");
    }

    @AfterSuite(groups = {"smoke","sanity"})
    public void afterSuite() {
        System.out.println("Close DB Connectivity");
    }
}
