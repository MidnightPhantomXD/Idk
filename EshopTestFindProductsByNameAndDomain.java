import org.example.Customer;
import org.example.Eshop;
import org.example.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class EshopTestFindProductsByNameAndDomain {
    private Eshop eshop;

    @BeforeEach
    public void setUp() {
        eshop = new Eshop();

        // Adding products using new constructor
        eshop.addProduct(new Product(1, "Laptop", "Electronics", 1000.0));
        eshop.addProduct(new Product(2, "Laptop Pro", "Electronics", 1500.0));
        eshop.addProduct(new Product(3, "Mobile Phone", "Electronics", 800.0));
        eshop.addProduct(new Product(4, "Book: 'Java Basics'", "Books", 20.0));
        eshop.addProduct(new Product(5, "Notebook", "Stationery", 5.0));

        // Adding customers
        eshop.addCustomer(new Customer(1, "Jan Novak", "jan.novak@example.com"));
        eshop.addCustomer(new Customer(2, "Eva Stastna", "eva.stastna@example.com"));
        eshop.addCustomer(new Customer(3,"Lukas Moudry", "lukas.moudry@example.com"));
        eshop.addCustomer(new Customer(4,"Anna Vesela", "anna.vesela@mydomain.com"));
        eshop.addCustomer(new Customer(5,"Petr Rychly", "petr.rychly@mydomain.com"));
        eshop.addCustomer(new Customer(6,"Helena Velka", "helena.velka@anotherdomain.com"));
        eshop.addCustomer(new Customer(7,"Martin Malý", "martin.maly@anotherdomain.com"));
    }

    // TESTY PRO findProductsByName

    @Test
    public void testFindProductsByName_ExactMatch() {
        List<Product> foundProducts = eshop.findProductsByName("Laptop Pro");
        assertEquals(1, foundProducts.size(), "Expected only 1 product with the exact name 'Laptop Pro'");
        assertEquals("Laptop Pro", foundProducts.get(0).getName(), "Expected product name to be 'Laptop Pro'");
    }

    @Test
    public void testFindProductsByName_PartialMatch() {
        List<Product> foundProducts = eshop.findProductsByName("Laptop");
        assertEquals(2, foundProducts.size(), "Expected 2 products with names containing 'Laptop'");
        assertTrue(foundProducts.stream().anyMatch(p -> p.getName().equals("Laptop")), "Expected to find a product with name 'Laptop'");
        assertTrue(foundProducts.stream().anyMatch(p -> p.getName().equals("Laptop Pro")), "Expected to find a product with name 'Laptop Pro'");
    }

    @Test
    public void testFindProductsByName_NoMatch() {
        List<Product> foundProducts = eshop.findProductsByName("NonExistingProduct");
        assertTrue(foundProducts.isEmpty(), "Expected no products with the name 'NonExistingProduct'");
    }

    @Test
    public void testFindProductsByName_EmptyString() {
        List<Product> foundProducts = eshop.findProductsByName("");
        assertEquals(5, foundProducts.size(), "Expected to return all products when given an empty string");
    }

    // TESTY PRO findCustomersByEmailDomain

    @Test
    public void testFindCustomersByEmailDomain_ExactMatch() {
        List<Customer> foundCustomers = eshop.findCustomersByEmailDomain("example.com");
        assertEquals(3, foundCustomers.size(), "Expected 3 customers with email domain 'example.com'");
        assertTrue(foundCustomers.stream().anyMatch(c -> c.getEmail().equals("jan.novak@example.com")), "Expected to find a customer with email 'jan.novak@example.com'");
        assertTrue(foundCustomers.stream().anyMatch(c -> c.getEmail().equals("eva.stastna@example.com")), "Expected to find a customer with email 'eva.stastna@example.com'");
        assertTrue(foundCustomers.stream().anyMatch(c -> c.getEmail().equals("lukas.moudry@example.com")), "Expected to find a customer with email 'lukas.moudry@example.com'");
    }

    @Test
    public void testFindCustomersByEmailDomain_MultipleMatches() {
        List<Customer> foundCustomers = eshop.findCustomersByEmailDomain("mydomain.com");
        assertEquals(2, foundCustomers.size(), "Expected 2 customers with email domain 'mydomain.com'");
    }

    @Test
    public void testFindCustomersByEmailDomain_NoMatch() {
        List<Customer> foundCustomers = eshop.findCustomersByEmailDomain("nonexistingdomain.com");
        assertTrue(foundCustomers.isEmpty(), "Expected no customers with email domain 'nonexistingdomain.com'");
    }

    @Test
    public void testFindCustomersByEmailDomain_EmptyString() {
        List<Customer> foundCustomers = eshop.findCustomersByEmailDomain("");
        assertEquals(7, foundCustomers.size(), "Expected to return all customers when given an empty domain string");
    }
}