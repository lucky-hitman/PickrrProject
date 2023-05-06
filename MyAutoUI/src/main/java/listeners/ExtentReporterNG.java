//package Listeners;
//
//import Utils.TestUtils;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import org.testng.Assert;
//import org.testng.IReporter;
//
//import java.io.IOException;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//
//import static Listeners.ExtentReporterNG1.getChildTest;
//import static Listeners.ExtentReporterNG1.getTest;
//
//public class ExtentReporterNG implements IReporter {
//
//	static String methodName;
//
//	static Calendar cal = Calendar.getInstance();
//	static SimpleDateFormat FormatDateValue = new SimpleDateFormat("MM-dd-yyyy hh-mm-ss a");
//
//	Date date = new Date();
//	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
//	String filePath = System.getProperty("user.dir") + "/Reports/NexsAutomationReport.html";
//
//	private static ExtentReports extent;
//	private static ExtentTest test;
//	private static ExtentTest parent;
//	private static ExtentHtmlReporter htmlReporter;
//
//	public ExtentReporterNG() {
//		htmlReporter = new ExtentHtmlReporter(filePath);
//		extent = new ExtentReports();
//		extent.attachReporter(htmlReporter);
//	}
//
//	public static void closeTest() {
//	}
//
//	private static class SingletonHelper {
//		private static final ExtentReporterNG INSTANCE = new ExtentReporterNG();
//	}
//
//	public static ExtentReporterNG getInstance() {
//		return SingletonHelper.INSTANCE;
//	}
//
//	public void start(String testName, String testDescription) {
//		parent = extent.createTest(
//				"<b><font face=\"Courier New\" color = \"#5F9EA0\" size=\"3\">" + testName + "</font></b>",
//				"<p><font face=\"Courier New\" color = \"#FFA500\" size=\"2\">SCENARIO:<br />" + testDescription
//						+ "</font></p>");
//	}
//
//	public ExtentTest startParent(String testName, String testDescription) {
//		parent = extent.createTest(
//				"<b><font face=\"Courier New\" color = \"#5F9EA0\" size=\"3\">" + testName + "</font></b>",
//				"<p><font face=\"Courier New\" color = \"#FFA500\" size=\"2\">SCENARIO:<br />" + testDescription
//						+ "</font></p>");
//		return parent;
//	}
//
//	public static ExtentTest startChild(String testName, String testDescription) {
//		test = parent.createNode(
//				"<b><font face=\"Courier New\" color = \"#5F9EA0\" size=\"3\">" + testName + "</font></b>",
//				"<p><font face=\"Courier New\" color = \"#FFA500\" size=\"2\">SCENARIO:<br />" + testDescription
//						+ "</font></p>");
//		return test;
//	}
//
//	public void appendChild(ExtentTest parent, ExtentTest child) {
//	}
//
//	public void end() {
//		extent.flush();
//	}
//
//	public void parentChild() {
//		parent.getExtent().flush();
//	}
//
//	public void endChild() {
//		test.getExtent().flush();
//	}
//
//	public static void logTest(Status logStatus, String description, Object... b) throws IOException {
//		if (logStatus.toString().equalsIgnoreCase("PASS"))
//			test.log(logStatus, "<b><font face=\"Courier New\" color = \"green\">" + description + "</font></b>");
//		else if (logStatus.toString().equalsIgnoreCase("FAIL")) {
//			if (b.length > 0) {
//				test.log(logStatus, "<b><font face=\"Courier New\" color = \"red\">" + description + "</font></b>"
//						+ test.addScreenCaptureFromPath((String) b[0]) + (String) b[1]);
//			}
//			test.log(logStatus, "<b><font face=\"Courier New\" color = \"red\">" + description + "</font></b>"
//					+ test.addScreenCaptureFromPath((String) b[0]) + (String) b[1]);
//		} else if (logStatus.toString().equalsIgnoreCase("SKIP")) {
//			test.log(logStatus, "<b><font face=\"Courier New\" color = \"blue\">" + description + "</font></b>"
//					+ test.addScreenCaptureFromPath((String) b[0]) + (String) b[1]);
//		}
//	}
//
//	public static void logFail(String description) throws Exception {
//		// TODO Auto-generated method stub
//		test.log(Status.FAIL, "<b><font face=\"Courier New\" color = \"red\">" + description + "</font></b>");
//		addScreenShot();
//	}
//
//	public static void logFailWOScrnsht(String description) throws Exception {
//		// TODO Auto-generated method stub
//		test.log(Status.FAIL, "<b><font face=\"Courier New\" color = \"red\">" + description + "</font></b>");
//	}
//
//	public static void logSkip(String description) {
//		// TODO Auto-generated method stub
//		test.log(Status.SKIP, "<b><font face=\"Courier New\" color = \"yellow\">" + description + "</font></b>");
//
//	}
//
//	public static void addScreenShot() throws Exception {
//		// TODO Auto-generated method stub
//		//test.addScreenCaptureFromPath(TestUtils.takeScreenshot("As"));
//	}
//
//	public static void logInfo(String description) {
//		// TODO Auto-generated method stub
//		test.log(Status.INFO, "<b><font face=\"Courier New\" color = \"black\">" + description + "</font></b>");
//
//	}
//
//	public static void logPass(String description) {
//		// TODO Auto-generated method stub
//		test.log(Status.PASS, "<b><font face=\"Courier New\" color = \"green\">" + description + "</font></b>");
//
//	}
//
//	public static void logAssert(Boolean status, String description) throws Exception {
//		// TODO Auto-generated method stub
//		if (status) {
//			test.log(Status.PASS, "<b><font face=\"Courier New\" color = \"green\">" + description + "</font></b>");
//		} else {
//			test.log(Status.FAIL, "<b><font face=\"Courier New\" color = \"red\">" + description + "</font></b>");
////			addScreenShot();
//		}
//		Assert.assertTrue(status, description);
//	}
//
//	public static void logAssertFalse(Boolean status, String description) throws Exception {
//		// TODO Auto-generated method stub
//		if (status) {
//			test.log(Status.FAIL, "<b><font face=\"Courier New\" color = \"red\">" + description + "</font></b>");
////			addScreenShot();
//		} else {
//			test.log(Status.PASS, "<b><font face=\"Courier New\" color = \"green\">" + description + "</font></b>");
//		}
//		Assert.assertFalse(status, description);
//	}
//
//	public static void logAssert(Boolean status) throws Exception {
//		// TODO Auto-generated method stub
//		if (status) {
//			test.log(Status.PASS, "<b><font face=\"Courier New\" color = \"green\">" + "Test Passed" + "</font></b>");
//		} else {
//			test.log(Status.FAIL, "<b><font face=\"Courier New\" color = \"red\">" + "Test Failed" + "</font></b>");
//		}
//		Assert.assertTrue(status);
//	}
//
//	public static void logSoftAssert(Boolean status, String description) throws Exception {
//		// TODO Auto-generated method stub
//		if (status) {
//			test.log(Status.PASS, "<b><font face=\"Courier New\" color = \"green\">" + description + "</font></b>");
//		} else {
//			test.log(Status.FAIL, "<b><font face=\"Courier New\" color = \"red\">" + description + "</font></b>");
////			addScreenShot();
//		}
//	}
//
//	public static void logAssertFailMobile(String imagePath, String msg) throws Exception {
//		test.log(Status.FAIL, "<b><font face=\"Courier New\" color = \"red\">" + msg + "</font></b>");
//		test.addScreenCaptureFromPath(imagePath);
//		Assert.assertTrue(false);
//	}
//	public synchronized static void closeChildTest(String testName) {
//
//		if (!testName.isEmpty()) {
//			ExtentTest test = getChildTest();
//			test.getExtent().flush();
//		}
//	}
//
//	public synchronized static void closeTest(String testName) {
//
//		if (!testName.isEmpty()) {
//			ExtentTest test = getTest();
//			test.getExtent().flush();
//		}
//	}
//
//	public synchronized static void closeReport() {
//		if (extent != null) {
//			extent.flush();
//		}
//	}
//}