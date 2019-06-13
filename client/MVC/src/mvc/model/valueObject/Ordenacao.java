/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.valueObject;

/**
 *
 * @author ld_si
 */
public class Ordenacao {

    private int numeroOriginal;
    private String numeroOrdenado;
    private int qtdeTrocas;

    /**
     * Construtor padrao que insere em todos os atributos do objeto
     * @param numeroOriginal
     * @param numeroOrdenado
     * @param qtdeTrocas 
     */
    public Ordenacao(int numeroOriginal, String numeroOrdenado, int qtdeTrocas) {
        this.numeroOriginal = numeroOriginal;
        this.numeroOrdenado = numeroOrdenado;
        this.qtdeTrocas = qtdeTrocas;
    }

    //Get and Set
    public String getNumeroOrdenado() {
        return numeroOrdenado;
    }

    public void setNumeroOrdenado(String numeroOrdenado) {
        this.numeroOrdenado = numeroOrdenado;
    }

    public int getNumeroOriginal() {
        return numeroOriginal;
    }

    public void setNumeroOriginal(int numeroOriginal) {
        this.numeroOriginal = numeroOriginal;
    }

    public int getQtdeTrocas() {
        return qtdeTrocas;
    }

    public void setQtdeTrocas(int qtdeTrocas) {
        this.qtdeTrocas = qtdeTrocas;
    }

    //Sobrescrevendo o toString do objeto
    @Override
    public String toString() {
        return 
                String.valueOf(this.numeroOriginal)
                .concat(" virou:\n")
                .concat(String.valueOf(this.numeroOrdenado))
                .concat("\nQtde de trocas: ")
                .concat(String.valueOf(this.qtdeTrocas));
    }
}
