//abstract classes
/*
An abstract class is a class containing at least one abstract function
Abstract classes cannot be instantiated 
Abstract classes must be extended 


//Interfaces
Interfaces are 
In java, interfaces are equivalent to an abstract class that only contains abstract functions */

interface examples
{
	public void func1();
	public int func2();

}

//child class

public child implements examples
{
	public void func1()
	{
		//do something
	}

	public int func2()
	{
		//do something else
	}
}

//--Java includes a built in interface defined as follows

interface Comparable
{
	public int compareTo(Object otherObj);

}

/*

Asymptotic cost
The symptotic cost of an algorithmn is determined by the heaviest term in the cost expression corresponding to the worst case senario

based on such term, we can determine the following common cost categories
** in increasingly more complex order
Constant cost: O(1)
Logarithmic: O(logn)
Linear cost: O(n)
nlogn cost: O(nlogn)
Quadratic cost: O(n^2)
Cubic cost: O(n^3)
Exponential cost O(2^n)
Factorial cost: O(n!)
\


*/
