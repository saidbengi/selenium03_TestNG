package tests.day21_reusableMethods_HtmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.hotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_PozitiveLoginTestiRaporlu extends TestBaseRapor {

    @Test
    public void positiveLoginTest() {
        extentTest=extentReports.createTest("Pozitif Login","Gecerli mail ve sifre ile giris yapabilmeli ");
        //2) Bir Class olustur : PositiveTest
        //3) Bir test method olustur positiveLoginTest()
        //https://www.hotelmycamp.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("hotelMyCamp"));
        extentTest.info("hotelMyCamp anasayfaya gidildi");
        //login butonuna bas
        hotelMyCampPage hp=new hotelMyCampPage();
        hp.loginButton.click();
        extentTest.info("login butonuna tiklandi");
        //test data username: manager ,
        hp.username.sendKeys(ConfigReader.getProperty("hotelValidUserName"));
        extentTest.info("Gecerli username yazildi");
        //test data password : Manager1!
        hp.password.sendKeys(ConfigReader.getProperty("hotelValidPassword"));
        extentTest.info("Gecerli password yazildi");
        hp.loginButton2.click();
        extentTest.info("login butonuna basildi");
        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        String actualUserName=hp.usernameTest.getText();
        String expectedUserName=ConfigReader.getProperty("hotelValidUserName");
        Assert.assertEquals(actualUserName,expectedUserName);
        extentTest.pass("Kullanici basarili sekilde giris yapti");
        Driver.closeDriver();
    }
}
