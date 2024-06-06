package pagepkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

public class Pageclass {
    WebDriver driver;
    WebDriverWait wait;
    Logger logger = Logger.getLogger(Pageclass.class.getName());

    // Update the XPath to a more robust version
    @FindBy(xpath = "//*[@id=\"shopify-section-sections--15888994500689__header\"]/section/header/div/div/div[2]/div[2]/div/a[2]")
    WebElement loginclick;

    @FindBy(id = "customer[email]")
    WebElement email;

    @FindBy(id = "customer[password]")
    WebElement pass;

    @FindBy(xpath = "//*[@id=\"customer_login\"]/button")
    WebElement signin;
    
    @FindBy(xpath = "/html/body/div[3]/section/nav/div/div/ul/li[1]/a")
    WebElement newarr;
    
    @FindBy(xpath = "//*[@id=\"7280709730385\"]/div/a/div/div/div[1]/img[2]")
    WebElement pd;
    
    @FindBy(xpath = "//*[@id=\"product_form_template--15888997548113__main7280709730385\"]/div[8]/button")
    WebElement cart;
    
    @FindBy(xpath = "//*[@id=\"mini-cart\"]/div/div[2]/div[2]/div/button")
    WebElement co;
    
    public Pageclass(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void loginbutton() {
        logger.info("Attempting to click on login button");

        wait.until(ExpectedConditions.visibilityOf(loginclick));
        if (loginclick.isDisplayed() && loginclick.isEnabled()) {
            logger.info("Login button is displayed and enabled");
            wait.until(ExpectedConditions.elementToBeClickable(loginclick));
            loginclick.click();
            logger.info("Clicked on login button successfully");
        } else {
            logger.severe("Login button is not displayed or not enabled");
        }
    }

    public void setvalues(String un, String pswd) {
        logger.info("Setting values for email and password");
        wait.until(ExpectedConditions.visibilityOf(email));
        email.clear();
        email.sendKeys(un);

        wait.until(ExpectedConditions.visibilityOf(pass));
        pass.clear();
        pass.sendKeys(pswd);
    }

    public void signinClick() {
        logger.info("Clicking on sign-in button");
        wait.until(ExpectedConditions.elementToBeClickable(signin));
        signin.click();
    }
    
    public void newar()
    {
    	newarr.click();
    }
    public void movemouse()
    {
    	WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(30));
    	WebElement p=driver.findElement(By.xpath("//*[@id=\"shopify-section-sections--15888994500689__header\"]/section/nav/div/div/ul/li[3]/a"));
    	Actions act=new Actions(driver);
		act.moveToElement(p).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"desktop-menu-0-3\"]/li[3]/a"))).click();
    }
    public void product()
    {
    	pd.click();
    }
    public void addtocart()
    {
    	cart.click();
    }
    public void checkout()
    {
    	co.click();
    }
}