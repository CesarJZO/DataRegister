package sorting;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * This class has an array as its attribute that will be sorted using several algorithms
 * based on the preferences of the user and so on with the searching algorithms
 */
public class DataRegister {
    private final int[] sortedArray;
    private int[] array;
    private final int[] originalArray;
    private final int length;

    /**
     * Creates an array with random numbers
     * @param length The length of the array
     * @param bound  The bounds of the value of the elements of the array
     */
    public DataRegister(int length, int bound) {
        this.length = length;
        array = new int[length];
        originalArray = new int[length];
        for (int i = 0; i < length; i++) {
            Random random = new Random();
            int num = random.nextInt(bound + 1);
            array[i] = num;
            originalArray[i] = num;
        }
        sortedArray = quickSort().clone();
        reset();
    }

    /**
     * Builds and object with an array predefined out of this class
     * @param array An integers array
     */
    public DataRegister(int[] array) {
        this.array = array;
        originalArray = array.clone();
        length = array.length;
        sortedArray = quickSort().clone();
        reset();
    }

    /**
     * Returns an array on its actual state, either sorted or on the original
     * state
     *
     * @return The array
     */
    public int[] getArray() {
        return array;
    }

    /**
     * Returns the length of the arrays
     * @return The length of the arrays
     */
    public int length() {
        return length;
    }

    /**
     * Returns the original array that has been settled down
     * @return The original array, no matter if it was sorted before
     */
    public int[] getOriginalArray() {
        return originalArray;
    }

    /**
     * Returns the sorted array, no matter if it was reset before
     * @return the sorted array
     */
    public int[] getSortedArray() {
        return sortedArray;
    }

    /**
     * Sorts the array that has been called by the method using the sorting
     * algorithm 'quicksort'
     *
     * @return The sorted array
     */
    public int[] quickSort() {
        return quickSort(0, array.length - 1);
    }

    /**
     * Executes the quicksort algorithm
     * @param first The first position of the list or the sublist
     * @param last The last position of the list or the the sublist
     * @return the array sorted
     */
    private int[] quickSort(int first, int last) {
        int pivote = array[(first + last) / 2];
        int i = first;
        int j = last;
        do {
            while (array[i] < pivote)
                i++;
            while (array[j] > pivote)
                j--;
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        } while (i <= j);
        if (first < j)
            quickSort(first, j); // Same process on the left sublist
        if (i < last)
            quickSort(i, last); // Same process on the right sublist
        return array;
    }

    /**
     * Sorts the array that has been called by the method using the sorting
     * algorithm 'shell'
     * @return The sorted array
     */
    public int[] shellSort() {
        int intervalo, i, j, k;
        int n = array.length;

        intervalo = n / 2;
        while (intervalo > 0) {
            for (i = intervalo; i < n; i++) {
                j = i - intervalo;
                while (j >= 0) {
                    k = j + intervalo;
                    if (array[j] <= array[k]) {
                        j = -1; // the pair is ordered
                    } else {
                        // the pair is not sorted and they exchange
                        swap(j, k);
                        // they subtract to move in a new position (backwards)
                        j -= intervalo;
                    }
                }
            }
            // get a new range (smaller)
            intervalo = intervalo / 2;
        }
        return array;
    }

    /**
     * Sorts the array that has been called by the method using the sorting
     * algorithm 'heapSort'
     * @return The sorted array
     */
    public int[] heapSort() {

        searchPosParent();
        int size = array.length - 1;
        for (int i = size; i >= 0; i--) {
            swap(0, i);
            size = size - 1;
            generateMaxHeap(0, size);
        }
        return array;
    }

    /**
     * Looks for the position of all the parents un the binary tree
     */
    private void searchPosParent() {
        for (int i = (array.length - 1) / 2; i >= 0; i--)
            generateMaxHeap(i, array.length - 1);
    }

    /**
     * Receives a parent, the array size and compares the parents with the children
     * Finally, establishes the bigger value within the parents and the children
     * @param i (Parent)
     * @param size the size of the array
     */
    private void generateMaxHeap(int i, int size) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int max;
        if (leftChild <= size && array[leftChild] > array[i]) {
            max = leftChild;
        } else {
            max = i;
        }

        if (rightChild <= size && array[rightChild] > array[max]) {
            max = rightChild;
        }
        if (max != i) { // Checks if the max value is different from the parent to exchange the
            // values with one of the children
            swap(i, max);
            generateMaxHeap(max, size);
        }
    }

    /**
     * Sorts the array that has been called by the method using the sorting
     * algorithm 'Bubble sort'
     *
     * @return The sorted array
     */
    public int[] bubbleSort() {
        for (int i = 0; i < length - 1; i++)
            for (int j = i + 1; j < length; j++)
                if (array[i] > array[j])
                    swap(i, j);
        return array;
    }

    /**
     * Sorts the array that has been called by the method using the sorting
     * algorithm 'Select sort'
     *
     * @return The sorted array
     */
    public int[] selectSort() {
        int indiceMenor;
        for (int i = 0; i < length - 1; i++) {
            // Start of the scan with the i index
            indiceMenor = i;
            for (int j = i + 1; j < length; j++)
                if (array[j] < array[indiceMenor])
                    indiceMenor = j;
            // Sits the element smaller than a[i]
            if (i != indiceMenor)
                swap(i, indiceMenor);
        }
        return array;
    }

    /**
     * Sorts the array that has been called by the method using the sorting
     * algorithm 'Insertion  sort'
     *
     * @return The sorted array
     */
    public int[] insertionSort() {
        for (int i = 0; i < length; i++) {
            int j = i;
            int aux = array[i];
            while (j > 0 && aux < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = aux;
        }
        return array;
    }

    /**
     * Returns the array to its initial state, if it is needed to reorder with
     * another method
     */
    public void reset() {
        if (length >= 0)
            System.arraycopy(originalArray, 0, array, 0, length);
    }

    /**
     * Exchanges the elements of the array based on the received index
     * @param i A position to be replaced for the element in j position
     * @param j A position to be replaced for the element in i position
     */
    private void swap(int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }

    /**
     * Sums all the values in the array and divides the sum by the
     * total amount of values
     * @return A double value which is the division by the length
     */
    public double average() {
        double sum = 0.0D;
        for (double d : this.array) {
            sum += d;
        }
        return sum / this.array.length;
    }

    /**
     * Search for the smallest value in the array
     * @return the smallest value on this log
     */
    public int min() {
        int min = this.array[0];
        for (int i = 1; i < this.array.length; i++) {
            if (this.array[i] < min) {
                min = this.array[i];
            }
        }
        return min;
    }

    /**
     * Search for the biggest value in the array
     * @return the biggest value on this log
     */
    public int max() {
        int max = this.array[0];
        for (int i = 1; i < this.array.length; i++) {
            if (this.array[i] > max) {
                max = this.array[i];
            }
        }
        return max;
    }

    /**
     * Counts all the occurrences of the specified value
     * @return An integer with the number of times the value appears
     */
    public int repeatedValue(int value) {
        Map<Integer, Integer> map = new HashMap<>();
        int count;
        for (int k : this.array) {
            if (!map.containsKey(k)) {
                map.put(k, 1);
            } else {
                count = map.get(k);
                map.put(k, count + 1);
            }
        }
        if (map.get(value) == null)
            return 0;

        return map.get(value);
    }

    /**
     * Counts all the different values and puts them in a map
     * @return An integer with the number of different values
     */
    public int totalValues() {
        Map<Integer, Integer> map = new HashMap<>();
        for (int v : this.array) {
            if (!map.containsKey(v)) {
                map.put(v, 0);
            }
        }
        return map.size();
    }

    /**
     * Counts all the different values in the log and search the most common
     * @return the number that repeats the most
     */
    public int mostRepeatedValue() {
        Map<Integer, Integer> map = new HashMap<>();
        int repeatedV = 0;
        int aux = 0;
        for (int i : array) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
                if (map.get(i) > aux) {
                    repeatedV = i;
                    aux = map.get(i);
                }
            } else {
                map.put(i, 1);
            }
        }
        return repeatedV;
    }

    /**
     * Calculates the number of elements inside a range in a ordered register
     * @param val1 The "left" value. Note: It must be smaller than the val2
     * @param val2 The "right" value. Note: It must be greater than the val 1
     * @return The number of elements inside the range or -1 if a value was not found or if it is invalid
     */
    public int calculateRange(int val1, int val2) {
        if (val1 > val2)
            return -1;
        quickSort();
        int posVal1 = sequentialSearch(val1);
        int posVal2 = sequentialSearch(val2);
        reset();

        return (posVal2 - posVal1) + repeatedValue(val2);
    }

    /**
     * Searches the specified element using the sequential search algorithm
     * @param element the element to be searched
     * @return The position of the specified element or -1 if it was not found
     */
    public int sequentialSearch(int element) {
        for (int i = 0; i < length; i++)
            if (array[i] == element)
                return i;
        return -1;
    }

    /**
     * Searches the specified element in this sorted log using the binary search algorithm
     * @param element The element to be searched
     * @return The position of the specified element or -1 if it was not found
     */
    public int binarySearch(int element) {
        int low = 0;
        int high = length - 1;
        while(low <= high) {
            int centralPos = (low + high) / 2;
            int centralValue = sortedArray[centralPos];
            if(element == centralValue)
                return centralPos;
            else if(element < centralValue)
                high = centralPos -1;
            else
                low = centralPos + 1;
        }
        return -1; // The element was not found
    }

    /**
     * Searches every element in this log using the binary search, and takes note of every time it took to
     * find each element, sums all the times and divides it by the length of the log
     * @return The efficiency in nanoseconds
     */
    public long testBinEfficiency() {
        long sumTime = 0;
        for(int i = 0; i < array.length; i++) {
            long startT = System.nanoTime();
            binarySearch(i);
            long finishT = System.nanoTime();
            long deltaT = finishT - startT;
            sumTime += deltaT;
        }
        return sumTime/array.length;
    }

    /**
     * Searches every element in this log using the sequential search, and takes note of every time it took to
     * find each element, sums all the times and divides it by the length of the log
     * @return The efficiency in nanoseconds
     */
    public long testSeqEfficiency() {
        long sumTime = 0;
        for(int i = 0; i < array.length; i++) {
            long startT = System.nanoTime();
            sequentialSearch(i);
            long finishT = System.nanoTime();
            long deltaT = finishT - startT;
            sumTime += deltaT;
        }
        return sumTime/array.length;
    }

    /**
     * Returns a representation using a string form of the original array and the
     * sorted array
     * @return An String representation the object
     */
    public String toString() {
        return "Original array: " + Arrays.toString(originalArray) +
             "\nSorted array:   " + Arrays.toString(sortedArray);
    }
}