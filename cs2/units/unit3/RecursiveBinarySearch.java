class RecursiveBinarySearch
{
	private static int Search(int[] arr, int n, int left, int 
	right)
	{
		int mid = (right - left) / 2 + 1;
		if(arr[mid] == n)
			return mid;
		if(arr[mid] > n)
			return Search(arr, n, mid, right);
		else
			return Search(arr, n, left, mid);
	}
	private static int Search(int[] arr, int n)
	{
		return Search(arr, n, 0, arr.length - 1);
	}

	public static void main(String[] args)
	{
		int[] arr = {2, 4, 5, 6, 7, 8, 12, 21};
		System.out.println(Search(arr, 5));
	}
}

