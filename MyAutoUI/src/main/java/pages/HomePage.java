package pages;

import org.openqa.selenium.By;

public class HomePage {

    public static By amz_signInLink = By.id("nav-link-accountList-nav-line-1");
    public static By amz_signInLink_Btn = By.xpath("//span[text()='Sign in' and @class ='nav-action-inner']");
    public static By amz_successSignInLocator = By.xpath("//span[@id='nav-link-accountList-nav-line-1' and contains(text(),'Hello, ')]");
    public static By amz_searchBarLocator = By.xpath("//input[@placeholder='Search Amazon.in' and @id='twotabsearchtextbox']");
    public static By amz_anyProductFromDealsLocator = By.xpath("//span[@class='a-list-item']/a");

    public static By createOrderTopButton = By.xpath("//button/span[text()='Create']");

    public static By createSingleOrderlink = By.xpath("//img[@alt='Create Order plus icon']");
}
