package hibernate.DAO;

import hibernate.entity.FishingSpot;

import java.util.List;

public interface FishingSpotDAO {
    List<FishingSpot> getSpots();

    FishingSpot getSpot(int id);
}
