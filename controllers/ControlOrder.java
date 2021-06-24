package controllers;

import entities.Customer;
import entities.Products;
import repositories.IOrderRepository;

import java.util.List;

public class ControlOrder {
    private final IOrderRepository iOrderRepository;

    public ControlOrder(IOrderRepository iOrderRepository) {
        this.iOrderRepository = iOrderRepository;
    }

    public String getCustomer(int id) {
        Customer customer = iOrderRepository.getCustomer(id);
        return (customer == null ? "Customer not found,try again!" : customer.toString());
    }
    public String getCustomerPhone(String phone) {
        Customer customer = iOrderRepository.getCustomerPhone(phone);
        return (customer == null ? "Customer not found,try again!" : customer.toString());
    }
    public String getAllCustomerList() {
        List<Customer> customers = iOrderRepository.getAllCustomerList();
        return customers.toString();
    }
    public void getAllProductList() {
        List<Products> products = iOrderRepository.getAllProductsList();

        for (Products p : products) {//foreach loop,where we can not change anything
            System.out.println(p.getId() + "/" + p.getPname() + "/" + p.getPrice() + "\n");
        }
    }
    public String mintNewCustomers(String name, String phoneNumber) {
        Customer customer = new Customer(name, phoneNumber);
        boolean created = iOrderRepository.mintCustomer(customer);
        return (created ? "Customer authorization was failed!" : "Customer has been successfully authorized!");
    }
    public String mintNewProduct(String pname, String price) {
        Products product = new Products(pname, price);
        boolean created = iOrderRepository.mintProduct(product);
        return (created ? "Product creating was failed!" : "Product has been successfully added!");
    }

}
