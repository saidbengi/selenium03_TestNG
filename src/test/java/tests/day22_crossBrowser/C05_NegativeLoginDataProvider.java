package tests.day22_crossBrowser;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.hotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C05_NegativeLoginDataProvider {
    hotelMyCampPage hp;

    @DataProvider
    public static Object[][] kullaniciListesi() {
        Object[][] kullaniciBilgileri = {{"saidb", "ismailabi"},
                {"sacmalama,", "durbi"},
                {"manager", "ismail"}};
        return new Object[][]{};
    }

    @Test(dataProvider = "kullaniciListesi")
    public void negativeLoginTest(String username, String password) {

        //2) Bir Class olustur : NegativeTest
        //3) Bir test method olustur negativeLoginTest()
        //https://www.hotelmycamp.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("hotelMyCamp"));
        //login butonuna bas
        hp = new hotelMyCampPage();
        hp.loginButton.click();
        //test data username: manager ,
        hp.username.sendKeys(username);
        //test data password : ismail
        hp.password.sendKeys(password);
        hp.loginButton2.click();
        //Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
        Assert.assertTrue(hp.loginButton2.isDisplayed());
        Driver.closeDriver();
    }

}
