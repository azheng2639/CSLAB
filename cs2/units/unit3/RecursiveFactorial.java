class RecursiveFactorial
{
	private static int Factorial(int n)
	{
		if(n <= 1)
			return n;
		return n * Factorial(n - 1);
	}

	public static void main(String[] args)
	{
		System.out.println(Factorial(6));
	}
}
