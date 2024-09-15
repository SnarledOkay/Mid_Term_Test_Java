package midTermTest.View;

import midTermTest.entities.Account;
import midTermTest.service.SignInService;
import midTermTest.service.SignUpService;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    SignInService signInService = new SignInService() ;
    SignUpService signUpService = new SignUpService() ;
    ArrayList<Account> accounts = new ArrayList<>() ;
//    Scanner scanner ;
    public void displayMenu(Scanner scanner){
        System.out.println("1. Log in");
        System.out.println("2. Sign up");
        System.out.println("To turn off the application, please enter 0");
//        selectMenu(scanner,accounts);
    }

    public void selectMenu(Scanner scanner, ArrayList<Account> accounts){
        int choice = Integer.parseInt(scanner.nextLine()) ;
        switch (choice){
            case 0:
                System.out.println("Thank you for using our service!");
                System.exit(0);
                break ;
            case 1:
                Account targetAccount = signInService.signIn(scanner);
                signInService.logInSuccess(scanner,targetAccount);
                break ;
            case 2:
                Account newAccount = signUpService.signUp(scanner) ;
                accounts.add(newAccount) ;
                break ;
        }
    }
}
