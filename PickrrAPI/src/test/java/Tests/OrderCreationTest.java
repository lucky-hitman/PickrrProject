package Tests;

import HttpResponse.OrderCreationAPIResponse;
import RequestPayloads.OrderCreationPayload;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrderCreationTest {

    @BeforeClass
    public void init(){
        RestAssured.baseURI="https://pickrr.com";
        RestAssured.basePath="/api/place-order/";
    }
    @Test
    public void verifySingleOrderCreation(ITestContext context){

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Content-Type","application/json");
        requestSpecification.body(new Gson()
                .toJson(OrderCreationPayload.createSingleOrderRequestBody((String) context.getAttribute("jwtToken"))))
                .log().all();

        Response response = requestSpecification.post();
        response.getBody().asPrettyString();

        OrderCreationAPIResponse orderCreationAPIResponse = new Gson().fromJson(response.getBody().asString(),OrderCreationAPIResponse.class);
        System.out.println("Order ID :: " + orderCreationAPIResponse.getOrderId());
        System.out.println("Courier Selected type is :: " + orderCreationAPIResponse.getCourierAllocation().getSelectedType());
        System.out.println("Courier Selected type is :: " + orderCreationAPIResponse.getSuccess());

    }
}
