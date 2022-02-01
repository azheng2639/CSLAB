class Test
{
	public static void main (String[] args)
	{
		HuffmanTree tree = new HuffmanTree();
		String input = args[0];
		tree.CreateLeafNodes(input);
		System.out.println("Original Text: " + input);
		tree.BuildTree();
		String huffmanText = tree.Encode(input);
		System.out.println("Encoded Text: " + huffmanText);
		String dText = tree.Decode(huffmanText);
		
		int compression = Math.round((huffmanText.length() * 100) / (input.length() * 8));
		
		
		System.out.println("Compression Ratio: " + compression + "%");
		System.out.println("Decoded Text: " + dText);
	}
}
