package DAO;

import model.Customer;
import service.DBConnection;
import service.GeneralDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements GeneralDAO<Customer> {
    private static final String SELECT_ALL_CUSTOMERS = "SELECT * FROM Customers";
    private static final String SELECT_CUSTOMER_BY_ID = "SELECT * FROM Customers WHERE id = ?";
    private static final String UPDATE_CUSTOMER_BY_ID = "UPDATE Customers SET name = ? WHERE id = ?";

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMERS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                customers.add(new Customer(id, name, email, address));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;

    }

    @Override
    public Customer findCustomerById(int id) {
        Customer customer = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                customer = new Customer(id, name, email, address);
            }
        } catch (SQLException e) {
           DBConnection.printSQLException(e);
        }
        return customer;
    }
    @Override
    public boolean updateCustomer(Customer customer) {
        boolean rowUpdated = false;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_BY_ID)){
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getEmail());
            preparedStatement.setString(3, customer.getAddress());
            preparedStatement.setInt(4, customer.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e){
            DBConnection.printSQLException(e);
        }

        return rowUpdated;
    }
    @Override
    public void add(Customer entity) {

    }



    @Override
    public void delete(int id) {

    }
}
