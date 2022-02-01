abstract class Shape
{
	String name;
	public Shape (String name)
	{
		this.name = name;
	}

	public void getName()		{System.out.println(name);}

	//every child class of Shape must implement getArea beacuse it is declared as abstract


	public abstract double getArea();
}
