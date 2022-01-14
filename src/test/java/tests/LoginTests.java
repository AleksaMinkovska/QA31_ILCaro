package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTests extends TestsBase{

    @Test


    public void loginSuccess(){
        // open form login
        app.getUserHelper().openLoginForm();


        // fill form ---> type()
        app.getUserHelper().fillLoginForm("lenastep@gmail.com", "12345nnnN");


        // button login  ---- > click()
        app.getUserHelper().submitForm();

    }



}

