package entity;

public class CurrentAccount extends Account{
    private String account_title;
    private String status;

    public CurrentAccount(String number, float balance, String description, int customerId, String customerName, String account_title, String status) {
        super(number, balance, description, customerId, customerName);
        this.account_title = account_title;
        this.status = status;
    }

    public String getAccount_title() {
        return account_title;
    }

    public void setAccount_title(String account_title) {
        this.account_title = account_title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
