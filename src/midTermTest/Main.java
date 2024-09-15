package midTermTest;

import midTermTest.entities.Account;
import midTermTest.View.Menu;
import midTermTest.service.SignInService;
import midTermTest.service.SignUpService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in) ;
        Menu mainMenu = new Menu() ;
        ArrayList<Account> accountList = new ArrayList<>() ;
        SignUpService signUpService = new SignUpService() ;
        SignInService signInService = new SignInService() ;
        int choice = 1 ;
        do{
            mainMenu.displayMenu(scanner);
            choice = Integer.parseInt(scanner.nextLine()) ;
            if(choice == 1){
                Account targetAccount = signInService.signIn(scanner) ;
                int choiceAccount ;
                do{
                    signInService.logInSuccess(scanner,targetAccount);
                    choiceAccount = Integer.parseInt(scanner.nextLine());
                    signInService.selectPostLogin(scanner,targetAccount,choiceAccount);
                }
                while (choiceAccount != 4) ;
            }
            else if(choice == 2){
                Account newAccount = signUpService.signUp(scanner) ;
                accountList.add(newAccount) ;
            }
        }
        while (choice != 0) ;
    }
}
