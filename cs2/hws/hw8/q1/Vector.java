class Vector
{
	private int length, size;
	Object[] items;

	public Vector()
	{
		size = 2;
		items = new Object[size];
	}
	//
	private void Grow()
	{
		size *= 2;
		Object[] nItems = new Object[size];
		for(int i = 0; i < length; i++)
			nItems[i] = items[i];
		items = nItems;
	}

	public void Insert(int idx, Object itm)
	{
		//check valid idx
		if(idx < 0 || idx > length)
		{
			throw new IllegalArgumentException("invalid index");
		}
		//grow if necessary
		if(length == size)
			Grow();
		//shift elements to the rights
		for(int i = length - 1; i >= idx; i --)
			items[i + 1] = items[i];

		items[idx] = itm;
		length ++;
	}
	public void Add(Object o)
	{
		Insert(length, o);
	}
	//avg O(n), O(1) when removing from end
	public void Remove(int idx)
	{
		if(idx < 0 || idx >= length)
		{
			throw new IllegalArgumentException("invalid index");
		}

		for(int i = idx + 1; i < length; i++)
			items[i] = items[i + 1];
		length--;
	}
	public int GetLength()	{return length;}
	public Object Get(int idx)
	{
		return !(idx < 0 || idx >= items.length) ? items[idx] : null;
	}
	public void Print()
	{
		for(Object o: items)
			System.out.println(o);
	}
	public void Swap(int idx1, int idx2)
	{
		Object tmp = items[idx1];
		items[idx1] = items[idx2];
		items[idx2] = tmp;
	}
}
