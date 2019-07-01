/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.basic;

import javax.swing.table.TableModel;

/**
 *
 * @author ld_si
 */
public class Table extends javax.swing.JTable{

    public Table() {
    }

    public Table(TableModel dm) {
        super(dm);
    }
    
    public void hideColumn(String columnName) {
        switch (columnName) {
            case "Descrição":
                getColumn("Descrição").setMinWidth(0);
                getColumn("Descrição").setPreferredWidth(0);
                getColumn("Descrição").setMaxWidth(0);
                break;
        }
    }   
}
