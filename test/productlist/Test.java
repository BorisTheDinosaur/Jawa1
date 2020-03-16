package productlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class TestProduct {
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

    @Test
    void addProduct() {
        assertTrue(test.addProduct("Lemon", 50,0));
        assertTrue(test.addProduct("Jam", 0,1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> { test.addProduct("Cola", -50, -10); });
        Assertions.assertThrows(IllegalArgumentException.class, () -> { test.addProduct("Gum", 0, 0); });
    }

    @Test
    void delete() {
        assertTrue(test.delete("Icecream"));
        assertTrue(test.delete("Soda"));
        Assertions.assertThrows(NullPointerException.class, () -> { test.delete("ppp"); });
        Assertions.assertThrows(NullPointerException.class, () -> { test.delete("Icecream"); });
    }

    @Test
    void changeName() {
        assertTrue(test.changeName("Milk", "Juice"));
        assertTrue(test.changeName("Fish", "Crab"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> { test.changeName("ddd", "ggg"); });
        Assertions.assertThrows(IllegalArgumentException.class, () -> { test.changeName("0057", "68"); });
    }

    @Test
    void changeCost() {
        assertTrue(test.changeCost("Water", 100, 0));
        assertTrue(test.changeCost("Milk", 35, 50));
        Assertions.assertThrows(IllegalArgumentException.class, () -> { test.changeCost("Wr", 910, 0); });
        Assertions.assertThrows(IllegalArgumentException.class, () -> { test.changeCost("Water", -910, 0); });
    }

    @Test
    void costDetermine() {
        assertEquals(149.95, test.costDetermine(0, 5));
        assertEquals(599.98, test.costDetermine(4, 2));
        Assertions.assertThrows(IllegalArgumentException.class, () -> { test.costDetermine(4, -2); });
        Assertions.assertThrows(IllegalArgumentException.class, () -> { test.costDetermine(-1, 0); });
    }
}
