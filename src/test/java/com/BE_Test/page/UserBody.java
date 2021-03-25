package com.BE_Test.page;


import java.util.Arrays;

public class UserBody {

    private String email;
    private String firstName;
    private String lastName;
    private String mobile;
    private String password;
    private String [] roles;

    @Override
    public String toString() {
        return "UserBody{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + Arrays.toString(roles) +
                '}';
    }
//constructor
    public UserBody(String email,String firstName, String lastName, String mobile, String password, String [] roles){
        this.email=email;
        this.firstName=firstName;
        this.lastName=lastName;
        this.mobile=mobile;
        this.password=password;
        this.roles=roles;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public UserBody(){

    }





}
