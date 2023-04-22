import java.util.Arrays;

public class quicksort {
    public void intercambiar(int[] lista, int valor1, int valor2){
        int auxiliar = lista[valor1];
        lista[valor1] = lista[valor2];
        lista[valor2] = auxiliar;
    }
    
    public void quicksort(int[] lista, int inicio, int fin){
        if (inicio < fin){
            int pivote = lista[inicio];
            int contadorIzq = inicio;

            for (int i = inicio+1; i <= fin; i++){
                if (lista[i] <= pivote){
                    contadorIzq++;
                    intercambiar(lista, contadorIzq, i);
                }
            }
            intercambiar(lista, inicio, contadorIzq);
            quicksort(lista, inicio, contadorIzq);
            quicksort(lista, contadorIzq+1, fin);
        }
    }
    
    public static void main(String[] args) {
        int[] lista = {4, 2, 8, 1, 3, 9, 6, 5, 7};
        System.out.println("Lista desordenada: " + Arrays.toString(lista));
        quicksort ms = new quicksort();
        ms.quicksort(lista, 0, lista.length-1);
        System.out.println("Lista ordenada: " + Arrays.toString(lista));
    }
}
