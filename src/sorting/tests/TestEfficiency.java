package sorting.tests;

import java.util.Random;

public class TestEfficiency {
    static int[] createLog() {
        Random random = new Random();
        int[] ints = new int[100000000];
        for (int i = 0; i < ints.length; i++)
            ints[i] = i;
//            ints[i] = random.nextInt(1000);
        return ints;
    }
    public static void main(String[] args) {
        int[] ints = createLog();





        long start = System.currentTimeMillis();
        int n = busquedaBinaria(ints, 10000000);
        long finish = System.currentTimeMillis();

        System.out.println("Busqueda binaria");
        System.out.println("Finish: " + finish +
                         "\nStart:  " + start);
        long deltaTime = finish - start;
        System.out.println("Delta time: " + deltaTime);

        long efficiency = deltaTime / n;
        System.out.println("The efficiency was of: " + efficiency + " ms");






        System.out.println("\n\n\nBusqueda secuencial");
        start = System.currentTimeMillis();
        n = busquedaSecuencial(ints, 10000000);
        finish = System.currentTimeMillis();
        System.out.println("Finish: " + finish +
                         "\nStart:  " + start);
        deltaTime = finish - start;
        System.out.println("Delta time: " + deltaTime);
        System.out.println("n: " + n);
        efficiency = Math.abs(deltaTime / n);
        System.out.println("The efficiency was of: " + efficiency + " ms");

    }

    public static int busquedaBinaria(int a[], int clave) {
        int central, valorCentral;
        int bajo = 0;
        int alto = a.length;
        int i = 0;
        while (bajo <= alto) {
            i++;
            central = (bajo + alto) / 2;
            valorCentral = a[central];
            if (clave == valorCentral)
                break;
            else if (clave < valorCentral)
                alto = central - 1;
            else
                bajo = central + 1;
        }
        return i;
    }

    public static int busquedaSecuencial(int a[], int clave) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == clave)
                return i;
        }
        return -1;
    }
}
