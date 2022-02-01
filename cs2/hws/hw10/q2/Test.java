class Test
{
	public static void main(String[] args)
	{
		Graph g1 = new Graph(6);
		Graph g2 = new Graph(6);
		Graph g3 = new Graph(6);

		g1.AddUndirectedEdge(0,1);
		g1.AddUndirectedEdge(1,2);
		g1.AddUndirectedEdge(1,4);
		g1.AddUndirectedEdge(3,4);
		g1.AddUndirectedEdge(4,5);

		g2.AddUndirectedEdge(0,1);
		g2.AddUndirectedEdge(1,4);
		g2.AddUndirectedEdge(4,3);
		g2.AddUndirectedEdge(2,5);

		g3.AddUndirectedEdge(1,0);
		g3.AddUndirectedEdge(1,2);
		g3.AddUndirectedEdge(1,3);
		g3.AddUndirectedEdge(1,5);
		g3.AddUndirectedEdge(0,3);
		g3.AddUndirectedEdge(2,5);


		System.out.println(g1.IsConnected());
		System.out.println(g2.IsConnected());
		System.out.println(g3.IsConnected());

	}
}
