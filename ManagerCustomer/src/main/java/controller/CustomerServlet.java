package controller;

import DAO.CustomerDAO;
import model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(name = "CustomerServlet", urlPatterns = "/managercustomers")
public class CustomerServlet extends HttpServlet {
    private CustomerDAO customerDAO;

    public void init() {
        customerDAO = new CustomerDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Customer> customers = new CustomerDAO().getAll();
        request.setAttribute("listcustomer", customers);
        request.getRequestDispatcher("/customer/listcustomer.jsp").forward(request, response);
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "add":
                    addCustomer(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteCustomer(request, response);
                    break;
                default:
                    showCustomerList(request, response);
                    break;
            }
        } catch (Exception e) {
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        updateCustomer(request, response);
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("address");
            Customer customer = new Customer(id, name, email, phone);
            customerDAO.updateCustomer(customer);
            response.sendRedirect("customers");
    }

    private void showCustomerList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Customer> listCustomer = customerDAO.getAll();
        request.setAttribute("listCustomer", listCustomer);
        request.getRequestDispatcher("/customer/listcustomer.jsp").forward(request, response);
    }


    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerDAO.findCustomerById(id);
        request.setAttribute("customer", customer);
        request.getRequestDispatcher("/customer/edit.jsp").forward(request, response);

    }

    private void addCustomer(HttpServletRequest request, HttpServletResponse response) {
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
    }
}
