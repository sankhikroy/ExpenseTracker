abstract class Account {
private double balance;
public Account(double balance){
    this.balance=balance;
}

    public double getBalance() {
        return balance;
    }
    protected void setBalance(double balance){
    this.balance=balance;
    }
    public void deduction( double pay) {
        if (balance > pay) {
            balance = balance - pay;
            System.out.println("Paid=" + pay);
            System.out.println("Remaining Balance" + balance);
        }
    }
}
