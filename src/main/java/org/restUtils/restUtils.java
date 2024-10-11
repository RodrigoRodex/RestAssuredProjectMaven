package org.restUtils;

import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;

public class restUtils {
    public static Response performPost(String endPoint, String requestPayLoad, Map<String,String> headers){
       return RestAssured.given().log().all()
                .baseUri(endPoint)
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestPayLoad)
                .post()
                .then().log().all().extract().response();
    }
    public static Response performPost(String endPoint, Map<String, Object> requestPayLoad, Map<String,String> headers){
        return RestAssured.given().log().all()
                .baseUri(endPoint)
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestPayLoad)
                .post()
                .then().log().all().extract().response();
    }
}
