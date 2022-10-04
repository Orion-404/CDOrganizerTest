import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Create_Write_Read_File
{
    static String fileName;
    static ArrayList<String> testArr = new ArrayList<>();
    static Scanner in;

    static String currFile;

    static String artist;
    static String album;
    static int genre;
    static int year;

    public static void main(String[] args) throws IOException
    {
        System.out.println("Starting...");

        readFile("Choices");

        System.out.print("Select a program: ");
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();

        switch ( input )
        {
            case 1 -> writeNewFile();
            case 2 -> saveFile();
            case 3 -> System.exit(0);
        }



    }

    public static void writeNewFile() throws IOException
    {
        File temp = new File("temp");

        StringBuilder str = new StringBuilder();

        System.out.print("Input artist: ");
        in = new Scanner(System.in);
        artist = in.nextLine();
        str.append(artist).append(" ");

        System.out.print("Input album: ");
        in = new Scanner(System.in);
        album = in.nextLine();
        str.append(album).append(" ");

        System.out.print("Input genre: ");
        genre = in.nextInt();
        str.append(genre).append(" ");

        System.out.print("Input year: ");
        year = in.nextInt();
        str.append(year);

        testArr.add(String.valueOf(str));
        System.out.println(testArr);

        writeFile(testArr.get(0), String.valueOf(temp));

    }

    public static void saveFile() throws IOException
    {
        System.out.println("Input the name of the file to save: ");
        Scanner name = new Scanner(System.in);
        fileName = name.nextLine();


        if(!Files.exists(Path.of(fileName)))
        {
            for(int i = 0; i < 3; i++)
            {
                testArr.add("Test num " + (i+1));
                writeFile(testArr.get(i), fileName);
            }
        }
        else
        {
            System.out.println("File already exists.");
        }

        clearFile(fileName);

    }

    public static void writeFile(String toWrite, String fileName) throws IOException
    {
        FileWriter myWriter = new FileWriter(fileName,true);
        myWriter.write(toWrite + '\n');
        myWriter.close();
    }

    public static void readFile(String name) throws FileNotFoundException
    {
        File myObj = new File(name);
        Scanner myReader = new Scanner(myObj);
        while ( myReader.hasNextLine() )
        {
            System.out.println(myReader.nextLine());
        }
        myReader.close();
    }

    public static void saveCheck()
    {

    }

    public static void clearFile(String fileName) throws IOException
    {
        Scanner myReader = new Scanner(fileName);
        FileWriter myWriter = new FileWriter(fileName);

        while ( myReader.hasNextLine() )
        {
            myWriter.write("");
            myReader.nextLine();
        }
        myWriter.close();
        myReader.close();
    }
}
