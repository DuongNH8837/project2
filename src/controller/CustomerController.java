package controller;

import database.Database;
import entity.Customer;
import util.StringDealer;
import java.util.ArrayList;

public class CustomerController {
    private final StringDealer stringDealer = new StringDealer();

    public String addCustomer(String name, String email, String phoneNo,String username, String address, String cardNo){
        name = stringDealer.trimMax(name);
        if(name.equals("")) {
            return "Please enter customer's name!";
        }

        email = stringDealer.trimMax(email);
        if(!email.equals("") && stringDealer.checkEmailRegex(email)){
            return "Email is not in right format!";
        }

        phoneNo = stringDealer.trimMax(phoneNo);
        if (phoneNo.equals("")){
            return "Please enter customer's phone number!";
        }

        username = stringDealer.trimMax(username);
        if(username.equals("")) {
            return "Please enter customer's username!";
        }

        address = stringDealer.trimMax(address);
        if(address.equals("")) {
            return "Please enter customer's address!";
        }

        cardNo = stringDealer.trimMax(cardNo);
        if(cardNo.equals("")){
            return "Please enter customer's card number";
        }

        Customer newCustomer = new Customer(0,name,email,phoneNo,username,address,cardNo);
        Database database = new Database();
        database.addCustomer(newCustomer);
        return "Add customer successful!";
    }

    public String editCustomer(int customerId,String name, String email, String phoneNo,String username, String address, String cardNo){
        Database database = new Database();
        Customer customer = database.searchCustomerById(customerId);
        if(customer == null){
            return "This customer doesn't exist";
        }
        name = stringDealer.trimMax(name);
        if(name.equals("")) {
            return "Please enter customer's name!";
        }

        email = stringDealer.trimMax(email);
        if(!email.equals("") && stringDealer.checkEmailRegex(email)){
            return "Email is not in right format!";
        }

        phoneNo = stringDealer.trimMax(phoneNo);
        if (phoneNo.equals("")){
            return "Please enter customer's phone number!";
        }

        username = stringDealer.trimMax(username);
        if(username.equals("")) {
            return "Please enter customer's username!";
        }

        address = stringDealer.trimMax(address);
        if(address.equals("")) {
            return "Please enter customer's address!";
        }

        cardNo = stringDealer.trimMax(cardNo);
        if(cardNo.equals("")){
            return "Please enter customer's card number";
        }

        Customer newCustomer = new Customer(0,name,email,phoneNo,username,address,cardNo);
        database.addCustomer(newCustomer);
        return "Edit customer successful!";
    }

    public String removeCustomer(int customerId){
        Database database = new Database();
        Customer customer = database.searchCustomerById(customerId);
        if(customer == null){
            return "This customer doesn't exist";
        }

        database.removeCustomer(customer);
        return "Remove customer successful!";
    }

    public Customer searchCustomerById(int customerId){
        Database database = new Database();
        Customer customer = database.searchCustomerById(customerId);
        return customer;
    }

    public ArrayList<Customer> searchCustomerByName(String customerName){
        customerName = stringDealer.trimMax(customerName);
        Database database = new Database();
        ArrayList<Customer> customers = database.searchCustomerByName(customerName);
        if (customers.isEmpty()){
            return null;
        }else{
            return customers;
        }
    }
}
