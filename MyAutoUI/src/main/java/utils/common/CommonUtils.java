package utils.common;

import base.BaseTest;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import javax.mail.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class CommonUtils extends BaseTest {
    public static String generateRandomNumber() {
        Date date = new Date();
        return String.valueOf(Math.abs(date.hashCode()));
    }

    public static boolean isValidURL(String expectedUrl) {
        try {
            new URL(expectedUrl).toURI();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void takeScreenshot(String testMethodName) throws Exception {

        File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        Date d = new Date();
       // String TimeStamp = d.toString().replace(":", "_").replace(" ", "_");
        String destination = "target/spark/Screenshots/" + testMethodName + ".png";
        FileUtils.copyFile(srcFile, new File(destination));
    }

    public static void verifyLinks(String linkUrl) {
        try {
            URL url = new URL(linkUrl);

            //Now we will be creating url connection and getting the response code
            HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
            httpURLConnect.setConnectTimeout(5000);
            httpURLConnect.connect();
            if (httpURLConnect.getResponseCode() >= 400) {
                System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + "is a broken link");
            }

            //Fetching and Printing the response code obtained
            else {
                System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
            }
        } catch (Exception e) {
        }
    }

    public static void writeDataToFile(String filePath, Map<String,String> dataMap) throws IOException {
        File file = new File(filePath);
        FileWriter fileWriter = new FileWriter(file);
//        Map<String,String> map = new HashMap<>();
//        map.put("Name","Lokesh");
//        map.put("Amount","2234.004");
//        map.put("ItemName","LSODFKSFD");
        fileWriter.write(String.valueOf(new JSONObject(dataMap)));
        fileWriter.flush();
        fileWriter.close();
    }

    public static void readDataFromFile(String filePath) {
        try {
            File reader  = new File("MyAutoUI/src/main/resources/testData.txt");
            Scanner scanner  = new Scanner(reader);
            while (scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

//            while (reader.read()!=-1){
//                System.out.println((char)reader.read());
//            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public static void main(String[] args) throws InterruptedException, MessagingException {
//        try {
//            writeDataToFile("MyAutoUI/src/main/resources/testData.txt","My Name is Pooja");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        readDataFromFile("");

    }
}
