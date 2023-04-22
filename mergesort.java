import java.util.Arrays;

public class mergesort {
    public void mergesort(int[] lista, int inicio, int fin){
        if (inicio < fin){
            int medio = (inicio + fin) / 2 ;
            mergesort(lista, inicio, medio);
            mergesort(lista, medio+1, fin);
            merge(lista, inicio, medio, fin);
        }
    }

    public void merge(int lista[], int inicio, int medio, int fin){
        int[] listaAux = new int[lista.length];
        for (int i = inicio; i <= fin; i++){
            listaAux[i] = lista[i];
        }
        int punteroIzq = inicio;
        int punteroDer = medio+1;
        int punteroActual = inicio;
        while(punteroIzq<=medio && punteroDer <= fin) {
            if(listaAux[punteroIzq]<=listaAux[punteroDer])
            {
                lista[punteroActual] = listaAux[punteroIzq];
                punteroIzq++;
            }
            else
            {
                lista[punteroActual] = listaAux[punteroDer];
                punteroDer++;
            }
            punteroActual++;
        }
        int restante = medio - punteroIzq;
        for (int i = 0; i <= restante; i++){
            lista[punteroActual+i] = listaAux[punteroIzq+i];
        }
    }


    public static void main(String[] args) {
        int[] lista = {4, 2, 8, 1, 3, 9, 6, 5, 7};
        System.out.println("Lista desordenada: " + Arrays.toString(lista));
        mergesort ms = new mergesort();
        ms.mergesort(lista, 0, lista.length-1);
        System.out.println("Lista ordenada: " + Arrays.toString(lista));
    }
}
