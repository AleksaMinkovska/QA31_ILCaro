package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SearchTests extends TestsBase {

    @Test
    public void searchPeriodCurrentMonth1() {
        app.getSearchHelper().fillSearchFormCurrentMonth("Tel Aviv, Israel", "2/24/2022", "2/28/2022");
        app.getUserHelper().submitForm();


        Assert.assertTrue(app.getSearchHelper().isListOfCarsAppeared());

    }


    @Test
    public void searchPeriodCurrentMonth2() {
        app.getSearchHelper().fillSearchFormCurrentMonth("Rehovot, Israel", "2/24/2022", "2/27/2022");
        app.getUserHelper().submitForm();

        Assert.assertTrue(app.getSearchHelper().isListOfCarsAppeared());

    }

// **************  Class Work  **************

    @Test
    public void searchPeriodInFuture(){
        //app.getSearchHelper().fillSearchForminFuture("Tel Aviv, Israel", "03/30/2022", "06/25/2022");   //done
        //app.getSearchHelper().fillSearchForminFuture("Tel Aviv, Israel", "03/30/2022", "01/31/2023");   // done
        app.getSearchHelper().fillSearchForminFuture("Tel Aviv, Israel", "01/10/2023", "01/31/2023");
        app.getUserHelper().submitForm();

        Assert.assertTrue(app.getSearchHelper().isListOfCarsAppeared());

    }

    @Test
    public void typePeriodInPast(){
        //1/30/2022 - 1/31/2022
        app.getSearchHelper().fillSearchInPast("Rehovot, Israel","2/10/2022","2/11/2022");
        app.getSearchHelper().pause(7000);

        //Assert.assertTrue(app.getSearchHelper().isDateInPast());
        Assert.assertTrue(app.getSearchHelper().isYallaButtonInactive());
    }



    @AfterMethod
    public void postCondition(){
        app.getSearchHelper().returnToHome();
    }
}

