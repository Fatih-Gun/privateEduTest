package com.BE_Test.page;

import com.github.javafaker.Faker;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

public class RegisterBEiam {

    Faker faker=new Faker();

    String registerEndPoint="IAM-SERVICE/api/auth/register";

    public void register(){

        String password=faker.internet().password(8,50,true,true,true);
        System.out.println(password);


        Map<String,Object> body=new HashMap<>();
        body.put("branch", faker.number().numberBetween(1,26));
        body.put("email", faker.internet().emailAddress());
        body.put("firstName",faker.name().firstName());
        body.put("lastName",faker.name().lastName());
        body.put("grade",faker.number().numberBetween(1,12));
        body.put("mobile",faker.number().digits(10));
        body.put("password",password);
        body.put("schoolId",faker.number().numberBetween(256,6161));


        Response response=
                given().
                        contentType(ContentType.JSON).body(body).log().all().
                when().
                        post(registerEndPoint).prettyPeek();


        assertEquals(201,response.statusCode());





    }

}
