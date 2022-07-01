package tests.Practices;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.hotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class HotelRoomCreation {

    @Test
    public void RoomCreateTest() {

        // 1. Tests packagenin altına class olusturun: D18_HotelRoomCreation
        //2. Bir metod olusturun: RoomCreateTest()
        //3. https://www.hotelmycamp.com adresine gidin.
        Driver.getDriver().get(ConfigReader.getProperty("hotelMyCamp"));
        //4. Username textbox ve password metin kutularını locate edin ve aşağıdaki verileri girin.
        //a. Username : manager b. Password : Manager1!
        hotelMyCampPage hp=new hotelMyCampPage();
        hp.loginButton.click();
        hp.username.sendKeys(ConfigReader.getProperty("hotelValidUserName"));
        hp.password.sendKeys(ConfigReader.getProperty("hotelValidPassword"));
        //5. Login butonuna tıklayın.
        hp.loginButton2.click();
        //6. Hotel Management menusunden Add Hotelroom butonuna tıklayın.
        hp.hotelManagement.click();
        hp.hotelRooms.click();
        hp.addHotelRoomButton.click();
        //7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        Select select=new Select(hp.ddmIDHotel);
        select.selectByVisibleText("Cizgi Dusler Hotel");
        Faker faker=new Faker();
        hp.codetext.sendKeys(faker.internet().macAddress()+ Keys.TAB+faker.name()+Keys.TAB+
                faker.leagueOfLegends()+Keys.TAB+"500");
        hp.addHotelRoomTextBox.sendKeys(faker.internet().avatar());
        Select select2=new Select(hp.ddmRoomType);
        select2.selectByVisibleText("King");
        hp.hotelRoomMaxCount.sendKeys(faker.numerify("2500")+Keys.TAB+"5");
        hp.hotelRoomApproved.click();
        //8. Save butonuna basin.
        hp.saveButton.click();
        //9. “HotelRoom was inserted successfully” textinin göründüğünü test edin.
        String actualText=hp.passedButonu.getText();
        String expectedText="HotelRoom was inserted successfully";
        Assert.assertTrue(expectedText.contains(actualText));
        //10. OK butonuna tıklayın.
        hp.okButonu.click();
        //11. Hotel rooms linkine tıklayın.
        hp.hotelRooms.click();
        //12. "LIST OF HOTELROOMS" textinin göründüğünü doğrulayın..
        Assert.assertTrue(hp.listOfHotelRooms.isDisplayed());

        Driver.closeDriver();
    }
}
