package com.BE_Test.page;

import com.UI_Test.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Tokens {
    static String superAdminEmail= ConfigurationReader.get("superAdminEmail");
    static String moderatorEmail= ConfigurationReader.get("moderatorEmail");
    static String editorEmail= ConfigurationReader.get("editorEmail");
    static String teacherEmail= ConfigurationReader.get("teacherEmail");
    static String studentEmail= ConfigurationReader.get("studentEmail");
    static String salesmanEmail= ConfigurationReader.get("salesmanEmail");
    static String schoolAdminEmail= ConfigurationReader.get("schoolAdminEmail");
    static String expertEmail= ConfigurationReader.get("expertEmail");
    static String password=ConfigurationReader.get("commonPassword");

    public static String superAdminToken(){

        Map<String, Object> credentials= new HashMap<>();
        credentials.put("email",superAdminEmail);
        credentials.put("password",password);

//        credentials.put("email","abc@abc.co");
//        credentials.put("password","abc123");

        Response response =given().
                contentType(ContentType.JSON).and().body(credentials).post("IAM-SERVICE/api/auth/login");

        return  response.jsonPath().getString("data.token");
    }

    public static String moderatorToken(){

        Map<String, Object> credentials= new HashMap<>();
        credentials.put("email",moderatorEmail);
        credentials.put("password",password);


        Response response =given().contentType(ContentType.JSON).and().body(credentials).post("IAM-SERVICE/api/auth/login");

        return response.jsonPath().getString("data.token");
    }

    public static String editorToken(){

        Map<String, Object> credentials= new HashMap<>();
        credentials.put("email",editorEmail);
        credentials.put("password",password);


        Response response =given().contentType(ContentType.JSON).and().body(credentials).post("IAM-SERVICE/api/auth/login");

        return response.jsonPath().getString("data.token");
    }
    public static String teacherToken(){

        Map<String, Object> credentials= new HashMap<>();
        credentials.put("email",teacherEmail);
        credentials.put("password",password);


        Response response =given().contentType(ContentType.JSON).and().body(credentials).post("IAM-SERVICE/api/auth/login");

        return response.jsonPath().getString("data.token");
    }

    public static String salesmanToken(){

        Map<String, Object> credentials= new HashMap<>();
        credentials.put("email",salesmanEmail);
        credentials.put("password",password);


        Response response =given().contentType(ContentType.JSON).and().body(credentials).post("IAM-SERVICE/api/auth/login");

        return response.jsonPath().getString("data.token");
    }
    public static String schoolAdminToken(){

        Map<String, Object> credentials= new HashMap<>();
        credentials.put("email",schoolAdminEmail);
        credentials.put("password",password);


        Response response =given().contentType(ContentType.JSON).and().body(credentials).post("IAM-SERVICE/api/auth/login");

        return response.jsonPath().getString("data.token");
    }
    public static String studentToken(){

        Map<String, Object> credentials= new HashMap<>();
        credentials.put("email",studentEmail);
        credentials.put("password",password);


        Response response =given().contentType(ContentType.JSON).and().body(credentials).post("IAM-SERVICE/api/auth/login");

        return response.jsonPath().getString("data.token");
    }
    public static String expertToken(){

        Map<String, Object> credentials= new HashMap<>();
        credentials.put("email",expertEmail);
        credentials.put("password",password);


        Response response =given().contentType(ContentType.JSON).and().body(credentials).post("IAM-SERVICE/api/auth/login");

        return response.jsonPath().getString("data.token");
    }

}
