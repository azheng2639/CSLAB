class Test
{
	public static void main(String[] args)
	{
		HashTable table = new HashTable();
		for(int i = 0; i < 1000; i ++)
			table.Insert(i,null);
	}
}
