package Tp1;

public class Ordena {

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

    public static void burbujaMejorado(int[] a) {
        int i = 0, j, bandera = 1, aux;
        while (i <= a.length - 2 && bandera == 1) {
            bandera = 0;
            for (j = 0; j <= a.length - 2 - i; j++) {
                if (a[j + 1] < a[j]) {
                    aux = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = aux;
                    bandera = 1;
                }
            }
            i++;
        }
    }

    public static void seleccion(int[] a) {
        int i, j, min;
        for (i = 0; i <= a.length - 2; i++) {
            min = i;
            for (j = i + 1; j <= a.length - 1; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            int aux = a[i];
            a[i] = a[min];
            a[min] = aux;
        }
    }

    public static void insercion(int[] a) {
        int p;
        for (p = 0; p <= a.length - 1; p++) {
            int temp = a[p];
            int j = p;
            while (j > 0 && temp < a[j - 1]) {
                a[j] = a[j - 1];
                j = j - 1;
            }
            a[j] = temp;
        }
    }

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

    public static void mergesort(int[] a){
        mergesort(a,0,a.length-1);
    }
    
    private static void mergesort(int[] a, int izq, int der) {
        if (izq < der) {
            int m = (izq + der) / 2;
            mergesort(a, izq, m);
            mergesort(a, m + 1, der);
            merge(a, izq, m, der);
        }
    }

    private static void merge(int A[], int izq, int m, int der) {
        int i, j, k;
        int[] B = new int[A.length];
        for (i = izq; i <= der; i++) {
            B[i] = A[i];
        }

        i = izq;
        j = m + 1;
        k = izq;
        while (i <= m && j <= der) {
            if (B[i] <= B[j]) {
                A[k++] = B[i++];
            } else {
                A[k++] = B[j++];
            }
        }
        while (i <= m) {
            A[k++] = B[i++];
        }
    }
    
    public static void heapsort(int[] a){
        ArbolHeap arbolHeap=new ArbolHeap();
        int i;
        for(i=0;i<=a.length-1;i++){
            arbolHeap.insertar(a[i]);
        }
        for(i=0;i<=a.length-1;i++){
            a[i]=(int)arbolHeap.obtenerCima();
            arbolHeap.eliminarCima();
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 7, 9, 4, 0, 2, 5, 8};
        //burbuja(arr);
        //seleccion(arr);
        //insercion(arr);
        //burbujaMejorada(arr);
        //quicksort(arr);
        //mergesort(arr);
        heapsort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
