import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Create_Write_Read_File
{
    static String fileName;
    final String inPath = "C:\\robocode\\CDOrganizer_2\\src\\";
    static ArrayList<String> testArr = new ArrayList<>();
    // boolean exists = false;

    public static void main(String[] args) throws IOException
    {
        System.out.println("Starting...");

        System.out.println("Input the name of the file to save: ");
        Scanner name = new Scanner(System.in);
        fileName = name.nextLine();

        if(!Files.exists(Path.of(fileName)))
        {
            for(int i = 0; i < 3; i++)
            {
                testArr.add("Test num " + i+1);
                writeFile(testArr.get(i), fileName);
            }
        }
        else
        {
            System.out.println("File already exists.");
        }

    }

    public static void writeFile(String toWrite, String fileName) throws IOException
    {
        FileWriter myWriter = new FileWriter(fileName,true);
        myWriter.write(toWrite + '\n');
        myWriter.close();
    }

    public static void readFile(String name)
    {

    }
}
