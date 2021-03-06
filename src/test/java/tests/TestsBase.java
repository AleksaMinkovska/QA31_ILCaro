package tests;

import manager.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class TestsBase {

    protected static ApplicationManager app = new ApplicationManager();

    @BeforeMethod(alwaysRun = true)
    public void startLogger(Method m){
        logger.info("Name of test: " + m.getName());
    }

    //@BeforeMethod   -  перед каждым методом каждого теста
    //@BeforeClass   - перед всеми методами тестами ОДНОГО класса
    @BeforeSuite(alwaysRun = true)   // -  перед всеми 1 раз

    public void setUp() {
        app.init();
    }

    //@AfterMethod
    //@AfterClass
    @AfterSuite(alwaysRun = true)  // - в конце один раз после всех метобов тестов

    public void tearown() {
        app.stop();
    }

    Logger logger = LoggerFactory.getLogger(TestsBase.class);  // logger v klasse TestBase(roditele)
}

