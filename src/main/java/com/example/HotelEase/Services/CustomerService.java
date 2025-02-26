package com.example.HotelEase.Services;

import java.util.List;

import com.example.HotelEase.Entities.Customer;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomerById(Integer id);
    Customer addCustomer(Customer customer);
    Customer updateCustomer(Integer id, Customer customer);
    void deleteCustomer(Integer id);
}
