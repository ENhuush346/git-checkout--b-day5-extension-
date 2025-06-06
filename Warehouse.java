import java.util.HashMap;
import java.util.Map;

/**
 * Warehouse ангид бүтээгдэхүүнүүд хадгалагдана.
 */
public class Warehouse {
    private Map<String, Integer> inventory = new HashMap<>();

    /**
     * Шинэ бүтээгдэхүүн нэмэх буюу одоогийн тоогоо нэмэгдүүлэх.
     * @param productName Бүтээгдэхүүний нэр
     * @param quantity Нэмэх тоо (сөрөг байж болохгүй)
     * @throws IllegalArgumentException хэрвээ quantity сөрөг бол
     */
    public void addProduct(String productName, int quantity) {
        if (quantity < 0) throw new IllegalArgumentException("Quantity must be non-negative");
        inventory.put(productName, inventory.getOrDefault(productName, 0) + quantity);
    }

    /**
     * Бүтээгдэхүүнээс тодорхой тоог хасах.
     * @param productName Бүтээгдэхүүний нэр
     * @param quantity Хасах тоо (сөрөг байж болохгүй)
     * @throws IllegalArgumentException хэрвээ тоо сөрөг буюу хасах тоо агуулахгүй байвал
     */
    public void removeProduct(String productName, int quantity) {
        if (quantity < 0) throw new IllegalArgumentException("Quantity must be non-negative");
        int currentQty = inventory.getOrDefault(productName, 0);
        if (quantity > currentQty) {
            throw new IllegalArgumentException("Not enough products to remove");
        }
        inventory.put(productName, currentQty - quantity);
    }

    /**
     * Тухайн бүтээгдэхүүний агуулах дахь тоо
     * @param productName Бүтээгдэхүүний нэр
     * @return тоо хэмжээ
     */
    public int getQuantity(String productName) {
        return inventory.getOrDefault(productName, 0);
    }
}
