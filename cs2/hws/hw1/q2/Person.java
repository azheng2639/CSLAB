class Person
{
	private String name;
	private int age;

	public Person(String name, int age)
	{
		this.name = name;
		this.age = age;
	}

	public void Print()
	{
		System.out.println("Name: " + name + "\n" + "Age: " + age);
	}
	
	public boolean IsUnderage()	{return age < 18;}
}
