package productlist;

import org.junit.jupiter.api.BeforeEach;

public class Test {
    private  ProductList test;

    @BeforeEach
    void input() {
        test = new ProductList();
        test.addProduct("Milk", 29, 99);
        test.addProduct("Soda", 59, 0);
        test.addProduct("Water", 35, 49);
        test.addProduct("Icecream",  140, 0);
        test.addProduct("Fish", 299, 99);
    }

    @org.junit.jupiter.api.Test
    void addProduct() {}

    @org.junit.jupiter.api.Test
    void delete() {}

    @org.junit.jupiter.api.Test
    void changeName() {}

    @org.junit.jupiter.api.Test
    void changeCost() {}

    @org.junit.jupiter.api.Test
    void costDetermine() {}

}
