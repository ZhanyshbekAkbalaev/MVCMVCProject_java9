package peaksoft.sevicies.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.entity.Customer;
import peaksoft.repositories.CustomerRepository;
import peaksoft.sevicies.CustomerService;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;

    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.saveCustomer(customer);
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @Override
    public void updateCustomer(Long customerId, Customer customer) {

    }

    @Override
    public void deleteCustomerByID(Long customerId) {

    }

    @Override
    public void assignCustomerToAgency(Long customerId, Long agencyId) {

    }
}
