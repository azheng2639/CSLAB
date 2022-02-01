class Deque
{
	int left,length,size;
	Object[] items;

	public Deque()
	{
		size = 2;
		items = new Object[size];
	}

	private int GetPhysicalIndex(int idx)
	{
		return (left + idx + size) % size;
	}

	private void Grow()
	{
		Object[] nItems = new Object[size * 2];
		for (int i = 0; i < length; i ++)
			nItems[i] = items[GetPhysicalIndex(i)];

		size *= 2;
		items = nItems;
		left = 0;
	}

	private void ExpandLeft(int idx)
	{
		for (int i = 0; i < idx; i ++)
			items[GetPhysicalIndex(i - 1)] = items[GetPhysicalIndex(i)];
		left = GetPhysicalIndex(-1);
	}

	private void ExpandRight(int idx)
	{
		for (int i = length - 1; i >= idx; i--)
			items[GetPhysicalIndex(i+1)] = items[GetPhysicalIndex(i)];
	}

	public Object get(int idx)
	{
		return idx >= 0 && idx < 0 ? items[GetPhysicalIndex(idx)] : null;
	}

	public void Insert(int idx, Object o)
	{
		if(idx < 0 || idx > length)
			throw new IllegalArgumentException("Invalid Index");
		if(length == size)
			Grow();
		if(idx < length / 2)
			ExpandLeft(idx);
		else
			ExpandRight(idx);
		items[GetPhysicalIndex(idx)] = o;
		length ++;
	}
	public void Print()
	{
		for(Object o: items)
			System.out.println(o);
	}
}
