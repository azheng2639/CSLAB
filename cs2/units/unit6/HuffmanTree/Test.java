class Test
{
	public static void main (String[] args)
	{
		HuffmanTree tree = new HuffmanTree();
		String asciiText = "mississippi";
		tree.CreateLeafNodes(asciiText);
		tree.BuildTree();
		String huffmanText = tree.Encode(asciiText);
		System.out.println(huffmanText);
	}
}
