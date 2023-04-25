package Actions;

import Pages.BasePage;
import Pages.HomePage;
import org.openqa.selenium.WebDriver;

public class HomepageActions extends BasePage {
    public HomepageActions(WebDriver driver) {
        super(driver);
    }

    public HomepageActions HoverCreateAndClickCreateOrder(){
        hoverOn(HomePage.createOrderTopButton);
        click(HomePage.createSingleOrderlink);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

}
