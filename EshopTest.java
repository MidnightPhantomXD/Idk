import org.example.Customer;
import org.example.Eshop;
import org.example.Product;
import org.example.ShoppingCart;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class EshopTest {

    private Product product1, product2;
    private Customer customer1, customer2;
    private Eshop eshop;
    private ShoppingCart shoppingCart;

    @BeforeEach
    public void setUp() {
        product1 = new Product(1, "Laptop", 1500.0);
        product2 = new Product(2, "Mouse", 25.0);
        customer1 = new Customer(1, "John Doe", "john.doe@example.com");
        customer2 = new Customer(2, "Jane Smith", "jane.smith@example.com");
        eshop = new Eshop();
        shoppingCart = new ShoppingCart();
    }

    @Test
    public void testAddAndRemoveProduct() {
        eshop.addProduct(product1);
        eshop.addProduct(product2);

        assertNotNull(eshop.findProduct(1));
        assertNotNull(eshop.findProduct(2));

        eshop.removeProduct(1);
        assertNull(eshop.findProduct(1));
    }

    @Test
    public void testAddAndRemoveCustomer() {
        eshop.addCustomer(customer1);
        eshop.addCustomer(customer2);

        assertNotNull(eshop.findCustomer(1));
        assertNotNull(eshop.findCustomer(2));

        eshop.removeCustomer(1);
        assertNull(eshop.findCustomer(1));
    }

    @Test
    public void testShoppingCartAddItem() {
        shoppingCart.addItem(product1, 1);
        double totalPrice = shoppingCart.getTotalPrice();

        assertEquals(1500.0, totalPrice);
    }

    @Test
    public void testShoppingCartRemoveItem() {
        shoppingCart.addItem(product1, 1);
        shoppingCart.removeItem(product1);
        double totalPrice = shoppingCart.getTotalPrice();

        assertEquals(0.0, totalPrice);
    }

    @Test
    public void testListAllProducts() {
        eshop.addProduct(product1);
        eshop.addProduct(product2);

        assertTrue(eshop.listAllProducts().contains(product1));
        assertTrue(eshop.listAllProducts().contains(product2));
    }

    @Test
    public void testListAllCustomers() {
        eshop.addCustomer(customer1);
        eshop.addCustomer(customer2);

        assertTrue(eshop.listAllCustomers().contains(customer1));
        assertTrue(eshop.listAllCustomers().contains(customer2));
    }
}