package tests.day17_pom;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C03_PageClassKullanimi {

    @Test
    public void test01() {
        // facebook anasayfaya gidin
        Driver.getDriver().get("https://www.facebook.com");
        // kullanici mail kutusuna rastgele bir isim yazdirin
        Faker faker=new Faker();
        FacebookPage fb=new FacebookPage();
        fb.mailGiris.sendKeys(faker.internet().emailAddress());
        // kullanici sifre kutusuna rastgele bir password yazdirin
        fb.passwordGiris.sendKeys(faker.internet().password());
        // login butonuna basin
        fb.loginBotton.click();
        // giris yapilamadigini test edin
        Assert.assertTrue(fb.errorText.isDisplayed());
        Driver.closeDriver();
    }
}
