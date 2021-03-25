package com.stepDefinitions;

import com.UI_Test.utilities.ConfigurationReader;
import com.UI_Test.utilities.Driver;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.reset;

public class Hooks {


    @Before
    public void setup(Scenario scenario){
        System.out.println(scenario.getSourceTagNames());
        System.out.println(scenario.getName());
        System.out.println("BEFORE");

        if(String.valueOf(scenario.getSourceTagNames()).contains("@web")){
            Driver.get().get(ConfigurationReader.get("uiURL"));
            Driver.get().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            Driver.get().manage().window().maximize();
        }else if(String.valueOf(scenario.getSourceTagNames()).contains("@api")){
            baseURI= ConfigurationReader.get("base_URI");
        }else{

        }

    }

    @After
    public void teardown(Scenario scenario){

        if(String.valueOf(scenario.getSourceTagNames()).contains("@web")){
            if(scenario.isFailed()){
                TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.get();
                byte[] image = takesScreenshot.getScreenshotAs(OutputType.BYTES);
                scenario.embed(image, "image/png");
            }
            Driver.closeDriver();
        }else if(String.valueOf(scenario.getSourceTagNames()).contains("@api")){
            reset();
        }else{

        }
        System.out.println("AFTER");
    }
}


