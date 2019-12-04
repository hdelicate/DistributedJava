package hibernate.service;

import hibernate.entity.FishingSpot;

import java.util.List;

public interface FishingSpotService {
    List<FishingSpot> getSpots();

    FishingSpot getSpot(int id);
}
