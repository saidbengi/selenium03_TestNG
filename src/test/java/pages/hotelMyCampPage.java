package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class hotelMyCampPage {
    public hotelMyCampPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath ="//*[text()='Log in']")
    public WebElement loginButton;

    @FindBy(xpath ="//input[@id='UserName']")
    public WebElement username;

    @FindBy(xpath ="//input[@id='Password']")
    public WebElement password;

    @FindBy(xpath ="//input[@id='btnSubmit']")
    public WebElement loginButton2;

    @FindBy(xpath ="//span[@class='username username-hide-on-mobile']")
    public WebElement usernameTest;

    @FindBy(xpath ="//a[@href='/admin/HotelAdmin']")
    public WebElement hotelListButton;

    @FindBy(xpath ="//span[@class='hidden-480']")
    public WebElement addHotelButton;

    @FindBy(xpath ="//input[@id='Code']")
    public WebElement codetext;

    @FindBy(xpath = "//select[@class='form-control input-lg required']")
    public WebElement ddmIDGroup;

    @FindBy(xpath = "//span[text()='Hotel Management']")
    public WebElement hotelManagement;

    @FindBy(xpath = "//textarea[@dir='ltr']")
    public WebElement addHotelRoomTextBox;

    @FindBy(xpath = "(//a[@href='/admin/HotelRoomAdmin'])")
    public WebElement hotelRooms;

    @FindBy(xpath ="//span[@class='hidden-480']")
    public WebElement addHotelRoomButton;

    @FindBy(xpath ="//button[@type='submit']")
    public WebElement saveButton;

    @FindBy(xpath ="(//select[@class='form-control input-lg required'])[1]")
    public WebElement ddmIDHotel;

    @FindBy(xpath ="(//select[@class='form-control input-lg required'])[2]")
    public WebElement ddmRoomType;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement passedButonu;

    @FindBy(xpath = "//button[@data-bb-handler='ok']")
    public WebElement okButonu;

    @FindBy(xpath = "//input[@placeholder='Adult count']")
    public WebElement hotelRoomMaxCount;

    @FindBy(xpath = "//input[@id='IsAvailable']")
    public WebElement hotelRoomApproved;

    @FindBy(xpath = "//span[@class='caption-subject font-green-sharp bold uppercase']")
    public WebElement listOfHotelRooms;
}
