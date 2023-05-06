package actions;

import base.BasePageActions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.PDP;

public class PDPActions extends BasePageActions implements PDP {
    public PDPActions(WebDriver driver) {
        super(driver);
    }

    public PDPActions isAddToCartPresent(){
        isElementPresent(addToCartButton);
        return this;
    }

    public PDPActions verifyProductTitle(String expectedTitle){
        String title = readText(productTitleMain);
        Assert.assertTrue(expectedTitle.contains(title.substring(0,5)));
        return this;
    }


}

