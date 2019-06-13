/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.dataAcessObject;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import mvc.model.valueObject.Passos;

/**
 *
 * @author ld_si
 */
 public class PassosDAO {

        /**
         * Metodo que recebe todos os passos (lista) e salva todos em um arquivo
         * @param passos
         * @throws FileNotFoundException 
         */
        public void salvarPassos(List<Passos> passos) throws FileNotFoundException{
            PrintWriter pw = new PrintWriter("passos.txt");
            for (Passos p : passos){
                pw.print(p);   
            }
            pw.flush();
            pw.close();
        }
    }
