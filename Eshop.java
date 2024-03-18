package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class Eshop {
    //TODO: Doplnit atributy pro produkty a zákazníky

    public Eshop() {
        //TODO: Inicializovat kolekce
    }

    public void addProduct(Product product) {
        //TODO: Doplnit metodu
    }

    public void removeProduct(int productId) {
        //TODO: Doplnit metodu
    }

    public Product findProduct(int productId) {
        return null; //TODO: Doplnit správnou implementaci
    }

    public void addCustomer(Customer customer) {
        //TODO: Doplnit metodu
    }

    public void removeCustomer(int customerId) {
        //TODO: Doplnit metodu
    }

    public Customer findCustomer(int customerId) {
        return null; //TODO: Doplnit správnou implementaci
    }

    public List<Product> listAllProducts() {
        return null; //TODO: Doplnit správnou implementaci
    }

    public List<Customer> listAllCustomers() {
        return null; //TODO: Doplnit správnou implementaci
    }

    public List<Product> findProductsByName(String searchTerm) {
        return null; //TODO: Doplnit správnou implementaci
    }

    public List<Customer> findCustomersByEmailDomain(String domain) {
        return null; //TODO: Doplnit správnou implementaci
    }

}