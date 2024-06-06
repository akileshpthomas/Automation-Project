package testpkg;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import basepkg.Baseclass;
import pagepkg.Pageclass;
import utilities.Excelutils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testclass extends Baseclass {
    Logger logger = Logger.getLogger(Testclass.class.getName());
    Pageclass page;

    @BeforeMethod
    public void setUp() {
        page = new Pageclass(driver);
    }

    @Test(priority = 1)
    public void lg() {
        try {
            page.loginbutton();
            logger.info("Clicked on login button");
        } catch (Exception e) {
            logger.severe("Failed to click on login button: " + e.getMessage());
            Assert.fail("Login button click failed");
        }
    }

    @Test(priority = 2)
    public void verifyLoginWithValidCred() throws Exception {
        String xl = "E:\\Software Testing Notes\\Assignments\\Book2.xlsx";
        String sheet = "Sheet1";
        int rowCount = Excelutils.getRowCount(xl, sheet);

        for (int i = 1; i <= rowCount; i++) {
            String userName = Excelutils.getCellValue(xl, sheet, i, 0);
            String pwd = Excelutils.getCellValue(xl, sheet, i, 1);
            logger.info("Attempting login with username: " + userName);

            try {
                page.setvalues(userName, pwd);
                page.signinClick();

                // Add wait to ensure the login process completes
                new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.urlContains("account"));

                logger.info("Login successful with username: " + userName);
            } catch (Exception e) {
                logger.severe("Login failed for username: " + userName + ". Error: " + e.getMessage());
                Assert.fail("Login failed for username: " + userName);
            }}
        }
        @Test(priority = 3)
        public void assertion()
        {
        	String expectedurl="https://basicslife.com/account";
        	String actualurl=driver.getCurrentUrl();
        	Assert.assertEquals(actualurl, expectedurl);
        }
    
    
    @Test(priority = 4)
    public void clicknewarr()
    {
    	Pageclass p1=new Pageclass(driver);
    	p1.newar();
    	p1.movemouse();
    	
    	
    }
    @Test(priority = 5)
    public void clickcart()
    {
    	Pageclass p1=new Pageclass(driver);
    	p1.product();
    	p1.addtocart();
    	p1.checkout();
}
    @Test(priority = 6)
    public void test() throws IOException
    {
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src,new File("./screenshot/screenshot.png"));
    }
    }