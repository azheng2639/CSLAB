import java.util.Scanner;

class TestPoint2D
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		Point2D a = new Point2D();
		Point2D b = new Point2D();
		a.Read(scan);
		b.Read(scan);
		a.Print();
		b.Print();
		System.out.println("Number of coordinates: " + a.GetNumCoordinates());
		System.out.println("Distance: " + a.GetDistance(b));
	}
}
