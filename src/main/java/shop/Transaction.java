package shop;

public interface Transaction {
    void execute(Cart cart, boolean thereOrBack);
}
