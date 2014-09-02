/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ep2;

import grafo.Arco;
import grafo.Grafo;
import grafo.Vertice;
import grafo.ComparatorVertice;
import util.LerGrafoTXT;

/**
 *
 * @author charleshenriqueportoferreira
 */
public class EP2 {

    /**
     * @param args the command line arguments
     */
    static int tempoAtual = 0;

    public static void main(String[] args) {
        LerGrafoTXT leGrafo = new LerGrafoTXT();
        Grafo grafo = leGrafo.LerArquivo("grafo2a.txt");
        DFS(grafo, false);
        transpoeGrafo(grafo);
        grafo.getVertices().sort(new ComparatorVertice());
        System.out.println();
        tempoAtual = 0;
        System.out.println("Componentes Fortemente Conectados");
        DFS(grafo, true);
        System.out.println();
    }

    public static void DFS(Grafo G, boolean imprimeBusca) {
        for (Vertice vertice : G.getVertices()) {
            vertice.setCor("Branco");
        }

        for (Vertice vertice : G.getVertices()) {
            if (vertice.getCor().equals("Branco")) {
                visitaDFS(G, vertice, imprimeBusca);
            }
        }

    }

    private static void visitaDFS(Grafo G, Vertice vertice, boolean imprimeBusca) {
        tempoAtual += 1;
        vertice.setDistancia(tempoAtual);
        if (imprimeBusca) {
            System.out.printf(" ( " + vertice.getNome());
        }
        vertice.setCor("Cinza");
        for (Arco arco : vertice.getArcos()) {
            Vertice verticeAdjacente = arco.getVerticeDestino();
            if (verticeAdjacente.getCor().equals("Branco")) {
                visitaDFS(G, verticeAdjacente, imprimeBusca);
            }
        }
        tempoAtual += 1;
        vertice.setFinalizacao(tempoAtual);
        if (imprimeBusca) {
            System.out.printf(" " + vertice.getNome() + " )");
        }
        vertice.setCor("Preto");
    }

    public static void transpoeGrafo(Grafo G) {
        for (Arco arco : G.getArcos()) {
            Vertice vOrigem = arco.getVerticeOrigem();
            Vertice vDestino = arco.getVerticeDestino();
            arco.setVerticeOrigem(arco.getVerticeDestino());
            arco.setVerticeDestino(vOrigem);
            vDestino.addArco(arco);
        }
    }

}
