//1. Divide the array into smaller arrays (changin indicies)
//2. Conquer call the functions recursively on the sub arrays
//3. Merge combine the arrays
class MergeSort
{

	private static void Merge(int[] arr, int left1, int right1, int left2, int right2)
	{
		//step 1
		int[] arr1 = new int[right1 - left1 + 1];
		int[] arr2 = new int[right2 - left2 + 1];

		for(int i = 0; i < right1 - left1 + 1; i ++)
			arr1[i] = arr[left1 + i];
		for(int i = 0; i < right2 - left2 + 1; i ++)
			arr2[i] = arr[left2 + i];
		int index1 = 0;
		int index2 = 0;
		int index = left1;

		//merge
		while(true)
		{
			//check for empty sub-arrays
			boolean empty1 = index1 == (right1 - left1 + 1);
			boolean empty2 = index2 == (right2 - left2 + 1);

			if(empty1 && empty2)
				break;

			/*
			condition to grab an element from the first sub-array
			a) second sub-array is empty or
			b) the first sub-array is not empty and its current element is less than the current
			element in the second sub-array
			*/
			if(empty2 || (!empty1 && arr1[index1] < arr2[index2]))
			{
				arr[index] = arr1[index1];
				index1 ++;
			}
			else
			{
				arr[index] = arr2[index2];
				index2++;
			}
			index++;
		}
	}
	public static void Sort(int arr[], int left, int right)
	{
		if(left >= right)
			return;
		int mid = (left + right)/2;
		Sort(arr, left, mid);
		Sort(arr, mid + 1, right);
		Merge(arr, left, mid, mid + 1, right);
	}

	public static void Sort(int[] arr)
	{
		Sort(arr, 0, arr.length - 1);
	}
	public static void Print(int[] arr)
	{
		for(int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
	}
	public static void main(String[] args)
	{
		int[] arr = {4,2,6,8,4,1,6,4};
		Sort(arr);
		Print(arr);
	}
}
