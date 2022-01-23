package tests;

import models.Car;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddCarTests extends TestsBase{

    @BeforeMethod
    public void precondition(){
        //if !logged --> login()

    }

    @Test
    public void addCarSuccess(){
        //open car form --> fill car form --> attach picture --> submit
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
                .carRegNumber("33-77-99")
                .price("199")
                .distance("3000")
                .features("null")
                .about("try it")
                .build();

        app.getCarHelper().openCarForm();
        app.getCarHelper().fillCarForm(car);
        app.getCarHelper().attachPhoto("");
        app.getCarHelper().submitForm();
    }


}
