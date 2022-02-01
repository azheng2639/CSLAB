/*
a vector is a container structure acting as a dynamically growing array
it is represented with the following field:
	a) size - array capacity representing the maximum number of elements that can be
	inseted before the array must grow
	b) length - the actual number of inserted elements
		length <= size
	c) items - array of elements

a vector has the following methods
	1) Insert(idx, item);
		A value of idx == length inserts item at the end

a) a tree is a rooted, connected, and cycle free graph
	1) one of the verticies is the root
	2) there are no disconnected verticies
	3) there is no path that leads one verticie to itself

b) binary tree - a tree where each node has at most two children

c) a complete tree - a tree in which all leaves have the same distance to the root

d) nearly complete tree - a tree in which the difference in distance between two leaves and the root can only be 1 or 0

e) heap - a nearly complete binary tree where the value of each node is greater or equal to the value of its children
	1) should not be confused with Binary Search Tree (BST)
	
*/
