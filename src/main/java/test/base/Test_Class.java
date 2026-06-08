package test.base;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Test_Class extends Base_Class{

    public static void main(String[] args){
        launchBrowser("chrome");
        launchUrl("https://www.instagram.com/");
        WebElement element = driver.findElement(By.name("N"));
        passInput(element,"flower");
    }
    @Test
    public void testLogin() {

        navigateTo("https://www.google.com");
        navigate("refresh");
    }
}
