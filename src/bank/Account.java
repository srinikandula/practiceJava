package bank;

public class Account{
    int accountId;
    String accountName;
    double balance;

    public void setAccountName(String accountName){
        this.accountName = accountName;
    }
    public void setAccountId(int accountId){
        this.accountId = accountId;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public String toString() {
        return "Account[Name=" + accountName + ",Balance=" + balance +"]";
    }

}