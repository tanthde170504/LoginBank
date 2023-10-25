/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Library {
    Scanner sc = new Scanner(System.in);
    Validate validate = new Validate();
    private static final char[] chars = {'1', 'A', 'a', 'B', 'b', 'C',
        'c', '2', 'D', 'd', 'E', 'e', 'F', 'f', '3', 'G', 'g', 'H', 'h',
        'I', 'i', 'J', 'j', 'K', 'k', 'L', 'l', '4', 'M', 'm', 'N', 'n',
        'O', 'o', '5', 'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's', 'T', 't',
        '6', '7', 'U', 'u', 'V', 'v', 'U', 'u', 'W', 'w', '8', 'X', 'x',
        'Y', 'y', 'Z', 'z', '9'};
    public String getValue(String msg){
        System.out.print(msg);
        return sc.nextLine();
    }
    
    public int getIntForMenu(String msg, int min, int max){
        int a = -1;
        while(true){
            System.out.print(msg);
            try {
                a = Integer.parseInt(sc.nextLine());
                if(a >= min && a <= max){
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter a number between " + min + " and " + max);
            }
        }
        return a;
    }
    
    
    public String generateCaptchaText() {
        String randomStrValue = "";
        final int LENGTH = 6;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < LENGTH; i++) {
            index = (int) (Math.random() * (chars.length - 1));
            sb.append(chars[index]);
        }
        return sb.toString();
    }
    
    public void login(Locale language) {
        validate.getWordLanguage(language, "enterAccountNumber");
        int accountNumber = validate.checkInputAccount(language);
        validate.getWordLanguage(language, "enterPassword");
        String passString = validate.checkInputPassword(language);
        String captchaGenerated = generateCaptchaText();
        while (true) {
            if (validate.checkInputCaptcha(captchaGenerated, language)) {
                validate.getWordLanguage(language, "loginSuccess");
                System.out.println();
                return;
            } else {
                validate.getWordLanguage(language, "errCaptchaIncorrect");
                System.out.println();
            }
        }
    }
}
