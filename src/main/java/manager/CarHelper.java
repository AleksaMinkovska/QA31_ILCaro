package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarHelper extends HelperBase{

    public CarHelper(WebDriver wd) {
        super(wd);
    }

    public void openCarForm() {
        click(By.cssSelector("[href='/let-car-work']"));

    }

    public void fillCarForm(Car car) {
        typeLocation(car.getLocation());
        type(By.id("make"), car.getMake());
        type(By.id("model"), car.getModel());
        type(By.id("year"), car.getYear());
        type(By.id("engine"), car.getEngine());

        select(By.id("fuel"), car.getFuel());
        select(By.id("gear"), car.getGear());
        select(By.id("wheelsDrive"), car.getWD());

        type(By.id("doors"), car.getDoors());
        type(By.id("seats"), car.getSeats());
        type(By.id("class"), car.getCarClass());
        type(By.id("fuelConsumption"), car.getFuelConsumption());
        type(By.id("serialNumber"), car.getCarRegNumber());
        type(By.id("price"), car.getPrice());
        type(By.id("distance"), car.getDistance());
        type(By.cssSelector(".feature-input"), car.getFeatures());

        type(By.id("about"), car.getAbout());

    }

    private void select(By locator, String option){
        //new Select(wd.findElement(locator)).selectByIndex(1);  //  or index
        new Select(wd.findElement(locator)).selectByValue(option);  //   or value
        //new Select(wd.findElement(locator)).selectByVisibleText(""); //   or Text
    }

    public void attachPhoto(String link) {
        wd.findElement(By.id("photos")).sendKeys(link);

    }

    public void submitForm() {
        new WebDriverWait(wd,15)
                .until(ExpectedConditions.elementToBeClickable(wd.findElement(By.xpath("//button[text()='Submit']"))));
        click(By.xpath("//button[text()='Submit']"));
    }

    public boolean isCarAdded() {
        //div.dialog-container h1

        new WebDriverWait(wd,15)
                .until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector("div.dialog-container"))));
        String message = wd.findElement(By.cssSelector("div.dialog-container h1")).getText();
        //Car added
        //div.dialog-container h1
        return message.equals("Car added");
    }

    public void clickSearchButton() {

        click(By.cssSelector("button[class='neutral-button ng-star-inserted']"));
    }
}
