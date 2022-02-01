/*
	a) a single linked list is a data structure composed of two fields
		1) node data
		2) a reference to the next node

		a list keeps track of a current element as a reference to any node in the list
		current element may be null in a "past-the-end" situation

		the list also keeps track of a previous element as a reference to the node right before the current element
		the previous element is set to null if the current element is the first


		a singly linked list supports the following methods
		1) Next()
			moves to the next element or to past-the-end if the current element is the last
		2) Head()
			operation that allows you to go back to the first element
		3) Insert(item)
			function that allows one item to be inserted or at the end if current element is past-the-end the new element then becomes the current element


	Stacks and queues
		Stack - A container that handles its elements in a last-in first-out manner
			The last element that is inserted is the first one to be extracted, like a stack of paper where last is on top
				This can be implemented on a vector or singly linked list

		Queue - A container that handles its elements in a first in first out manner
			this can be implemented on a deque or a doubly linked list
*/
