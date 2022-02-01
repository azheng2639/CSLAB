class BinarySearch
{
	static int search(int arr[], int x)
	{
		int left = 0;
		int right = arr.length - 1;

		while( left <= right)
		{
			int n = right - left + 1;
			int mid = left + n/2;

			if(x == arr[mid])
				return mid;

			if(x < arr[mid])
				right = mid - 1;
			else
				left = mid + 1;
		}

		return -1;
	}
}
