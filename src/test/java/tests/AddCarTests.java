package tests;

import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddCarTests extends TestsBase{

    @BeforeMethod
    public void precondition(){
        //if !logged --> login()
        if(!app.getUserHelper().isLogOutButtonPresent()){
            User user = new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$");
            app.getUserHelper().login(user);
            logger.info("Car was added for user" + user.toString());
        }

    }

    @Test
    public void addCarSuccess1(){
        //open car form --> fill car form --> attach picture --> submit

        int index = (int)(System.currentTimeMillis()/1000%3600);
        Car car = Car.builder()
                .location("Tel Aviv, Israel")
                .make("SUPER")
                .model("CAR")
                .year("2022")
                .engine("3.5")
                .fuel("Petrol")
                .gear("MT")
                .wD("AWD")
                .doors("2")
                .seats("4")
                .carClass("sport")
                .fuelConsumption("12l")
                .carRegNumber("33-"+ index +"-99")
                .price("199")
                .distance("3000")
                .features("null")
                .about("try it")
                .build();

        logger.info("Car was added" + car.toString());

        app.getCarHelper().openCarForm();
        app.getCarHelper().fillCarForm(car);
        app.getCarHelper().attachPhoto("C:\\Users\\User\\Desktop\\Downloads\\car.jpg");
        app.getCarHelper().submitForm();

        Assert.assertTrue(app.getCarHelper().isCarAdded());
    }


    @Test
    public void addCarSuccess2(){
        //open car form --> fill car form --> attach picture --> submit

        int index = (int)(System.currentTimeMillis()/1000%3600);
        Car car = Car.builder()
                .location("Tel Aviv, Israel")
                .make("SUPER")
                .model("CAR")
                .year("2022")
                .engine("3.5")
                .fuel("Petrol")
                .gear("MT")
                .wD("AWD")
                .doors("2")
                .seats("4")
                .carClass("sport")
                .fuelConsumption("12l")
                .carRegNumber("33-"+ index +"-99")
                .price("199")
                .distance("3000")
                .features("null")
                .about("try it")
                .build();

        app.getCarHelper().openCarForm();
        app.getCarHelper().fillCarForm(car);
        app.getCarHelper().attachPhoto("C:\\Users\\User\\Desktop\\Downloads\\car.jpg");
        app.getCarHelper().submitForm();

        Assert.assertTrue(app.getCarHelper().isCarAdded());
    }

    @AfterMethod
    public void postConditions(){
        app.getCarHelper().clickSearchButton();
        app.getUserHelper().logOut();
    }


}
