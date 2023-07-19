package controller;

import GUI.GUI;
import database.Database;
import entity.Account;
import entity.CurrentAccount;
import entity.Customer;
import entity.SavingAccount;
import util.StringDealer;

import javax.xml.crypto.Data;
import java.util.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class AccountController {
    private final StringDealer stringDealer = new StringDealer();

    public String addAccount(Scanner scanner) {
        Database database = new Database();
        Account account = null;

        GUI gui = new GUI();
        gui.displayCustomer(database.getAllCustomer());

        int customerId;
        Customer customer;
        System.out.println("Please choose customer to open account");
        do {
            customerId = stringDealer.validateInteger("Please enter valid customer's id", scanner.nextLine());
            customer = database.searchCustomerById(customerId);
            if (customer == null) {
                System.out.println("This customer doesn't exist! Please re-enter customer's number");
                ;
            }
        } while (customer == null);

        int accountType = -1;
        do {
            System.out.println("Please choose account to create");
            System.out.println("1: Current account");
            System.out.println("2: Saving account");
            accountType = stringDealer.validateInteger(scanner.nextLine(), "Please enter 1 or 2 to choose account type");
        } while (accountType != 1 && accountType != 2);

        float balance;
        do {
            System.out.println("Please enter account balance");
            balance = stringDealer.validateFloat(scanner.nextLine(), "Please enter valid balance number!");
        } while (balance < 0);

        System.out.println("Please enter description");
        String description = scanner.nextLine();
        description = stringDealer.trimMax(description);

        System.out.println("Please enter account title");
        String account_title = stringDealer.trimMax(scanner.nextLine());

        System.out.println("Please enter account status");
        String status = stringDealer.trimMax(scanner.nextLine());

        if (accountType == 2) {
            float interest = -1F;
            do {
                System.out.println("Please enter interest (%)");
                interest = stringDealer.validateFloat(scanner.nextLine(), "Please enter valid interest!");

            } while (interest < 0);

            Date startDate = null;
            do {
                System.out.println("Please enter start date! (YYYY-MM-DD)");
                startDate = stringDealer.convertStringToDate(scanner.nextLine(), "Please enter valid date!)");
            } while (startDate == null);

            Date endDate = null;
            do {
                System.out.println("Please enter end date! (YYYY-MM-DD)");
                endDate = stringDealer.convertStringToDate(scanner.nextLine(), "Please enter valid date!)");
            } while (endDate == null);
            account = new SavingAccount("0", balance, description, customerId, customer.getName()
                    , account_title, status, interest, startDate, endDate);
        } else {
            account = new CurrentAccount("0", balance, description, customerId, customer.getName()
                    , account_title, status);
        }

        database.addAccount(account);
        return "Add saving account successful!";
    }

    public String editSavingAccount(Scanner scanner) {
        Database database = new Database();
        ArrayList<SavingAccount> accountArrayList = database.getAllSavingAccount();

        GUI gui = new GUI();
        gui.displayAllSavingAccount(accountArrayList);
        String accountNumber;
        Account editAccount;
        do {
            System.out.println("Please enter account's number");
            accountNumber = stringDealer.trimMax(scanner.nextLine());
            editAccount = database.findAccountByNumber(accountNumber);
            if (editAccount == null) {
                System.out.println("Account number doesn't exist");
            }
        } while (editAccount == null);

        System.out.println("Please enter account balance");
        float balance;
        do {
            balance = stringDealer.validateFloat(scanner.nextLine(), "Please enter valid balance number!");
        } while (balance < 0);

        System.out.println("Please enter description");
        String description = scanner.nextLine();
        description = stringDealer.trimMax(description);

        System.out.println("Please enter account title");
        String account_title = stringDealer.trimMax(scanner.nextLine());

        System.out.println("Please enter account status");
        String status = stringDealer.trimMax(scanner.nextLine());

        float interest = -1F;
        do {
            System.out.println("Please enter interest (%)");
            interest = stringDealer.validateFloat(scanner.nextLine(), "Please enter valid interest!");

        } while (interest < 0);

        Date startDate = null;
        do {
            System.out.println("Please enter start date! (YYYY-MM-DD)");
            startDate = stringDealer.convertStringToDate(scanner.nextLine(), "Please enter valid date!)");
        } while (startDate == null);

        Date endDate = null;
        do {
            System.out.println("Please enter end date! (YYYY-MM-DD)");
            endDate = stringDealer.convertStringToDate(scanner.nextLine(), "Please enter valid date!)");
        } while (endDate == null);

        Account account = new SavingAccount(editAccount.getNumber(), balance, description, editAccount.getCustomerId(), editAccount.getCustomerName()
                , account_title, status, interest, startDate, endDate);
        database.editSavingAccount(account);
        return "Edit saving account successful!";
    }

    public String editMainAccount(Scanner scanner) {
        Database database = new Database();
        ArrayList<CurrentAccount> currentAccounts = database.getAllCurrentAccount();

        GUI gui = new GUI();
        gui.displayAllCurrentAccount(currentAccounts);
        String accountNumber;
        Account editAccount;
        do {
            System.out.println("Please enter account's number");
            accountNumber = stringDealer.trimMax(scanner.nextLine());
            editAccount = database.findAccountByNumber(accountNumber);
            if (editAccount == null) {
                System.out.println("Account number doesn't exist");
            }
        } while (editAccount == null);

        System.out.println("Please enter account balance");
        float balance;
        do {
            balance = stringDealer.validateFloat(scanner.nextLine(), "Please enter valid balance number!");
        } while (balance < 0);

        System.out.println("Please enter description");
        String description = scanner.nextLine();
        description = stringDealer.trimMax(description);

        System.out.println("Please enter account title");
        String account_title = stringDealer.trimMax(scanner.nextLine());

        System.out.println("Please enter account status");
        String status = stringDealer.trimMax(scanner.nextLine());

        Account account = new CurrentAccount(editAccount.getNumber(), balance, description, editAccount.getCustomerId(), editAccount.getCustomerName(), account_title, status);
        database.editSavingAccount(account);
        return "Edit current account successful!";
    }

    public String removeAccount(Scanner scanner) {
        Database database = new Database();
        ArrayList<Account> accounts = database.getAllAccount();

        GUI gui = new GUI();
        gui.displayAllAccount(accounts);

        Account removeAccount;
        do {
            System.out.println("Please enter account number to be remove");
            removeAccount = database.findAccount(scanner.nextLine().trim());
            if (removeAccount == null) System.out.println("Account doesn't exist");
        } while (removeAccount == null);

        boolean check = database.removeAccount(removeAccount);
        if (check) {
            return "Remove account successful";
        } else {
            return "Remove account not successful";
        }
    }
}
