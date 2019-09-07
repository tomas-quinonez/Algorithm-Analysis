package TestTPO1;

import Tp1.Implementacion;
import Tp1.RandomInts;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

//INTEGRANTES: APABLAZA FABIO - FAI-2039 Y QUIÑONEZ TOMÁS - FAI-1901

public class TestImplementacion {

    @Test
    public void testBurbuja() {

        int[] ordenAleatorio = RandomInts.leerArchivo();
        int[] creciente = ordenAleatorio.clone();
        Implementacion.burbuja(creciente);
        int[] decreciente = invertido(creciente);
        int[] comparable = creciente.clone();

        Implementacion.burbuja(creciente);
        assertArrayEquals(comparable, creciente);
        Implementacion.burbuja(decreciente);
        assertArrayEquals(comparable, decreciente);
        Implementacion.burbuja(ordenAleatorio);
        assertArrayEquals(comparable, ordenAleatorio);

    }

    @Test
    public void testQuicksort() {
        int[] ordenAleatorio = RandomInts.leerArchivo();
        int[] creciente = ordenAleatorio.clone();
        Implementacion.burbuja(creciente);
        int[] decreciente = invertido(creciente);
        int[] comparable = creciente.clone();

        Implementacion.quicksort(creciente);
        assertArrayEquals(comparable, creciente);
        Implementacion.quicksort(decreciente);
        assertArrayEquals(comparable, decreciente);
        Implementacion.quicksort(ordenAleatorio);
        assertArrayEquals(comparable, ordenAleatorio);

    }

    @Test
    public void testBucketsort() {
        int[] ordenAleatorio = RandomInts.leerArchivo();
        int[] creciente = ordenAleatorio.clone();
        Implementacion.burbuja(creciente);
        int[] decreciente = invertido(creciente);
        int[] comparable = creciente.clone();

        Implementacion.bucketsort(creciente);
        assertArrayEquals(comparable, creciente);
        Implementacion.bucketsort(decreciente);
        assertArrayEquals(comparable, decreciente);
        Implementacion.bucketsort(ordenAleatorio);
        assertArrayEquals(comparable, ordenAleatorio);
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
