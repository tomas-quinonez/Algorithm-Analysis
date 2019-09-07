package Tp1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//INTEGRANTES: APABLAZA FABIO - FAI-2039 Y QUIÑONEZ TOMÁS - FAI-1901

public class Implementacion {
    public static void quicksort(int[] a) {
        quicksort(a, 0, a.length - 1);
    }

    public static void quicksort(int[] a, int izq, int der) {
        int pivote = a[izq];
        int k = particion(a, izq, der, pivote);
        if (izq < k - 1) {
            quicksort(a, izq, k - 1);
        }
        if (k + 1 < der) {
            quicksort(a, k + 1, der);
        }
    }

    private static int particion(int[] a, int izq, int der, int pivote) {
        int i = izq;
        int j = der;
        int aux;
        while (i < j) {
            while (a[i] <= pivote && i < j) {
                i++;
            }
            while (a[j] > pivote) {
                j--;
            }
            if (i < j) {
                aux = a[i];
                a[i] = a[j];
                a[j] = aux;
            }
        }
        a[izq] = a[j];
        a[j] = pivote;
        return j;
}
    
    public static void burbuja(int[] a) {
        for (int i = 0; i <= a.length - 2; i++) {
            for (int j = 0; j <= a.length - 2 - i; j++) {
                if (a[j + 1] < a[j]) {
                    int aux = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = aux;
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
    
    public static void bucketsort(int[] ar) {
        int[] valores = obtenerValorMinMax(ar);
        int minVal = valores[0];
        int maxVal = valores[1];

        int n = ar.length; // n es el numero de elementos
        int m = maxVal - minVal; // m es el rango de valores
        int cantBuckets = m / n + 1;
        List<List<Integer>> buckets = new ArrayList<>(cantBuckets);
        for (int i = 0; i < cantBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        // Ubicar cada elemento en un bucket
        for (int i = 0; i < n; i++) {
            int posBucket = (ar[i] - minVal) / m;
            List<Integer> bucket = buckets.get(posBucket);
            bucket.add(ar[i]);
        }

        // Ordenar los buckets y mezclarlos en un solo arreglo
        for (int pos = 0, j = 0; pos < cantBuckets; pos++) {
            List<Integer> bucket = buckets.get(pos);
            if (bucket != null) {
                Object[] lista = bucket.toArray();
                int[] listaInt = Arrays.stream(lista).mapToInt(o -> (int)o).toArray();
                if(listaInt.length>1){
                    quicksort(listaInt);
                }
                for (int k = 0; k < listaInt.length; k++) {
                    ar[j++] = listaInt[k];
                }
            }
        }
    }
    
}
