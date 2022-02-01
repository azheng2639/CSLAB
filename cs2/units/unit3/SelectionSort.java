//cost is O(n^2)
class SelectionSort
{
	static int getMinIdx(int[] arr, int left, int right)
	{
		int min = left;
		for(int i = left + 1; i <= right; i ++)
			if(arr[i] < arr[min])
				min = i;

		return min;
	}

	static void Swap(int[] arr, int idx1, int idx2)
	{
		int tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
	}

	static void Sort(int[] arr)
	{
		for(int i = 0; i < arr.length - 1; i ++)
		{
			int min = getMinIdx(arr, i, arr.length -1);
			Swap(arr, min, i);
		}
	}
	static void Print(int[] v)
	{
		for(int i = 0; i < v.length; i ++)
			System.out.println(v[i]);
	}

	public static void main (String[] args)
	{
		int[] arr = {3,4,2,65,2,7,12};
		Sort(arr);
		Print(arr);
	}
}
