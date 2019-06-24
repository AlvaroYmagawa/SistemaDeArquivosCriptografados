/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Kenzo
 */
public class ListaArquivo {
    private final SimpleStringProperty nomeArquivo;
    private final SimpleStringProperty hashCode;
    private final SimpleStringProperty dadosArquivo;

    public ListaArquivo(String nomeArquivo, String hashCode, String dadosArquivo) {
        super();
        this.nomeArquivo = new SimpleStringProperty(nomeArquivo);
        this.hashCode = new SimpleStringProperty(hashCode);
        this.dadosArquivo = new SimpleStringProperty(dadosArquivo);
    }

    public String getNomeArquivo() {
        return nomeArquivo.get();
    }

    public String getHashCode() {
        return hashCode.get();
    }

    public String getDadosArquivo() {
        return dadosArquivo.get();
    }
    
    
            
   
}
