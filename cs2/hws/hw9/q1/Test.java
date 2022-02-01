class Test
{
	public static void main(String args[])
	{
		// Create persons
		Person p1 = new Person("Adam", 21);
		Person p2 = new Person("John", 20);
		Person p3 = new Person("Mary", 25);
		Person p4 = new Person("Zack", 22);

		// Insert them into a hash table
		HashTable hash_table = new HashTable();
		hash_table.Insert(p1.GetName(), p1);
		hash_table.Insert(p2.GetName(), p2);
		hash_table.Insert(p3.GetName(), p3);
		hash_table.Insert(p4.GetName(), p4);

		// Queries
		System.out.println("Successor of " + p3.GetName() + ": " + hash_table.GetSuccessor(p3.GetName()));
		System.out.println("Successor of " + p4.GetName() + ": " + hash_table.GetSuccessor(p4.GetName()));
	}
}
