class HuffmanTree
{
	Node root;
	Node[] leafNodes;

	public void CreateLeafNodes(String ascii)
	{
		leafNodes = new Node[256];
		for(int i = 0; i < ascii.length(); i ++)
		{
			int asciiCode = ascii.charAt(i);
			if(leafNodes[asciiCode] == null)
				leafNodes[asciiCode] = new Node(asciiCode);
			leafNodes[asciiCode].frequency++;
		}


	}

	public void BuildTree()
	{
		Heap heap = new Heap();

		for(int i = 0; i < 256; i++)
			if(leafNodes[i] != null)
				heap.Insert(leafNodes[i]);
		while (heap.GetLength() > 1)
		{
			Node left = (Node) heap.ExtractMax();
			Node right = (Node) heap.ExtractMax();
			root = new Node(0);

			root.left = left;
			root.right = right;
			root.frequency = left.frequency + right.frequency;
			heap.Insert(root);
		}
		root.SetHuffmanCode("");
	}

	public String Encode(String asciiText)
	{
		String result = "";
		for(int i = 0; i < asciiText.length(); i ++)
		{
			int asciiCode = asciiText.charAt(i);
			if(leafNodes[asciiCode] == null)
				throw new RuntimeException("Character not supported" +
					asciiText.charAt(i));
			String huffmanCode = leafNodes[asciiCode].huffman_code;
			result += huffmanCode;
			System.out.println(asciiText.charAt(i) + " -> " + huffmanCode);
		}
		return result;
	}
}
