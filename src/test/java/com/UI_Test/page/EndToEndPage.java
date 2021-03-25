package com.UI_Test.page;


import com.UI_Test.utilities.BrowserUtils;
import com.UI_Test.utilities.Driver;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;


public class EndToEndPage {
    Faker faker=new Faker();

    WebDriver driver=Driver.get();

    public EndToEndPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(),'Moderators')]")
    public WebElement moderatorTab;


    @FindBy(xpath = "//span[@class=\"MuiButton-label\"]")
    public WebElement addButton;

    @FindBy(xpath = "//*[@class=\"MuiDialogContent-root\"]/div/div/input")
    public List<WebElement> infoInputs;

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@aria-describedby=\"notistack-snackbar\"]")
     public WebElement snackbar;

    @FindBy(xpath = "//span[contains(text(),'Editors')]")
    public WebElement editorsTab;

    @FindBy(xpath = "//span[contains(text(),'Teachers')]")
    public WebElement teachersTab;

    @FindBy(xpath = "//span[contains(text(),'Salesman')]")
    public WebElement salesmanTab;

    @FindBy(xpath = "//span[contains(text(),'School Admin')]")
    public WebElement schoolAdminTab;


    @FindBy(id = "region")
    private WebElement regionDropDown;

    @FindBy(xpath = "//*[@class=\"MuiAutocomplete-popper\"]")
    private WebElement regionOptions;

    @FindBy(id = "district")
    private WebElement districtDropDown;

    @FindBy(id = "school")
    private WebElement schoolDropDown;


//    @FindBy(xpath = "//input[@id='email']")
//    public WebElement inputEmail;
//
//    @FindBy(xpath = "//input[@id='firstName']")
//    public WebElement inputFirstName;
//
//    @FindBy(xpath = "//input[@id='lastName']")
//    public WebElement inputLastName;




    String emailModerator="";
    String password="Test123456!";

    String emailEditor="";
    String emailTeacher="";
    String emailSalesman="";
    String emailSchoolAdmin="";


    public void LoginAsSuperAdmin(){
        Login login=new Login();
        login.navigateLoginPage();
        login.enterCredentials("superadmin");
        login.clickLoginButton();
    }

    public void createModerator(){
        emailModerator=faker.internet().emailAddress();
//        password=faker.internet().password(8,50,true,true,true);

        moderatorTab.click();
        addButton.click();
        infoInputs.get(0).sendKeys(emailModerator);
        infoInputs.get(1).sendKeys(faker.name().firstName());
        infoInputs.get(2).sendKeys(faker.name().lastName());
        infoInputs.get(3).sendKeys(faker.number().digits(10));
        infoInputs.get(4).sendKeys(password);
        saveButton.click();
        BrowserUtils.waitFor(1);
    }

    public void verifyCreatedModerator(){

            System.out.println("Verify message: "+ snackbar.getText());

        Assert.assertEquals("Moderator created", snackbar.getText());
        BrowserUtils.waitFor(5);
    }

    public void createEditor(){
        emailEditor=faker.internet().emailAddress();
//        password=faker.internet().password(8,50,true,true,true);

        editorsTab.click();
        addButton.click();
        infoInputs.get(0).sendKeys(emailEditor);
        infoInputs.get(1).sendKeys(faker.name().firstName());
        infoInputs.get(2).sendKeys(faker.name().lastName());
        infoInputs.get(3).sendKeys(faker.number().digits(10));
        infoInputs.get(4).sendKeys(password);
        saveButton.click();
        BrowserUtils.waitFor(2);
    }
    public void verifyCreatedEditor(){

        System.out.println("Verify message: "+ snackbar.getText());
        Assert.assertEquals("Editor created", snackbar.getText());
        BrowserUtils.waitFor(5);
    }
    public void createTeacher(){
        emailTeacher=faker.internet().emailAddress();
//        password=faker.internet().password(8,50,true,true,true);

        teachersTab.click();
        addButton.click();
        enterSchoolId();
        infoInputs.get(0).sendKeys(emailTeacher);
        infoInputs.get(1).sendKeys(faker.name().firstName());
        infoInputs.get(2).sendKeys(faker.name().lastName());
        infoInputs.get(3).sendKeys(faker.number().digits(10));
        infoInputs.get(4).sendKeys(password);
        saveButton.click();
        BrowserUtils.waitFor(2);
    }
    public void verifyCreatedTeacher(){

        System.out.println("Verify message: "+ snackbar.getText());
        Assert.assertEquals("Teacher created", snackbar.getText());
        BrowserUtils.waitFor(5);
    }
    public void createSalesman(){
        emailSalesman=faker.internet().emailAddress();
//        password=faker.internet().password(8,50,true,true,true);

        salesmanTab.click();
        addButton.click();
        enterSchoolId();
        infoInputs.get(0).sendKeys(emailSalesman);
        infoInputs.get(1).sendKeys(faker.name().firstName());
        infoInputs.get(2).sendKeys(faker.name().lastName());
        infoInputs.get(3).sendKeys(faker.number().digits(10));
        infoInputs.get(4).sendKeys(password);
        saveButton.click();
        BrowserUtils.waitFor(2);
    }
    public void verifyCreatedSalesman(){

        System.out.println("Verify message: "+ snackbar.getText());
        Assert.assertEquals("Salesman created", snackbar.getText());
        BrowserUtils.waitFor(5);
    }
    public void createSchoolAdmin(){
        emailSchoolAdmin=faker.internet().emailAddress();
//        password=faker.internet().password(8,50,true,true,true);

        schoolAdminTab.click();
        addButton.click();
        enterSchoolId();
        infoInputs.get(0).sendKeys(emailSchoolAdmin);
        infoInputs.get(1).sendKeys(faker.name().firstName());
        infoInputs.get(2).sendKeys(faker.name().lastName());
        infoInputs.get(3).sendKeys(faker.number().digits(10));
        infoInputs.get(4).sendKeys(password);
        saveButton.click();
        BrowserUtils.waitFor(2);
    }
    public void verifyCreatedSchoolAdmin(){

        System.out.println("Verify message: "+ snackbar.getText());
        Assert.assertEquals("School Admin created", snackbar.getText());
        BrowserUtils.waitFor(2);
    }

    public void enterSchoolId(){

        Response response = given().get("http://server.serra.pw:9000/TEST-CENTRE-SERVICE/api/schools");

        List<Integer> regionIds = response.jsonPath().getList("data.regions.id");
        List<String>  regionsName= response.jsonPath().getList("data.regions.name");

        List<Integer> districtIds= response.jsonPath().getList("data.districts.id");
        List<String>  districtNames=response.jsonPath().getList("data.districts.name");
        List<Integer>  districtParentIds= response.jsonPath().getList("data.districts.parentId");

        List<Integer>  schoolIds=response.jsonPath().getList("data.schools.id");
        List<String> schoolNames=response.jsonPath().getList("data.schools.name");
        List<Integer>  schoolParentIds=response.jsonPath().getList("data.schools.parentId");


        int regionIndex= new Random().nextInt(regionIds.size()-1);
        int regionId=regionIds.get(regionIndex);
        String regionName= regionsName.get(regionIndex);

        List<Integer> regionsDistrictids= new ArrayList<>();
        List<String> regionsDistrictNames= new ArrayList<>();

        for (int i = 0; i <districtIds.size() ; i++) {

            if (districtParentIds.get(i)==regionId){
                regionsDistrictids.add(districtIds.get(i));
                regionsDistrictNames.add(districtNames.get(i));
            }

        }

        int distrinctIndex= new  Random().nextInt(regionsDistrictids.size()-1);

        int districtId= regionsDistrictids.get(distrinctIndex);

        String districtName=regionsDistrictNames.get(distrinctIndex);

        List<Integer> districtSchoolIds=new ArrayList<>();
        List<String>  districtSchoolName= new ArrayList<>();
        for (int i = 0; i <schoolIds.size() ; i++) {

            if (schoolParentIds.get(i)==districtId){
                districtSchoolIds.add(schoolIds.get(i));
                districtSchoolName.add(schoolNames.get(i));
            }

        }

        int schoolIndex= new Random().nextInt(districtSchoolIds.size()-1);

        int schoolId=districtSchoolIds.get(schoolIndex);
        String schoolName =districtSchoolName.get(schoolIndex);

        regionDropDown.sendKeys(regionName);
        regionOptions.click();
        BrowserUtils.waitFor(1);

        districtDropDown.sendKeys(districtName);
        regionOptions.click();
        BrowserUtils.waitFor(1);

        schoolDropDown.sendKeys(schoolName);
        regionOptions.click();
        BrowserUtils.waitFor(1);


    }


}
