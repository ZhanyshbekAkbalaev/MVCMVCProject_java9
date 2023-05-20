package peaksoft.sevicies;

import peaksoft.entity.House;
import peaksoft.exception.MyException;

import java.util.List;

public interface HouseService {
    void saveHouse(Long agencyId, House house) throws MyException;
    House getHouseById(Long houseId);
    List<House> getAllHouses(Long agencyId);
    void updateHouse(Long houseId,House house);
    void deleteHouse(Long houseId);
}
