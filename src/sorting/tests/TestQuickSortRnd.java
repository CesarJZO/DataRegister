package sorting.tests;

import sorting.DataRegister;

import java.util.Arrays;

public class TestQuickSortRnd {
    public static void main(String[] args) {
        DataRegister array = new DataRegister(1000000, 10);
        System.out.println(Arrays.toString(array.quickSort()));
    }
}
