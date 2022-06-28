package tests.day18_pom;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_ConfigReaderKullanimi {
    @Test
    public void test01() {

        // facebook anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));
        // kullanici mail kutusuna yanlis bir isim yazdirin
        FacebookPage fb = new FacebookPage();
        fb.mailGiris.sendKeys(ConfigReader.getProperty("fbWrongUserName"));
        // kullanici sifre kutusuna rastgele bir password yazdirin
        fb.passwordGiris.sendKeys(ConfigReader.getProperty("fbWrongPassword"));
        // login butonuna basin
        fb.loginBotton.click();
        // giris yapilamadigini test edin
        Assert.assertTrue(fb.errorText.isDisplayed());
        // sayfayi kapatin
        Driver.closeDriver();
    }
}
