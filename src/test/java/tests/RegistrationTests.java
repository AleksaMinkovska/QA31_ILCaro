package tests;

import org.testng.annotations.Test;

public class RegistrationTests extends TestsBase{


    @Test

    public void registrationSuccess(){

        app.getUserHelper().openRegistrationForm();
        app.getUserHelper().fillRegistrationForm("Markus", "Strom", "markusstrom@gmail.com", "Mstr1234%");
        app.getUserHelper().checkPolicy();
        app.getUserHelper().submitForm();

        

        // open form registration
        // fill form  ---> type()
        // checkbox
        // button register ---> click()

    }
}
