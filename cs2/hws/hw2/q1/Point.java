import java.util.Scanner;

abstract class Point
{
	private String name;

	public void Print()	{System.out.println("Point " + name);}

	public void Read(Scanner scan)
	{
		System.out.println("Enter name:");
		name = scan.nextLine();
	}

	public abstract int GetNumCoordinates();
}
