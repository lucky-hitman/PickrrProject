package pages;

import org.openqa.selenium.By;

public class LoginPage {


    public static By loginLink= By.xpath("//a[@href='https://dashboard.pickrr.com/sign-in']/parent::li[@class='blueBtn nav-item desktop-only-cust']");
    public static By emailIDInputBox = By.id("email");
    public static By amz_userInputbox = By.name("email");
    public static By passwordInputBox = By.id("password");
    public static By amz_passwordInputBox = By.name("password");
    public static By amz_continueButton  = By.id("continue");
    public static By amz_SignInButton  = By.id("signInSubmit");

    public static By loginBtn  = By.xpath("//button[@type='submit']");

}
