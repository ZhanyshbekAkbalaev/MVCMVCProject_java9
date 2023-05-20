package peaksoft.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Agency;
import peaksoft.exception.MyException;
import peaksoft.repositories.AgencyRepository;

import java.util.List;
import java.util.Objects;

@Repository
@Transactional
public class AgencyRepositoryImpl implements AgencyRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public AgencyRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveAgency(Agency agency) {
        try {
            entityManager.persist(agency);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Agency getAgencyById(Long agencyId) {
        return entityManager.find(Agency.class, agencyId);
//        try {
//            boolean isEmpty = false;
//            for (Agency agency : getAllAgency()) {
//                if (Objects.equals(agency.getId(), agencyId)) {
//                    isEmpty = true;
//                }
//            }
//            if (isEmpty) {
//                return entityManager.createQuery("select a from Agency a where a.id=:agencyId"
//                        , Agency.class).setParameter("agencyId", agencyId).getSingleResult();
//            } else {
//                throw new MyException("Agency by ID : " + agencyId + " not found!");
//            }
//        } catch (MyException e) {
//            System.out.println(e.getMessage());
//        }
//        return null;
    }

    @Override
    public List<Agency> getAllAgency() {
        return entityManager.createQuery("select a from Agency a", Agency.class).getResultList();
    }

    @Override
    public void updateAgency(Long agencyId, Agency agency2) {
        try {
            boolean isEmpty = false;
            for (Agency agency : getAllAgency()) {
                if (Objects.equals(agency.getId(), agencyId)) {
                    isEmpty = true;
                }
            }
            if (isEmpty) {
                Agency agency1 = entityManager.find(Agency.class, agencyId);
                agency1.setName(agency2.getName());
                agency1.setCountry(agency2.getCountry());
                agency1.setPhoneNumber(agency2.getPhoneNumber());
                agency1.setEmail(agency2.getEmail());
                agency1.setImage(agency2.getImage());
                entityManager.merge(agency1);
            } else {
                throw new MyException("Agency by ID : " + agencyId + " not found!");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteAgency(Long agencyId) {
        Agency agency2 = entityManager.find(Agency.class, agencyId);
        entityManager.remove(agency2);
    }
//        try {
//            boolean isFalse = false;
//            for (Agency agency1 : getAllAgency()) {
//                if (Objects.equals(agency1.getId(), agencyId)) {
//                    isFalse =false;
//                }
//                if (isFalse) {
//                    Agency agency = entityManager.find(Agency.class, agencyId);
//                    entityManager.remove(agency);
//                    isFalse=true;
//                } else {
//                    throw new MyException("Agency by Id : " + agencyId + " not found!");
//                }
//            }
//        } catch (MyException e) {
//            System.out.println(e.getMessage());
//        }
//
//    }
}
