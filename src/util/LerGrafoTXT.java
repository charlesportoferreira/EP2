/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import grafo.Arco;
import grafo.Grafo;
import grafo.Vertice;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author charleshenriqueportoferreira
 */
public class LerGrafoTXT {

    public Grafo LerArquivo(String nomeArquivo) {
        Grafo grafo = new Grafo();
        Map<Integer, Vertice> vertices = new HashMap<>(200);
        //List<Vertice> vertices = new ArrayList<>();
        List<Arco> arcos = new ArrayList<>();
        int totalVertices = 0;
        int totalArcos = 0;
        int nrVerticesLidos = 0;
        int idVerticeAtual = 0;

        try {
            //faz a leitura do arquivo
            FileReader fr = new FileReader(nomeArquivo);
            BufferedReader br = new BufferedReader(fr);

            totalVertices = Integer.parseInt(br.readLine());
            //enquanto houver mais linhas
            while (br.ready()) {
                //lê a proxima linha
                String linha = br.readLine();
                Vertice vertice = new Vertice(linha);
                vertice.setId(idVerticeAtual);
                idVerticeAtual++;
                vertices.put(vertice.getId(), vertice);
                nrVerticesLidos++;
                grafo.addVertice(vertice);
                //faz algo com a linha
                //System.out.println(linha);
                if (nrVerticesLidos == totalVertices) {
                    break;
                }
            }

            totalArcos = Integer.parseInt(br.readLine());
            while (br.ready()) {
                String linha = br.readLine();
                String idVerticeOrigem = linha.split(" ")[0];
                String idVerticeDestino = linha.split(" ")[1];
                String peso = linha.split(" ")[2];
                Vertice origem = vertices.get(Integer.parseInt(idVerticeOrigem));
                Vertice destino = vertices.get(Integer.parseInt(idVerticeDestino));
                Arco arco = new Arco(origem, destino, Integer.parseInt(peso));
                origem.addArco(arco);
                grafo.addArco(arco);
               
            }
            br.close();
            fr.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return grafo;
    }
}
