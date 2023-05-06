package httpRequests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("item_name")
    @Expose
    private String itemName;
    @SerializedName("sku")
    @Expose
    private String sku;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("item_tax_percentage")
    @Expose
    private Integer itemTaxPercentage;
    @SerializedName("variant_title")
    @Expose
    private String variantTitle;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("hsn_code")
    @Expose
    private String hsnCode;
    @SerializedName("item_weight")
    @Expose
    private Float itemWeight;
    @SerializedName("item_length")
    @Expose
    private Integer itemLength;
    @SerializedName("item_breadth")
    @Expose
    private Integer itemBreadth;
    @SerializedName("item_height")
    @Expose
    private Integer itemHeight;
    @SerializedName("shipping_charge")
    @Expose
    private String shippingCharge;
    @SerializedName("secure_shipment")
    @Expose
    private String secureShipment;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getItemTaxPercentage() {
        return itemTaxPercentage;
    }

    public void setItemTaxPercentage(Integer itemTaxPercentage) {
        this.itemTaxPercentage = itemTaxPercentage;
    }

    public String getVariantTitle() {
        return variantTitle;
    }

    public void setVariantTitle(String variantTitle) {
        this.variantTitle = variantTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHsnCode() {
        return hsnCode;
    }

    public void setHsnCode(String hsnCode) {
        this.hsnCode = hsnCode;
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

    public Integer getItemBreadth() {
        return itemBreadth;
    }

    public void setItemBreadth(Integer itemBreadth) {
        this.itemBreadth = itemBreadth;
    }

    public Integer getItemHeight() {
        return itemHeight;
    }

    public void setItemHeight(Integer itemHeight) {
        this.itemHeight = itemHeight;
    }

    public String getShippingCharge() {
        return shippingCharge;
    }

    public void setShippingCharge(String shippingCharge) {
        this.shippingCharge = shippingCharge;
    }

    public String getSecureShipment() {
        return secureShipment;
    }

    public void setSecureShipment(String secureShipment) {
        this.secureShipment = secureShipment;
    }

}
