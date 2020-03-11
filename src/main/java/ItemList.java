import java.util.ArrayList;

public class ItemList{
    private ArrayList item = new ArrayList<Pair<String, Integer>>();
    private ArrayList cost = new ArrayList<Pair<Integer, Integer>>();



    public void addItem(String name, int rubles, int pennies){
        item.add(new Pair(name, item.size()));
        cost.add(new Pair(rubles, pennies));
    }

    public void changeName(String oldName, String newName){
        for (int i = 0; i <= item.size() - 1; i++) {
            if (((Pair) item.get(i)).getL().equals(oldName)){
                ((Pair) item.get(i)).setL(newName);
                break;
            }
        }
    }

    public void changeCost(String name, int rubles, int pennies){
        for (int i = 0; i <= item.size() - 1; i++) {
            if (((Pair) item.get(i)).getL().equals(name)){
                ((Pair) cost.get(i)).setL(rubles);
                ((Pair) cost.get(i)).setR(pennies);
                break;
            }
        }
    }

    public void delete(String name){
        for (int i = 0; i <= item.size() - 1; i++) {
            if (((Pair) item.get(i)).getL().equals(name)){
                item.remove(i);
                cost.remove(i);
                break;
            }
        }
    }

    public Integer costDetermine(int code, int amount){
        for (int i = 0; i <= item.size() - 1; i++) {
            if (((Pair) item.get(i)).getR().equals(code)){
                Integer rubbles = (Integer) ((Pair) cost.get(i)).getL();
                Integer pennies = (Integer) ((Pair) cost.get(i)).getR() / 100;
                return (rubbles + pennies) * amount;
                     //   ((Integer) ((Pair) cost.get(i)).getL() * 100 + (Integer) ((Pair) cost.get(i)).getR()) * amount;
            }
        }
        return 0;
    }


    public int size() {
        int x = Math.max(item.size(), cost.size());
        return x;
    }

    public void print(){
        for (int i = 0; i <= item.size() - 1; i++) {
            System.out.print(((Pair) item.get(i)).getL() + "/" +((Pair) item.get(i)).getR() + "\t\t"
                    + ((Pair) cost.get(i)).getL() + ",");
            System.out.format("%02d%n",((Pair) cost.get(i)).getR());
        }
    }


    public static void main (String[] args) {
        ItemList list = new ItemList();
        list.addItem("Milk",  29, 99);
        list.addItem("Soda", 59, 0);
        list.addItem("Water", 35, 49);
        list.addItem("Icecream",  140, 0);
        list.addItem("Fish", 299, 99);
        list.changeName("Milk", "Juice");
        list.delete("Icecream");
        list.changeCost("Water", 100, 0);
        list.changeName("ggg", "ppp");
        System.out.println(list.costDetermine(0, 5));
        System.out.println(list.size());
        list.print();
    }

}
