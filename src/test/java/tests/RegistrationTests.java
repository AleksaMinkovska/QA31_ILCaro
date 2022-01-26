package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestsBase{

    @BeforeMethod
    public void precondition(){
        //  if logged --> logOut
        if(app.getUserHelper().isLogOutButtonPresent()){
            app.getUserHelper().logOut();
        }
    }

    @Test

    public void registrationSuccess(){

        int index = (int)(System.currentTimeMillis()/1000%3600);
        System.out.println(index);
        app.getUserHelper().openSingUpForm();
        app.getUserHelper().fillRegistrationForm("Markus", "Strom", "markusstrom" + index + "@gmail.com", "Mstrom777%");
        app.getUserHelper().checkBox();
        //app.getUserHelper().checkBoxByXY();
        app.getUserHelper().submitForm();

        //app.getUserHelper().pause(2000);  // metod pauzi testa

        Assert.assertTrue(app.getUserHelper().isRegistrationSuccess());

    }


////////////////////////////////   the same registration method with MODEL   ////////////////////////////////
    @Test

    public void registrationSuccessModel(){

        int index = (int)(System.currentTimeMillis()/1000%3600);

        User user = new User().withName("Roman").withLastName("Strom").withEmail("rstrom" + index + "@gmail.com").withPassword("Strom999$");

        app.getUserHelper().openSingUpForm();
        app.getUserHelper().fillRegistrationForm(user);
        app.getUserHelper().checkBox();
        //app.getUserHelper().checkBoxByXY();
        app.getUserHelper().submitForm();

        Assert.assertTrue(app.getUserHelper().isRegistrationSuccess());

    }

    @AfterMethod
    public void postcondition(){
        //click Ok
        app.getUserHelper().clickOkButton();
    }
}
