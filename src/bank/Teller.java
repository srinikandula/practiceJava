package bank;

public interface Teller{
    void createAccount(int accountId,String accName,double amount);

    double getBalance(int accountId);

    void cashDeposit(int accountId, double amount);
}