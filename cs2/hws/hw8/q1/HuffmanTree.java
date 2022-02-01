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
		}
		return result;
	}
	public String Decode(String HText)
	{
		String result = "";
		Node node = root;
		for(int i = 0; i < HText.length(); i ++)
		{
			char cChar = HText.charAt(i);
			if (!(cChar == '1' || cChar == '0'))
				throw new IllegalArgumentException("invalid Huffman-Encoded String");
			if(node.left == null || node.right == null)
			{
				result += (char)node.ascii_code;
				node = root;
			}
			if(cChar == '0')
				node = node.left;
			else if(cChar == '1')
				node = node.right;
		}
		return result + (char)node.ascii_code;
	}
}
