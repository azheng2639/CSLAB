import java.util.ArrayDeque;
import java.util.Queue;
class Graph
{
	int size;
	Vertex[] verticies;

	public Graph(int size)
	{
		this.size = size;
		verticies = new Vertex[size];
		for(int i = 0; i < size; i++)
			verticies[i] = new Vertex();
	}

	public void AddEdge(int source, int target)
	{
		Edge edge = new Edge(target);
		edge.next = verticies[source].edge;
		verticies[source].edge = edge;
	}

	public void AddUndirectedEdge(int source, int target)
	{
		AddEdge(source,target);
		AddEdge(target,source);
	}

	public void Print()
	{
		System.out.println("* * Graph * *");
		for(int i = 0; i < size; i ++)
		{
			System.out.println("Vertex " + i + ":");
			System.out.println(" Distance: " + verticies[i].distance);
			System.out.println(" Parent: " + verticies[i].parent);
			System.out.println(" Edges:");
			for (Edge edge = verticies[i].edge; edge != null; edge = edge.next)
				System.out.println("    " + i + " -> " + edge.target);
		}
	}

	public void BFS(int start)
	{
		for(int i = 0; i < size; i ++)
		{
			verticies[i].color = i == start ? Vertex.GREY : Vertex.WHITE;
			verticies[i].distance = i == start ? 0 : Integer.MAX_VALUE;
			verticies[i].parent = -1;
		}
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(start);
		while(queue.peek() != null)
		{
			int source = queue.remove();

			for(Edge edge = verticies[source].edge; edge != null; edge = edge.next)
			{
				int target = edge.target;
				if(verticies[target].color == Vertex.WHITE)
				{
					verticies[target].color = Vertex.GREY;
					verticies[target].parent = source;
					verticies[target].distance = verticies[source].distance + 1;
					queue.add(target);
				}
			}
			verticies[source].color = Vertex.BLACK;
		}
	}

	public void PrintShortestPath(int source, int target)
	{
		if(source == target)
		{
			System.out.print(source);
		}
		else if(verticies[target].parent == -1)
		{
			System.out.print("unreachable");
		}
		else
		{
			PrintShortestPath(source,verticies[target].parent);
			System.out.print(" -> " + target);
		}
	}

	private int DFSVisit(int source, int time)
	{
		verticies[source].color = Vertex.GREY;
		verticies[source].time_in = time++;
		for(Edge edge = verticies[source].edge; edge!=null; edge = edge.next)
		{
			int target = edge.target;
			if(verticies[target].color == Vertex.WHITE)
			{
				verticies[target].parent = source;
				time = DFSVisit(target,time);
			}
		}
		verticies[source].color = Vertex.BLACK;
		verticies[source].time_out = time++;
		return time;
	}

	public int GetSize()		{return size;}

	private boolean HasEdge(int source, int target)
	{
		for(Edge edge = verticies[source].edge; edge != null; edge = edge.next)
			if(edge.target == target)
				return true;
		return false;
	}

	public boolean HasPath(int[] arr)
	{
		for(int i = 0; i < arr.length - 1; i ++)
		{
			if(!HasEdge(arr[i],arr[i+1]))
				return false;
		}
		return true;
	}
}

