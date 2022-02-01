class Test
{
	public static void main(String[] args)
	{
		//create linked list
		LinkedList l = new LinkedList();

		//insert elements at the end
		l.insert(10);
		l.next();
		l.insert(11);
		l.next();
		l.insert(12);

		//insert more elements before the previous ones
		l.head();
		l.insert(13);
		l.next();
		l.insert(14);
		l.next();
		l.insert(15);
	}
}

