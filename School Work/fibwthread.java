import java.util.*;
public class fibwthread extends Thread {
	private int n;
	public int fibCalculated;
	public fibwthread(int n)
	{
		this.n = n;
	}
	
	public void run()
	{
		if(n == 0)
			fibCalculated = 0;
		else if(n == 1 || n== 2)
			fibCalculated =1;
		else
		{
			try{
			fibwthread fib1 = new fibwthread(n-1);
			fibwthread fib2 = new fibwthread(n-2);
			fib1.start();
			fib2.start();
			fib1.join();
			fib2.join();
			fibCalculated = fib1.fibCalculated + fib2.fibCalculated;
			}catch(InterruptedException ex)
			{
				ex.printStackTrace();
			}
			
			
		}
		
	}

	public static void main(String args[]) {
		int enteredValue;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter a Fib index to compute: ");
		enteredValue  = keyboard.nextInt();
		fibwthread f = new fibwthread(enteredValue);
		try{
			f.start();
			f.join();
			System.out.println("The index you entered: " + enteredValue + " has a fibvalue of: "+ f.fibCalculated);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
