class BinarySearchTree
{
	Node root;
	/*
		Given a key return the node containing it or null if the key
		is not present in the tree. Nodes are not exposed to the user
		this is a priavte auxilary function
	*/
	private Node SearchNode(Comparable key)
	{
		Node node = root;
		while(node != null)
		{
			if(key.compareTo(node.GetKey()) == 0)
				return node;
			else if (key.compareTo(node.GetKey()) < 0)
				node = node.left;
			else
				node = node.right;
		}
		return null;
	}

	/*
		Given a key, return the data associated with it, or null
		if the key is not present in the tree
	*/
	public Object Search(Comparable key)
	{
		Node node = SearchNode(key);
		return node == null ? null : node.GetData();
	}

	//return the node containing the min key within the subtree
	//starting at the node starting at the argument, or null if empty
	private Node GetMinNode(Node node)
	{
		//go down the left branch
		while(node != null && node.left != null)
			node = node.left;

		return node;
	}

	//return the data assiciated with the minimum node in the tree
	// or null if tree is empty
	public Object GetMin()
	{
		Node node = GetMinNode(root);
		return node == null ? null : node.GetData();
	}

	//return the successor node for node passed as argument
	//or null if the node passed as argument is the last
	//this is an auxiliary private function
	private Node GetSuccessorNode(Node node)
	{
		//case 1
		if(node.right != null)
			return GetMinNode(node.right);
		//case 2
		Node parent = node.parent;
		while(parent != null && parent.left != node)
		{
			node = parent;
			parent = parent.parent;
		}
		return parent;
	}
	//return successor data for given key
	//or null if given key is the last or not present
	public Object GetSuccessor(Comparable key)
	{
		Node node = SearchNode(key);
		if(node == null)
			return null;

		//get successor node
		node = GetSuccessorNode(node);

		//return associated data
		return node == null ? null : node.GetData();
	}

	private int GetNodeHeight(Node node)
	{
		if(node == null)
			return -1;
		return Math.max(GetNodeHeight(node.left), GetNodeHeight(node.right)) + 1;
	}

	public int GetHeight(Comparable key)
	{
		if (SearchNode(key) == null)
			return -1;
		return GetNodeHeight(SearchNode(key));
	}

	public int GetHeight()
	{
		if (root != null)
			return GetNodeHeight(root);
		return -1;
	}

	public void Insert(Comparable key, Object data)
	{
		//create node
		Node node = new Node(key, data);

		//traverse down tree
		Node parent = null;
		Node child = root;
		while(child != null)
		{
			parent = child;
			if(key.compareTo(child.GetKey()) < 0)
				child = child.left;
			else if(key.compareTo(child.GetKey()) > 0)
				child = child.right;
			else
				throw new RuntimeException("Duplicate key");
		}
		node.parent = parent;
		if(parent == null)
			root = node;
		else if (key.compareTo(parent.GetKey()) < 0)
			parent.left = node;
		else
			parent.right = node;
	}

	private void PrintNode(Node node)
	{
		if(node == null)
			return;
		PrintNode(node.left);
		System.out.println(node.GetData());
		PrintNode(node.right);
	}

	public void Print()
	{
		PrintNode(root);
	}
}
