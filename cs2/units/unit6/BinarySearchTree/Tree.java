class Tree
{
	Node root;
	/*
		Given a keyt return the node containing it or null if the key
		is not [resent in the tree. Nodes are not exposed to the user
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
}
