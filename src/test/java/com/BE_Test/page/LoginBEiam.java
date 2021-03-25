package com.BE_Test.page;

import com.UI_Test.utilities.ConfigurationReader;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

public class LoginBEiam {

    String IAMserviceLogin="IAM-SERVICE/api/auth/login";


    public void loginWithRoles(String role,String roles){
        String email="";
        String password=ConfigurationReader.get("commonPassword");
        Map<String,Object> body= new HashMap<>();



        if (role.equalsIgnoreCase("superadmin")){
            email= ConfigurationReader.get("superAdminEmail");
        }else if(role.equalsIgnoreCase("moderator")){
            email=ConfigurationReader.get("moderatorEmail");

        }else if (role.equalsIgnoreCase("editor")){
            email= ConfigurationReader.get("editorEmail");
        }else if (role.equalsIgnoreCase("teacher")){
            email= ConfigurationReader.get("teacherEmail");
        }else if (role.equalsIgnoreCase("student")){
            email=ConfigurationReader.get("studentEmail");
        }else if (role.equalsIgnoreCase("salesman")){
            email=ConfigurationReader.get("salesmanEmail");
        }else if (role.equalsIgnoreCase("schooladmin")){
            email=ConfigurationReader.get("schoolAdminEmail");
        }else if (role.equalsIgnoreCase("expert")){
            email=ConfigurationReader.get("expertEmail");
        }else{
            System.out.println("Email or Password invalid");
        }

        body.put("email",email);
        body.put("password",password);


        Response response= given()
                .contentType(ContentType.JSON).body(body).log().all().
                when()
                .post(IAMserviceLogin).prettyPeek();

        assertEquals(200,response.statusCode());

        String bodyRole=response.jsonPath().getString("data.roles[0]");

        assertEquals(roles,bodyRole);


        System.out.println(bodyRole);
        System.out.println(response.statusCode());






    }

}
