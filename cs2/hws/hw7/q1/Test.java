class Test
{

	public static void main(String[] args)
	{
		BinarySearchTree tree1 = new BinarySearchTree();
		BinarySearchTree tree2 = new BinarySearchTree();
		BinarySearchTree tree3 = new BinarySearchTree();

		tree1.Insert(5,null);
		tree1.Insert(2,null);
		tree1.Insert(1,null);
		tree1.Insert(3,null);
		tree1.Insert(8,null);
		tree1.Insert(7,null);
		tree1.Insert(10,null);
		System.out.println(tree1.GetHeight());

		tree2.Insert(8,null);
		tree2.Insert(7,null);
		tree2.Insert(5,null);
		tree2.Insert(2,null);
		tree2.Insert(1,null);
		tree2.Insert(3,null);
		tree2.Insert(10,null);
		System.out.println(tree2.GetHeight());

		tree3.Insert(1,null);
		tree3.Insert(3,null);
		tree3.Insert(2,null);
		tree3.Insert(5,null);
		tree3.Insert(7,null);
		tree3.Insert(8,null);
		tree3.Insert(10,null);
		System.out.println(tree3.GetHeight());

		
	}
}
