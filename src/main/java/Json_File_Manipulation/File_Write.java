package Json_File_Manipulation;

import java.io.FileWriter;
import java.io.IOException;

public class File_Write {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("./src/main/resources/test.txt", true);
        fileWriter.write("Hello earth");
        fileWriter.write("\n");
        fileWriter.close();
    }
}
