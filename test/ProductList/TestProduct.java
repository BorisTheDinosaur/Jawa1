package ProductList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;


class TestProduct {
    private  ProductList test;

    @BeforeEach
    void input() {
        test = new ProductList();
        test.addProduct("Milk", 29, 99);
        test.addProduct(1,"Soda", 59, 0);
        test.addProduct("Water", 35, 49);
        test.addProduct(3,"Icecream",  140, 5);
        test.addProduct("Fish", 299, 99);
    }

    @Test
    void addProduct() {
        assertTrue(test.addProduct("Lemon", 50,0));
        assertTrue(test.addProduct(10,"Jam", 0,1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> test.addProduct("Cola", -50, -10));
        Assertions.assertThrows(IllegalArgumentException.class, () -> test.addProduct("Gum", 0, 0));
        assertFalse(test.addProduct("Lemon", 50,0));
        assertFalse(test.addProduct(10,"JamJar", 110,1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> test.addProduct(-10,"JamJar", 110,1));
    }

    @Test
    void delete() {
        assertTrue(test.delete("Icecream"));
        assertTrue(test.delete("Soda"));
        assertTrue(test.delete(2));
        assertTrue(test.delete(4));
        assertFalse(test.delete("ppp"));
        assertFalse(test.delete("Icecream"));
        assertFalse(test.delete(10));
        assertFalse(test.delete(2));
    }

    @Test
    void changeName() {
        assertTrue(test.changeName("Milk", "Juice"));
        assertTrue(test.changeName("Fish", "Crab"));
        assertTrue(test.changeName(1,"Candy"));
        assertTrue(test.changeName(4, "Butter"));
        assertFalse(test.changeName("ddd", "ggg"));
        assertFalse(test.changeName("0057", "68"));
        assertFalse(test.changeName(10, "Potatoes"));
        assertFalse(test.changeName(99999, "Shampoo"));
    }

    @Test
    void changeCost() {
        assertTrue(test.changeCost("Water", 100, 0));
        assertTrue(test.changeCost("Milk", 35, 50));
        assertTrue(test.changeCost(1, 100, 100));
        assertTrue(test.changeCost(4, 100, 100));
        assertFalse(test.changeCost("Wr", 910, 0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> test.changeCost("Water", -910, 0));
        assertFalse(test.changeCost(10, 800, 0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> test.changeCost(2, 800, -300));
    }

    @Test
    void costDetermine() {
        HashMap<Integer, Integer> costs = new HashMap<>();
        costs.put(1,40);
        costs.put(3,5);


        assertEquals(BigDecimal.valueOf(149.95), test.costDetermine(0, 5));
        assertEquals(BigDecimal.valueOf(599.98), test.costDetermine(4, 2));
        assertEquals(3060.25, test.costDetermine(costs));

        costs.put(-1,1);

        Assertions.assertThrows(IllegalArgumentException.class, () -> assertEquals(3060.25, test.costDetermine(costs)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> test.costDetermine(4, -2));
        Assertions.assertThrows(IllegalArgumentException.class, () -> test.costDetermine(-1, 0));

    }

    @Test
    void other() {
        assertEquals("Milk\t\t29,99" + System.lineSeparator() +
                "Soda\t\t59,00" + System.lineSeparator() +
                "Water\t\t35,49" + System.lineSeparator() +
                "Icecream\t\t140,05" + System.lineSeparator() +
                "Fish\t\t299,99" + System.lineSeparator(), test.toString());

        ProductList clone = test;
        String str = "GG";

        assertEquals(test, test);
        assertEquals(clone, test);
        assertNotEquals(test, null);
        assertNotEquals(str, test);

    }


}
