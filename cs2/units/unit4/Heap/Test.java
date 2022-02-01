class Test
{
	public static void main(String[] agrs)
	{
		//create heap and insert elements 
		Heap heap = new Heap(); 
		Heap.Insert(10); 
		// Java will implicitly call Heap.Insert(Integer.valueOf(10)); 
		Heap.Insert(1); 
		Heap.Insert(4); 
		Heap.Insert(6);
		Heap.Insert(9);
	}
}
