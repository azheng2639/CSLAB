import java.util.Scanner;

class TestPoint3D
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		Point3D a = new Point3D();
		Point3D b = new Point3D();
		a.Read(scan);
		b.Read(scan);
		a.Print();
		b.Print();
		System.out.println("Number of coordinates: " + a.GetNumCoordinates());
		System.out.println("Distance: " + a.GetDistance(b));
	}
}
