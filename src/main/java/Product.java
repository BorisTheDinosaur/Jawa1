public class Product {
    private String name;
    private int rubles;
    private int pennies;

    public Product (String name, int rubles, int pennies) {
        this.name = name;
        this.rubles = rubles;
        this.pennies = pennies;

    }

    public String getName() {
        return name;
    }

    public int getRubles() {
        return rubles;
    }

    public int getPennies() {
        return pennies;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRubles(int rubles) {
        this.name = name;
    }

    public void setPennies(int pennies) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
