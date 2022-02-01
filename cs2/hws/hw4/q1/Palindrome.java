import java.util.Scanner;
class Palindrome
{
	public static boolean IsPalindrome(String s)
	{
		//base case
		if(s.length() <= 1)
			return true;
		//check if first and last characters are the same, then recursive call
		if(s.charAt(0) == s.charAt(s.length() - 1))
			return IsPalindrome(s.substring(1,s.length() - 1));
		//else it is false
		return false;
	}

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter string: ");
		if(IsPalindrome(scan.nextLine()))
			System.out.println("The string is a palindrome");
		else
			System.out.println("The string is not a palindrome");
	}
}
