package tests.Practices;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.hotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class CreateHotel {
    @Test
    public void createHotel() {
        //1. Tests packagenin altına class olusturun: CreateHotel
        //2. Bir metod olusturun: createHotel
        //3. https://www.hotelmycamp.com adresine git.
        Driver.getDriver().get(ConfigReader.getProperty("hotelMyCamp"));
        //4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri girin.
        //a. Username : manager
        //b. Password : Manager1!
        hotelMyCampPage hp=new hotelMyCampPage();
        hp.loginButton.click();
        hp.username.sendKeys(ConfigReader.getProperty("hotelValidUserName"));
        hp.password.sendKeys(ConfigReader.getProperty("hotelValidPassword"));
        //5. Login butonuna tıklayın.
        hp.loginButton2.click();
        //6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
        hp.hotelManagement.click();
        hp.hotelListButton.click();
        hp.addHotelButton.click();
        //7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        Faker faker=new Faker();
        hp.codetext.sendKeys(faker.internet().ipV4Address()+ Keys.TAB+faker.name()
        +Keys.TAB+faker.address()+Keys.TAB+faker.phoneNumber()+Keys.TAB+faker.internet().emailAddress());
        Select select=new Select(hp.ddmIDGroup);
        select.selectByVisibleText("Hotel Type2");
        //8. Save butonuna tıklayın.
        hp.saveButton.click();
        //9. “Hotel was inserted successfully” textinin göründüğünü test edin.
        String actualText=hp.passedButonu.getText();
        String expectedText="Hotel was inserted successfully";
        Assert.assertTrue(expectedText.contains(actualText));
        //10. OK butonuna tıklayın.
        hp.okButonu.click();

        Driver.closeDriver();
    }
}
