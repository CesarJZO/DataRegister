package sorting.tests;
import sorting.DataRegister;
import java.util.Scanner;

public class TestRange {
    public static void main(String[] args) {
//        int[] ints = {1,2,2,3,4,5,5,6};
//
//        DataRegister dataRegister = new DataRegister(ints);
        DataRegister dataRegister = new DataRegister(20,10);
        Scanner scanner = new Scanner(System.in);

        System.out.println(dataRegister);

        System.out.print("Type a left val:  ");
        int val1 = scanner.nextInt();
        System.out.print("Type a right val: ");
        int val2 = scanner.nextInt();

        System.out.println("The range is: " + dataRegister.calculateRange(val1, val2));
    }
}
