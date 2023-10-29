package Estructura_Final;
    
    import java.util.*;
public class Dijkstra {


        public static void dijkstra(int[][] grafo, int nodoInicial) { //Declaramos los valores de visitado, la distancia y el nodo.
            int nodo = grafo.length;
            int[] distancia = new int[nodo];
            boolean[] visitado = new boolean[nodo];
    
            for (int i = 0; i < nodo; i++) { // Le damos a la distancia un valor cercano a infinito y ponemos como falso elvalor de visitado.
                distancia[i] = Integer.MAX_VALUE;
                visitado[i] = false;
            }
    
            distancia[nodoInicial] = 0; //Ponemos que la distancia del nodo inicial al nodo inicial es 0.
    
            for (int i = 0; i < nodo - 1; i++) {
                int minDistance = Integer.MAX_VALUE;
                int minIndex = -1;
    
                for (int j = 0; j < nodo; j++) {
                    if (!visitado[j] && distancia[j] < minDistance) { //En este apartado creamos una condicion en la que si no se ha visitado un nodo y la distancia es menor a el valor guardado  en la minima distancia, se reemplaza ese valor, esto sirve para ir comparando las distancias y poder encontrar la menor.
                        minDistance = distancia[j];
                        minIndex = j;
                    }
                }
    
                visitado[minIndex] = true; //Posteriormente se cambia el estado de visitado, para no volver a checar la distancia en ese nodo.
    
                for (int j = 0; j < nodo; j++) { //Esto sirve para ir sumando las distancias entre los nodos mas lejanos, es decir si se quiere llegar del nodo 0 al 2, se sumaran las distancias más cortas que se encontraron.
                    if (!visitado[j] && grafo[minIndex][j] != 0 && distancia[minIndex] != Integer.MAX_VALUE
                            && distancia[minIndex] + grafo[minIndex][j] < distancia[j]) {
                        distancia[j] = distancia[minIndex] + grafo[minIndex][j];
                    }
                }
            }
    
            // Imprimir las distancias más cortas desde el nodo de inicio
            for (int i = 0; i < nodo; i++) {
                System.out.println("Distancia desde el nodo " + nodoInicial + " al nodo " + i + " es: " + distancia[i]);
            }
        }
    
        public static void main(String[] args) {
            int[][] grafo = {
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
            };
    
            dijkstra(grafo, 0);
        }
    } 

