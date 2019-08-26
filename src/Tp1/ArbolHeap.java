package Tp1;

public class ArbolHeap {

    private static final int TAM = 100000;
    private Comparable[] heap;
    private int ultimo;

    public ArbolHeap() {
        this.heap = new Comparable[this.TAM];
        ultimo = 0;
    }

    public boolean insertar(Comparable elem) {
        boolean exito = false;
        if (this.ultimo == 0) {
            this.ultimo++;
            this.heap[this.ultimo] = elem;
            exito = true;
        } else {
            this.ultimo++;
            this.heap[this.ultimo] = elem;
            int aux = this.ultimo;
            int padre = (int) aux / 2;
            while (!exito) {
                if (this.heap[aux].compareTo(this.heap[padre]) < 0) {
                    this.heap[aux] = this.heap[padre];
                    this.heap[padre] = elem;
                    aux = padre;
                    padre = aux / 2;
                    if (aux == 1) {
                        exito = true;
                    }
                } else {
                    exito = true;
                }
            }
        }
        return exito;
    }

    public boolean eliminarCima() {
        boolean exito;
        if (this.ultimo == 0) {
            exito = false;
        } else {
            this.heap[1] = this.heap[this.ultimo];
            this.ultimo--;
            this.hacerBajar(1);
            exito = true;
        }
        return exito;
    }

    private void hacerBajar(int posicion) {
        int hijoMenor;
        int temp = (int) this.heap[posicion];
        boolean salir = false;
        while (!salir) {
            hijoMenor = posicion * 2;
            if (hijoMenor <= this.ultimo) {
                if (hijoMenor < this.ultimo) {
                    if ((int) this.heap[hijoMenor + 1] < (int) this.heap[hijoMenor]) {
                        hijoMenor++;
                    }
                }
                if ((int) this.heap[hijoMenor] < temp) {
                    this.heap[posicion] = this.heap[hijoMenor];
                    posicion = hijoMenor;
                } else {
                    salir = true;
                }
            } else {
                salir = true;
            }
        }
        this.heap[posicion] = temp;
    }

    public Object obtenerCima() {
        return this.heap[1];
    }

    @Override
    public String toString() {
        String s = "";
        if (ultimo == 0) {
            s = "Árbol vacío.";
        } else {
            s = "[";
            for (int i = 1; i <= this.ultimo; i++) {
                s = s + this.heap[i] + ",";
            }
            s = s + "]";
        }
        return s;
    }
}
