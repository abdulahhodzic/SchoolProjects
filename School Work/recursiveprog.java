import java.util.*;

public class recursiveprog {
	//input constraint : n must be a positive number and cannot be zero
	public static int recSum(int n)
	{
		if(n==1)
			return 1;
		else
			return n+recSum(n-1);
	}
	//input constraint : n must be a positive number and cannot be zero
	public static int recPower(int n)
	{
		if (n==1)
			return 2;
		else
			return 2*recPower(n-1);
	}
	//input constraint : n must be a positive number and cannot be zero
	public static int recTimesFive(int n)
	{
		if (n==1)
			return 5;
		else 
			return 5 + recTimesFive(n-1);
	}
		public static void main(String[] args)
		{
			int value = 0;
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Enter a value to be computed");
			value = keyboard.nextInt();
			System.out.println("Recursive sum " + recSum(value) + "\n" + "Power " + recPower(value) + "\n"
					+ "timefive " + recTimesFive(value) + "\n");
		}
}
