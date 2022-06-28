package tests.day16_notations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C06_SoftAssert extends TestBase {

    /*
    Softassertion baslangic ve bitis satirlari arasindaki
    tum assertion'lari yapip
    bitis satirina geldiginde bize buldugu tum hatalari rapor eder

     */
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

        /*
        Softassert'un hata bulsa bile calismaya devam etme ozelligi
        assertAll()'a kadardir
        Eger assertAll()'da failed rapor edilirse calisma durur
        ve class'in kalan kismi calistirilmaz
        (Yani assertAll hardAssert'deki her bir assert gibidir, hatayi yakalarsa calismayi durdurur
         */

        System.out.println("assertion'lardan fail olan olursa , burasi calismaz");
    }
}
