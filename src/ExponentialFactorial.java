import java.util.Scanner;

public class ExponentialFactorial
{
    
    public static void main( String[] args )
    {
        System.out.println( "Input the base power: " );
        Scanner in = new Scanner( System.in );
        int n = in.nextInt();
        
        System.out.println( "Iterations: " );
        Scanner it = new Scanner( System.in );
        int times = it.nextInt();
        
        System.out.println( Math.pow( n, Factorial( times ) ) );
        
    }
    
    public static long Factorial( int iterations )
    {
        long fin = 1;
        
        for ( int i = 1; i < iterations + 1; i++ )
        {
            fin *= i;
            System.out.println( fin );
        }
        
        return fin;
    }
    
}
