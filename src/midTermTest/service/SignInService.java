package midTermTest.service;

import midTermTest.data.Database;
import midTermTest.entities.Account;
import midTermTest.View.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class SignInService {
    SignUpService signUpService = new SignUpService() ;
    public Account signIn(Scanner scanner){
        System.out.println("Enter username: ");
        String username = scanner.nextLine() ;

//        Account account = findUserByUsernamePassword(username,password) ;
//        Account account = findUserByUsername(username) ;
        while (findUserByUsername(username) == null){
            System.out.println("Enter username: ");
            username = scanner.nextLine() ;
        }
        Account account = findUserByUsername(username) ;
        System.out.println("Enter password: ");
        String password = scanner.nextLine() ;
        if (checkPassword(password, account)){
            return account ;
        }
        else{
            while (!checkPassword(password,account)){
                System.out.println("Password incorrect");
                System.out.println("1. Enter again ");
                System.out.println("2. Change password");
                int choice = Integer.parseInt(scanner.nextLine());
                if(choice == 1){
                    System.out.println("Enter password again");
                    password = scanner.nextLine() ;
                }
                else{
                    changePassword(scanner,account);
                }
            }
        }
        return  account ;
    }

    public void changePassword(Scanner scanner, Account account){
        System.out.println("Enter your email: ");
        String email = scanner.nextLine() ;
        while(!checkEmail(email,account)){
            System.out.println("Incorrect email, please enter again: ");
            email = scanner.nextLine() ;
        }
        System.out.println("Correct email, please enter new password: ");
        String newPassword = scanner.nextLine() ;
        while (!signUpService.checkPasswordForm(newPassword) || newPassword.equals(account.getPassword())){
            System.out.println("Password not reaching the requirements or same as previous password");
            newPassword = scanner.nextLine() ;
        }
        account.setPassword(newPassword);
    }

    public void logInSuccess(Scanner scanner, Account account){
        System.out.println("Welcome user " + account.getUsername() + " , please select your next step: ");
        System.out.println("1. Change username");
        System.out.println("2. Change email");
        System.out.println("3. Change password");
        System.out.println("4. Log out");
//        selectPostLogin(scanner,account);
    }

    public void selectPostLogin(Scanner scanner, Account account, int choice){
//        int choice = Integer.parseInt(scanner.nextLine()) ;
        switch (choice){
            case 1:
                updateUsername(scanner,account);
                break;
            case 2:
                updateEmail(scanner,account);
                break;
            case 3:
                updatePassword(scanner,account);
                break;
//            case 4:
////                menu.displayMenu(scanner);
//                break;
            case 0:
                System.exit(0);
                break;
        }
    }
    public void updateUsername(Scanner scanner, Account account){
        System.out.println("Enter new username: ");
        String username = scanner.nextLine() ;
        account.setUsername(username);
    }

    public void updateEmail(Scanner scanner, Account account){
        System.out.println("Enter new email: ");
        String email = scanner.nextLine() ;
        account.setEmail(email);
    }

    public void updatePassword(Scanner scanner, Account account){
        System.out.println("Enter new password: ");
        String password = scanner.nextLine() ;
        account.setPassword(password);
    }

    public Account findUserByEmail(String email){
        for (Account account:Database.accountList){
            if(account.getEmail().equals(email)){
                return account ;
            }
        }
        return null ;
    }

    public Account findUserByUsername(String username){
        for (Account account:Database.accountList){
            if(account.getUsername().equals(username)){
                return account ;
            }
        }
        return null ;
    }
    public Account findUserByUsernamePassword(String username, String password){
        for(Account account: Database.accountList){
            if(account.getUsername().equals(username) && account.getPassword().equals(password)){
                return account ;
            }
        }
        return null;
    }

    public boolean checkPassword(String password, Account account){
        if(password.equals(account.getPassword())){
            return true ;
        }
        return false ;
    }
    
    public boolean checkEmail(String email, Account account){
        if(email.equals(account.getEmail())){
            return true ;
        }
        return false ;
    }
}
