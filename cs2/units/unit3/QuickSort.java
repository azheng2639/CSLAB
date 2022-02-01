/*
Quick sort is a divide and conq sorting alg with the following stages
1) Divide - a) pick an element in the array called the "pivot"
	    b) find a final positon for the pivot p such that arr[i] < p for all values of i < p && v [i]
	    >= pivot for i > p
2) Run -  QuickSort on subarrays on the left and right array of the pivot
3) Combine - no action required array is sorted


quicksort reduces the memory footprint of mergesort by sorting in place
*/
class QuickSort
{
	public static void Swap(int[] arr, int idx1, int idx2)
	{
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

	static int Partition(int[] arr, int left, int right)
	{
		//initialize target pivot position
		int p = left;
		//pivot value
		int pivot = arr[right];
		//traverse array
		for(int now = left; now < right; now ++)
		{
			if(arr[now] < pivot)
			{
				Swap(arr, p, now);
				p++;
			}
		}
		//place pivot in target position
		Swap(arr, right, p);
		//return final pivot position
		return p;
	}

	static void Sort(int arr[], int left, int right)
	{
		if(left >= right)
			return;
		//Partition
		int p = Partition(arr,left,right);
		Sort(arr,left,p - 1);
		Sort(arr,p + 1, right);
	}
	static void Sort(int[] arr)
	{
		Sort(arr, 0, arr.length -1);
	}
	static void Print(int[] arr)
	{
		for(int i: arr)
			System.out.println(i);
	}
	public static void main(String[] args)
	{
		int[] arr = {4,3,6,2,5,6,4,2,1,5,7,6,9};
		Sort(arr);
		Print(arr);
	}
}

