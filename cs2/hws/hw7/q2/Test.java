import java.util.Random;

class Test
{
	public static void main(String[] args)
	{
		String set = args[0];
		int values = Integer.parseInt(args[1]);
		BinarySearchTree tree = new BinarySearchTree();
		Random random = new Random();
		if(set.toLowerCase().equals("sorted"))
		{
			for(int i = 0; i < values; i ++)
				try
				{
					tree.Insert(i, null);
				}
				catch (RuntimeException e)
				{
					System.out.println("Duplicate key");
				}
		}
		else if (set.toLowerCase().equals("random"))
		{
			for(int i = 0; i < values; i ++)
				try
				{
					tree.Insert(random.nextInt(), null);
				}
				catch (RuntimeException e)
				{
					System.out.println("Duplicate key");
				}
		}
		else
			throw new RuntimeException("Not a valid input");
	}
}
