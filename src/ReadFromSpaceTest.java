import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ReadFromSpaceTest
{
    public static ArrayList<String> sortedArr = new ArrayList<>();  // Initialize arr to hold the sorted artists
    
    public static void main( String[] args ) throws FileNotFoundException
    {
        OutputFile( "/home/orion/IdeaProjects/BoredIdeas/src/CDList" );
        AddToList();
        System.out.println( sortedArr );
        FindArtist();
    }
    
    public static void OutputFile( String path ) throws FileNotFoundException
    {
        Scanner sc = new Scanner( new File( path ) );
        while ( sc.hasNextLine() )
        {
            System.out.println( sc.nextLine() ); // While there are still lines in the file, continue to output
        }
    }
    
    public static void AddToList() throws FileNotFoundException
    {
        
        ArrayList<String> Artists = new ArrayList<>();
        Scanner sc = new Scanner( new File( "/home/orion/IdeaProjects/BoredIdeas/src/CDList" ) );
        while ( sc.hasNextLine() )
        {
            Artists.add( sc.next() );   // Add the next line to the Artists list
            sc.nextLine();  // Move to the next line in the file
        }
        Artists.remove( 0 );    // Remove the first index (outputs "Artist") -> only need this part for the CDList file
        AlphaSort( Artists );   // Call the sorting method to sort Artists alphabetically
        
    }
    
    public static void AlphaSort( ArrayList<String> alist )
    {
        String[] artists = new String[ alist.size() ];  // Convert the elements in alist to a normal array
        for ( int i = 0; i < alist.size(); i++ )
        {
            artists[ i ] = alist.get( i );
        }
        
        Arrays.sort( artists ); // Alphabetically sort the artists
        
        sortedArr.addAll( Arrays.asList( artists ) );   // Add each element of artists to the sortedArr arraylist
    }
    
    public static void FindArtist()
    {
        int found = 0;  // Keep track of how many matching strings have been found
        System.out.print( "Enter Artist (all or partial name): " );
        Scanner str = new Scanner( System.in );
        String searchStr = str.nextLine().toUpperCase();
        
        for ( String s : sortedArr )    // Search each element in sortedArr to see if the substring is in the artists
        // list
        {
            if ( s.contains( searchStr ) )
            {
                System.out.println( s );    // Output the matching strings
                found++;    // Increment the number of matches
            }
        }
        
        System.out.println();   // Add a blank line
        
        if ( found < 2 )    // If there are more than 1 matching cases
        {
            switch ( found )
            {
                case 0 -> System.out.println( "0 records found." );
                case 1 -> System.out.println( "1 record found." );
            }
        }
        else
        {
            System.out.println( found + " records found." );    // Output the number of strings that matched
        }
    }
    
    
}
