package HttpResponse;

import HttpRequests.CourierAllocation;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderCreationAPIResponse {

    @SerializedName("track_url")
    @Expose
    private String trackUrl;
    @SerializedName("dispatch_mode")
    @Expose
    private String dispatchMode;
    @SerializedName("client_order_id")
    @Expose
    private String clientOrderId;
    @SerializedName("manifest_link_pdf")
    @Expose
    private String manifestLinkPdf;
    @SerializedName("manifest_img_link_v2")
    @Expose
    private String manifestImgLinkV2;
    @SerializedName("order_pk")
    @Expose
    private Integer orderPk;
    @SerializedName("edd_stamp")
    @Expose
    private Object eddStamp;
    @SerializedName("routing_code")
    @Expose
    private String routingCode;
    @SerializedName("manifest_img_link")
    @Expose
    private String manifestImgLink;
    @SerializedName("manifest_link")
    @Expose
    private String manifestLink;
    @SerializedName("courier")
    @Expose
    private String courier;
    @SerializedName("order_id")
    @Expose
    private String orderId;
    @SerializedName("scheduled_ship_date")
    @Expose
    private Object scheduledShipDate;
    @SerializedName("ip_string")
    @Expose
    private Object ipString;
    @SerializedName("courier_id")
    @Expose
    private Integer courierId;
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("err")
    @Expose
    private Object err;
    @SerializedName("scheduled_ship_status")
    @Expose
    private String scheduledShipStatus;
    @SerializedName("is_delayed_pickup")
    @Expose
    private Boolean isDelayedPickup;
    @SerializedName("courier_allocation")
    @Expose
    private CourierAllocation courierAllocation;
    @SerializedName("tracking_id")
    @Expose
    private String trackingId;
    @SerializedName("udaan_parent_shipment_id")
    @Expose
    private String udaanParentShipmentId;

    public String getTrackUrl() {
        return trackUrl;
    }

    public void setTrackUrl(String trackUrl) {
        this.trackUrl = trackUrl;
    }

    public String getDispatchMode() {
        return dispatchMode;
    }

    public void setDispatchMode(String dispatchMode) {
        this.dispatchMode = dispatchMode;
    }

    public String getClientOrderId() {
        return clientOrderId;
    }

    public void setClientOrderId(String clientOrderId) {
        this.clientOrderId = clientOrderId;
    }

    public String getManifestLinkPdf() {
        return manifestLinkPdf;
    }

    public void setManifestLinkPdf(String manifestLinkPdf) {
        this.manifestLinkPdf = manifestLinkPdf;
    }

    public String getManifestImgLinkV2() {
        return manifestImgLinkV2;
    }

    public void setManifestImgLinkV2(String manifestImgLinkV2) {
        this.manifestImgLinkV2 = manifestImgLinkV2;
    }

    public Integer getOrderPk() {
        return orderPk;
    }

    public void setOrderPk(Integer orderPk) {
        this.orderPk = orderPk;
    }

    public Object getEddStamp() {
        return eddStamp;
    }

    public void setEddStamp(Object eddStamp) {
        this.eddStamp = eddStamp;
    }

    public String getRoutingCode() {
        return routingCode;
    }

    public void setRoutingCode(String routingCode) {
        this.routingCode = routingCode;
    }

    public String getManifestImgLink() {
        return manifestImgLink;
    }

    public void setManifestImgLink(String manifestImgLink) {
        this.manifestImgLink = manifestImgLink;
    }

    public String getManifestLink() {
        return manifestLink;
    }

    public void setManifestLink(String manifestLink) {
        this.manifestLink = manifestLink;
    }

    public String getCourier() {
        return courier;
    }

    public void setCourier(String courier) {
        this.courier = courier;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Object getScheduledShipDate() {
        return scheduledShipDate;
    }

    public void setScheduledShipDate(Object scheduledShipDate) {
        this.scheduledShipDate = scheduledShipDate;
    }

    public Object getIpString() {
        return ipString;
    }

    public void setIpString(Object ipString) {
        this.ipString = ipString;
    }

    public Integer getCourierId() {
        return courierId;
    }

    public void setCourierId(Integer courierId) {
        this.courierId = courierId;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getErr() {
        return err;
    }

    public void setErr(Object err) {
        this.err = err;
    }

    public String getScheduledShipStatus() {
        return scheduledShipStatus;
    }

    public void setScheduledShipStatus(String scheduledShipStatus) {
        this.scheduledShipStatus = scheduledShipStatus;
    }

    public Boolean getIsDelayedPickup() {
        return isDelayedPickup;
    }

    public void setIsDelayedPickup(Boolean isDelayedPickup) {
        this.isDelayedPickup = isDelayedPickup;
    }

    public CourierAllocation getCourierAllocation() {
        return courierAllocation;
    }

    public void setCourierAllocation(CourierAllocation courierAllocation) {
        this.courierAllocation = courierAllocation;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public String getUdaanParentShipmentId() {
        return udaanParentShipmentId;
    }

    public void setUdaanParentShipmentId(String udaanParentShipmentId) {
        this.udaanParentShipmentId = udaanParentShipmentId;
    }

}
