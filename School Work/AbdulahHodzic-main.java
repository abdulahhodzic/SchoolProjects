//Abdulah Hodzic 10/04/16
import java.util.*;
public class AbdulahHodzic-main {
    
// indicates if a number is prime
	public static boolean isPrime(int prime)
	{
		for(int i = 1; i < Math.sqrt(prime);i++)
		{
			if(prime%i == 0)
			{
				System.out.println(prime + " is Not Prime");
				return false;
			}
		}
		System.out.println(prime+ " is a Prime Number");
		return true;
	}
    
		//factors int f and outputs the factors 
	public static int factor(int f)
	{
		System.out.println("Factors: \n");
        for(int j=1; j<=f; j++){
            if(f%j==0){
                System.out.println(j);
            }
        }
        
	return f;
        	}
    
	// main function takes in input and passes this input to functions isprime and factor 
	public static void main(String[] args) {
		int e;
		System.out.println("Enter a number to factor:");
		Scanner keyboard = new Scanner(System.in);
		e = keyboard.nextInt();
		isPrime(e);
		factor(e);
}
}
