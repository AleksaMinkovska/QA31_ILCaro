package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHelper extends HelperBase{

    public UserHelper(WebDriver wd) {
        super(wd);
    }


/////////////////////////////   Methods   /////////////////////////////

    public void openLoginForm(){
        click(By.xpath("//a[text()=' Log in ']"));
    }

    public void fillLoginForm(String email, String password){
        type(By.id("email"), email);
        type(By.id("password"), password);
    }
//////////////////////   method with model  //////////////////////

    public void fillLoginForm(User user){
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public void submitForm() {
        click(By.cssSelector("[type='submit']"));
    }

    // --------------------------  Registration  --------------------------

    public void openSingUpForm() {
        click(By.xpath("//*[text()=' Sign up ']"));
    }

    public void fillRegistrationForm(String name, String lastname, String email, String password) {
        if(wd.findElement(By.tagName("form")).isDisplayed())   // proverka na otobrazenije form
        {
            type(By.id("name"), name);
            type(By.id("lastName"), lastname);
            type(By.id("email"), email);
            type(By.id("password"), password);
        }
    }

    public void fillRegistrationForm(User user) {
        if(wd.findElement(By.tagName("form")).isDisplayed())   // proverka na otobrazenije form
        {
            type(By.id("name"), user.getName());
            type(By.id("lastName"), user.getLastName());
            type(By.id("email"), user.getEmail());
            type(By.id("password"), user.getPassword());
        }
    }

    public void checkBox() {
        //wd.findElement(By.cssSelector("[class='checkbox-label terms-label']"));
        //click(By.cssSelector("[class='ng-dirty ng-touched ng-valid']"));
        //click(By.cssSelector("[class='checkbox-label terms-label']"));

        if(!wd.findElement(By.id("terms-of-use")).isSelected()) {
            click(By.cssSelector("[class='checkbox-container']"));
        }

    }
///////////////////////////////////  ASSERT METHODS  ///////////////////////////////////

    public boolean isRegistrationSuccess() {
        // dialog is displayed???

        WebElement message = wd.findElement(By.cssSelector("h2.message"));
        String text = message.getText();
        return text.equals("You are logged in success");
    }

    public boolean isLoginSuccess() {

        WebElement loginMessage = wd.findElement(By.cssSelector("h2.message"));
        String mes = loginMessage.getText();
        return mes.equals("Logged in success");
    }
}

