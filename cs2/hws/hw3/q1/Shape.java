abstract class Shape
{
	private String name;

	public Shape(String name)
	{
		this.name = name;
	}

	public void Print()
	{
		System.out.println("\n" + "Name: " + name);
		System.out.println("Area: " + GetArea());
	}

	public abstract double GetArea();

	public int compareTo(Shape p)
	{
		if(GetArea() < p.GetArea())
			return -1;
		if(GetArea() == p.GetArea())
			return 0;

		return 1;
	}
}
