class Test
{
	public static void main(String[] args)
	{
		Graph graph = new Graph(5);

		graph.AddEdge(0,1);
		graph.AddEdge(2,1);
		graph.AddEdge(1,3);
		graph.AddEdge(3,2);
		graph.AddEdge(1,4);
		int[] p1 = {0,1,3,2,1};
		int[] p2 = {0,1,2,3};
		int[] p3 = {3,2,1,4};


		System.out.println(graph.HasPath(p1));
		System.out.println(graph.HasPath(p2));
		System.out.println(graph.HasPath(p3));
	}
}
