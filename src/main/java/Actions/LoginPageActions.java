package Actions;

import Pages.BasePage;
import Pages.HomePage;
import Pages.LoginPage;
import org.mortbay.log.Log;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

public class LoginPageActions extends BasePage {


    public LoginPageActions(WebDriver driver) {
        super(driver);
    }

    public LoginPageActions loginToPickrr(String userName, String password) {
        Log.info("Clicking Login Tab to land Pickrr's Login Page");
        click(LoginPage.loginLink);
        Log.info("Trying to login Pickrr dashboard via.");
        Set<String> childWindows = driver.getWindowHandles();
        System.out.println(childWindows);
        for (String window : childWindows){
            driver.switchTo().window(window);
        }
       // driver.findElement(By.xpath("//button[text()='Allow']")).click();
        inputText(LoginPage.emailIDInputBox,userName);
        inputText(LoginPage.passwordInputBox,password);
        click(LoginPage.loginBtn);
        return this;
    }

    public LoginPageActions verifyloginToPickrr() {
        Log.info("Verifying login to pickrr is successfull");
        Assert.assertTrue(isCreateOrderPresent());
        // Code to reload the page
        String s= driver.getCurrentUrl();
        driver.get(s);
        return this;
    }

    public boolean isCreateOrderPresent(){
        return waitVisibility(HomePage.createOrderTopButton).isDisplayed();
    }

    public LoginPageActions goToUrl(String url) {
        Log.info("Opening url :: "+ url+ " in browser");
        driver.get(url);
        return this;
    }

}
