# SearchingFunctions

This class Searching functions only compares the functions linear search and binary search in an array

Linear Search:
  - This linear search in order to find an element in the array, will have to go over all the elements the array contains.
  - The best case scenarion for this function is only one access to the array. This implies the element you are looking for
  is in the first position.
  - But what could be the worst scenario? If the value you are looking for is not in the array, there would be O(n) accesses 
  in the array, as it would have to go over the array to see if your value is in the next position. This would be the worst case.
  - However, we can calculate the average time of this process, not all the elements will be at the begining or at the end of the
  array, the averege of searching time is O(n/2).
  
Linear Search is not the best case, there are other cases like Binary Search.

Binary Search:
  - This search is better than the linear search. However, we need the array to be sorted for the search to work.
  - This search works by dividing the array by the middle value. If the element we are looking for is bigger or smaller than the 
  middle value, then we would search in the left half if the value is smaller or the right half if the value is bigger. We will use
  recursive function until we would find the value in the array. If the value is not found a -1 will be returned.
  - The best of the cases is to find the element in the first half.
  - The worst case is to find the element at the end and the time would be O(log2 n)
  
