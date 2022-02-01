class Rectangle extends Shape
{
	private double width, height;

	public Rectangle(String name, double width, double height)
	{
		super(name);
		this.width = width;
		this.height = height;
	}

	public void Print()
	{
		super.Print();
		System.out.println("Width: " + width);
		System.out.println("Height: " + height);
	}

	public double GetArea()
	{
		return height * width;
	}
}
