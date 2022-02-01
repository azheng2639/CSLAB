/*
	a doubly linked list is a linked list that has two fields
	the list holds reference to both the head and tail nodes
	traversal is possible in both directions
	the doubly linked list supports all the following operations:
	1)  head(), tail() O(1)
		allows you to set the current Node to head and tail
	2) 	next(), previous() O(1)
		traversese the list to next and previous
	3)  insert(Object data) O(1)
		inserts and object at a given location
		i)
			current node if null, then node.previous = tail
			else if current node is other, then node.previous = current.previous
		ii) node.next = current
	    iii) case 1: current == head
					head = node
			 case 2: current == null
			 		tail.next = node
			 case 3: current == anything else
			 		current.previous.next = node
		iv)  case 1: if current = previous
					 tail = nodee
			 case 2: else
			 		 current.previous = node
		 v) current = node
*/

