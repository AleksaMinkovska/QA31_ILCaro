package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SearchHelper extends HelperBase {

    public SearchHelper(WebDriver wd) {
        super(wd);
    }


    public void fillSearchFormCurrentMonth(String city, String dateFrom, String dateTo) {
        fillInputCity(city);
        selectPeriodCurrentMonth(dateFrom, dateTo);
    }

    private void fillInputCity(String city) {
        type(By.id("city"), city);
        pause(2000);
        click(By.cssSelector(".pac-item"));
        pause(2000);
    }

    public void selectPeriodCurrentMonth(String dateFrom, String dateTo) {

        //   1/28/2022  -  1/30/2022

        click(By.id("dates"));

        String []dateF = dateFrom.split("/");   // ---> [1] [28] [2022] --> get[1]

        String []dateT = dateTo.split("/"); // --> [1] [30] [2022] --> get[10


        String locator1 = "//div[text()=' " + dateF[1] + " ']";

        //String loc = String.format("//div[text()=' %s ']", dateF[1]); //  String format, metod iz klassa string

        click(By.xpath(locator1));

        String locator2 = "//div[text()=' " + dateT[1] + " ']"; // konkatinacija


        click(By.xpath(locator2));

        pause(2000);
    }


    public boolean isListOfCarsAppeared() {
        return isElementPresent(By.cssSelector(".search-results"));
    }

    public void returnToHome() {
        click(By.xpath("(//img[@alt='logo'])[1]"));
    }

    public void fillSearchForminFuture(String city, String dateFrom, String dateTo) {
        fillInputCity(city);
        selectAnyData(dateFrom, dateTo);
    }


    private void selectAnyData(String dateFrom, String dateTo) {
        // "3/30/2022", "6/25/2022"

        LocalDate from = LocalDate.parse(dateFrom, DateTimeFormatter.ofPattern("MM/dd/yyyy"));  // sami diktujem v kakom formate peredajom string
        LocalDate to = LocalDate.parse(dateTo, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate now = LocalDate.now();

        click(By.id("dates"));

        int mouthDiff = from.getYear() - now.getYear()
                == 0 ? from.getMonthValue() - now.getMonthValue() : 12 - now.getMonthValue() + from.getMonthValue();

        clickNextMonth(mouthDiff);

        String dateLocator = String.format("//div[text()=' %s ']",from.getDayOfMonth());
        click(By.xpath(dateLocator));

        mouthDiff = to.getYear() - from.getYear()
                == 0 ? to.getMonthValue() - from.getMonthValue() : 12- from.getMonthValue() + to.getMonthValue();
        clickNextMonth(mouthDiff);

        dateLocator = String.format("//div[text()=' %s ']",to.getDayOfMonth());
        click(By.xpath(dateLocator));


    }

    private void clickNextMonth(int count) {
        for (int i = 0; i < count; i++) {
            click(By.cssSelector("button[aria-label='Next month']"));

        }
    }

    public void fillSearchInPast(String city, String from, String to) {
        fillInputCity(city);
        typePeriodInPast(from, to);

    }

    private void typePeriodInPast(String from, String to) {
        type(By.id("dates"),from + " - " + to);
    }

    public boolean isDateInPast() {
        WebElement el = wd.findElement(By.cssSelector(".error .ng-star-inserted"));
        String text = el.getText();
        return text.equals("You can't pick date before today");
        //return text.contains("pick date before today");

    }

    public boolean isYallaButtonInactive() {
        return !wd.findElement(By.cssSelector("[type='submit']")).isEnabled();
    }
}




