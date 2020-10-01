package productlist;

import java.util.Objects;

public class Product {
    private String name;
    private int rubles;
    private int pennies;

    public Product (String name, int rubles, int pennies) {
        this.name = name;
        if (rubles == 0 && pennies == 0) throw new IllegalArgumentException();
        if (rubles >= 0 ) this.rubles = rubles;
        else throw new IllegalArgumentException();
        if (pennies >= 0 ) this.pennies = pennies;
        else throw new IllegalArgumentException();
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

    public void setRubles(Integer rubles) {
        this.rubles = rubles;
    }

    public void setPennies(Integer pennies) {
        this.pennies = pennies;
    }

    @Override
    public String toString() {
        return "Product: name = " + name +  "; rubles = " + rubles + "; pennies = " + pennies;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (null == obj || this.getClass() != obj.getClass()) return false;
        return name.equals(((Product) obj).name) && rubles == ((Product) obj).rubles && pennies == ((Product) obj).pennies;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rubles, pennies);
    }
}
