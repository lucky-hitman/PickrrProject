package Utils.Connectors;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.*;

import java.io.*;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
    private static final String CREDENTIALS_FILE_PATH = "PickrrUI/src/main/resources/credentials.json";

    /**
     * Creates an authorized Credential object.
     *
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT)
            throws IOException {
        // Load client secrets.
        InputStream in = new FileInputStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
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


    private Sheets getSheetsService() throws IOException, GeneralSecurityException {
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        return
                new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                        .setApplicationName(APPLICATION_NAME)
                        .build();
    }

    public List<List<Object>> getDataFromSheet(String spreadSheet, String range) {
        Sheets sheets;
        try {
            sheets = getSheetsService();
        } catch (IOException | GeneralSecurityException e) {
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
        } catch (IOException | GeneralSecurityException e) {
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
        } catch (IOException | GeneralSecurityException e) {
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
        } catch (IOException | GeneralSecurityException e) {
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
        } catch (IOException | GeneralSecurityException e) {
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

    /**
     * Prints the names and majors of students in a sample spreadsheet:
     * https://docs.google.com/spreadsheets/d/1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms/edit
     */
    public static void main(String... args) throws IOException, GeneralSecurityException {
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final String spreadsheetId = "1ypCJEtomPFyfyomeB8WI2yODgxDU67ne79teRELI13A";
        final String range = "PracticeSheet!A2:C";
        Sheets service =
                new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                        .setApplicationName(APPLICATION_NAME)
                        .build();
        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();
        List<List<Object>> values = response.getValues();
        if (values == null || values.isEmpty()) {
            System.out.println("No data found.");
        } else {
            System.out.println("Name, Age, Roll No");
            for (List row : values) {
                // Print columns A and E, which correspond to indices 0 and 4.
                System.out.printf("%s, %s, %s\n", row.get(0), row.get(1),row.get(2));
            }
        }
    }


}
