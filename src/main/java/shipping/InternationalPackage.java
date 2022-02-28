package shipping;

public class InternationalPackage implements Transportable {

    private static final int DEFAULT_PRICE = 1200;

    private int weight;

    private boolean breakable;

    private String destinationCountry;

    private int distance;


    public InternationalPackage(int weight, boolean breakable, String destinationCountry, int distance) {
        this.weight = weight;
        this.breakable = breakable;
        this.destinationCountry = destinationCountry;
        this.distance = distance;
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
        int kmPrice = distance * 10;
        return isBreakable() ? DEFAULT_PRICE * 2 + kmPrice : DEFAULT_PRICE + kmPrice;
    }

    @Override
    public String getDestinationCountry() {
        return destinationCountry;
    }

    public int getDistance() {
        return distance;
    }

}
