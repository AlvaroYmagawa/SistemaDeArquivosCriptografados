/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import mvc.model.businessObject.OrdenacaoBO;
import mvc.model.valueObject.Ordenacao;
import mvc.view.DialogGerarNumero;
import mvc.view.FramePrincipal;

/**
 *
 * @author ld_si
 */
public class ControllerPrincipal implements ActionListener, ChangeListener {

    private FramePrincipal framePrincipal;
    private DialogGerarNumero dialogGerarNumero;

    /**
     * Construtor<br>Recebe o objeto da FramePrincipal para 'observer' seu comportamento,
     * tratar os eventos e redirecionar para a model.
     * @param framePrincipal 
     */
    public ControllerPrincipal(FramePrincipal framePrincipal) {
        this.framePrincipal = framePrincipal;
        //Definindo os listeners para os botoes dessa view.
        this.framePrincipal.getBtGerarNumero().addActionListener(this);
        this.framePrincipal.getBtOrdernarNumero().addActionListener(this);
    }

    //Evento de acao, pressionar um botao ou um [Enter] em inputs     
    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * Se for o pressionar do botao 'Gerar Numero' da FrameMain, instancia uma
         * DialogGerarNumero
         */
        if (e.getSource() == this.framePrincipal.getBtGerarNumero()) {

            //Instanciando a DialogGerarNumero             
            this.dialogGerarNumero = new DialogGerarNumero();
            this.dialogGerarNumero.getSlNumeroMaximo().setValue( Integer.parseInt(this.framePrincipal.getTfNumeroMaximo().getText()));

            //Registrando os listeners do Dialog            
            this.dialogGerarNumero.getBtGerar().addActionListener(this);
            this.dialogGerarNumero.getBtGerarOrdenar().addActionListener(this);
            this.dialogGerarNumero.getSlNumeroMaximo().addChangeListener(this);
            this.dialogGerarNumero.setVisible(true);
            //Destruo o Dialog
            this.dialogGerarNumero = null;

        } else if (this.dialogGerarNumero != null) {            
            //Eventos do DialogGerarNumero
            if (e.getSource() == this.dialogGerarNumero.getBtGerar()) {
                gerarNumero();
            }
            else if (e.getSource() == this.dialogGerarNumero.getBtGerarOrdenar()){
                gerarNumero();
                ordenarNumero();
            }
        }
        else if (e.getSource() == this.framePrincipal.getBtOrdernarNumero()){
            ordenarNumero();
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (this.dialogGerarNumero != null) {
            /**
             * A medida que o Slider eh arrastado, o campo equivalente na FramePrincipal
             * tem seu valor alterado
             */
            if (e.getSource() == this.dialogGerarNumero.getSlNumeroMaximo()) {
                this.framePrincipal.getTfNumeroMaximo().setText( String.valueOf(this.dialogGerarNumero.getSlNumeroMaximo().getValue()));
            }
        }
    }

    /**
     * Metodo responsavel em controlar a acao de ordenacao. Redireciona para a Model
     */
    private void ordenarNumero(){

        //Manda ordenar e recebe uma Ordenacao como resultado do processo.         
        Ordenacao ordenacao = new OrdenacaoBO().bubbleSort( Integer.parseInt(this.framePrincipal.getTfNumeroGerado().getText()));

        //Atualiza a view com o resultado         
        this.framePrincipal.getTfNumeroOrdenado().setText( String.valueOf(ordenacao.getNumeroOrdenado()));
        this.framePrincipal.getTfQtdeTrocas().setText( String.valueOf(ordenacao.getQtdeTrocas()));
    }    
    /**
     * Metodo que limpa os campos que contem valores resultados de uma ordenacao
     */
    private void limparDadosOrdenacaoAnterior() {
        this.framePrincipal.getTfNumeroOrdenado().setText(null);
        this.framePrincipal.getTfQtdeTrocas().setText(null);
    }

    /**
     * Metodo que gera um numero randomico e atualiza a view.<br>
     * Executa logo apos o pressionar do botao 'Gerar' do DialogGerarNumero
     */
    private void gerarNumero() {
        limparDadosOrdenacaoAnterior();

        //Fecha o DialogGerarNumero        
        this.dialogGerarNumero.setVisible(false);

        //Atualiza o numero na FramePrincipal         
        this.framePrincipal.getTfNumeroGerado().setText(String.valueOf((int) (Math.random() * this.dialogGerarNumero.getSlNumeroMaximo().getValue())));

        //Destroi a DialogGerarNumero         
        this.dialogGerarNumero = null;

        //Habilita o botao 'Ordenar' da FramePrincipal
        this.framePrincipal.getBtOrdernarNumero().setEnabled(true);
    }
}
