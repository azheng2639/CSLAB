class DoublyLinkedList
{
	private Node head, tail, current;
	public void Head()		{current = head;}
	public void Tail()		{current = tail;}
	public void Previous() 	{current = current.previous;}
	public void Next()
	{
		current = current.next;
	}
	public void Insert(Object data)
	{
		Node node = new Node(data);
		if(current == null)
			node.previous = tail;
		else
			node.previous = current.previous;
		node.next = current;
		if(current == head)
			head = node;
		else if(current == null)
			tail.next = node;
		else
			current.previous.next = node;
		if(current == node.previous)
			tail = node;
		else if(current != null)
			current.previous = node;
		current = node;
	}
	public Object Get()
	{
		return current == null ? null : current.GetData();
	}

	public void Print()
	{
		//for(Head(); current != null; Next())
		for(current = head; current != null; current = current.next)
			System.out.println(Get());
	}
}
