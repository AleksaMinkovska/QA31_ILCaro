package tests;

import manager.MyDataProvider;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestsBase{

    @BeforeMethod(alwaysRun = true)
    public void precondition(){
        //  if logged --> logOut
        if(app.getUserHelper().isLogOutButtonPresent()){
            app.getUserHelper().logOut();
        }
    }

    @Test(groups = {"web"})
    public void registrationSuccess(){

        int index = (int)(System.currentTimeMillis()/1000%3600);
        System.out.println(index);
        app.getUserHelper().openSingUpForm();
        app.getUserHelper().fillRegistrationForm("Alex", "Dow", "alex" + index + "@gmail.com", "Aalex12345$");
        app.getUserHelper().checkBox();
        //app.getUserHelper().checkBoxByXY();
        app.getUserHelper().submitForm();
        app.getUserHelper().pause(2000);  // metod pauzi testa

        Assert.assertTrue(app.getUserHelper().isRegistrationSuccess());

    }


////////////////////////////////   the same registration method with MODEL   ////////////////////////////////
    @Test

    public void registrationSuccessModel(){

        int index = (int)(System.currentTimeMillis()/1000%3600);

        User user = new User().withName("Luna").withLastName("Kler").withEmail("kler" + index + "@gmail.com").withPassword("Kkler9876$");

        app.getUserHelper().openSingUpForm();
        app.getUserHelper().fillRegistrationForm(user);
        app.getUserHelper().checkBox();
        //app.getUserHelper().checkBoxByXY();
        app.getUserHelper().submitForm();

        Assert.assertTrue(app.getUserHelper().isRegistrationSuccess());

    }

    @AfterMethod(alwaysRun = true)
    public void postcondition(){
        //click Ok
        app.getUserHelper().clickOkButton();
    }


//////////////////////    Tests with DataProvider     //////////////////////

//    @Test(dataProvider = "registrationValidData", dataProviderClass = MyDataProvider.class)
//
//    public void registrationSuccessDatProvider(String name, String surname, String email, String password){
//
//        app.getUserHelper().openSingUpForm();
//        app.getUserHelper().fillRegistrationForm(name, surname, email, password);
//        app.getUserHelper().checkBox();;
//        app.getUserHelper().submitForm();
//
//        Assert.assertTrue(app.getUserHelper().isRegistrationSuccess());
//
//    }


}
