public class Account<T> {

    private T accountType;
    public void add(T newType) {accountType = newType;}
    public T get() {return accountType;}

}
