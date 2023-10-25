/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import common.Library;
import common.Validate;
import java.util.Locale;
import view.Menu;

/**
 *
 * @author DELL
 */
public class BankManager extends Menu<String>{

    Library library = new Library();
    Validate validate = new Validate();
    Locale vietnamese = new Locale("vi");
    Locale english = Locale.US;
    
    static String[] mc = {"Vietnamese", "English","Exit"};
    public BankManager(){
        super("TienPhong Bank", mc);
    }
    @Override
    public void executed(int n) {
        switch (n) {
            case 1:
                library.login(vietnamese);
                break;
            case 2:
                library.login(english);
                break;
            case 3:
                System.out.println("End program");
                System.exit(0);
            default:
                throw new AssertionError();
        }
    }

    
}
