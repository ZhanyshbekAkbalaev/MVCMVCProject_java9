package peaksoft.sevicies.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.entity.Agency;
import peaksoft.entity.House;
import peaksoft.exception.MyException;
import peaksoft.repositories.AgencyRepository;
import peaksoft.repositories.HouseRepository;
import peaksoft.sevicies.HouseService;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    private final HouseRepository houseRepository;
    private final AgencyRepository agencyRepository;
    @Autowired
    public HouseServiceImpl(HouseRepository houseRepository, AgencyRepository agencyRepository) {
        this.houseRepository = houseRepository;
        this.agencyRepository = agencyRepository;
    }

    @Override
    public void saveHouse(Long agencyId, House house) throws MyException {
        houseRepository.saveHouse(agencyId,house);
    }

    @Override
    public House getHouseById(Long houseId) {
        return houseRepository.getHouseById(houseId);
    }

    @Override
    public List<House> getAllHouses(Long agencyId) {
        return houseRepository.getAllHouses(agencyId);
    }

    @Override
    public void updateHouse(Long houseId, House house) {
        houseRepository.updateHouse(houseId,house);
    }

    @Override
    public void deleteHouse(Long houseId) {
        houseRepository.deleteHouse(houseId);
    }
}
