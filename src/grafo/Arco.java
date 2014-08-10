/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

/**
 *
 * @author charleshenriqueportoferreira
 */
public class Arco {

    private Vertice verticeOrigem;
    private Vertice verticeDestino;
    private double peso;
    private int id;

    public Arco(Vertice verticeOrigem, Vertice verticeDestino, double peso) {
        this.verticeOrigem = verticeOrigem;
        this.verticeDestino = verticeDestino;
        this.peso = peso;
    }

    public Arco(Vertice verticeOrigem, Vertice verticeDestino, double peso, int id) {
        this.verticeOrigem = verticeOrigem;
        this.verticeDestino = verticeDestino;
        this.peso = peso;
        this.id = id;
    }

    
    
    
    public Vertice getVerticeOrigem() {
        return verticeOrigem;
    }

    public void setVerticeOrigem(Vertice verticeOrigem) {
        this.verticeOrigem = verticeOrigem;
    }

    public Vertice getVerticeDestino() {
        return verticeDestino;
    }

    public void setVerticeDestino(Vertice verticeDestino) {
        this.verticeDestino = verticeDestino;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   

}
