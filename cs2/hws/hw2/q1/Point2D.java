import java.util.Scanner;

class Point2D extends Point
{
	private double x,y;

	public void Read(Scanner scan)
	{
		super.Read(scan);
		System.out.println("Enter X:");
		x = scan.nextDouble();
		scan.nextLine();
		System.out.println("Enter Y:");
		y = scan.nextDouble();
		scan.nextLine();
	}

	public void Print()
	{
		super.Print();
		System.out.println("X-coordinate: " + x);
		System.out.println("Y-coordinate: " + y);
	}

	public int GetNumCoordinates() {return 2;}

	public double GetDistance(Point2D B)
	{
		return Math.sqrt(Math.pow(B.x - x, 2) + Math.pow(B.y - y, 2));
	}
}
