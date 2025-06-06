import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WarehouseTest {
    private Warehouse warehouse;

    @BeforeEach
    public void setup() {
        warehouse = new Warehouse();
    }

    @Test
    public void testAddProductPositiveQuantity() {
        warehouse.addProduct("apple", 10);
        assertEquals(10, warehouse.getQuantity("apple"));
    }

    @Test
    public void testAddProductNegativeQuantityThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            warehouse.addProduct("apple", -5);
        });
    }

    @Test
    public void testRemoveProductValid() {
        warehouse.addProduct("banana", 20);
        warehouse.removeProduct("banana", 5);
        assertEquals(15, warehouse.getQuantity("banana"));
    }

    @Test
    public void testRemoveProductMoreThanAvailableThrows() {
        warehouse.addProduct("orange", 3);
        assertThrows(IllegalArgumentException.class, () -> {
            warehouse.removeProduct("orange", 5);
        });
    }

    @Test
    public void testRemoveProductNegativeQuantityThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            warehouse.removeProduct("banana", -2);
        });
    }
}
