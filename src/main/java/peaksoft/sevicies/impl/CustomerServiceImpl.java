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
    public void saveCustomer(Long agencyId,Customer customer) {
        customerRepository.saveCustomer(agencyId,customer);
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        return customerRepository.getCustomerById(customerId);
    }

    @Override
    public List<Customer> getAllCustomers(Long agencyId) {
        return customerRepository.getAllCustomers(agencyId);
    }

    @Override
    public void updateCustomer(Long customerId, Customer customer) {

    }

    @Override
    public void deleteCustomerById(Long customerId) {

    }
}
