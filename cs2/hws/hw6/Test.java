class Test
{
	public static void main(String[] args)
	{
		DoublyLinkedList list = new DoublyLinkedList();
		list.Insert("a");
		list.Insert("b");
		list.Insert("c");
		list.Tail();
		list.Previous();
		list.Insert("d");
		list.Tail();
		list.Next();
		list.Insert("e");
		list.Print();
	}
}
