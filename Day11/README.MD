# Code of Advent Day 11.

## The main file contains 2 solution.
### Solution 1 
- SolveWithLinkedList() 

This solution uses a custom linked list implementation to make inserting and removing from the list easy and fast while iterating over it.
(At least in theory. In practice, we create an object for each list element and that comes with a big overhead in java)

It solves the problem with 25 blinks but runs out of memory for 75 blinks

### Solution 2
- SolveWithArrayList


This uses a ArrayList and adds the new elements to the end of it. (since the order of the engravings doesn't matter when they only ask for the number of them)

This solution turned out to be slower than the first one.