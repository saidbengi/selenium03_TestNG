package tests.day16_notations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_Assertions extends TestBase {

    @Test
    public void test01() {
        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        // title'in Amazon icerdigini test edin
        String actualTitle=driver.getTitle();
        String expecteTitle="Amazon";
        Assert.assertTrue(actualTitle.contains(expecteTitle));
        // arama kutusunun erisilebilir oldugunu test edin
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(searchBox.isEnabled());
        // arama kutusuna nutella yazip aratin
        searchBox.sendKeys("Nutella"+ Keys.ENTER);
        // arama yapildigini test edin
        WebElement sonucYaziElement=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucYaziElement.isDisplayed());
        // arama sonucunun Nutella icerdigini test edin
        Assert.assertTrue(sonucYaziElement.getText().contains("Nutella"));
    }
}
