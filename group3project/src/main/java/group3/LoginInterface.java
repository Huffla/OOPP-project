package group3;

public interface LoginInterface {
    public void addObserver(LoginObserver lo);

    public void createUser(String name, int password);
}
