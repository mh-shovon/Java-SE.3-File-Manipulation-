package Json_File_Manipulation;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Json_Manipulation_Write {
    public static void main(String[] args) throws IOException, ParseException {
        //jsonWrite();
        //jsonRead();
        //writeJsonArrayList();
        //readJsonArrayList(2);
        //updateEmployeeJson("name", "Mehedi Hasan Shovon");
        //updateStudentJsonList(2, "name", "Akil Jawad");
        deleteJsonData(3);
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

        String name = (String) EmployeeObj.get("name");
        System.out.println(name);
        String department = (String) EmployeeObj.get("Department");
        System.out.println(department);
        String designation = (String) EmployeeObj.get("Designation");
        System.out.println(designation);

        JSONObject addressObj = (JSONObject) EmployeeObj.get("address");
        String area = (String) addressObj.get("Area");
        System.out.println(area);
        String po = (String) addressObj.get("PO");
        System.out.println(po);
        String present_address = (String) addressObj.get("Present_Address");
        System.out.println(present_address);

        String phone_number = (String) EmployeeObj.get("Phone_Number");
        System.out.println(phone_number);

    }

    private static void writeJsonArrayList() throws IOException, ParseException {
        char ch = 'y';
        String fileName = "./src/main/resources/Student.json";
        do {
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader(fileName));
            JSONObject studentObj = new JSONObject();

            Scanner input = new Scanner(System.in);
            System.out.println("Input student ID: ");
            studentObj.put("id", input.next());
            System.out.println("Input student name: ");
            studentObj.put("name", input.next());
            System.out.println("Input Department ");
            studentObj.put("department", input.next());

            JSONArray jsonArray = (JSONArray) obj;
            jsonArray.add(studentObj);
            System.out.print(jsonArray);
            FileWriter file = new FileWriter(fileName);
            file.write(jsonArray.toJSONString());
            file.flush();
            file.close();
            System.out.println("Saved!");
            System.out.print(jsonArray);
            System.out.println("\nDo you want to add more?[y/n]");
            ch = input.next().charAt(0);

        }
        while (ch != 'n');
    }

    private static void readJsonArrayList(int position) throws IOException, ParseException {
//        Scanner input = new Scanner(System.in);
//        System.out.println("Enter The Position: ");
//        int position = input.nextInt();
        String fileName = "./src/main/resources/Student.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;
        System.out.println(jsonArray);
        JSONObject jsonObject = (JSONObject) jsonArray.get(position);

        String id = (String) jsonObject.get("id");
        String name = (String) jsonObject.get("name");
        String department = (String) jsonObject.get("department");
        System.out.println(id);
        System.out.println(name);
        System.out.println(department);

    }

    private static void updateEmployeeJson(String key, String value) throws IOException, ParseException {
        String fileName = "./src/main/resources/Employee.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONObject EmployeeObj = (JSONObject) obj;
        System.out.println(EmployeeObj);
        EmployeeObj.put(key, value);
        FileWriter file = new FileWriter(fileName);
        file.write(EmployeeObj.toJSONString());
        file.flush();
        file.close();
        System.out.println("Updated!");
        System.out.print(EmployeeObj);
    }

    private static void updateStudentJsonList(int index, String key, String value) throws IOException, ParseException {
        String fileName = "./src/main/resources/Student.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;

        JSONObject jsonObject = (JSONObject) jsonArray.get(index);
        jsonObject.put(key, value);

        FileWriter file = new FileWriter(fileName);
        file.write(jsonArray.toJSONString());
        file.flush();
        file.close();
        System.out.println("Updated!");
        System.out.print(jsonArray);
    }

    private static void deleteJsonData(int index) throws IOException, ParseException {
        String fileName="./src/main/resources/Student.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;
        jsonArray.remove(index);
        FileWriter file = new FileWriter(fileName);
        file.write(jsonArray.toJSONString());
        file.flush();
        file.close();
        System.out.println("Deleted!");
        System.out.print(jsonArray);
    }
}
