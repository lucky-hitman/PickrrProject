package Pages;

import org.openqa.selenium.By;

public class CreateOrderPage {

    public static By insufficientBalanceToPlaceOrder = By.xpath("//div[contains(text(),'Insufficient wallet balance')]");
    public static By customerName = By.id("to_name");
    public static By customerPhone = By.id("to_phone_number");
    public static By customerPincode = By.id("to_pincode");
    public static By customerAddress = By.id("to_address");
    public static By defaultPickUpLocation = By.xpath("//img[@src='https://d10srchmli830n.cloudfront.net/1619703973552_radio_checked.svg']");
    public static By nextButton = By.xpath("//button/span[text()='Next']");
    public static By FirstItemName = By.id("item_list_0_item_name");
    public static By FirstItemQty = By.id("item_list_0_quantity");
    public static By boxWeight = By.id("item_weight");
    public static By boxLength = By.id("item_length");
    public static By boxBreadth = By.id("item_breadth");
    public static By boxHeight = By.id("item_height");
    public static By invoiceValue = By.id("invoice_value");
    public static By clientOrderID = By.id("client_order_id");


}
