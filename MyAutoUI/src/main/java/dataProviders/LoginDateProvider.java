package dataProviders;

import common.ConstantLiterals;
import org.testng.annotations.DataProvider;

import java.util.List;

import static utils.connectors.ConnectToGoogleSheets.getDataFromGoogleSheet;

public class LoginDateProvider {


    @DataProvider(name = "user creds")
    public Object[][] getDifferentCourierCodes() throws Exception {
        List<List<Object>> listOfList;

            listOfList = getDataFromGoogleSheet(ConstantLiterals.Test_Data_WorkBook, ConstantLiterals.LoginTestData_WorkBook);
            for (List row : listOfList) {
                // Print columns A and E, which correspond to indices 0 and 4.
                System.out.printf("%s, %s\n", row.get(0), row.get(1));
            }
//            System.out.println("Hi");
//            System.out.println(listOfList.toArray().toString());
//            System.out.println(Arrays.deepToString(listOfList.stream().map(l -> l.stream().toArray(String[]::new)).toArray(String[][]::new)));
            return listOfList.stream().map(l -> l.stream().toArray(String[]::new)).toArray(String[][]::new);
    }
}
