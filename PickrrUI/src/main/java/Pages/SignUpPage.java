package Pages;

import org.openqa.selenium.By;

public class SignUpPage {

    public static By SR_allowBtn = By.xpath("//button[text()='ALLOW']");
    public static By firstNameInputBox = By.name("first_name");
    public static By lastNameInputBox = By.name("last_name");
    public static By companyNameInputBox = By.name("company_name");
    public static By emailIDInputBox = By.name("email");
    public static By passwordInputBox = By.name("password");
    public static By termsAndConditionCheckBox = By.xpath("//span[@class='customcheckbox']");
    public static By submitFormButton = By.xpath("//button[@type='submit']");
    public static By SR_Login_Link = By.xpath("//a[text()='Login']");
    public static By mobileNumberInputBox = By.xpath("//input[@formcontrolname='mobile' and @type='tel']");

    public static By mobileErrorLabel = By.xpath("//div[@class='text-danger']");


    ///////////////////// Common Text CommonTexts ############
    public static By signUpMessageHolder = By.xpath("//app-root/app-register/div[2]/div/div/div[2]/div[2]/div[2]/div/h3");
    public static By signUpMessageHolder1 = By.xpath("//h3[contains(text(),'Thank you for choosing Shiprocket!')]");

    By otpVerificationLabel = By.xpath("//h6[contains(text(),'OTP Verification')]");
}


