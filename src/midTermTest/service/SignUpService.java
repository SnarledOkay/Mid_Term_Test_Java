package midTermTest.service;

import midTermTest.entities.Account;

import java.util.ArrayList;
import java.util.Scanner;

public class SignUpService {
    SignInService signInService = new SignInService() ;
    public Account signUp(Scanner scanner){
        boolean status = true ;
        System.out.println("Enter new username: ");
        String username = scanner.nextLine() ;
        while(signInService.findUserByUsername(username) != null){
            username = scanner.nextLine() ;
        }
        System.out.println("Enter new email: ");
        String email = scanner.nextLine() ;
        while (signInService.findUserByEmail(email) != null){
            email = scanner.nextLine() ;
        }
        System.out.println("Enter new password: ");
        String password = scanner.nextLine() ;
        while (!checkPasswordForm(password)){
            password = scanner.nextLine() ;
        }

        return new Account(username,password,email) ;
    }

    public boolean checkPasswordForm(String password){
        int capital = 0, special = 0 ;
        if(password.length() < 7 || password.length() > 15){
            return false ;
        }
        else{
            for(int i = 0 ; i < password.length() ; i++){
                if(password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') capital++ ;
                if(password.charAt(i) == '.' || password.charAt(i) == ',' || password.charAt(i) == '-' || password.charAt(i) == '_' || password.charAt(i) == ';') special++ ;
            }
            if(capital != 0 && special != 0) return true ;
        }
        return false ;
    }
}
