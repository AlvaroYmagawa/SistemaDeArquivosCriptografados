
import control.ControllerLogin;
import view.Login;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ld_si
 */
public class TestLogin {
    public static void main(String[] args) {
        Login login = new Login();
        new ControllerLogin(login);
    }
}
