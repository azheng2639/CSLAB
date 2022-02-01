class Vector
{
	private int length, size;
	Object[] items;

	public Vector()
	{
		size = 2;
		items = new Object[size];
	}

	private void Resize(int new_size)
	{
		size = new_size;
		Object[] nItems = new Object[size];
		for(int i = 0; i < length; i++)
			nItems[i] = items[i];
		items = nItems;
		System.out.println("Resizing capacity to " + size + " elements");
	}

	public void Insert(int idx, Object itm)
	{
		//check valid idx
		if(idx < 0 || idx > length)
		{
			System.out.println("Invalid index");
			return;
		}
		//grow if necessary
		if(length == size)
			Resize(size * 2);
		//shift elements to the rights
		for(int i = length - 1; i >= idx; i --)
			items[i + 1] = items[i];

		items[idx] = itm;
		length ++;
		System.out.println("Inserted " + itm);
	}
	public void Add(Object o)
	{
		Insert(length, o);
	}
	//avg O(n), O(1) when removing from end
	public void Remove(int idx)
	{
		if(idx < 0 || idx > length - 1)
		{
			System.out.println("Invalid index");
			return;
		}
		System.out.println("Removing " + items[idx]);
		for(int i = idx + 1; i < length; i++)
			items[i - 1] = items[i];
		items[length - 1] = null;
		length--;

		if (length < size / 2 + 1)
			Resize(size / 2);
	}
	public int getLength()	{return length;}
	public Object get(int idx)
	{
		return (idx >= 0 || idx < length) ? items[idx] : null;
	}
	public void Print()
	{
		for(Object o: items)
			System.out.println(o);
	}
	public void swap(int idx1, int idx2)
	{
		Object tmp = items[idx1];
		items[idx1] = items[idx2];
		items[idx2] = tmp;
	}
}
