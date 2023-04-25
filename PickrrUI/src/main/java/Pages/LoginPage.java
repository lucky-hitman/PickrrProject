package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    public static By loginLink= By.xpath("//a[@href='https://dashboard.pickrr.com/sign-in']/parent::li[@class='blueBtn nav-item desktop-only-cust']");
    public static By emailIDInputBox = By.id("email");
    public static By passwordInputBox = By.id("password");
    public static By loginBtn  = By.xpath("//button[@type='submit']");

}
