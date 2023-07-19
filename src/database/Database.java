package database;

import entity.Account;
import entity.CurrentAccount;
import entity.Customer;
import entity.SavingAccount;

import java.util.ArrayList;

public class Database {
    private static int customerId = 1;
    private static int accountNumber = 1;
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<Account> accounts = new ArrayList<>();

    public void addCustomer(Customer customer){
        if(customer != null){
            customer.setId(customerId);
            customers.add(customer);
            customerId++;
        }
    }

    public Customer searchCustomerById(int searchId){
        for (Customer customer: customers
             ) {
            if (customer.getId() == searchId) return customer;
        }
        return null;
    }

    public void removeCustomer(Customer customer){
        customers.remove(customer);
    }

    public ArrayList<Customer> searchCustomerByName(String customerName){
        ArrayList<Customer> customerList = new ArrayList<>();
        for (Customer customer: customers
             ) {
            if(customer.getName().equals(customerName)){
                customerList.add(customer);
            }
        }
        return customerList;
    }

    public ArrayList<Customer> getAllCustomer(){
        return customers;
    }

    public void addAccount(Account account){
        if(account != null){
            account.setNumber(String.valueOf(accountNumber));
            accounts.add(account);
            accountNumber++;
        }
    }

    public ArrayList<Account> getAllAccount() {
        return accounts;
    }

    public Account findAccountByNumber(String accountNumber){
        for (Account account: accounts
             ) {
            if(account.getNumber().equals(accountNumber)) return account;
        }
        return null;
    }

    public void editSavingAccount(Account editAccount){
        for (Account account: accounts
             ) {
            if(account instanceof SavingAccount && account.getNumber().equals(editAccount.getNumber())){
                account = editAccount;
            }
        }
    }

    public ArrayList<SavingAccount> getAllSavingAccount(){
        ArrayList<SavingAccount> result = new ArrayList<>();
        for (Account account: accounts
             ) {
            if(account instanceof SavingAccount){
                result.add((SavingAccount) account);
            }
        }
        return result;
    }

    public ArrayList<CurrentAccount> getAllCurrentAccount(){
        ArrayList<CurrentAccount> result = new ArrayList<>();
        for (Account account: accounts
        ) {
            if(account instanceof CurrentAccount){
                result.add((CurrentAccount) account);
            }
        }
        return result;
    }

    public void editCurrentAccount(Account editAccount){
        for (Account account: accounts
             ) {
            if(account instanceof CurrentAccount && account.getNumber().equals(editAccount.getNumber())){
                account = editAccount;
            }
        }
    }

    public Account findAccount(String accountNumber){
        for (Account account: accounts
             ) {
            if(account.getNumber().equals(accountNumber)){
                return account;
            }
        }
        return null;
    }

    public boolean removeAccount(Account account){
        return accounts.remove(account);
    }
}
