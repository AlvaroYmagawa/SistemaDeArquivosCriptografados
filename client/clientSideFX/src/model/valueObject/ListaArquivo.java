/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.valueObject;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Kenzo
 */
public class ListaArquivo {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty nome;
    private final SimpleStringProperty url;

    public ListaArquivo(int id, String nome, String url) {
        super();
        this.id = new SimpleIntegerProperty(id);
        this.nome = new SimpleStringProperty(nome);
        this.url = new SimpleStringProperty(url);
    }

    public SimpleIntegerProperty getId() {
        return id;
    }

    public SimpleStringProperty getNome() {
        return nome;
    }

    public SimpleStringProperty getUrl() {
        return url;
    }

   
    
    
            
   
}
