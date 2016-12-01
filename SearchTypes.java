import java.util.Arrays;

/**
 * Created by ignacioojanguren on 1/12/16.
 *
 * This class proves the differences between Linear Search and Binary Search
 *
 * In the main function there is a timer in millisecond that calculates the time it takes for each method to find
 * the value.
 *
 * Feel free to modify and see the different times it takes depending on the values you are looking for.
 *
 */
public class SearchTypes {

    final private static int NUMBERVALUES = 1000000;//Number of elements in the array

    /**
     * LinearSearch searches the element going over every element in the array until the element has been found.
     *  The worst case of this search is O(n) as there would be n array accesses.
     *  However the average is half the time of the worst case.
     *  The best case of this search is only one array access.
     * @param elements
     *  INT Array that contains the elements
     * @param value
     *  int is the value we want to find in the array
     * @return
     *  returns -1 if the element is not found or the position were the element is located.
     */
    public static int linearSearch(int[] elements, int value){
        for(int i = 0; i < elements.length; i++){
            if(elements[i] == value){
                return i;
            }
        }
        return -1;
    }

    /**
     * BinarySearch uses the recursive call to find a value in an array. The array has to be sorted in order for
     * the BinarySearch to work.
     * It works by looking at the middle element of the array, if the value we want to find is bigger than the
     * middle element then we do a recursive call with the new array being half the size as the previous. Being the new
     * array first element the middle value until the last value.
     * The same would apply if the value is smaller, instead, the new array would be from the first element to the middle element
     *
     * The worst scenario of accesses to the array is O(log2 n)
     * The best scenario will be find it in the middle.
     *
     * @param elements
     *  INT Array that contains the int elements
     * @param value
     *  int element we want to find in the array
     * @param position
     *  position contains the position were the element is located in the array
     * @return
     *  returns -1 if the element couldn't be found or if it is found, it returns the position of the element.
     */
    public static int binarySearch(int[] elements, int value, int position){
        int middle = elements.length / 2;
        if(elements.length == 0)
            return -1;
        else {
            if (value == elements[middle]){
                position += middle;
                return position;
            }else if (value < elements[middle]){
                return binarySearch(Arrays.copyOf(elements, middle), value, position);
            }else{
                position += middle;
                return binarySearch(Arrays.copyOfRange(elements, middle, elements.length), value, position);
            }
        }
    }

    public static void main(String[] args){
        long begin, end;
        int[] elements = new int[NUMBERVALUES];
        int valueSearch = 929321; //Value we want to find

        for(int i = 0; i < NUMBERVALUES; i++){//Filling the array with sorted integers
            elements[i] = i;
        }

        begin = System.currentTimeMillis();//Begin time of the method
        System.out.println("Is "+valueSearch+" in the array? " + linearSearch(elements, valueSearch));
        end = System.currentTimeMillis();//End time of the method
        System.out.println("Time elapsed for Linear Search: " + (end - begin) + " milliseconds");

        begin = System.currentTimeMillis();//Begin time of the method
        System.out.println("Binary search is "+valueSearch+" in the array? " + binarySearch(elements,valueSearch, 0));
        end = System.currentTimeMillis();//End time of the method
        System.out.println("Time elapsed for Binary Search: " + (end - begin) + " milliseconds");

    }

}
