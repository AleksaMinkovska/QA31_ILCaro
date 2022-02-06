package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    //WebDriver wd;

    EventFiringWebDriver wd;

    UserHelper userHelper;
    CarHelper carHelper;
    SearchHelper searchHelper;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);   // Logger  import org.slf4j.Logger; "


//////////////////////////////   init = setUp  //////////////////////////////

    public void init(){


        //wd = new ChromeDriver();

        wd = new EventFiringWebDriver(new ChromeDriver());

        logger.info("All tests start in Chrome Browser");
        wd.manage().window().maximize();
        wd.navigate().to("https://ilcarro.xyz/search");

        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);   // nastrojka na ozidanije ljubogo elementa
                                                                            // piwetsja odin raz v kode. Srabativajet v momente wd.findElement, togda otrabativajet etot taimer v 5 sec.
        wd.register(new MyListener());

        userHelper = new UserHelper(wd);
        carHelper = new CarHelper(wd);
        searchHelper = new SearchHelper(wd);

    }

/////////////////////////    stop = tearDown   /////////////////////////

    public void stop(){
        wd.quit();
    }


////////////////////////////////  Getters   ////////////////////////////////

    public UserHelper getUserHelper() {
        return userHelper;
    }
    public CarHelper getCarHelper() {
        return carHelper;
    }
    public SearchHelper getSearchHelper() {
        return searchHelper;
    }
}
