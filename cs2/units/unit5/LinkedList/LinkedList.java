class LinkedList
{
	Node head, current, previous;

	public Object get()
	{
		//return the data associated with the current element or null if current element is pass-the-end
		return current == null ? null: current.getData();
	}

	public void head()
	{
		current = head;
		previous = null;
	}

	public void next()
	{
		if(current != null)
		{
			current = current.next;
		}
	}
	public void insert(Object data)
	{
		Node node = new Node(data);
		node.next = current;
		//check if current node is the head;
		if(current == head)
			head = node;
		else
			previous.next = node;
		//update current
		current = node;
	}

	//delete the element at the current position
	//O(1)
	//the current element becomes the one after the removed element
	//or past-the-end or if the removed element was the last
	public void remove()
	{
		//past-the-end is an invalid position
		if(current == null)
			throw new RuntimeException("Invalid position to remove");

		if(current == head)
			head = current.next;
		else
			previous.next = current.next;
		current = current.next;
	}

	public void print()
	{
		for(head(); current != null; next())
			System.out.println(get());
	}
}
