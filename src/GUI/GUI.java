package GUI;

import entity.Account;
import entity.CurrentAccount;
import entity.Customer;
import entity.SavingAccount;

import java.util.ArrayList;

public class GUI {
    public void displayCustomer(ArrayList<Customer> customerArrayList){
        System.out.printf("%-4d%-24d%-20%-11%-24d%-15d\n","ID" , "Customer's name", "Email", "Phone number", "Username", "Card number");
        for (Customer customer: customerArrayList
             ) {
            System.out.printf("%-4d%-24d%-20%-11%-24d%-15d\n", customer.getId(), customer.getName(), customer.getEmail(), customer.getPhoneNo(), customer.getUsername(),customer.getCardNo());
        }
    }

    public void displayCustomer(Customer customer){
        System.out.printf("%-4d%-24d%-20%-11%-24d%-15d\n","ID" , "Customer's name", "Email", "Phone number", "Username", "Card number");
        System.out.printf("%-4d%-24d%-20%-11%-24d%-15d\n", customer.getId(), customer.getName(), customer.getEmail(), customer.getPhoneNo(), customer.getUsername(),customer.getCardNo());
    }

    public void displayAllAccount(ArrayList<Account> accountArrayList){
        for (Account account: accountArrayList
             ) {
            System.out.printf("%-14s%-24s%-20s%-50s\n","Account Number" , "Customer's name", "Balance", "Description");
            System.out.printf("%-14s%-24s%-20f%-50s\n", account.getNumber(), account.getCustomerName(), account.getBalance(), account.getDescription());
        }
    }
    public void displayAllSavingAccount(ArrayList<SavingAccount> accountArrayList){
        for (SavingAccount account: accountArrayList
        ) {
            System.out.printf("%-14s%-24s%-20s%-5s%-10s%-10s%-50s\n","Account Number" , "Customer's name", "Balance","Interest","Start date", "End date", "Description");
            System.out.printf("%-14s%-24s%-20f%-5f%-10s%-10s%-50s\n", account.getNumber(), account.getCustomerName()
                    , account.getBalance(), account.getInterest(), account.getStartDate().toString(),account.getEndDate().toString(), account.getDescription());
        }
    }

    public void displayAllCurrentAccount(ArrayList<CurrentAccount> accountArrayList){
        for (CurrentAccount account: accountArrayList
        ) {
            System.out.printf("%-14s%-24s%-20s%-50s\n","Account Number" , "Customer's name", "Balance", "Description");
            System.out.printf("%-14s%-24s%-20f%-50s\n", account.getNumber(), account.getCustomerName(), account.getBalance(), account.getDescription());
        }
    }
}
