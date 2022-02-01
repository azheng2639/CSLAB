class Rectangle extends Shape
{
	double width, height;
	String name;
	

	public Rectangle(String name)
	{
		super(name);
	}
	public void setDimentions(double width, double height)
	{
		this.width = width;
		this.height = height;
	}

	public double getArea()
	{
		return width * height;
	}

	public String getName()	{return name;}
}
