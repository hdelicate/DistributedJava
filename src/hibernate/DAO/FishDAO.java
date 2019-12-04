package hibernate.DAO;

import hibernate.entity.FishSpecies;

import java.util.List;

public interface FishDAO {

    List<FishSpecies> getFishes();

    void saveFish(FishSpecies aFish);

    FishSpecies getFish(int theId);

    void deleteFish(int theId);

    List<FishSpecies> getFishByName(String theSearchTerm);
}
