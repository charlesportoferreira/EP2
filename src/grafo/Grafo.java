/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author charleshenriqueportoferreira
 */
public class Grafo {

    List<Vertice> vertices;
    List<Arco> arcos;

    public Grafo(List<Vertice> vertices, List<Arco> arcos) {
        this.vertices = vertices;
        this.arcos = arcos;
    }

    public Grafo() {
        vertices = new ArrayList<>();
        arcos = new ArrayList<>();
    }

    public void addVertice(Vertice vertice) {
        this.vertices.add(vertice);
    }

    public void addArco(Arco arco) {
        this.arcos.add(arco);
    }
    
    public List<Vertice> getVertices(){
        return this.vertices;
    }

    public List<Arco> getArcos() {
        return arcos;
    }
    
    
}
