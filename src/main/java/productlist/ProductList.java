package productlist;

import java.util.*;

public class ProductList {
    private Map<Integer, Product> map = new HashMap<Integer, Product>();

    public boolean addProduct(String name, int rubles, int pennies) {
        for (int i = 0; i <= map.size() - 1; i++) {
            if (map.get(i).getName().equals(name)) return false;
        }
        map.put(map.size(), new Product(name, rubles, pennies));
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

    public boolean changeName(String oldName, String newName){
        for (int i = 0; i <= map.size() - 1; i++) {
            if (map.get(i).getName().equals(oldName)){
                map.get(i).setName(newName);
                return true;
            }
        }
        return false;
    }

    public boolean changeCost(String name, int rubles, int pennies){
        for (int i = 0; i <= map.size() - 1; i++) {
            if (map.get(i).getName().equals(name)){
                map.get(i).setRubles(rubles);
                map.get(i).setPennies(pennies);
                return true;
            }
        }
        return false;
    }

    public double costDetermine(int code, int amount){
        Set<Map.Entry<Integer, Product>> set = map.entrySet();
        int i = 0;
        for (Map.Entry<Integer, Product> pair : set) {
            if (code == pair.getKey()) {
                return ((double) map.get(i).getRubles() + (double) map.get(i).getPennies() / 100) * amount;
            }
            i++;
        }
        return 0.0;
    }



    public int size() {
        int x = Math.max(map.size(), map.size());
        return x;
    }

    public void print(){
        for (int i = 0; i <= map.size() - 1; i++) {
            if (map.get(i) != null) {
                System.out.print(map.get(i).getName() + "\t\t" + map.get(i).getRubles() + ",");
                System.out.format("%02d%n", map.get(i).getPennies());
            }
        }
    }



    public static void main(String[] args) {
        ProductList map = new ProductList();
        map.addProduct("Milk", 29, 99);
        map.addProduct("Soda", 59, 0);
        map.addProduct("Water", 35, 49);
        map.addProduct("Icecream",  140, 0);
        map.addProduct("Fish", 299, 99);
        map.changeName("Milk", "Juice");
        map.delete("Icecream");
        map.changeCost("Water", 100, 0);
        //map.changeName("ggg", "ppp");
        System.out.println(map.costDetermine(0, 5));
        System.out.println(map.size());
        map.print();


        Map<Integer, Integer> map1 = new LinkedHashMap<Integer, Integer>();
        map1.put(map.size(), 50);
        System.out.println(map1);
    }

}
