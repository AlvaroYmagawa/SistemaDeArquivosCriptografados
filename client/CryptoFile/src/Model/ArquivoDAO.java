/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Kenzo
 */
public class ArquivoDAO {
    
    
    public List<Arquivo> listArq(){
        
        List<Arquivo> list = new ArrayList<>();
        list.add(new Arquivo("1","2","3"));
        list.add(new Arquivo("1","4","3"));
        list.add(new Arquivo("1","5","3"));
        return list;
    }
    
}
