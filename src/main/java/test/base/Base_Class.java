package test.base;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class Base_Class {
    public static WebDriver driver;

    protected static WebDriver launchBrowser(String browserName) {
        try {
            if (browserName.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            }
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING BROWSER LAUNCH");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        return driver;
    }

    protected static void navigateTo(String url) {
        try {
            driver.get(url);
        } catch (Exception e) {
            Assert.fail("ERROR OCCURRED DURING NAVIGATION");
        }
    }

    protected static void windowsHandling(int num) {
        try {
            List<String> allwindow = new ArrayList<>(driver.getWindowHandles());
        } catch (Exception e) {
            Assert.fail("ERROR OCCURRED WHILE PASSING VALUE");
        }
    }


    protected static void navigate(String action) {

        try {

            if (action.equalsIgnoreCase("back")) {
                driver.navigate().back();

            } else if (action.equalsIgnoreCase("forward")) {
                driver.navigate().forward();

            } else if (action.equalsIgnoreCase("refresh")) {
                driver.navigate().refresh();

            } else {
                Assert.fail("INVALID NAVIGATION ACTION: " + action);
            }

        } catch (Exception e) {
            Assert.fail("ERROR OCCURRED DURING NAVIGATION");
        }
    }


    protected static void mouseAction(String action, WebElement element) {

        try {

            Actions act = new Actions(driver);

            switch (action.toLowerCase()) {

                case "click":
                    act.click(element).perform();
                    break;

                case "doubleclick":
                    act.doubleClick(element).perform();
                    break;

                case "contextclick":
                    act.contextClick(element).perform();
                    break;

                default:
                    Assert.fail("INVALID MOUSE ACTION: " + action);
            }

        } catch (Exception e) {
            Assert.fail("ERROR OCCURRED DURING MOUSE ACTION");
        }
    }

    protected static void handleAlert(String action, String text) {

        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            switch (action.toLowerCase()) {

                case "accept":
                    alert.accept();
                    break;

                case "dismiss":
                    alert.dismiss();
                    break;

                case "sendkeys":
                    alert.sendKeys(text);
                    alert.accept();
                    break;

                case "gettext":
                    System.out.println(alert.getText());
                    break;

                default:
                    Assert.fail("INVALID ALERT ACTION: " + action);
            }

        } catch (Exception e) {
            Assert.fail("ERROR OCCURRED WHILE HANDLING ALERT");
        }
    }

    protected static void clickOnElement(WebElement element) {

        try {
            element.click();

        } catch (Exception e) {
            Assert.fail("ERROR OCCURRED WHILE CLICKING ON ELEMENT");
        }
    }

    protected static void passInput(WebElement element, String value) {

        try {
            element.sendKeys(value);
        } catch (Exception e) {
            Assert.fail("ERROR OCCURRED WHILE PASSING INPUT");
        }
    }

    protected static void launchUrl(String url) {

        try {

            driver.get(url);

        } catch (Exception e) {

            Assert.fail("ERROR OCCURRED WHILE LAUNCHING URL");
        }
    }

    protected static void screenShot(String name) throws IOException {
        TakesScreenshot tk = (TakesScreenshot) driver;
        File src = tk.getScreenshotAs(OutputType.FILE);
        File dest = new File("C:\\Users\\nasri\\IdeaProjects\\MavenProject\\src\\test\\screenhots" + name + ".png");
        FileHandler.copy(src, dest);
    }
    protected static void scrolldown(WebElement down) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", down);

    }

    public void scrollup(WebElement up) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false)", up);
    }
    }

