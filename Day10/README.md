# Code of Advent Day 10.

## This module contains 2 solution for the challange.
If you didn't see this challenge yet, you can check it out at https://adventofcode.com/2024/day/10

### Solution 1
#### Part 1
This solution goes through every element in the map and for every 0 found it starts a breadth-first search on the correct paths available.
<br>After we found a 9, we store it in a Set, so if we found a 9 on 2 different path it doesn't count twice.

#### Part 2
The only modification we need to make to our solution for Part 1, is that we don't need to use a Set to keep track of the 9s we found. Instead, we can use a counter that we increase by 1 every time we find a 9 (even if we have found it before).

### Solution 2
This solution iterates through the whole map, first looking for 8s, that has neighbouring 9s, and if we found some we store it(storing it in hashmap is a good option)

After this iteration, we iterate through the whole map again, but this time looking for 7s that has neighbouring 8s with stored 9s. Then we store the 9s in the found 7.

We repeat this process until we reach 0s and then calculate the solution based on the 9s stored.

(for Part 1 we need to store the 9s in a Set like way. For Part 2 we can just store number for the number of 9s reachable.)
