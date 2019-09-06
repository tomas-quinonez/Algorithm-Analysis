package Tp1;

import static Tp1.Ordena.quicksort;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//INTEGRANTES: APABLAZA FABIO - FAI-2039 Y TOMÁS QUIÑONEZ - FAI-1901

public class TPO1 {

    public static void burbuja(int[] a) {
        for (int i = 0; i <= a.length - 2; i++) {
            for (int j = 0; j <= a.length - 2 - i; j++) {
                if (sumaDigitos(a[j + 1]) < sumaDigitos(a[j])) {
                    int aux = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = aux;

                }
                if (sumaDigitos(a[j + 1]) == sumaDigitos(a[j])) {
                    if (a[j + 1] < a[j]) {
                        int temp = a[j];
                        a[j] = a[j + 1];
                        a[j + 1] = temp;
                    }

                }
            }
        }
    }

    private static int[] obtenerValorMinMax(int[] arr) {
        int[] aux = new int[2];
        if (arr.length >= 2) {
            aux[0] = arr[0];
            aux[1] = arr[1];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < aux[0]) {
                    aux[0] = arr[i];
                } else if (arr[i] > aux[1]) {
                    aux[1] = arr[i];
                }
            }
        } else {
            aux[0] = arr[0];
            aux[1] = arr[0];
        }

        return aux;
    }

    public static int sumaDigitos(int num) {
        int temp = 0;
        while (num > 1) {
            temp = temp + num % 10;
            num = num / 10;
        }
        temp = temp + num % 10;
        return temp;
    }

    public static int[] arregloSuma(int[] arr) {
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = sumaDigitos(arr[i]);
        }
        return temp;
    }

    public static void bucketsort(int[] ar) {
        int[] temp = arregloSuma(ar);
        int[] valores = obtenerValorMinMax(temp);
        int minVal = valores[0];
        int maxVal = valores[1];

        int n = ar.length; // n es el numero de elementos
        int m = maxVal - minVal + 1; // m es el rango de valores
        int cantBuckets = m / n + 1;
        List<List<Integer>> buckets = new ArrayList<>(cantBuckets);
        for (int i = 0; i < cantBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        // Ubicar cada elemento en un bucket
        for (int i = 0; i < n; i++) {
            int bi = (temp[i] - minVal) / m;
            //System.out.println(buckets.size() + " n: " + n + " bi: " + bi);
            if (bi == buckets.size()) {
                bi--;
            }
            List<Integer> bucket = buckets.get(bi);
            bucket.add(ar[i]);
        }

        // Ordenar los buckets y mezclarlos en un solo arreglo
        for (int bi = 0, j = 0; bi < cantBuckets; bi++) {
            List<Integer> bucket = buckets.get(bi);
            if (bucket != null) {
                //Collections.sort(bucket);
                Object[] lista = bucket.toArray();
                int[] listaInt = Arrays.stream(lista).mapToInt(o -> (int) o).toArray();
                if (listaInt.length > 1) {
                    burbuja(listaInt);
                }
                for (int k = 0; k < listaInt.length; k++) {
                    ar[j++] = listaInt[k];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5382,3852,8253,2385,5238,3528,8532,2835,5328,8235,3258,2538,5823,3582,8352,2358,
            8325,5283,8523,3285,2853,2583,3825,5232};
        bucketsort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
