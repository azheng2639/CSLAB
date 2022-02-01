import java.util.Scanner;
class q1
{

	public static void main (String args[])
	{
		System.out.println("Enter an Integer");
		System.out.println(Factorial(new Scanner(System.in).nextInt()));
	}

	private static int Factorial(int n)
	{

		//recursive

		if(n == 1)
			return n;
		return n * Factorial(n - 1);

		//iterative

		/*
		int out = 1;
		for(int i = 1; i <= n; i++)
			out *= i;
		return out;
		*/
	}
}
