import java.io.*;
import java.util.Scanner;

public class SwitchTesting
{
    private static String artist;
    private static String title;
    private static int year;
    private static int genre;
    
    private static int ch;
    
    public static void main( String[] args ) throws IOException
    {
        while ( ch != 4 )   // Keep repeating the main while user doesn't input the exit code
        {
            
            System.out.println( "CD Organizer -- Enter your choice" );
            OutputFile( "/home/orion/IdeaProjects/BoredIdeas/src/Choices" );    // Output the available choices
            Scanner choice = new Scanner( System.in );
            int num = choice.nextInt();
            
            if(num > 4 || num < 1)
            {
                System.out.println("Please input a valid choice. ");
                System.out.println();
            }
            else
            {
                ch = num;   // Set the class variable to the user input
                switch ( num )
                {
                    case 1 -> C1(); // Enter a new CD
                    case 2 -> C2(); // View the list of CDs
                    case 3 -> C3(); // Search for a CDit
                    case 4 -> C4(); // Exit the program
                }
            }
            
        }
        
    }
    
    public static void OutputFile( String path ) throws FileNotFoundException
    {
        Scanner sc = new Scanner( new File( path ) );
        while ( sc.hasNextLine() )
        {
            System.out.println( sc.nextLine() ); // While there are still lines in the file, continue to output
        }
    }
    
    public static void WriteToFile( String path, String str ) throws IOException
    {
        BufferedWriter writer = new BufferedWriter( new FileWriter( path, true ) );
        writer.append( str ).append( "\n" );    // Add the user's string info and start a new line
        writer.close(); // Close the writer
    }
    
    public static void FindInFile( String str ) throws IOException
    {
        str = str.trim();
        BufferedReader br = null;
        
        try
        {
            br = new BufferedReader( new InputStreamReader( new FileInputStream( "/home/orion/IdeaProjects/BoredIdeas" +
                                                                                         "/src/Genres" ) ) );
            String line;
            while ( ( line = br.readLine() ) != null )
            {
                if ( line.contains( str ) )
                {
                    System.out.println( "Found!" );
                }
            }
        }
        finally
        {
            try
            {
                if ( br != null )
                    br.close();
            }
            catch ( Exception e )
            {
                System.err.println( "Exception while closing bufferedreader " + e.toString() );
            }
        }
        
    }
    
    public static void C1( ) throws IOException
    {
        System.out.print( "Enter the artist: " );
        Scanner art = new Scanner( System.in );
        artist = art.nextLine();
        
        System.out.print( "Enter the CD title: " );
        Scanner ttle = new Scanner( System.in );
        title = ttle.nextLine();
        
        System.out.print( "Enter the year of the CD: " );
        Scanner yr = new Scanner( System.in );
        year = yr.nextInt();
        
        OutputFile( "/home/orion/IdeaProjects/BoredIdeas/src/Genres" ); // Output the list of Genres
        
        System.out.print( "Enter the number of the genre: " );
        Scanner gnre = new Scanner( System.in );
        genre = gnre.nextInt();
        
        // Write the data in the format ARTIST TITLE GENRE YEAR
        WriteToFile( "/home/orion/IdeaProjects/BoredIdeas/src/CDList",
                artist.toUpperCase() + " " + title.toUpperCase() + " " + genre + " " + year );
        
    }
    
    public static void C2( ) throws FileNotFoundException
    {
        OutputFile( "/home/orion/IdeaProjects/BoredIdeas/src/CDList" ); // Output the current list of CDs
        System.out.println();   // Put an empty space after the output
    }
    
    public static void C3( ) throws IOException
    {
        System.out.println( "Search by (1) Artist or (2) Genre?" );
        Scanner choice = new Scanner( System.in );
        int ch = choice.nextInt();
        
        if ( ch == 1 )
        {
            srchA();    // Search by the Artist
        }
        else if ( ch == 2 )
        {
            srchG();    // Search by the Genre
        }
        else
        {
            System.out.println( "Please input a valid choice. " );
            C3();   // Rerun the selection prompt until the user inputs a valid choice
        }
        
    }
    
    public static void srchA( ) throws IOException
    {
        System.out.print( "Enter Artist (all or partial name): " );
        Scanner art = new Scanner( System.in );
        String choice = art.nextLine();
        
        FindInFile( choice );
    }
    
    public static void srchG( ) throws IOException
    {
        System.out.print( "Enter Genre number for which to search: " );
        Scanner gnre = new Scanner( System.in );
        String choice = gnre.nextLine();
        
        FindInFile( choice );
    }
    
    
    public static void C4( )
    {
        System.exit( 0 );   // Exit the program
    }
    
    private static class CDLink
    {
        private String artist = SwitchTesting.artist;
        private String title = SwitchTesting.title;
        private int genre = SwitchTesting.genre;
        private int year = SwitchTesting.year;
        private CDLink n;
    }
    
}
