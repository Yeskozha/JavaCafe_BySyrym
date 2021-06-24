package repositories;

import database.IDB;
import database.PostgreDB;
import entities.Customer;
import entities.Products;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class OrderRepository implements IOrderRepository {
    public OrderRepository() { }
    private Connection con;
    IDB Connect = new PostgreDB();

    @Override
    public boolean mintCustomer(Customer customer) {
        try {
            con = Connect.getConnection();
            String sqlCode = "INSERT INTO project_java(customer_phone,customer_name) VALUES(?,?)";
            PreparedStatement statement = con.prepareStatement(sqlCode);
            statement.setString(1, customer.getPhone());
            statement.setString(2, customer.getName());
            boolean execution = statement.execute();
            return execution;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return false;
    }

    @Override
    public boolean mintProduct(Products products) {
        try {
            con = Connect.getConnection();
            String sqlCode = "INSERT INTO products(product_name,price) VALUES(?,?)";
            PreparedStatement statement = con.prepareStatement(sqlCode);
            statement.setString(1, products.getPname());
            statement.setString(2, products.getPrice());
            boolean execution = statement.execute();
            return execution;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return false;
    }

    @Override
    public Customer getCustomer(int id) {
        try {
            con = Connect.getConnection();
            String sqlCode = "SELECT customer_id,customer_name,customer_phone FROM project_java WHERE customer_id=?";
            PreparedStatement statement = con.prepareStatement(sqlCode);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return new Customer(rs.getInt("customer_id"),
                        rs.getString("customer_name"),
                        rs.getString("customer_phone"));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Customer> getAllCustomerList() {
        try {
            con = Connect.getConnection();
            String sqlCode = "SELECT customer_id,customer_name,customer_phone from project_java";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlCode);
            List<Customer> customers = new LinkedList<>();
            while (rs.next()) {
                Customer customer = new Customer(rs.getInt("customer_id"),
                        rs.getString("customer_name"),
                        rs.getString("customer_phone"));
                customers.add(customer);
            }
            return customers;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Customer getCustomerPhone(String phone) {
        try {
            con = Connect.getConnection();
            String sqlCode = "SELECT customer_id,customer_name,customer_phone FROM project_java WHERE customer_phone=?";
            PreparedStatement statement = con.prepareStatement(sqlCode);
            statement.setString(1, phone);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return new Customer(rs.getInt("customer_id"),
                        rs.getString("customer_name"),
                        rs.getString("customer_phone"));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Products> getAllProductsList() {
        try {
            con = Connect.getConnection();
            String sqlCode = "SELECT * FROM products";
            PreparedStatement pr = con.prepareStatement(sqlCode);
            ResultSet rs = pr.executeQuery();
            List<Products> products = new LinkedList<>();
            while (rs.next()) {
                Products product = new Products(rs.getInt("product_id"),
                        rs.getString("price"),
                        rs.getString("product_name"));
                products.add(product);
            }
            return products;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
    public Products getProductsByUsingID(int idP){
        try{
            con=Connect.getConnection();
            String sqlCode="SELECT * FROM products WHERE product_id=?";
            PreparedStatement pr=con.prepareStatement(sqlCode);
            pr.setInt(1,idP);
            ResultSet resultSet=pr.executeQuery();
            Products products=null;
            while(resultSet.next()){
                products=new Products(resultSet.getInt("product_id"),
                        resultSet.getString("price"),
                        resultSet.getString("product_name"));
            }
            return products;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
    public void orderCreating(Customer customer,Products products) {
        try {
            con = Connect.getConnection();
            String sqlCode = "INSERT INTO order_details(order_id,product_id) VALUES(?,?)";
            PreparedStatement pr = con.prepareStatement(sqlCode);
            pr.setInt(1, customer.getId());
            pr.setInt(2, products.getId());
            pr.executeUpdate();
            System.out.println("Order has been successfully posted!");

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}

