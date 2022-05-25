package visitor;

public class User {
    private String userName;
    private double many;


    public User(String userName, double many) {
        this.userName = userName;
        this.many = many;
    }

    public double getMany() {
        many = 52.45;
        return many;
    }

    public String getUserName(){
        return userName;
    }

    public void setMany(double many) {
        this.many = many;
    }
}
