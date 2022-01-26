package tests;

import manager.ApplicationManager;
import org.testng.annotations.*;

public class TestsBase {

    protected static ApplicationManager app = new ApplicationManager();


    //@BeforeMethod   -  перед каждым методом каждого теста
    //@BeforeClass   - перед всеми методами тестами ОДНОГО класса
    @BeforeSuite   // -  перед всеми 1 раз

    public void setUp() {
        app.init();
    }

    //@AfterMethod
    //@AfterClass
    @AfterSuite  // - в конце один раз после всех метобов тестов

    public void tearDown() {
        //app.stop();
    }


}

