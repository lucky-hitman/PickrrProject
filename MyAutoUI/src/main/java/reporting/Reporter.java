package reporting;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.IOException;

public class Reporter {
    static ExtentReports extentReports;

    static ExtentTest extentTest;

    public static ExtentTest getExtentTest() {
        return extentTest;
    }

    public static void setExtentTest(String testName) {
        extentTest = extentReports.createTest(testName);

    }

    public static void setTestStatus(Status logStatus, String description, String testMethodName) {

        String path = "./Screenshots/"+ testMethodName + ".png";
        if (logStatus.toString().equalsIgnoreCase("PASS")) {
            extentTest.pass("pass");
            extentTest.log(logStatus, "<b><font face=\"Courier New\" color = \"green\">" + description + "</font></b>");
        }
        else if (logStatus.toString().equalsIgnoreCase("FAIL")) {
            extentTest.fail("Test Case Failed Snapshot is below " + extentTest.addScreenCaptureFromPath(path));
            extentTest.log(logStatus,"<a href="+path+"> <img src='"+
                    path+"/selenium-reports/html/"+ testMethodName + ".jpg' height='100' width='100'/> </a>");
        } else if (logStatus.toString().equalsIgnoreCase("SKIP")) {
            extentTest.skip("skip");
            extentTest.log(logStatus, "<b><font face=\"Courier New\" color = \"blue\">" + description + "</font></b>");
        }
    }

    public static void init(){
        if(extentReports ==null ) {
            extentReports = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter("target/spark/Spark.html");
            //spark.config().setTheme(Theme.DARK);
           // spark.config().setReportName("Automation Report");
            extentReports.attachReporter(spark);
            extentReports.setSystemInfo("Operating System", "macos");
            extentReports.setSystemInfo("Browser", "chrome");
            extentReports.setAnalysisStrategy(AnalysisStrategy.CLASS);
            System.out.println("Printing :: " + spark.getFile());
        }
    }

    public static void generateReport(){
        extentReports.flush();
    }



}
