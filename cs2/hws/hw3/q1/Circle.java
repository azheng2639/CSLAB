class Circle extends Shape
{
	private double radius;

	public Circle(String name, double radius)
	{
		super(name);
		this.radius = radius;
	}

	public void Print()
	{
		super.Print();
		System.out.println("Radius: " + radius);
	}

	public double GetArea()
	{
		return Math.PI * Math.pow(radius, 2);
	}
}
