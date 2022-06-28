package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {
    public FacebookPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@name='email']")
    public WebElement mailGiris;

    @FindBy(xpath = "//input[@name='pass']")
    public WebElement passwordGiris;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement loginBotton;

    @FindBy(xpath = "//div[@class='_9ay7']")
    public WebElement errorText;
}
