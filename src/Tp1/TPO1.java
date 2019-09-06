package Tp1;

import static Tp1.Ordena.quicksort;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TPO1 {
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
        int temp=0;
        while (num>1) {
            temp = temp+num % 10;
            num= num/10;
        }        
            temp = temp+num % 10;
        return temp;
    }

    public static int[] arregloSuma(int[] arr){
        int[] temp= new int[arr.length];
        for(int i=0;i<arr.length;i++){
            temp[i]=sumaDigitos(arr[i]);
        }
        return temp;
    } 

    public static void bucketsort(int[] ar) {
        int[] temp=arregloSuma(ar);
        int[] valores = obtenerValorMinMax(temp);
        int minVal = valores[0];
        int maxVal = valores[1];


        int n = ar.length; // n es el numero de elementos
        int m = maxVal - minVal+1; // m es el rango de valores
        int cantBuckets = m / n + 1;
        List<List<Integer>> buckets = new ArrayList<>(cantBuckets);
        for (int i = 0; i < cantBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        // Ubicar cada elemento en un bucket
        for (int i = 0; i < n; i++) {
            int bi = (temp[i] - minVal) / m;
            System.out.println(buckets.size()+" n: "+n+" bi: "+bi);
            if(bi==buckets.size()){
                bi--;
            }
            List<Integer> bucket = buckets.get(bi);
            bucket.add(ar[i]);
        }

        // Ordenar los buckets y mezclarlos en un solo arreglo
        for (int bi = 0, j=0; bi < cantBuckets; bi++) {
            List<Integer> bucket = buckets.get(bi);
            if (bucket != null) {
                //Collections.sort(bucket);
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
    
    public static void main(String[] args) {
        int[] arr = {14,30,55,83,24,52,11};
        int[] arr2 = {14,30,55,83,24,52,11};
        bucketsort(arr);
        quicksort(arr2);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
            System.out.println(arr2[i]);
        }
    }
}
