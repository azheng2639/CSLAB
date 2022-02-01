class Heap
{
	Vector vector;


	private int Parent(int idx)	{return ((idx - 1) / 2);}

	private int Left(int idx)	{return idx * 2 + 1;}

	private int Right(int idx)	{return idx * 2 + 2;}

	public Heap()
	{
		vector = new Vector();
	}

	public int GetLength()	{return vector.GetLength();}

	public Comparable Get(int idx)	{return (Comparable)vector.Get(idx);}

	private void Sink(int index)
	{
		//get the left and right indexes
		int left = Left(index);
		int right = Right(index);

		//assume max val is current node
		int max = index;

		//update max to left child if necessary
		if(left < GetLength() && Get(left).compareTo(Get(max)) > 0)
			max = left;

		//update max to right child if necessary
		if(right < GetLength() && Get(right).compareTo(Get(max)) > 0)
			max = right;

		//check if max is not current elements
		if(max != index)
		{
			//swap current with max, and continue sinking
			vector.Swap(index,max);
			Sink(max);
		}
	}

	private static void Float(int index)
	{
		//check if index is root
		if(index == 0)
			return;

		//check if current item is greater than parent
		int parent = Parent(index);
		if(Get(index).compareTo(Get(parent)) > 0)
		{
			vector.Swap(index, parent);
			Float(parent);
		}
	}

	public void Insert(Comparable item)
	{
		//append to the end
		vector.Add(item);
		Float(GetLength() - 1);
	}

	public Comparable ExtractMax()
	{
		//check for empty array
		if(GetLength() == 0)
			throw new RuntimeException("Heap is empty");
		Comparable root = Get(0);
		vector.Swap(0 , GetLength() - 1);
		vector.Remove(GetLength() - 1);
		Sink(0);
		return root;
	}
}
