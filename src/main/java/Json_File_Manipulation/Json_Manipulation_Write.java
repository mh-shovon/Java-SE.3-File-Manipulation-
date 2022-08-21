package Json_File_Manipulation;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Json_Manipulation_Write {
    public static void main(String[] args) throws IOException, ParseException {
        //jsonWrite();
        jsonRead();
    }

    private static void jsonWrite() throws IOException {
        JSONObject EmployeeObj = new JSONObject();
        EmployeeObj.put("name", "Mr. Shajib");
        EmployeeObj.put("Department", "IT");
        EmployeeObj.put("Designation", "Software Engineer");
        JSONObject addressObj = new JSONObject();
        addressObj.put("Present_Address", "Badda,Gulshan-1");
        addressObj.put("PO", "Gulshan");
        addressObj.put("Area", "Gulshan-1");
        EmployeeObj.put("address", addressObj);
        EmployeeObj.put("Phone_Number", "01789000522");
        FileWriter fileWriter = new FileWriter("./src/main/resources/Employee.json");
        fileWriter.write(EmployeeObj.toJSONString());
        fileWriter.flush();
        System.out.println(EmployeeObj);
    }

    private static void jsonRead() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader("./src/main/resources/Employee.json"));
        JSONObject EmployeeObj = (JSONObject) obj;
        System.out.println(EmployeeObj);
    }
}
