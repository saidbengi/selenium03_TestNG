package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.hotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class NegativeLoginTest {


    @Test
    public void negativeLoginTest() {
        //2) Bir Class olustur : NegativeTest
        //3) Bir test method olustur negativeLoginTest()
        //https://www.hotelmycamp.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("hotelMyCamp"));
        //login butonuna bas
        hotelMyCampPage hp=new hotelMyCampPage();
        hp.loginButton.click();
        //test data username: manager ,
        hp.username.sendKeys(ConfigReader.getProperty("hotelValidUserName"));
        //test data password : ismail
        hp.password.sendKeys(ConfigReader.getProperty("hotelWrongPassword"));
        hp.loginButton2.click();
        //Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
        Assert.assertTrue(hp.loginButton2.isDisplayed());
        Driver.closeDriver();
    }
    // bu class da 2 test methodu daha olusturun
    // biri yanlis Kullanici
    @Test
    public void negativeLoginTest2() {
        //2) Bir Class olustur : NegativeTest
        //3) Bir test method olustur negativeLoginTest2()
        //https://www.hotelmycamp.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("hotelMyCamp"));
        //login butonuna bas
        hotelMyCampPage hp=new hotelMyCampPage();
        hp.loginButton.click();
        //test data username: manager ,
        hp.username.sendKeys(ConfigReader.getProperty("hotelWrongUserName"));
        //test data password : ismail
        hp.password.sendKeys(ConfigReader.getProperty("hotelValidPassword"));
        hp.loginButton2.click();
        //Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
        Assert.assertTrue(hp.loginButton2.isDisplayed());
        Driver.closeDriver();
    }
    // digeri de yanlis sifre ve kullanici adi

    @Test
    public void negativeLoginTest3() {
        //2) Bir Class olustur : NegativeTest
        //3) Bir test method olustur negativeLoginTest3()
        //https://www.hotelmycamp.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("hotelMyCamp"));
        //login butonuna bas
        hotelMyCampPage hp=new hotelMyCampPage();
        hp.loginButton.click();
        //test data username: manager ,
        hp.username.sendKeys(ConfigReader.getProperty("hotelWrongUserName"));
        //test data password : ismail
        hp.password.sendKeys(ConfigReader.getProperty("hotelWrongPassword"));
        hp.loginButton2.click();
        //Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
        Assert.assertTrue(hp.loginButton2.isDisplayed());
        Driver.closeDriver();
    }
}
