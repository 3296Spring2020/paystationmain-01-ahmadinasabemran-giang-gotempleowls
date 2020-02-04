import java.util.Map;

public interface PayStation {

    public void addPayment(int coinValue) throws IllegalCoinException;

    public int readDisplay();

    public Receipt buy();

    public Map<Integer, Integer> cancel();

    public int empty();

}
