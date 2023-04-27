package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

import Listeners.ExtentReporterNG;


public class BaseTest {

    Properties properties;
    WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public Properties initializeProperties() {
        try {
            properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/BaseProperties.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public void initializeBrowser() {
        String browserName = properties.getProperty("browser");
        System.out.println("Browser is ::" + browserName);

        switch (browserName) {

            case ("FF"):
                WebDriverManager.firefoxdriver().setup();
                System.getProperty("webdriver.gecko.driver");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                break;

            case ("safari"):
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                break;

            case ("Edge"):
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                break;

            default:
                ChromeOptions options = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                options.addArguments("--disable-notifications");
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                break;

        }
        System.out.println(properties.getProperty("url"));
    }

        @BeforeSuite(alwaysRun = true)
        public void startBeforeSuiteExecution(ITestContext ctx) throws Exception {
//    //    workingDirPath = System.getProperty("user.dir");
//        tc = BossBase.getDriver();
//        Utilities.emptyFolder(workingDirPath + "/errorScreenShot", false, ".png");
//        Utilities.emptyFolder(workingDirPath + "/data/GenericBulk/RunTimeUploadCSV", false, ".csv");
////		Utilities.emptyFolder(workingDirPath + "/Logs/Admin", false, ".txt");
////		Utilities.emptyFolder(workingDirPath + "/Logs/Boss", false, ".txt");
////		DatabaseUtil.closeConnection1();
//        DatabaseUtil.getInstance(DBpropertyFactory);
//
//        uiFlag = System.getProperty("uiOpen");
//        slackNotificationFlag = System.getProperty("sn");
//
//        System.out.println("UI Open flag : "+uiFlag);
//        System.out.println("Slack Notification flag : "+slackNotificationFlag);
//
//        if(uiFlag.equalsIgnoreCase("true")){
//            String username			= DBpropertyFactory.getProperty("BOSS_USER");
//            String password			= DBpropertyFactory.getProperty("BOSS_PASSWORD");
//
//            BossUtil bossUtil 			= BossBase.getUtil();
//            bossUtil.login1(username, password);
//
//            cookie1 = tc.getDriver().manage().getCookieNamed("BOSS_SESSION");
//        }

//		cts = new ConnectToServer();
//		bSession = cts.createServerSession(DBpropertyFactory.getProperty("LOG_BOSS_USER"), DBpropertyFactory.getProperty("LOG_BOSS_IP"), DBpropertyFactory.getProperty("LOG_BOSS_PASSWORD"));
//		aSession = cts.createServerSession(DBpropertyFactory.getProperty("LOG_ADMIN_USER"), DBpropertyFactory.getProperty("LOG_ADMIN_IP"), DBpropertyFactory.getProperty("LOG_ADMIN_PASSWORD"));
        }

        @BeforeClass
        public void beforeClassTest() throws Exception {
            ExtentReporterNG.startParent(this.getClass().getSimpleName(), this.getClass().getSimpleName());
//		DatabaseUtil.initConnection(DBpropertyFactory);
        }

        @BeforeMethod
        public void beforeMethodTest(Method method) throws Exception {
            ExtentReporterNG.startChild(this.getClass().getSimpleName(), method.getName(), "");
//		sTime.put(method.getName(), getCurrentTime());
        }

        @AfterClass(alwaysRun = true)
        public void initReport() throws Exception {
            ExtentReporterNG.closeTest();
            System.gc();
        }

        @AfterSuite(alwaysRun = false)
        public void stopTestExecution(ITestContext ctx) throws Exception {
            //DatabaseUtil.closeConnection1();
            ExtentReporterNG.closeReport();
//        Utilities.emptyFolder(workingDirPath + "/allure-results/", false, ".json");
//        SlackIntegrationTest st = new SlackIntegrationTest();
//        if (uiFlag.equalsIgnoreCase("true")) {
//            tc.quit();
//            if(slackNotificationFlag.equalsIgnoreCase("true")) {
//                st.sendTestExecutionReportToSlack("./Reports/ExtentReport.html","Extents Report","UI Extents");
//                st.sendTestExecutionReportToSlack("./target/surefire-reports/customized-emailable-report.html","TestNG Emailable Report","UI TestNG");
//            }
//        }else {
//            if(slackNotificationFlag.equalsIgnoreCase("true")) {
//                st.sendTestExecutionReportToSlack("./Reports/ExtentReport.html","Extents Report","API Extents");
//                st.sendTestExecutionReportToSlack("./target/surefire-reports/customized-emailable-report.html","TestNG Emailable Report","API TestNG");
//            }
//        }

//		cts.disconnectToServer(bSession);
//		cts.disconnectToServer(aSession);
        }

        @AfterMethod
        public void afterMethod(ITestResult result, Method method) throws Exception {
//		eTime.put(method.getName(), getCurrentTime());
//		String stime = sTime.get(method.getName());
//		String etime = eTime.get(method.getName());
//		cts.createLogFile(bSession,workingDirPath+"/Logs/Boss/"+method.getName()+".txt","sed -n '/"+stime+"/,/"+etime+"/p' "+DBpropertyFactory.getProperty("LOG_BOSS_PATH"));
//		cts.createLogFile(aSession,workingDirPath+"/Logs/Admin/"+method.getName()+".txt","sed -n '/"+stime+"/,/"+etime+"/p' "+DBpropertyFactory.getProperty("LOG_ADMIN_PATH"));
//		attachLogs(workingDirPath+"/Logs/Boss/"+method.getName()+".txt",workingDirPath+"/Logs/Admin/"+method.getName()+".txt");

            if (result.getStatus() == ITestResult.FAILURE) {
                //   if (tc.getDriver() != null)
                ExtentReporterNG
                        .logFail(method.getName() + " test execution failed " + result.getThrowable().toString());
//            else
//                ExtentReporterNG.logFailWOScrnsht(
//                        method.getName() + " test execution failed " + result.getThrowable().toString());
            } else if (result.getStatus() == ITestResult.SKIP) {
                ExtentReporterNG.logSkip(method.getName() + " test execution skipped " + result.getThrowable());
            } else {
                ExtentReporterNG.logPass(method.getName() + " test execution passed");
            }

            ExtentReporterNG.closeChildTest(this.getClass().getSimpleName() + "." + method.getName());

        }

        public void logTest(Status logStatus, String description, Object... b) throws IOException {
            ExtentReporterNG.logTest(logStatus, description, b);
        }

        public void logFail(String description) throws Exception {
            ExtentReporterNG.logFail(description);
        }

        public void logFailWOScrnsht(String description) throws Exception {
            ExtentReporterNG.logFailWOScrnsht(description);
        }

        public void logSkip(String description) {
            ExtentReporterNG.logSkip(description);
        }

        public void addScreenShot() throws Exception {
            ExtentReporterNG.addScreenShot();
        }

        public static void logInfo(String description) {
            ExtentReporterNG.logInfo(description);
        }

        public static void attachLogs(String bPath,String aPath) throws Exception {
            ExtentReporterNG.attachLogFile(bPath,aPath);
        }

        public void logPass(String description) {
            ExtentReporterNG.logPass(description);
        }

        public void logAssert(Boolean status, String description) throws Exception {
            ExtentReporterNG.logAssert(status, description);
        }

        public void logAssertFalse(Boolean status, String description) throws Exception {
            ExtentReporterNG.logAssertFalse(status, description);
        }

        public void logAssert(Boolean status) throws Exception {
            ExtentReporterNG.logAssert(status);
        }

        public void logSoftAssert(Boolean status, String description) throws Exception {
            ExtentReporterNG.logSoftAssert(status, description);
        }

        public void logAssertFailMobile(String imagePath, String msg) throws Exception {
            ExtentReporterNG.logAssertFailMobile(imagePath, msg);
        }
    }



