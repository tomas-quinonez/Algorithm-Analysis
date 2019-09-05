package TestTp1;

import java.util.*;

import Tp1.*;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class OrdenamientoTest {

    @Test
    public void testBurbuja() {

        int[] ordenAleatorio = RandomInts.leerArchivo();
        int[] creciente = ordenAleatorio.clone();
        Ordena.burbuja(creciente);
        int[] decreciente = invertido(creciente);
        int[] comparable = creciente.clone();

        Ordena.burbuja(creciente);
        assertArrayEquals(comparable, creciente);
        Ordena.burbuja(decreciente);
        assertArrayEquals(comparable, decreciente);
        Ordena.burbuja(ordenAleatorio);
        assertArrayEquals(comparable, ordenAleatorio);

    }

    @Test
    public void testBurbujaMejorado() {

        int[] ordenAleatorio = RandomInts.leerArchivo();
        int[] creciente = ordenAleatorio.clone();
        Ordena.burbuja(creciente);
        int[] decreciente = invertido(creciente);
        int[] comparable = creciente.clone();

        Ordena.burbujaMejorado(creciente);
        assertArrayEquals(comparable, creciente);
        Ordena.burbujaMejorado(decreciente);
        assertArrayEquals(comparable, decreciente);
        Ordena.burbujaMejorado(ordenAleatorio);
        assertArrayEquals(comparable, ordenAleatorio);

    }

    @Test
    public void testSeleccion() {

        int[] ordenAleatorio = RandomInts.leerArchivo();
        int[] creciente = ordenAleatorio.clone();
        Ordena.burbujaMejorado(creciente);
        int[] decreciente = invertido(creciente);
        int[] comparable = creciente.clone();

        Ordena.seleccion(creciente);
        assertArrayEquals(comparable, creciente);
        Ordena.seleccion(decreciente);
        assertArrayEquals(comparable, decreciente);
        Ordena.seleccion(ordenAleatorio);
        assertArrayEquals(comparable, ordenAleatorio);
    }

    @Test
    public void testQuicksort() {
        int[] ordenAleatorio = RandomInts.leerArchivo();
        int[] creciente = ordenAleatorio.clone();
        Ordena.burbujaMejorado(creciente);
        int[] decreciente = invertido(creciente);
        int[] comparable = creciente.clone();

        Ordena.quicksort(creciente);
        assertArrayEquals(comparable, creciente);
        Ordena.quicksort(decreciente);
        assertArrayEquals(comparable, decreciente);
        Ordena.quicksort(ordenAleatorio);
        assertArrayEquals(comparable, ordenAleatorio);

    }

    @Test
    public void testInserccion() {
        int[] ordenAleatorio = RandomInts.leerArchivo();
        int[] creciente = ordenAleatorio.clone();
        Ordena.burbujaMejorado(creciente);
        int[] decreciente = invertido(creciente);
        int[] comparable = creciente.clone();

        Ordena.insercion(creciente);
        assertArrayEquals(comparable, creciente);
        Ordena.insercion(decreciente);
        assertArrayEquals(comparable, decreciente);
        Ordena.insercion(ordenAleatorio);
        assertArrayEquals(comparable, ordenAleatorio);

    }

    @Test
    public void testMergesort() {
        int[] ordenAleatorio = RandomInts.leerArchivo();
        int[] creciente = ordenAleatorio.clone();
        Ordena.burbujaMejorado(creciente);
        int[] decreciente = invertido(creciente);
        int[] comparable = creciente.clone();

        Ordena.mergesort(creciente);
        assertArrayEquals(comparable, creciente);
        Ordena.mergesort(decreciente);
        assertArrayEquals(comparable, decreciente);
        Ordena.mergesort(ordenAleatorio);
        assertArrayEquals(comparable, ordenAleatorio);
    }

    @Test
    public void testHeapsort() {
        int[] ordenAleatorio = RandomInts.leerArchivo();
        int[] creciente = ordenAleatorio.clone();
        Ordena.burbujaMejorado(creciente);
        int[] decreciente = invertido(creciente);
        int[] comparable = creciente.clone();

        Ordena.heapsort(creciente);
        assertArrayEquals(comparable, creciente);
        Ordena.heapsort(decreciente);
        assertArrayEquals(comparable, decreciente);
        Ordena.heapsort(ordenAleatorio);
        assertArrayEquals(comparable, ordenAleatorio);
    }
    
    @Test
    public void testBucketSort(){
        
    }

    @Test
    public void testTiempos() {
        int[] a = RandomInts.leerArchivo();
        double t1 = System.currentTimeMillis();
        Ordena.seleccion(a);
        double t2 = System.currentTimeMillis();
        System.out.println("**TIEMPO seleccion=" + (t2 - t1));
    }

    private int[] invertido(int[] a) {
        int[] inv = a.clone();
        int l = a.length;
        int temp;
        for (int i = 0; i < l / 2 - 1; i++) {
            temp = inv[i];
            inv[i] = inv[l - i - 1];
            inv[l - i - 1] = temp;
        }
        return inv;
    }

}
