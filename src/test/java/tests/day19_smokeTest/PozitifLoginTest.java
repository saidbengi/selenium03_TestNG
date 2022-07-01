package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.hotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class PozitifLoginTest {

    @Test
    public void positiveLoginTest() {
        //2) Bir Class olustur : PositiveTest
        //3) Bir test method olustur positiveLoginTest()
        //https://www.hotelmycamp.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("hotelMyCamp"));
        //login butonuna bas
        hotelMyCampPage hp=new hotelMyCampPage();
        hp.loginButton.click();
        //test data username: manager ,
        hp.username.sendKeys(ConfigReader.getProperty("hotelValidUserName"));
        //test data password : Manager1!
        hp.password.sendKeys(ConfigReader.getProperty("hotelValidPassword"));
        hp.loginButton2.click();
        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        String actualUserName=hp.usernameTest.getText();
        String expectedUserName=ConfigReader.getProperty("hotelValidUserName");
        Assert.assertEquals(actualUserName,expectedUserName);
        Driver.closeDriver();
    }
}
