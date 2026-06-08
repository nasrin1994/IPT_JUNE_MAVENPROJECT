package test.pageobjectmodule;

import test.base.Base_Class;
import test.interfaceelements.LoginPageInterfaceElements;
import test.pageobjectmanager.PageObjectManager;
import test.utility.FileReaderManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LogInPage extends Base_Class implements LoginPageInterfaceElements {

    @FindBy(id = "login2")
    public static WebElement loginLink;

    @FindBy(id = "loginusername")
    public static WebElement username;

    @FindBy(id = "loginpassword")
    public static WebElement password;

    @FindBy(xpath = "//button[text()='Log in']")
    public static WebElement signin;

    @FindBy(id = "itemc")
    public static WebElement Laptop;

    @FindBy(xpath = "//a[contains(text(),'Sony vaio i5')]")
    public static WebElement Sony;

    @FindBy(xpath = "//a[contains(text(),'Add to')]")
    public static WebElement AddToCart;

    @FindBy(id = "cartur")
    public static WebElement menuCart;

    @FindBy(xpath = "//button[@class='btn btn-success']")
    public static WebElement placeOrderButton;

    @FindBy(id = "name")
    public static WebElement nameFill;

    @FindBy(id = "country")
    public static WebElement Country;

    @FindBy(id = "city")
    public static WebElement city;

    @FindBy(id = "card")
    public static WebElement creditCard;

    @FindBy(id = "month")
    public static WebElement month;

    @FindBy(id = "year")
    public static WebElement year;

    @FindBy(xpath = "//button[contains(text(),'Purchase')]")
    public static WebElement purchaseButton;


    public LogInPage(){
        PageFactory.initElements(driver,this);
    }

    public static void validLogin() throws IOException, InterruptedException {
        clickOnElement(loginLink);
        PageObjectManager.getPageObjectManager().getFileReaderManager();
        passInput(username, FileReaderManager.getDataProperty("username"));
        PageObjectManager.getPageObjectManager().getFileReaderManager();
        passInput(password, FileReaderManager.getDataProperty("password"));
        clickOnElement(signin);
        //handleAlert("accept",null);
        Thread.sleep(4000);
        clickOnElement(Laptop);
        clickOnElement(Sony);
        clickOnElement(AddToCart);
        handleAlert("accept",null);
        clickOnElement(menuCart);
        Thread.sleep(4000);
        screenShot("ProductsPage");
        clickOnElement(placeOrderButton);
        passInput(nameFill,FileReaderManager.getDataProperty("name"));
        passInput(Country,FileReaderManager.getDataProperty("country"));
        passInput(city,FileReaderManager.getDataProperty("city"));
        passInput(creditCard,FileReaderManager.getDataProperty("creditcard"));
        passInput(month,FileReaderManager.getDataProperty("month"));
        scrolldown(year);
        clickOnElement(purchaseButton);
        screenShot("FinalPage");
        driver.quit();



    }


}
