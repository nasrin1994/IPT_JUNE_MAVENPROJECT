package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.base.Base_Class;
import test.utility.ReadExcelData;

import java.io.IOException;
import java.time.Duration;

public class TestRunner extends Base_Class {

    public static void main(String[] args) throws IOException, InterruptedException {

        launchBrowser("chrome");
        launchUrl("https://www.youtube.com/");
        String youtube = ReadExcelData.getParticularData(0,0);
        driver.findElement(By.xpath("//input[@name='search_query']")).sendKeys(youtube);
        WebElement searchicon = driver.findElement(By.xpath("//button[@title='Search']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(searchicon));
        searchicon.click();
        Thread.sleep(4000);
        screenShot("youtubeJava");

    }
}
