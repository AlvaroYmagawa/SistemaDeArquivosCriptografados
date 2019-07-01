/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import view.Main;
import view.basic.TableModelItem;

/**
 *
 * @author ld_si
 */
public class ControllerMain extends Controller{

    private Main main;
    private TableModelItem tmItem;
    protected int selected;


    public ControllerMain(Main main) {
        this.main = main;
//
//        tmItem = new TableModelItem();
//        tmItem.loadTableModelRowsValues();
//        tmProvider = new TableModelProvider();
//        tmProvider.loadTableModelRowsValues();
        
//        try {
//            itens = ItemDAO.readItem();
//        } catch (IOException ex) {
//            System.out.println("Erro controllerMain - "+ex.getMessage());
//        }
//        
    
        main.getjButtonCompartilhar().addActionListener(this);
        this.main.getjTable().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        
        main.getjButtonAdicionar().addActionListener(this);
       
        
        ControllerHead.add(this.main.getHead(), this.main);
        add(main.getjButtonCompartilhar());
        add(main.getjButtonAdicionar());
//        
//        new ControllerSearch(main.getjTextFieldSearch(),
//                this.main.getjTable());

        this.main.getjTable().setModel(tmItem);
        //this.main.getjTable().hideColumn("Descrição");

        this.main.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.main.getjButtonCompartilhar()) {
//            System.out.println("Insert");
//            switch(this.main.getjComboBoxType().getSelectedItem().toString()){
//                case "Produtos":
//                    InsertItem insert = new InsertItem();
//                    insert.getHead().getbMinimize().setEnabled(false);
//                    insert.getjButtonDelete().setEnabled(false);
//                    insert.getjButtonDelete().setBorder(insert.getjButtonDelete().border.grey);
//                    new ControllerInsertItem(insert, this.main, this, ControllerInsertItem.NEW);
//                    this.main.setEnabled(false);
//                    insert.setVisible(true);
//                    break;
//                case "Fornecedor":
//                    InsertProvider insertProvider = new InsertProvider();
//                    insertProvider.setVisible(true);
//                    new ControllerInsertProvider(insertProvider, this.main);
//                    this.main.setEnabled(false);
//                    break;
//            }
        }

        if (e.getSource() == this.main.getjButtonAdicionar()) {
//            System.out.println("Edit");
//            switch(this.main.getjComboBoxType().getSelectedItem().toString()){
//                case "Produtos":
//                    InsertItem insert = new InsertItem();
//                    insert.getHead().getbMinimize().setEnabled(false);
//                    new ControllerInsertItem(insert, this.main, this, ControllerInsertItem.EDIT);
//                    this.main.setEnabled(false);
//                    insert.setVisible(true);
//                    break;
//                case "Fornecedor":
//                    InsertProvider insertProvider = new InsertProvider();
//                    insertProvider.setVisible(true);
//                    new ControllerInsertProvider(insertProvider, this.main);
//                    this.main.setEnabled(false);
//                    break;
//            }
        }
    }

    private void tableMouseClicked(MouseEvent e) {
        selected = this.main.getjTable().getSelectedRow();
        System.out.println("Indice selecionado: " + selected);

        if (e.getClickCount() == 2 && !e.isConsumed()) {
            e.consume();
            this.main.getjButtonAdicionar().doClick();
        }
    }
   
}
