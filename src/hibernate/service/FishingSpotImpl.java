package hibernate.service;

import hibernate.DAO.FishingSpotDAO;
import hibernate.entity.FishingSpot;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public class FishingSpotImpl implements FishingSpotService {
    @Autowired
    private FishingSpotDAO fishingSpotDAO;

    @Override
    @Transactional
    public List<FishingSpot> getSpots() {
        return fishingSpotDAO.getSpots();
    }

    @Override
    @Transactional
    public FishingSpot getSpot(int id) {
        return fishingSpotDAO.getSpot(id);
    }
}
