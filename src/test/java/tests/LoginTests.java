package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestsBase{


    @BeforeMethod
    public void precondition(){
        //  if logged --> logOut
        if(app.getUserHelper().isLogOutButtonPresent()){
            app.getUserHelper().logOut();
        }
    }


    @Test
    public void loginSuccess(){
        logger.info("Test starts with email: [\"lenastep@gmail.com\"] and password: [\"12345nnnN\"]");
        // open form login
        app.getUserHelper().openLoginForm();

        // fill form ---> type()
        app.getUserHelper().fillLoginForm("lenastep@gmail.com", "12345nnnN");

        // button login  ---- > click()
        app.getUserHelper().submitForm();


        Assert.assertTrue(app.getUserHelper().isLoginSuccess());
    }


//////////////////////////////   MODEL  //////////////////////////////

    @Test
    public void loginSuccessModel(){

        User user = new User().withEmail("lenastep@gmail.com").withPassword("12345nnnN");

        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(user);
        app.getUserHelper().submitForm();

        app.getUserHelper().takeScreenShot("src/test/screenshots/scr2.png");

        Assert.assertTrue(app.getUserHelper().isLoginSuccess());

    }


    @AfterMethod
    public void postcondition(){
        //click Ok
        app.getUserHelper().clickOkButton();
    }
}

