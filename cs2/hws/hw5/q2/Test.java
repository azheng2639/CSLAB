import java.util.Scanner;
class Test
{
	public static void main(String[] args)
	{
		int[] arr = {4,5,2,1,7,3};

		while(true)
		{
			Scanner scan = new Scanner(System.in);
			System.out.println("enter an index");
			int input = scan.nextInt();
			try
			{
				System.out.println(arr[input]);
			}
			catch (Exception ArrayIndexOutOfBoundsException)
			{
				System.out.println("that is an invalid index, enter another index");
			}
		}
	}
}
