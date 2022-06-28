package day16_notations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.*;

public class C07_SoftAssert extends TestBase {

    @Test
    public void test01() {
        //Yeni bir Class Olusturun : C03_SoftAssert
        //1. “http://zero.webappsecurity.com/” Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        //2. Sign in butonuna basin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        //3. Login kutusuna “username” yazin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
        //4. Password kutusuna “password” yazin
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
        //5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.navigate().back();
        //6. Online banking menusu icinde Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//li[@id='onlineBankingMenu']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();
        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();
        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement ddo=driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select=new Select(ddo);
        select.selectByVisibleText("Eurozone (euro)");
        //9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        SoftAssert softAssert=new SoftAssert();
        String secilenOption=select.getFirstSelectedOption().getText();
        String expectedOption="Eurozone (Euro)";
        softAssert.assertEquals(secilenOption,expectedOption,"secilen option uygun degil");
        //10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        List<WebElement>optionList=select.getOptions();
        List<String> optionListString=new ArrayList<>();
        for (WebElement each:optionList
             ) {
            optionListString.add(each.getText());
        }
        Collections.sort(optionListString);
        for (String each:optionListString
             ) {
            System.out.println(each);
        }
        System.out.println("-----------------ActualList-------------------");
        List<String>actualList=new ArrayList<>(Arrays.asList("Select One","Australia (dollar)",
                "Canada (dollar)","Switzerland (franc)","China" +
                " (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong" +
                " (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand" +
                " (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"));
        Collections.sort(actualList);
        for (String each:actualList
             ) {
            System.out.println(each);
        }

        softAssert.assertEquals(actualList,optionListString);

        softAssert.assertAll();


        //"Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China
        //(yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong
        //(dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand
        //(dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"
    }
}
