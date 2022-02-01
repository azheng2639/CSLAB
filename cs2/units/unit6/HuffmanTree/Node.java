class Node implements Comparable
{
	public int frequency, ascii_code;
	public Node left, right;
	public String huffman_code;

	public Node(int ascii_code)
	{
		this.ascii_code = ascii_code;
	}

	public int compareTo(Object other)
	{
		Node otherNode = (Node)other;
		if(frequency < otherNode.frequency)
			return 1;
		else if(frequency > otherNode.frequency)
			return -1;
		else
			return 0;
	}
	public void SetHuffmanCode(String huffman_code)
	{
		this.huffman_code = huffman_code;
		if(left != null)
			left.SetHuffmanCode(huffman_code + "0");
		if(right != null)
			right.SetHuffmanCode(huffman_code + "1");
	}
}
