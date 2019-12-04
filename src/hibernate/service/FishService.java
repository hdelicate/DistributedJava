package hibernate.service;

import hibernate.entity.FishSpecies;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FishService {
    List<FishSpecies> getFishes();

    void saveFish(FishSpecies aFish, String applicationPath);

    FishSpecies getFish(int theId);

    void deleteFish(int theId);

    List<FishSpecies> getFishByName(String theSearchTerm);
}
