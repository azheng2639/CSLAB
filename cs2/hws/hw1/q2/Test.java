import java.util.Scanner;
class Test
{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a name");
		String name = scan.nextLine();

		System.out.println("Enter an age");
		int age = scan.nextInt();

		Person p = new Person(name, age);
		p.Print();
		System.out.println("Underage: " + p.IsUnderage());
	}
}
