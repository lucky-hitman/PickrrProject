package HttpRequests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OrderCreationAPIRequest {

    @SerializedName("hsn_code")
    @Expose
    private String hsnCode;
    @SerializedName("is_new")
    @Expose
    private Boolean isNew;
    @SerializedName("is_reverse")
    @Expose
    private Boolean isReverse;
    @SerializedName("from_pincode")
    @Expose
    private String fromPincode;
    @SerializedName("from_address")
    @Expose
    private String fromAddress;
    @SerializedName("from_phone_number")
    @Expose
    private String fromPhoneNumber;
    @SerializedName("from_name")
    @Expose
    private String fromName;
    @SerializedName("item_name")
    @Expose
    private String itemName;
    @SerializedName("to_pincode")
    @Expose
    private String toPincode;
    @SerializedName("to_phone_number")
    @Expose
    private String toPhoneNumber;
    @SerializedName("to_name")
    @Expose
    private String toName;
    @SerializedName("to_email")
    @Expose
    private String toEmail;
    @SerializedName("to_address")
    @Expose
    private String toAddress;
    @SerializedName("item_weight")
    @Expose
    private Float itemWeight;
    @SerializedName("item_length")
    @Expose
    private Integer itemLength;
    @SerializedName("item_height")
    @Expose
    private Integer itemHeight;
    @SerializedName("item_breadth")
    @Expose
    private Integer itemBreadth;
    @SerializedName("invoice_value")
    @Expose
    private Integer invoiceValue;
    @SerializedName("client_order_id")
    @Expose
    private String clientOrderId;
    @SerializedName("auth_token")
    @Expose
    private String authToken;
    @SerializedName("is_mps")
    @Expose
    private String isMps;
    @SerializedName("from_email")
    @Expose
    private String fromEmail;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("child_auth_token")
    @Expose
    private String childAuthToken;
    @SerializedName("item_list")
    @Expose
    private List<Item> itemList;
    @SerializedName("cod_amount")
    @Expose
    private Float codAmount;
    @SerializedName("sku_details_source")
    @Expose
    private String skuDetailsSource;
    @SerializedName("total_discount")
    @Expose
    private String totalDiscount;
    @SerializedName("tags")
    @Expose
    private String tags;
    @SerializedName("invoice_number")
    @Expose
    private String invoiceNumber;
    @SerializedName("order_time")
    @Expose
    private String orderTime;
    @SerializedName("location_id")
    @Expose
    private String locationId;
    @SerializedName("shopify_order_id")
    @Expose
    private String shopifyOrderId;
    @SerializedName("shipping_charge")
    @Expose
    private String shippingCharge;
    @SerializedName("apply_secure_shipment")
    @Expose
    private Boolean applySecureShipment;

    public String getHsnCode() {
        return hsnCode;
    }

    public void setHsnCode(String hsnCode) {
        this.hsnCode = hsnCode;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    public Boolean getIsReverse() {
        return isReverse;
    }

    public void setIsReverse(Boolean isReverse) {
        this.isReverse = isReverse;
    }

    public String getFromPincode() {
        return fromPincode;
    }

    public void setFromPincode(String fromPincode) {
        this.fromPincode = fromPincode;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getFromPhoneNumber() {
        return fromPhoneNumber;
    }

    public void setFromPhoneNumber(String fromPhoneNumber) {
        this.fromPhoneNumber = fromPhoneNumber;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getToPincode() {
        return toPincode;
    }

    public void setToPincode(String toPincode) {
        this.toPincode = toPincode;
    }

    public String getToPhoneNumber() {
        return toPhoneNumber;
    }

    public void setToPhoneNumber(String toPhoneNumber) {
        this.toPhoneNumber = toPhoneNumber;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public Float getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(Float itemWeight) {
        this.itemWeight = itemWeight;
    }

    public Integer getItemLength() {
        return itemLength;
    }

    public void setItemLength(Integer itemLength) {
        this.itemLength = itemLength;
    }

    public Integer getItemHeight() {
        return itemHeight;
    }

    public void setItemHeight(Integer itemHeight) {
        this.itemHeight = itemHeight;
    }

    public Integer getItemBreadth() {
        return itemBreadth;
    }

    public void setItemBreadth(Integer itemBreadth) {
        this.itemBreadth = itemBreadth;
    }

    public Integer getInvoiceValue() {
        return invoiceValue;
    }

    public void setInvoiceValue(Integer invoiceValue) {
        this.invoiceValue = invoiceValue;
    }

    public String getClientOrderId() {
        return clientOrderId;
    }

    public void setClientOrderId(String clientOrderId) {
        this.clientOrderId = clientOrderId;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getIsMps() {
        return isMps;
    }

    public void setIsMps(String isMps) {
        this.isMps = isMps;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getChildAuthToken() {
        return childAuthToken;
    }

    public void setChildAuthToken(String childAuthToken) {
        this.childAuthToken = childAuthToken;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public Float getCodAmount() {
        return codAmount;
    }

    public void setCodAmount(Float codAmount) {
        this.codAmount = codAmount;
    }

    public String getSkuDetailsSource() {
        return skuDetailsSource;
    }

    public void setSkuDetailsSource(String skuDetailsSource) {
        this.skuDetailsSource = skuDetailsSource;
    }

    public String getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(String totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getShopifyOrderId() {
        return shopifyOrderId;
    }

    public void setShopifyOrderId(String shopifyOrderId) {
        this.shopifyOrderId = shopifyOrderId;
    }

    public String getShippingCharge() {
        return shippingCharge;
    }

    public void setShippingCharge(String shippingCharge) {
        this.shippingCharge = shippingCharge;
    }

    public Boolean getApplySecureShipment() {
        return applySecureShipment;
    }

    public void setApplySecureShipment(Boolean applySecureShipment) {
        this.applySecureShipment = applySecureShipment;
    }

}
