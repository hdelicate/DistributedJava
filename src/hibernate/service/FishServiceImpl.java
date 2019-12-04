package hibernate.service;

import hibernate.DAO.FishDAO;
import hibernate.entity.FishSpecies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class FishServiceImpl implements FishService {


    @Autowired
    private FishDAO fishDAO;

    @Override
    @Transactional
    public List<FishSpecies> getFishes() {
      return  fishDAO.getFishes();
    }



    @Override
    @Transactional
    public void saveFish(FishSpecies aFish, MultipartFile file, String applicationPath) {
        fishDAO.saveFish(aFish);
    }

    @Override
    @Transactional
    public FishSpecies getFish(int theId) {
        return fishDAO.getFish(theId);
    }

    @Override
    @Transactional
    public void deleteFish(int theId) {
    fishDAO.deleteFish(theId);
    }

    @Override
    @Transactional
    public List<FishSpecies> getFishByName(String theSearchTerm) {
        return fishDAO.getFishByName(theSearchTerm);
    }
}
