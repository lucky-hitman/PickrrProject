package TestFiles;

import actions.HomepageActions;
import actions.LoginPageActions;
import actions.PDPActions;
import base.BaseTest;
import common.CommonTexts;
import common.PageTitles;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import listeners.ExecutionListener;

@Listeners(ExecutionListener.class)

public class HomePageTests extends BaseTest implements CommonTexts {

    HomepageActions homepageActions;
    LoginPageActions loginPageActions;
    PDPActions pdpActions;

    @BeforeClass
    public void init() {
        properties = initializeProperties();
        initializeBrowser();
        homepageActions = new HomepageActions(getDriver());
        loginPageActions = new LoginPageActions(getDriver());
        pdpActions = new PDPActions(getDriver());

    }

    @Test(description = "Verify that home page is displayed after login or not")
    public void verifyHomePageDisplayedAfterLogin() {
        loginPageActions
                .goToUrl(properties.getProperty("url"))
                .hoverCreateAndClickSignIn()
                .isLoginPage()
                .enterUserName(properties.getProperty("username"))
                .clickContinue()
                .isPasswordPage()
                .enterPassword(properties.getProperty("password"))
                .clickSignIn()
                .validateLogin();

        homepageActions
                .assertPageTitle(PageTitles.amazonHomepageTitle);
        ;
    }

    @Test(dependsOnMethods = "verifyHomePageDisplayedAfterLogin", description = "Verify that user name is displayed on home page or not")
    public void verifyUserNameIsDisplayedOnHomePage() {
        homepageActions.validateUserNameIsPresent("Lokesh");
    }

    @Test(dependsOnMethods = "verifyHomePageDisplayedAfterLogin", description = "Verify that Search Functionality is present on home page")
    public void verifySearchFunctionalityIsPresentOnHomePage() {
        homepageActions.validateSearchOptionIsPresent();
    }

    @Test(dependsOnMethods = "verifyHomePageDisplayedAfterLogin", description = "Verify that when user clicks on a product," +
            " user should be redirected to product specification page.")
    public void verifyForAnyProductSpecificationPageLanding() {
        homepageActions.selectAnyProductFromTopDealsCarousel();
        pdpActions
                .isAddToCartPresent();
    }
}
