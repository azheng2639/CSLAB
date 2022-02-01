class HashTable
{
	// Class fields
	Node nodes[];
	int size;
	int length;

	// Constants
	static final double max_load_factor = 0.7;
	static final int initial_size = 5;

	public HashTable()
	{
		size = initial_size;
		nodes = new Node[size];
	}

	// Return the data associated with the given key, or null if the key
	// is not present in the hash table.
	public Object Search(Comparable key)
	{
		// Obtain index for the key
		int index = key.hashCode() % size;

		// Traverse collision list
		for (Node node = nodes[index]; node != null; node = node.next)
			if (node.key.equals(key))
				return node.data;

		// Not found
		return null;
	}


	// Insert a pair key-data into the hash table.
	public void Insert(Comparable key, Object data)
	{
		// Check if the table must grow
		double load_factor = (double) length / size;
		if (load_factor > max_load_factor)
			Grow();
		
		// Create node
		Node node = new Node(key, data);

		// Get index for the key
		int index = key.hashCode() % size;

		// Insert it
		node.next = nodes[index];
		nodes[index] = node;

		// Update length
		length++;
	}

	// Grow the hash table. All nodes must be repositioned according to
	// their new hash indices based on the new table size.
	void Grow()
	{
		// Message
		System.out.println("Growing hash table");

		// Save old nodes and table size
		int old_size = size;
		Node old_nodes[] = nodes;

		// Create new table
		size = size * 2;
		length = 0;
		nodes = new Node[size];

		// Traverse old nodes
		for (int i = 0; i < old_size; i++)
			for (Node node = old_nodes[i]; node != null; node = node.next)
				Insert(node.key, node.data);
	}


	// Remove the element with the given key from the hash table. If the
	// given key is not present, an exception is thrown.
	public void Remove(Comparable key)
	{
		// Get index for the key
		int index = key.hashCode() % size;

		// Traverse collision list
		Node previous = null;
		Node node = nodes[index];
		while (node != null && !node.key.equals(key))
		{
			previous = node;
			node = node.next;
		}

		// Not found
		if (node == null)
			throw new RuntimeException("Key not found");

		// Delete it
		if (previous == null)
			nodes[index] = node.next;
		else
			previous.next = node.next;
		// Update length
		length--;
	}

	// Print associated data for all nodes
	public void Print()
	{
		// Traverse table
		for (int i = 0; i < size; i++)
			for (Node node = nodes[i]; node != null; node = node.next)
				System.out.println(node.data);
	}

	private Node GetSuccessorNode(Comparable key)
	{
		/*
		Node successor = null;
		int min = 0;
		int index = Math.floorMod(key.hashCode(), size);
		for(Node tnode: nodes)
		{
			if(tnode == null)
				continue;
			System.out.println(key.compareTo(tnode.key));
			if(key.compareTo(tnode.key) > min)
			{
				min = key.compareTo(tnode.key);
				successor = tnode;
			}
		}
		return successor;
		*/
		int min = -100;
		Node successor = null;
		for(int i = 0; i < size; i ++)
			for(Node node = nodes[i]; node != null; node = node.next)
			{
				int comp = key.compareTo(node.key);
				if(comp == 0)
					continue;
				if((comp < 0) && (comp > min))
				{
					min = comp;
					successor = node;
				}
			}
		if(min == 0)
			return null;
		return successor;
	}

	private Node SearchNode(Comparable key)
	{
		int index = key.hashCode() % size;
		for(Node node = nodes[index]; node != null; node = node.next)
			if(key.compareTo(node.key) == 0)
				return node;
		return null;
	}

	public Object GetSuccessor(Comparable key)
	{
		Node node = SearchNode(key);
		if(node == null)
			return null;
		node = GetSuccessorNode(key);
		return node == null ? null : node.data;
	}

	public int GetLength()
	{
		return length;
	}
}

