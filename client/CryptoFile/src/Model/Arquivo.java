/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


public class Arquivo {
    private String nomeArquivo;
    private String hashArquivos;
    private String dadoArquivos;

    public Arquivo(String nomeArquivo, String hashArquivos, String dadoArquivos) {
        this.nomeArquivo = nomeArquivo;
        this.hashArquivos = hashArquivos;
        this.dadoArquivos = dadoArquivos;
    }

  
    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public String getHashArquivos() {
        return hashArquivos;
    }

    public void setHashArquivos(String hashArquivos) {
        this.hashArquivos = hashArquivos;
    }

    public String getDadoArquivos() {
        return dadoArquivos;
    }

    public void setDadoArquivos(String dadoArquivos) {
        this.dadoArquivos = dadoArquivos;
    }
}
