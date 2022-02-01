import java.util.Scanner;

class Test
{
	static int getMinIdx(Shape[] arr, int left, int right)
	{
		int min = left;
		for(int i = left + 1; i <= right; i ++)
			if(arr[i].compareTo(arr[min]) == -1)
				min = i;

		return min;
	}

	static void Swap(Shape[] arr, int idx1, int idx2)
	{
		Shape tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
	}

	private static void Sort(Shape[] arr)
	{
		for(int i = 0; i < arr.length - 1; i ++)
		{
			int min = getMinIdx(arr, i, arr.length -1);
			Swap(arr, min, i);
		}
	}

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		//ask how many shapes
		System.out.println("How many shapes? ");
		//allocate memory
		Shape[] arr = new Shape[scan.nextInt()];
		scan.nextLine();
		//repeat n times
		for(int i = 0; i < arr.length; i ++)
		{
			//ask circle or rec
			System.out.println("Circle or Rectangle?");
			//read for circle, else rectangle
			if(scan.nextLine().toLowerCase().equals("circle"))
			{
				//circle properties
				System.out.println("Name?");
				String name = scan.nextLine();
				System.out.println("Radius?");
				double radius = scan.nextDouble();
				scan.nextLine();
				//instanciate the circle
				arr[i] = new Circle(name, radius);
			}
			else
			{
				//rectangle properties
				System.out.println("Name?");
				String name = scan.nextLine();
				System.out.println("Width?");
				double width = scan.nextDouble();
				scan.nextLine();
				System.out.println("Height?");
				double height = scan.nextDouble();
				scan.nextLine();
				//inistanciate the rectangle
				arr[i] = new Rectangle(name, width, height);
			}
		}
		//Sort array with selection sort
		Sort(arr);
		//enchanced for loop to call print from every ele in arr
		for(Shape s: arr)
			s.Print();
	}
}
