package com.BE_Test.page;

import com.github.javafaker.Faker;
import static io.restassured.RestAssured.*;

import io.cucumber.java.hu.Ha;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class UserController {

    String userControllerEndpoint = "IAM-SERVICE/api/users";
    Response response;

    public static UserBody createUserBody(String role){
        Faker faker=new Faker();
        String email= faker.internet().emailAddress();
        String firstName=faker.name().firstName();
        String lastName=faker.name().lastName();
        String mobile=String.valueOf(faker.number().digits(10));
//        String password=faker.internet().password(8,50,true,true,true);
      String password="Test123456!";
        String [] roles= {role};
        UserBody createUserBody=new UserBody(email,firstName,lastName,mobile,password,roles);
         return createUserBody;
    }

    public void createNewUser(String role){
        response= given().contentType(ContentType.JSON).
                headers("Authorization","Bearer "+ Tokens.superAdminToken()).
                body(createUserBody(role)).log().all().
                when().post(userControllerEndpoint).prettyPeek();

    }
    public void roleVerify(String role){
        assertEquals(201,response.getStatusCode() );
        String actualRole=response.jsonPath().getString("data.roles[0]");
        assertEquals(role,actualRole);
    }

    public void searchUsersAll(int pageSize, String userrole){
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("pageSize",pageSize);
        queryParams.put("role",userrole);
        response =given().contentType(ContentType.JSON).queryParams(queryParams).
                headers(Tokens.token("superadmin")).log().all().
                when().get(userControllerEndpoint);

    }
    public void searchAllVerify(int statuscode){
        assertEquals(statuscode,response.getStatusCode());
        int size=response.jsonPath().getList("data.data.id").size();
        System.out.println("user counts= "+size);
//        assertEquals(100,size);

    }
    public void searchUsersById(int id){
        response = given().contentType(ContentType.JSON).
                headers(Tokens.token("superadmin")).log().all().
                when().get(userControllerEndpoint+"/"+id);
    }
    public void searchByIdVerify(int statuscode){
        assertEquals(statuscode,response.getStatusCode());
        String  id=response.jsonPath().getString("data.id");
        System.out.println("user id="+id);
    }


}
