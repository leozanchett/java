package classes;

public abstract class Account {
    private Integer number;
    private String holder;
    protected Double balance;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public void withDraw(double amount) {
        this.balance -= amount + (amount * 0.10);
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public Account() {

    }

    ;

    public Account(Integer number, String holder, Double balance) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
    }
}
