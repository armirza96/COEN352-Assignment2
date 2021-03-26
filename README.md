# COEN352-Assignment2
Java implementations of different algorithms

Q1) Implement a recursive algorithm that puts evens first of an array.

Q2) Merge algorithm that implements a merge sort with only M extra space instead of N space. M is a multiple of N.

Q3) An indirect merge sort that doesnt modify the original array but instead returned a new array which elements point to the correct order of the orignal array.
    For example for the array: {6, 3, 4, 1, 5, 2} a new array of {3, 5, 1, 2, 4, 0} is returned. When looping over the new arrays elements and indexing the old array with them (array[perm[i]])
    we outout the old array in sequential order.
    
Q4) Implemenation of an Entropy Optimal Sort. Useful for when duplicate keys exist and time can be reduced from linearithmic to linear.

Q5) Fast 3 way partioning sort but it does extra swaps for the keys that are equal to it. Theres a bug that needs to be fixed according to the TA.

Q6) Time class that implements Java<Comparable> and sorts in ascending order. Also keeps track of any duplicates.
