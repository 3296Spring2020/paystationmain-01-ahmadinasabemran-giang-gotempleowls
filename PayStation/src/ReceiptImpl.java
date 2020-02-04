public class ReceiptImpl implements Receipt {

    private int value;

    public ReceiptImpl(int value) {

        this.value = value;

    }

    @Override
    public int value() {
        return value;
    }

}
