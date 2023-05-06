package requestPayloads;

import httpRequests.Item;
import httpRequests.OrderCreationAPIRequest;
import utils.TestUtils;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderCreationPayload {

    public static OrderCreationAPIRequest orderCreationAPIRequest;

    public static OrderCreationAPIRequest createSingleOrderRequestBody(String authToken){
        orderCreationAPIRequest = new OrderCreationAPIRequest();
        orderCreationAPIRequest.setHsnCode("None");
        orderCreationAPIRequest.setIsNew(true);
        orderCreationAPIRequest.setIsReverse(false);
        orderCreationAPIRequest.setFromPincode("121001");
        orderCreationAPIRequest.setFromAddress("38 gf, Sant nagar, EOK, New Delhi");
        orderCreationAPIRequest.setFromPhoneNumber("9898989898");
        orderCreationAPIRequest.setFromName("delhi warehouse");
        orderCreationAPIRequest.setItemName("Bag - Large : silver x 1");
        orderCreationAPIRequest.setToPincode("122002");
        orderCreationAPIRequest.setToPhoneNumber("8787878787");
        orderCreationAPIRequest.setToName("Funsuk Wangdu");
        orderCreationAPIRequest.setToName("Funsuk Wangdu");
        orderCreationAPIRequest.setToEmail("Funsuk@pickrr.com");
        orderCreationAPIRequest.setItemWeight(2.3f);
        orderCreationAPIRequest.setItemHeight(22);
        orderCreationAPIRequest.setItemBreadth(22);
        orderCreationAPIRequest.setItemLength(22);
        orderCreationAPIRequest.setInvoiceValue(2220);
        orderCreationAPIRequest.setClientOrderId("AutoIt"+ TestUtils.generateRandomNumber());
        orderCreationAPIRequest.setAuthToken(authToken);
        orderCreationAPIRequest.setToAddress("Automation Wali Gali");
        orderCreationAPIRequest.setIsMps("None");
        orderCreationAPIRequest.setFromEmail("testAuto@gmail.com");
        orderCreationAPIRequest.setQuantity(1);
        orderCreationAPIRequest.setChildAuthToken(authToken);
        orderCreationAPIRequest.setQuantity(1);
        orderCreationAPIRequest.setCodAmount(554f);
        orderCreationAPIRequest.setSkuDetailsSource("weight_sku_mapper");
        orderCreationAPIRequest.setTotalDiscount("0.0");
        orderCreationAPIRequest.setTags("");
        orderCreationAPIRequest.setInvoiceNumber("retail1083");
        orderCreationAPIRequest.setOrderTime(new Date().toString());
        System.out.println("Order Time Set is :: " + new Date().getTime());
        // "2022-07-28 22:25:25.131776T22:25"
        orderCreationAPIRequest.setLocationId("34640855142");
        orderCreationAPIRequest.setShopifyOrderId("4385832534118");
        orderCreationAPIRequest.setShippingCharge("12.2");
        orderCreationAPIRequest.setApplySecureShipment(false);

        orderCreationAPIRequest.setItemList(OrderCreationPayload.createItemsList());
        return orderCreationAPIRequest;
    }

    public static List<Item> createItemsList(){
        List<Item> items  = new ArrayList<>();
        Item item1 = new Item();
        item1.setItemBreadth(1);
        item1.setItemHeight(1);
        item1.setItemLength(1);
        item1.setQuantity(1);
        item1.setName("Ipad");
        item1.setItemName("Ipad");
        item1.setSku("apple1");
        item1.setPrice(456);
        item1.setItemTaxPercentage(0);
        item1.setVariantTitle("Large");
        item1.setItemWeight(1.2f);
        item1.setHsnCode("hsn_code");
        item1.setSecureShipment("SECURE");
        item1.setShippingCharge("0.0");

        Item item2 = new Item();
        item2.setItemBreadth(1);
        item2.setItemHeight(1);
        item2.setItemLength(1);
        item2.setQuantity(1);
        item2.setName("Macbook Pro");
        item2.setItemName("Macbook Pro");
        item2.setSku("apple2");
        item2.setPrice(456);
        item2.setItemTaxPercentage(0);
        item2.setVariantTitle("Large");
        item2.setHsnCode("hsn_code");
        item2.setItemWeight(1.2f);
        item2.setSecureShipment("NOT_SECURE");
        item2.setShippingCharge("0.0");

        Item item3 = new Item();
        item3.setItemBreadth(1);
        item3.setItemHeight(1);
        item3.setItemLength(1);
        item3.setQuantity(1);
        item3.setItemWeight(1.2f);
        item3.setName("Macbook Air");
        item3.setItemName("Macbook Air");
        item3.setSku("apple3");
        item3.setPrice(456);
        item3.setItemTaxPercentage(0);
        item3.setVariantTitle("Large");
        item3.setHsnCode("hsn_code");
        item3.setSecureShipment("SECURE");
        item3.setShippingCharge("0.0");

        items.add(item1);
        items.add(item2);
        items.add(item3);
        return items;
    }

}
