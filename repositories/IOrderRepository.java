package repositories;

import entities.Customer;
import entities.Products;

import java.util.List;
public interface IOrderRepository {
    Customer getCustomer(int id);
    List<Customer> getAllCustomerList();
    Customer getCustomerPhone(String phone);
    List<Products> getAllProductsList();
    boolean mintCustomer(Customer customer);
    boolean mintProduct(Products products);
}
