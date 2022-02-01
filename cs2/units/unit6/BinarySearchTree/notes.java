/*
	A BST supporst the following operations
	O(h) where h is the height if unbalanced
	O(logn) if balanced
	Search(Comparable key)
	{
		returns the data associated with the given key or null if not present
	}

	GetMin()
	{
		Operation returns the minimum value or null if empty.This
		operation consists of descending down the left most branch
		of the tree
		O(h) cost
	}

	GetMax()
	{
		O(h) cost
	}

	GetSuccessor(key)
	{
		O(h) or O(log n) if balanced
		returns the data structure for the successors
		returns null if the given key is not present
		or if it is the last one in the tree
		SUCCESSOR IS THE NUMBER RIGHT AFTER NOT THE CHILD
		case 1:
			The node has a right child
			find the minimum node in the right subtree
		cose 2:
			The node does NOT have a right child
			Then traverse up until you find a node that is
			the left child of its parent. The parent is the successor4
			keep going up left until you can go right
	}

	GetPredecessor(key)
	{
		^^^see above; similar
	}
*/
