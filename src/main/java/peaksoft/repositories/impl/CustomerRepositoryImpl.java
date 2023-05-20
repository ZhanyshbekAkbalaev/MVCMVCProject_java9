package peaksoft.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Agency;
import peaksoft.entity.Customer;
import peaksoft.repositories.CustomerRepository;

import java.util.List;
@Repository
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository {
    @PersistenceContext
    private final EntityManager entityManager;
    @Autowired
    public CustomerRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveCustomer(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return entityManager.createQuery("select c from Customer c",Customer.class).getResultList();
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
