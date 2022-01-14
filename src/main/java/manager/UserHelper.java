package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase{

    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm(){
        click(By.xpath("//a[text()=' Log in ']"));
    }

    public void fillLoginForm(String email, String password){
        type(By.id("email"), email);
        type(By.id("password"), password);
    }

    public void submitForm() {
        click(By.cssSelector("[type='submit']"));
    }

    public void openRegistrationForm() {
    }

    public void fillRegistrationForm(String markus, String strom, String s, String s1) {
    }

    public void checkPolicy() {
    }
}

