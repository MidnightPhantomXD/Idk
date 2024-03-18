import org.example.Customer;
import org.example.Eshop;
import org.example.Product;
import org.example.ShoppingCart;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class EshopTestComplicated {

    private Product product1, product2, product3;
    private Customer customer1, customer2, customer3;
    private Eshop eshop;
    private ShoppingCart shoppingCart;

    @BeforeEach
    public void setUp() {
        product1 = new Product(1, "Laptop", 1500.0);
        product2 = new Product(2, "Mouse", 25.0);
        product3 = new Product(3, "Keyboard", 50.0);
        customer1 = new Customer(1, "John Doe", "john.doe@example.com");
        customer2 = new Customer(2, "Jane Smith", "jane.smith@example.com");
        customer3 = new Customer(3, "Alice Johnson", "alice.johnson@example.com");
        eshop = new Eshop();
        shoppingCart = new ShoppingCart();
    }

    @Test
    public void testAddAndRemoveMultipleProducts() {
        eshop.addProduct(product1);
        eshop.addProduct(product2);
        eshop.addProduct(product3);

        assertNotNull(eshop.findProduct(1));
        assertNotNull(eshop.findProduct(2));
        assertNotNull(eshop.findProduct(3));

        eshop.removeProduct(2);
        assertNull(eshop.findProduct(2));

        eshop.removeProduct(3);
        assertNull(eshop.findProduct(3));

        eshop.removeProduct(1);
        assertNull(eshop.findProduct(1));
    }

    @Test
    public void testAddAndRemoveMultipleCustomers() {
        eshop.addCustomer(customer1);
        eshop.addCustomer(customer2);
        eshop.addCustomer(customer3);

        assertNotNull(eshop.findCustomer(1));
        assertNotNull(eshop.findCustomer(2));
        assertNotNull(eshop.findCustomer(3));

        eshop.removeCustomer(2);
        assertNull(eshop.findCustomer(2));

        eshop.removeCustomer(3);
        assertNull(eshop.findCustomer(3));

        eshop.removeCustomer(1);
        assertNull(eshop.findCustomer(1));
    }

    @Test
    public void testShoppingCartAddMultipleItems() {
        shoppingCart.addItem(product1, 1);
        shoppingCart.addItem(product2, 2);
        shoppingCart.addItem(product3, 3);

        double totalPrice = shoppingCart.getTotalPrice();

        assertEquals(1500.0 + (2 * 25.0) + (3 * 50.0), totalPrice);
    }

    @Test
    public void testShoppingCartRemoveMultipleItems() {
        shoppingCart.addItem(product1, 1);
        shoppingCart.addItem(product2, 2);
        shoppingCart.addItem(product3, 3);

        shoppingCart.removeItem(product1);
        shoppingCart.removeItem(product2);
        double totalPrice = shoppingCart.getTotalPrice();

        assertEquals(3 * 50.0, totalPrice);
    }

    @Test
    public void testListAllWithMultipleEntries() {
        eshop.addProduct(product1);
        eshop.addProduct(product2);
        eshop.addProduct(product3);
        eshop.addCustomer(customer1);
        eshop.addCustomer(customer2);
        eshop.addCustomer(customer3);

        assertTrue(eshop.listAllProducts().contains(product1));
        assertTrue(eshop.listAllProducts().contains(product2));
        assertTrue(eshop.listAllProducts().contains(product3));

        assertTrue(eshop.listAllCustomers().contains(customer1));
        assertTrue(eshop.listAllCustomers().contains(customer2));
        assertTrue(eshop.listAllCustomers().contains(customer3));
    }

    @Test
    public void testShoppingCartEdgeCases() {
        assertThrows(IllegalArgumentException.class, () -> {
            shoppingCart.addItem(product1, 0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            shoppingCart.addItem(product1, -1);
        });

        shoppingCart.addItem(product1, 5);
        shoppingCart.removeItem(product1);
        assertEquals(0, shoppingCart.getTotalPrice(), "Price should be 0 after removing all products");
    }
}