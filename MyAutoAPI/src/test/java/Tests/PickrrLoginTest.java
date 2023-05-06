package Tests;

import httpRequests.LoginAPIRequest;
import httpResponse.LoginAPIResponse;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PickrrLoginTest {


    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    String jwtToken;
    @BeforeMethod
    public void init(){
        RestAssured.baseURI = "https://pickrr.com";
        RestAssured.basePath = "/api/v1/web-login/";
    }

    @Test(groups = {"LOGIN"})
    public void Login(ITestContext context){

        LoginAPIRequest loginRequestBody = new LoginAPIRequest();
        loginRequestBody.setEmail("g.mangla911@gmail.com");
        loginRequestBody.setPassword("complex@1357");

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Content-Type","application/json").log().all();
        String request = new Gson().toJson(loginRequestBody);
        requestSpecification.body(request.toString()).log().all();


        Response response = requestSpecification.post();
        response.getBody().asPrettyString();
        LoginAPIResponse loginApiResponse = new Gson().fromJson(response.getBody().asString(), LoginAPIResponse.class);
        System.out.println(loginApiResponse.toString());
        context.setAttribute("jwtToken",loginApiResponse.getAuth_token());
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
