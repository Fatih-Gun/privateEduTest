package com.BE_Test;

import com.UI_Test.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class DeSerialization {
/*
{
    "data": {
        "id": 100,
        "email": "aa@a.com",
        "firstName": "xcvbhj",
        "lastName": "cvm,",
        "mobile": null,
        "roles": [
            "STUDENT"
        ]
    },
    "errors": [],
    "timestamp": "2021-03-31T15:42:001Z"
}
 */
    @Before
    public void setUp(){
        baseURI=ConfigurationReader.get("base_URI");

    }


    @Test
    public void test(){
        Response response=given().accept(ContentType.JSON).
                pathParam("id",100).and().when().get("baseURI"+"api/users/{id}");

        Map<String,Object> usersMap =response.body().as(Map.class);

        System.out.println("firstName: "+usersMap.get("data.firstName"));
        System.out.println("id: "+usersMap.get("data.id"));



    }


}
