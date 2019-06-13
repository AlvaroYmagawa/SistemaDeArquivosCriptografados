
import mvc.controller.ControllerPrincipal;
import mvc.model.businessObject.OrdenacaoBO;
import mvc.model.valueObject.Ordenacao;
import mvc.view.FramePrincipal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ld_si
 */
public class MVC {
    public static void main(String[] args) {
        FramePrincipal framePrincipal = new FramePrincipal();
        new ControllerPrincipal(framePrincipal);
        framePrincipal.setVisible(true);
    }
}
