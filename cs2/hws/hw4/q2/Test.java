import java.util.Scanner;
import java.util.Random;

class Test
{
	public static void main(String[] args)
	{
		String alg = args[0].toLowerCase();
		int size = Integer.parseInt(args[1]);
		int[] arr = new int[size];
		Random ran = new Random();
		for(int i = 0; i < arr.length; i ++)
			arr[i] = ran.nextInt(20);
		if(alg.equals("merge"))
			MergeSort.Sort(arr);
		else if(alg.equals("selection"))
			SelectionSort.Sort(arr);
		else
			System.out.println("Invalid Sorting Algorithm");
	}
}
