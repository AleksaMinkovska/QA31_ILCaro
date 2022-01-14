package tests;

import org.testng.annotations.Test;

public class RegistrationTests extends TestsBase{


    @Test

    public void registrationSuccess(){

        app.getUserHelper().openSingUpForm();
        app.getUserHelper().fillRegistrationForm("Markus", "Strom", "markusstrom@gmail.com", "Mstrom777%");
        app.getUserHelper().checkBox();
        app.getUserHelper().submitForm();

    }
}
