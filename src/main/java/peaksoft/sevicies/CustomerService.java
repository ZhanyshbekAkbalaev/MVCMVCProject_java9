package peaksoft.sevicies;

import peaksoft.entity.Customer;

import java.util.List;

public interface CustomerService {
    void saveCustomer(Long agencyId,Customer customer);
    Customer getCustomerById(Long customerId);
    List<Customer> getAllCustomers(Long agencyId);
    void updateCustomer(Long customerId,Customer customer);
    void deleteCustomerById(Long customerId);
}
