# Code of Advent Day 2.
If you didn't see this challenge yet, you can check it out at https://adventofcode.com/2024/day/2

## Overview
The program consists of 3 steps:
- step 1: Read the input data and store it as list of lists of integers
- step 2: Calculates the solution for Part 1 and Part 2 and store them.
- step 3: Write the solution to an output file

The solution for part 1 is fairly simple. The solution for part 2 also seems simple, but it has some challenges.

## Part 1
To tell if a report is safe, first we need to check if the levels of the reports are ascending or descending. We can do that by comparing any 2 neighbouring levels of the report. (We can choose any 2 neighbouring element because all of them has to be in the same order, otherwise the report will be unsafe anyway) 

After that we have to iterate through the levels of the report and check if the current level is safe with the next level. If all the levels were safe, then the report is safe too.

To get the solution, we have to repeat this process for each report and count how many of them were safe.


## Part 2
### Overview of part 2
At first part 2 seems also simple. We have to do the same as in part 1, but if we found an unsafe level neighbours, we have to check if we ignore 1 of them would the report still be safe.

But there are 2 new problems:
1. We can decide the ascending order anymore by comparing any 2 neighbouring levels, because if 1 of the chosen levels if the one we want to ignore, we can get inaccurate results.
2. If we want to ignore the firs or second level, then the ascending order can change.

We can solve these by just checking for both order. By doing this we sacrifice a bit of optimization in the favor of readability, maintainability and developer hours.<br>
On the optimization we don't lose much, since when we check for the wrong order, we will always return after checking 3 levels. The length of the report doesn't matter 

### Solution of part 2

To get if a report is safe, we have to check for each level and the level after it if they are safe. <br>
When we find our first 2 unsafe levels we have to 2 things to tell if the report is safe:
1. We have to check if the levels before and after the ignored levels are safe with each-other. (When we ignore a level, then the levels before and after the ignored level become neighbours, which they weren't before).
2. We have to check if the rest of the report is safe.

If by ignoring any of the first 2 unsafe level, the rest of the report is safe and the new 2 neighbouring levels are safe, then the whole report is safe.

To get the solution we have to repeat this process for each report and count how many of them were safe.

## Side note
A variation where we can ignore more than 1 level could also be implemented with slight modifications.