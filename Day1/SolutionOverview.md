# Code of Advent Day 1.
If you didn't see this challenge yet, you can check it out at https://adventofcode.com/2024/day/1

## Overview
 The program consists of 3 steps:
- step 1: Read the input data and store the 2 columns as Lists. (Storing the second column as a map could be worth to consider)
- step 2: Calculates the solution for Part 1 and Part 2 and store them.
- step 3: Write the solution to an output file

## Part 1
The most straight forward way to solve Part 1, is to sort both lists and compare the elements 1 by 1. (Our program does exactly that)

A more optimal solution would be to compare the elements already when the second sort is happening, so we dont have to iterate through one of the array an extra time.

## Part 2
The most straight forward way to solve Part 2 is to iterate through fhe first list, then for every element also iterate through the second list and count the occurrences.

But the time complexity of this (nested loop) is n^2, and there are better solutions than this. 

We can create a map from the second array. (The keys of the map are the values of the second array. The value for each key is the number of times the key appeared in the second array)

After we created the map, we can iterate through the first array and calculate the similarity score. (which our program does).

This way we increased the space complexity by the size of our map, but reduced the time complexity to 2n from n^2 (1 iteration for the second array to create the map and 1 iteration for the first array to calculate the score)