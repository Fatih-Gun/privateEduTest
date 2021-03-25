package com.BE_Test.page;

import com.BE_Test.page.Tokens;
import com.BE_Test.page.UserBody;
import com.github.javafaker.Faker;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.junit.Assert.*;

public class UserCreateIAM {
    String userCreateEndpoint= "IAM-SERVICE/api/users";

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

//    public static void main(String[] args) {
//        System.out.println(createUserBody("SUPER_ADMIN"));
//        System.out.println(createUserBody("MODERATOR"));
//        System.out.println(createUserBody("EDITOR"));
//        System.out.println(createUserBody("TEACHER"));
//        System.out.println(createUserBody("STUDENT"));
//        System.out.println(createUserBody("SALESMAN"));
//        System.out.println(createUserBody("SCHOOL_ADMIN"));
//        System.out.println(createUserBody("EXPERT"));
//    }

//    public static void main(String[] args) {
////        UserCreateBEiam create=new UserCreateBEiam();
////        //instance variable/method
////        System.out.println(create.createUserBody("SUPER_ADMIN"));
// instance method ile cagirabilmek icin createUserBody method u static olmamali
//}

    Response response;

    public void createNewUser(String role){
        response= given().contentType(ContentType.JSON).
                headers("Authorization","Bearer "+ Tokens.superAdminToken()).
                body(createUserBody(role)).log().all().
                when().post(userCreateEndpoint).prettyPeek();

    }
    public void roleVerify(String role){
        assertEquals(201,response.getStatusCode() );
        String actualRole=response.jsonPath().getString("data.roles[0]");
        assertEquals(role,actualRole);
    }

}
