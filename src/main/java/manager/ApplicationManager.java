package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    UserHelper userHelper;


//////////////////////////////   init = setUp  //////////////////////////////

    public void init(){
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.navigate().to("https://ilcarro.xyz/search");

        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);   // nastrojka na ozidanije ljubogo elementa
                                                                            // piwetsja odin raz v kode. Srabativajet v momente wd.findElement, togda otrabativajet etot taimer v 5 sec.
        userHelper = new UserHelper(wd);

    }

/////////////////////////    stop = tearDown   /////////////////////////

    public void stop(){
        wd.quit();
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }
}
