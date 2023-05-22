package peaksoft.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Agency;
import peaksoft.entity.Customer;
import peaksoft.exception.MyException;
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
    public void saveCustomer(Long agencyId,Customer customer) {
        Agency agency = entityManager.find(Agency.class, agencyId);
        agency.getCustomers().add(customer);
        customer.getAgencies().add(agency);
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        return entityManager.find(Customer.class,customerId);
    }

    @Override
    public List<Customer> getAllCustomers(Long agencyId) {
        return entityManager.createQuery("select c from Customer c join c.agencies a where a.id = :agencyId",Customer.class).setParameter("agencyId",agencyId).getResultList();
    }

    @Override
    public void updateCustomer(Long customerId, Customer customer) {

    }

    @Override
    public void deleteCustomerById(Long customerId) {

    }
}
