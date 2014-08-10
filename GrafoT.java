/*

2014jun02 
Grafo transposto

*/

import java.util.*;

public class GrafoT extends Grafo {
    
    public GrafoT(Grafo G) {
        GrafoT GT = this;
        int n = G.totV;
        LinkedList listaVertices = new LinkedList(); 
        int idVert = 0; 
        for (int i = 0; i < n; i++) {
            Vertice u = G.V[i];
            Vertice ut = new Vertice(u.nome);
            listaVertices.addLast(ut);
            ut.id = idVert;
            idVert++;
        }
        GT.inicializaListasAdjacencia(listaVertices);
        for (int i = 0; i < n; i++) {
            Vertice u = G.V[i];
            Iterator it = G.Adj[u.id].iterator();
            while (it.hasNext()) {
                Aresta e = (Aresta)it.next();
                Vertice v = e.destino;
                GT.insereAresta(GT.V[v.id], GT.V[u.id], e.peso);
            }
        }
    }

    public GrafoT(Grafo G, int[] ordem) {
        GrafoT GT = this;
        int n = G.totV;
        int[] novaPosicao = new int[n];
        LinkedList listaVertices = new LinkedList(); 
        int idVert = 0; 
        for (int i = 0; i < n; i++) {
            Vertice u = G.V[ordem[i]];
            novaPosicao[ordem[i]] = i;
            Vertice ut = new Vertice(u.nome);
            listaVertices.addLast(ut);
            ut.id = idVert;
            idVert++;
        }
        GT.inicializaListasAdjacencia(listaVertices);
        for (int i = 0; i < n; i++) {
            Vertice u = G.V[i];
            Iterator it = G.Adj[u.id].iterator();
            int uid = novaPosicao[u.id];
            while (it.hasNext()) {
                Aresta e = (Aresta)it.next();
                Vertice v = e.destino;
                int vid = novaPosicao[v.id];
                GT.insereAresta(GT.V[vid], GT.V[uid], e.peso);
            }
        }
    }

//exemplo de uso para grafo transposto com uma ordem especifica para os vertices.
    public static void main( String args[] ) {
        String fn = "grafo2a.txt";
        System.out.println("Entrada: "+fn);
        Grafo G = new Grafo(fn);
        G.imprime();

        // cria grafo transposto com verts em ordem decrescente de indice
        int[] ordem = {5,4,3,2,1,0};
        System.out.println("\n\nGrafo transposto:");
        GrafoT GT = new GrafoT(G, ordem);
        GT.imprime();

    }
}

