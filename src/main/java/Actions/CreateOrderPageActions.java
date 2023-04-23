package Actions;

import Common.CommonTexts;
import Pages.BasePage;
import Pages.CreateOrderPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;

public class CreateOrderPageActions extends BasePage {

    public CreateOrderPageActions(WebDriver driver) {
        super(driver);
    }

    public CreateOrderPageActions addCustomerDetails(String name, String phone, String pincode, String address) {
        // Write condition to handle low balance popup
        if (waitVisibility(CreateOrderPage.insufficientBalanceToPlaceOrder).isDisplayed()) {
            click(By.xpath("//button/span[text()='Place Order']"));
        }
        inputText(CreateOrderPage.customerName, name);
        inputText(CreateOrderPage.customerPhone, phone);
        inputText(CreateOrderPage.customerPincode, pincode);
        inputText(CreateOrderPage.customerAddress, address);
        return this;
    }

    public CreateOrderPageActions selectShipmentType(String type) {
        // TO DO
        return this;
    }

    public CreateOrderPageActions addAdditionalDetails(String ss) {
        // TO DO
        return this;
    }

    public CreateOrderPageActions isMultiPackageServe() {
        // TO DO is Multi Package;
        return this;
    }

    public CreateOrderPageActions isOrderPlacementInLocalLanguage() {
        click(By.xpath("//input[@type='checkbox' and @class='ant-checkbox-input']"));
        return this;
    }

    public CreateOrderPageActions isDefaultPickUpLocationPresent() {
        waitVisibility(CreateOrderPage.defaultPickUpLocation).isDisplayed();
        return this;
    }

    public CreateOrderPageActions addNewPickUpLocation() {
        // TO DO write add New PickUp Location
        return this;
    }

    public CreateOrderPageActions searchPickUpLocation(String searchKeyword) {
        // TO DO write search functionality for pickup location
        return this;
    }

    public CreateOrderPageActions selectDefaultPickUpLocation() {
        click(CreateOrderPage.defaultPickUpLocation);
        return this;
    }

    public CreateOrderPageActions selectNext() {
        click(CreateOrderPage.nextButton);
        return this;
    }

    public CreateOrderPageActions enterItemDetails(String itemName, int qty) {
        inputText(CreateOrderPage.FirstItemName, itemName);
        inputText(CreateOrderPage.FirstItemQty, String.valueOf(qty));
        return this;
    }

    public CreateOrderPageActions addAnotherItem() {
        // TO DO Enter another Item Details
        return this;
    }


    public CreateOrderPageActions addMoreAdditionalDetails() {
        // TO DO Enter addMoreAdditionalDetails Details
        return this;
    }

    public CreateOrderPageActions addResellerDetails() {
        // TO DO Enter addResellerDetails
        return this;
    }

    public CreateOrderPageActions addCompleteOrderDetails(double weight, List<Double> dimensionsInCM, double invoiceValue, String paymentMode, String clientID) {
        inputText(CreateOrderPage.boxWeight, String.valueOf(weight));
        inputText(CreateOrderPage.boxLength, String.valueOf(dimensionsInCM.get(0)));
        inputText(CreateOrderPage.boxBreadth, String.valueOf(dimensionsInCM.get(1)));
        inputText(CreateOrderPage.boxHeight, String.valueOf(dimensionsInCM.get(2)));
        if (invoiceValue != 0.0) {
            inputText(CreateOrderPage.invoiceValue, String.valueOf(invoiceValue));
        }
            if (paymentMode.equalsIgnoreCase("cod")) {
                click(By.xpath("//input[@type='search' and @role='combobox']"));
                click(By.xpath("//div[@class='ant-select-item-option-content' and text()='COD']"));
            }
        if (clientID != null && !clientID.isEmpty() && !clientID.isBlank()) {
            inputText(CreateOrderPage.clientOrderID, clientID);
        }
        return this;
    }

    public CreateOrderPageActions reviewOrderDetails(String invoiceExpectedValue, String shippingDate) {
        String invoiceActualValue = readText(By.xpath("//*[@id=\"root\"]/section/section/main/div[3]/div[1]/div[1]/div/div/div[13]/p/text()[3]"));
        Assert.assertEquals(invoiceActualValue, invoiceExpectedValue);
        if (shippingDate != null && !shippingDate.isBlank() && !shippingDate.isEmpty()) {
            // To Do for Selecting specific PickUpDate
        }
        return this;
    }

    public CreateOrderPageActions clickPlaceOrder() {
        click(By.xpath("//button/span[text()='Create Order']"));
        Assert.assertTrue(textIsPresent(CommonTexts.orderPlacementSuccessText));
        return this;
    }

    public CreateOrderPageActions fetchClientOrderID(){
        // Need to think of logic to fetch and return clientOrder ID
        return this;
    }

}
