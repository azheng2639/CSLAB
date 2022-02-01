import java.util.Scanner;

class Point3D extends Point
{
	private double x,y,z;

	public void Read(Scanner scan)
	{
		super.Read(scan);
		System.out.println("Enter X:");
		x = scan.nextDouble();
		System.out.println("Enter Y:");
		y = scan.nextDouble();
		scan.nextLine();
		System.out.println("Enter Z:");
		z = scan.nextDouble();
		scan.nextLine();
	}

	public void Print()
	{
		super.Print();
		System.out.println("X-coordinate: " + x);
		System.out.println("Y-coordinate: " + y);
		System.out.println("Z-coordinate: " + z);
	}

	public int GetNumCoordinates() {return 3;}

	public double GetDistance(Point3D B)
	{
		return Math.sqrt(Math.pow(B.x - x, 2) + Math.pow(B.y - y, 2) + Math.pow(B.z - z, 2));
	}
}
