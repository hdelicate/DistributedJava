package hibernate.DAO;

import hibernate.entity.FishingSpot;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class FishingSpotDAOImpl implements FishingSpotDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<FishingSpot> getSpots() {
        Session session = sessionFactory.getCurrentSession();

        List<FishingSpot> list = session.createQuery("from FishingSpot ", FishingSpot.class).getResultList();

        return list;
    }

    @Override
    public FishingSpot getSpot(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(FishingSpot.class, id);
    }
}
