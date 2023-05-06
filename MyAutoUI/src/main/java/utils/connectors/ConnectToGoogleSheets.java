package utils.connectors;

import common.ConstantLiterals;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.util.*;

public class ConnectToGoogleSheets {
    private static final String APPLICATION_NAME = "Google Sheets API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES =
            Collections.singletonList(SheetsScopes.SPREADSHEETS_READONLY);
    private static final String CREDENTIALS_FILE_PATH = "./src/main/resources/credentials.json";

    private static final java.io.File DATA_STORE_DIR = new java.io.File(System.getProperty("user.home"), CREDENTIALS_FILE_PATH);

    private static HttpTransport HTTP_TRANSPORT;
    private static ValueRange response;
    private static Sheets service;

    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            new FileDataStoreFactory(DATA_STORE_DIR);
        }
        catch (Throwable t) {
            System.exit(1);
        }
    }

    private final static Logger log = LogManager.getLogger(ConnectToGoogleSheets.class.getName());

    /**
     * Creates an authorized Credential object.
     *
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private static Credential getCredentials()
            throws IOException {
        // Load client secrets.
        InputStream in = Files.newInputStream(Paths.get(CREDENTIALS_FILE_PATH));
        GoogleClientSecrets clientSecrets =
                GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    private static Sheets getSheetsService() throws IOException {
        Credential credential;
        credential = getCredentials();
        return new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    /**
     * Build and return values of the cells defined in the range.
     */
    public static void initGoogleWorkBook() throws IOException {
        service = getSheetsService();
        if(service != null) {
            log.info("Google workbook initialized");
        }
    }

    public static ValueRange initGoogleSheet(String spreadsheetId, String range, String majorDimensions) throws IOException {
        return response = service.spreadsheets()
                .values()
                .get(spreadsheetId, range)
                //.setMajorDimension(majorDimensions)
                .execute();
    }

    public static List<List<Object>> getDataFromGoogleSheet(String googleSheet, String forProcess) throws IOException {
        ConnectToGoogleSheets.initGoogleWorkBook();
        String range = forProcess;
        System.out.println(range);
        ValueRange res = ConnectToGoogleSheets.initGoogleSheet(googleSheet, range,ConstantLiterals.MajorDimension_Row);
        List<List<Object>> listOfList = ConnectToGoogleSheets.getRows(res);
        return listOfList;
    }

    public static void main(String... args) throws IOException, GeneralSecurityException {
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final String spreadsheetId = "1ypCJEtomPFyfyomeB8WI2yODgxDU67ne79teRELI13A";
        final String range = "PracticeSheet!A2:B";
        Sheets service =
                new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials())
                        .setApplicationName(APPLICATION_NAME)
                        .build();
        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, range).setMajorDimension("ROWS")
                .execute();
        List<List<Object>> values = response.getValues();
        if (values == null || values.isEmpty()) {
            System.out.println("No data found.");
        } else {
            System.out.println("Name, Age");
            for (List row : values) {
                // Print columns A and E, which correspond to indices 0 and 4.
                System.out.printf("%s, %s\n", row.get(0), row.get(1));
            }
        }
    }
    public List<List<Object>> getDataFromSheet(String spreadSheet, String range) {
        Sheets sheets;
        try {
            sheets = getSheetsService();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        ValueRange valueRange;
        try {
            valueRange = sheets.spreadsheets().values()
                    .get(spreadSheet, range)
                    .execute();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return valueRange.getValues();
    }

    public Boolean putDataIntoSheet(String spreadSheet, String range, List<List<Object>> body) {
        Sheets sheets;
        try {
            sheets = getSheetsService();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        ValueRange requestBody = new ValueRange().setValues(body);
        UpdateValuesResponse updateValuesResponse;
        try {
            updateValuesResponse = sheets.spreadsheets().values()
                    .update(spreadSheet, range, requestBody)
                    .setValueInputOption("USER_ENTERED")
                    .execute();
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
        return Boolean.TRUE.equals(updateValuesResponse.getUpdatedRows().equals(body.size()));
    }

    public Boolean appendDataIntoSheet(String spreadSheet, String range, List<List<Object>> body) {
        Sheets sheets;
        try {
            sheets = getSheetsService();
        } catch (IOException  e) {
            e.printStackTrace();
            return null;
        }
        ValueRange requestBody = new ValueRange().setValues(body);
        AppendValuesResponse appendValuesResponse;
        try {
            appendValuesResponse = sheets.spreadsheets().values()
                    .append(spreadSheet, range, requestBody)
                    .setValueInputOption("USER_ENTERED")
                    .execute();
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
        return Boolean.TRUE.equals(appendValuesResponse.getUpdates().equals(body.size()));
    }

    public Boolean clearGSheetData(String spreadSheet, String range) {
        Sheets sheets;
        try {
            sheets = getSheetsService();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        ClearValuesResponse clearValuesResponse;
        try {
            clearValuesResponse = sheets.spreadsheets().values()
                    .clear(spreadSheet, range, new ClearValuesRequest())
                    .execute();
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }

        return Boolean.TRUE.equals(clearValuesResponse.getClearedRange().equals(range));
    }

    public Set<Object> getHeaders(String spreadSheet, String headerRange) {
        Sheets sheets;
        try {
            sheets = getSheetsService();
        } catch (IOException  e) {
            e.printStackTrace();
            return null;
        }
        ValueRange valueRange;
        try {
            valueRange = sheets.spreadsheets().values()
                    .get(spreadSheet, headerRange)
                    .execute();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return new LinkedHashSet<>(valueRange.getValues().get(0));
    }

    private static List<List<Object>> setValue(Object value) {
        return Arrays.asList(Arrays.asList(value));
    }

    public static List<List<Object>> getRows(ValueRange res) throws IOException {
        return res.getValues();
    }

    public static int getGoogleSheetSize() {
        int size = response.getValues().size();
        return size;
    }

    //TODO Delete this method, new methods are updateCellValues() and appendCellValues()
    public static void setCellValue(String spreadsheetId, String range, String value) throws IOException {

        ValueRange requestBody = new ValueRange();
        requestBody.setValues(setValue(value));
        Sheets.Spreadsheets.Values.Update request = service.spreadsheets().values().update(spreadsheetId, range, requestBody);
        request.setIncludeValuesInResponse(Boolean.TRUE);
        request.setValueInputOption("RAW");

        UpdateValuesResponse response = request.execute();
        log.info("setCellValue: "+response);
    }

    public static void clearCellValue(String spreadSheetId, String range, ClearValuesRequest requestBody) throws IOException {
        Sheets.Spreadsheets.Values.Clear request = service.spreadsheets().values().clear(spreadSheetId, range, requestBody);
        ClearValuesResponse response = request.execute();
        log.info("clearCellValue: "+response);
    }

    private static void updateCellValues(String spreadsheetId, String range, ValueRange requestBody) throws IOException {
        Sheets.Spreadsheets.Values.Update request = service.spreadsheets().values().update(spreadsheetId, range, requestBody);
        request.setIncludeValuesInResponse(Boolean.TRUE);
        request.setValueInputOption("RAW");

        UpdateValuesResponse response = request.execute();
        log.info("updateCellValues: "+response);
    }

    private static void appendCellValues(String spreadsheetId, String range, ValueRange requestBody) throws IOException {
        Sheets.Spreadsheets.Values.Append request = service.spreadsheets().values().append(spreadsheetId, range, requestBody);
        request.setValueInputOption("RAW");

        AppendValuesResponse response = request.execute();
        log.info("appendCellValues: "+response);
    }

    public static void batchUpdateDataValue(String spreadsheetId, List<ValueRange> data) throws IOException {
        BatchUpdateValuesRequest requestBody = new BatchUpdateValuesRequest();
        requestBody.setValueInputOption("RAW");
        requestBody.setData(data);
        Sheets.Spreadsheets.Values.BatchUpdate request = service.spreadsheets().values().batchUpdate(spreadsheetId, requestBody);

        BatchUpdateValuesResponse response = request.execute();
        log.info("Batch updated: "+response);
    }

    /**
     * Build and return values of the cells defined in the range.
     * @return a list of objects
     */
    public static List<List<Object>> getCellValues(String spreadsheetId, String range, String majorDimensions) throws IOException {
        Sheets service = getSheetsService();
        try {
            if(service != null) {
                ValueRange response = service.spreadsheets().values().get(spreadsheetId, range).setMajorDimension(majorDimensions).execute();
                List<List<Object>> listListObject = response.getValues();

                if (listListObject == null || listListObject.size() == 0) {
                    return null;
                }
                else {

                    log.info(response.toPrettyString());
                    return listListObject;
                }
            }
        }
        catch (IOException e) {
            log.info("getCellValues: "+e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public static Object getCellValue(int row, int column) throws NullPointerException{
        try {
            return response.getValues().get(row-1).get(column-1);
        }
        catch (IndexOutOfBoundsException e) {
            return "";
        }
    }

    public static void updateDataToSheet(String spreadSheetId, String range, List<Object> data, String majorDimension) {
        try {
            ValueRange requestBody = new ValueRange();
            requestBody.setValues(Arrays.asList(data));
            requestBody.setMajorDimension(majorDimension);
            requestBody.setRange(range);
            updateCellValues(spreadSheetId, range, requestBody);
        }
        catch (IOException e) {
            log.info("updateDataToSheet: "+e.getMessage());
            e.printStackTrace();
        }
    }

    public static void appendDataToSheet(String spreadSheetId, String range, List<Object> data, String majorDimension) {
        try {
            ValueRange requestBody = new ValueRange();
            requestBody.setValues(Arrays.asList(data));
            requestBody.setMajorDimension(majorDimension);
            requestBody.setRange(range);
            appendCellValues(spreadSheetId, range, requestBody);
        }
        catch (IOException e) {
            log.info("appendDataToSheet: "+e.getMessage());
            e.printStackTrace();
        }
    }

    public static void clearDataFromSheet(String spreadSheetId, String range) throws IOException {
        ClearValuesRequest requestBody = new ClearValuesRequest();
        Sheets.Spreadsheets.Values.Clear request = service.spreadsheets().values().clear(spreadSheetId, range, requestBody);
        ClearValuesResponse response = request.execute();
        log.info("clearDataFromSheet: "+response);
    }

    //TODO
    public static void updateData(String atRow, String spreadSheetId, String range, List<Object> data, String majorDimension) {
        try {
            ValueRange requestBody = new ValueRange();
            requestBody.setValues(Arrays.asList(data));
            requestBody.setMajorDimension(majorDimension);
            updateCellValues(spreadSheetId, range, requestBody);
        }
        catch (IOException e) {
            log.info("updateData: "+e.getMessage());
            e.printStackTrace();
        }
    }

    public static  Map<String, Character> toFromOfColumns(String range) {
        Map<String, Character> info	= new HashMap<>();
        info.put("to",  '\u0000');
        info.put("from", '\u0000');
        range						= range.substring(range.indexOf("!")+1);
        if(range.contains(":")) {
            String[] characters		= range.split(":");
            info.put("to", characters[0].replaceAll("\\d*", "").toCharArray()[0]);
            info.put("from", characters[1].replaceAll("\\d*", "").toCharArray()[0]);
        }
        else {
            info.put("to", range.replaceAll("\\d*", "").toCharArray()[0]);
            info.put("from", '\u0000');
        }
        return info;
    }

    public static String getSheetEnvColumn() {
        String row = null;

        switch (System.getProperty("Environment")) {
            case "newpreprod":
                row="B";
                break;

            case "preprod":
                row="B";
                break;

            case "development":
            case "lenskartsg":
                row="D";
                break;

            case "scmQe":
                row="C";
                break;

            case "webQe":
                row="E";
                break;

            case "posQe":
                row="F";
                break;

            case "testing":
                row="G";
                break;

            case "nxtgen":
                row="H";
                break;

            default:
                System.out.println("Environment not found");
                break;
        }
        return row;
    }

    public static String getSheetEnvColumnForCompleteOrders() {
        String row = null;

        switch (System.getProperty("Environment")) {
            case "newpreprod":
                row="I";
                break;

            case "preprod":
                row="I";
                break;

            case "development":
            case "lenskartsg":
                row="K";
                break;

            case "scmQe":
                row="J";
                break;

            case "webQe":
                row="L";
                break;

            case "posQe":
                row="M";
                break;

            case "testing":
                row="N";
                break;

            case "nxtgen":
                row="O";
                break;

            default:
                System.out.println("Environment not found");
                break;
        }
        return row;
    }



}
