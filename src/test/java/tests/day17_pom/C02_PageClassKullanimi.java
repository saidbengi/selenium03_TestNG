package tests.day17_pom;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_PageClassKullanimi {

    @Test
    public void test01() {
        // amazona gidelim
        Driver.getDriver().get("https://www.amazon.com");
        // nutella aratalim
        AmazonPage amazon=new AmazonPage();
        amazon.aramaKutusu.sendKeys("nutella"+ Keys.ENTER);
        // sonuc yazisinin nutella icerdigini test edelim
        String actualSonuc=amazon.aramaSonucElementi.getText();
        String expectedKelime="nutella";

        Assert.assertTrue(actualSonuc.contains(expectedKelime));

        Driver.closeDriver();

    }
}
