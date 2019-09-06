package TestTPO1;

import Tp1.TPO1;
import org.junit.Test;
import static org.junit.Assert.*;


// INTEGRANTES: APABLAZA FABIO - FAI-2039 Y QUIÑONEZ TOMÁS-FAI-1901
public class TestTPO1 {
    
    @Test
    public void testProblema(){
        
        //Caso en el que la suma de todos los digitos del arreglo es la misma (18).
        int[] arrOrdenado = {2358,2385,2538,2583,2835,2853,  3258,3285,3528,3582,3825,3852,  
            5238,5283,5328,5382,5823,5832,  8235,8253,8325,8352,8523,8532};
        int[] arrAOrdenar = {5382,3852,8253,2385,5238,3528,8532,2835,5328,8235,3258,2538,5823,3582,8352,2358,
            8325,5283,8523,3285,2853,2583,3825,5832};
        TPO1.bucketsort(arrAOrdenar);
        assertArrayEquals(arrOrdenado, arrAOrdenar);
        
        //Caso en el que se hacen las comparaciones en orden creciente, decreciente y aleatorio.
        int[] ordenAleatorio = {1111,8652,328,5555,50,95,123,99,4,75,5,46,63};
        int[] creciente = {4,1111,5,50,123,63,46,75,328,95,99,5555,8652};
        int[] decreciente = invertido(creciente);
        int[] comparable = creciente.clone();

        TPO1.bucketsort(creciente);
        assertArrayEquals(comparable, creciente);
        TPO1.bucketsort(decreciente);
        assertArrayEquals(comparable, decreciente);
        TPO1.bucketsort(ordenAleatorio);
        assertArrayEquals(comparable, ordenAleatorio);
        
        //Caso en el que el arreglo tenga un solo elemento.
        int[] arrOrdenado3 = {4};
        int[] arrAOrdenar3 = {4};
        TPO1.bucketsort(arrAOrdenar3);
        assertArrayEquals(arrOrdenado3, arrAOrdenar3);
    }
    
    @Test
    public void testTiempos() {
        int[] arr1 = {2358,2385,2538,2583,2835,2853,  3258,3285,3528,3582,3825,3852,  
            5238,5283,5328,5382,5823,5832,  8235,8253,8325,8352,8523,8532};;
        double t1 = System.currentTimeMillis();
        TPO1.bucketsort(arr1);
        double t2 = System.currentTimeMillis();
        System.out.println("**TIEMPO seleccion= " + (t2 - t1));
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

