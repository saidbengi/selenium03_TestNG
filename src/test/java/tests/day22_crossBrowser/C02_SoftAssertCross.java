package tests.day22_crossBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;
import utilities.TestBaseCross;

public class C02_SoftAssertCross extends TestBaseCross {


    // Sorfassert baslangici obje olusturmaktir
    SoftAssert softAssert=new SoftAssert();

    @Test
    public void test01() {
        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        // title'in Amazon icerdigini test edin
        String actualTitle = driver.getTitle();
        String expecteTitle = "Amazon";
        softAssert.assertTrue(actualTitle.contains(expecteTitle),"title amazon icermiyor");
        // arama kutusunun erisilebilir oldugunu test edin
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(searchBox.isEnabled(),"arama kutusuna erisilemiyor");
        // arama kutusuna nutella yazip aratin
        searchBox.sendKeys("Nutella" + Keys.ENTER);
        // arama yapildigini test edin
        WebElement sonucYaziElement = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(sonucYaziElement.isDisplayed(),"arama yapilamadi");
        // arama sonucunun Nutella icerdigini test edin
        softAssert.assertTrue(sonucYaziElement.getText().contains("Nutella"),"sonuc yazısı Kutella icermiyor ");

        // softasserte bitis satirini soylemek icin assertAll() kullanilir

        softAssert.assertAll();// bu satir yazilmazsa assertion gorevi yapilmamis olur

        System.out.println("assertion'lardan fail olan olursa , burasi calismaz");
    }
}
