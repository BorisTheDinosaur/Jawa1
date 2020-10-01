package ProductList;


import java.math.BigDecimal;
import java.util.*;

public class ProductList {
    private final HashMap<Integer, Product> map = new HashMap<Integer, Product>();



    public boolean addProduct(String name, int rubles, int pennies) {
        for (int i = 0; i <= map.size() - 1; i++) {
            if (!map.containsKey(i)) continue;
            if (map.get(i).getName().equals(name)) return false;
        }
        map.put(map.size(), new Product(name, rubles, pennies));
        return true;
    }

    public boolean addProduct(int code, String name, int rubles, int pennies) {
        if (code < 0) throw new IllegalArgumentException();
        if (map.containsKey(code)) return false;
        map.put(code, new Product(name, rubles, pennies));
        return true;
    }



    public boolean delete(String name) {
        for (int i = 0; i <= map.size() - 1; i++) {
            if (map.get(i).getName().equals(name)){
                map.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean delete(int code) {
        if (map.containsKey(code)) {
            map.remove(code);
            return true;
        }
        return false;
    }



    public boolean changeName(String oldName, String newName){
        for (int i = 0; i <= map.size() - 1; i++) {
            if (map.get(i).getName().equals(oldName) && map.get(i) != null){
                map.get(i).setName(newName);
                return true;
            }
        }
        return false;
    }

    public boolean changeName(int code, String newName){
        if (map.containsKey(code)) {
            map.get(code).setName(newName);
            return true;
        }
        return false;
    }



    public boolean changeCost(String name, int rubles, int pennies){
        if (rubles < 0 || pennies < 0) throw new IllegalArgumentException();
        for (int i = 0; i <= map.size() - 1; i++) {
            if (map.get(i).getName().equals(name)){
                map.get(i).setRubles(rubles);
                map.get(i).setPennies(pennies);
                return true;
            }
        }
        return false;
    }

    public boolean changeCost(int code, int rubles, int pennies){
        if (rubles < 0 || pennies < 0) throw new IllegalArgumentException();
        if (map.containsKey(code)) {
            map.get(code).setRubles(rubles);
            map.get(code).setPennies(pennies);
            return true;
        }
        return false;
    }



    public BigDecimal costDetermine(int code, int amount) {
        if (amount < 0) throw new IllegalArgumentException();
        if (map.containsKey(code)) {
            BigDecimal rubles = BigDecimal.valueOf(map.get(code).getRubles());
            BigDecimal pennies = BigDecimal.valueOf(map.get(code).getPennies()).divide(BigDecimal.valueOf(100));
            return rubles.add(pennies).multiply(BigDecimal.valueOf(amount));
        }
        throw new IllegalArgumentException();
    }

    public Double costDetermine(HashMap<Integer, Integer> costs) {
        double res = 0.0;
        Set<HashMap.Entry<Integer, Integer>> set = costs.entrySet();
        for (HashMap.Entry<Integer, Integer> pair: set) {
            res += this.costDetermine(pair.getKey(), pair.getValue()).doubleValue();
        }
        return res;
    }

    private HashMap getMap() {return map;}


    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        int i = 0;
        while (i <= map.size() - 1) {
            if (!map.containsKey(i)) continue;
            String str = String.format("%02d", map.get(i).getPennies());
            res.append(map.get(i).getName()).append("\t\t").append(map.get(i).getRubles()).append(",").append(str).append(System.lineSeparator());
            i++;
        }
        return res.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (null == obj || this.getClass() != obj.getClass()) return false;
        return map.equals(((ProductList) obj).getMap());
    }

    @Override
    public int hashCode() {
        return Objects.hash(map);
    }

}
