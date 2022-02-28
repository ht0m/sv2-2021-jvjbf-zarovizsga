package shipping;

public class NationalPackage implements Transportable {

    private static final int FIXED_PRICE = 1000;

    private int weight;

    private boolean breakable;

    public NationalPackage(int weight, boolean breakable) {
        this.weight = weight;
        this.breakable = breakable;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public boolean isBreakable() {
        return breakable;
    }

    @Override
    public int calculateShippingPrice() {
        return isBreakable() ? FIXED_PRICE * 2 : FIXED_PRICE;
    }
}
