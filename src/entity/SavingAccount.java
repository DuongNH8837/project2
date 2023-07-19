package entity;

import java.util.Date;

public class SavingAccount extends Account{
    private String account_title;
    private String status;
    private float interest;
    private Date startDate;
    private Date endDate;

    public SavingAccount(String number, float balance, String description, int customerId, String customerName, String account_title, String status, float interest, Date startDate, Date endDate) {
        super(number, balance, description, customerId, customerName);
        this.account_title = account_title;
        this.status = status;
        this.interest = interest;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
