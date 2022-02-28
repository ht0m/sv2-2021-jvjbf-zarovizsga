package shipping;

import java.util.*;

public class ShippingService {
    List<Transportable> packages = new ArrayList<>();

    public void addPackage(Transportable transportable) {
        if (transportable != null) {
            packages.add(transportable);
        }
    }

    public List<Transportable> collectItemsByBreakableAndWeight(boolean breakable, int weight) {
        return packages.stream()
                .filter(transportable -> transportable.isBreakable() == breakable)
                .filter(transportable -> transportable.getWeight() >= weight)
                .toList();
    }

    public Map<String, Integer> collectTransportableByCountry() {
        Map<String, Integer> result = new HashMap<>();
        for (Transportable actual : packages) {
            String key = actual.getDestinationCountry();
            if (!result.keySet().contains(key)) {
                result.put(key, 0);
            }
            int value = result.get(key);
            result.put(key, value + 1);
        }
        return result;
    }

    public List<Transportable> sortInternationalPackagesByDistance() {
        List<InternationalPackage> temp = new ArrayList<>();
        for (Transportable actual : packages) {
            if (actual instanceof InternationalPackage) {
                temp.add((InternationalPackage) actual);
            }
        }
        Collections.sort(temp, Comparator.comparing(InternationalPackage::getDistance));
        List<Transportable> result = new ArrayList<>();
        for (InternationalPackage actual: temp) {
            result.add(actual);
        }
        return result;
    }


    public List<Transportable> getPackages() {
        return new ArrayList<>(packages);
    }
}

