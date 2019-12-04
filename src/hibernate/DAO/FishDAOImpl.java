package hibernate.DAO;

import hibernate.entity.FishSpecies;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FishDAOImpl implements FishDAO {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<FishSpecies> getFishes() {
        Session session = sessionFactory.getCurrentSession();

        List<FishSpecies> list = session.createQuery("from FishSpecies ", FishSpecies.class).getResultList();

        return list;
    }

    @Override
    public void saveFish(FishSpecies aFish) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(aFish);
    }

    @Override
    public FishSpecies getFish(int theId) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(FishSpecies.class, theId);
    }

    @Override
    public void deleteFish(int theId) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from FishSpecies where id = :doomedFishId");

        query.setParameter("doomedFishId", theId);

        query.executeUpdate();
    }

    @Override
    public List<FishSpecies> getFishByName(String theSearchTerm) {
        Session session = sessionFactory.getCurrentSession();

        Query<FishSpecies> query = session.createQuery("from FishSpecies where lower(speciesName) like :searchTerm");

        theSearchTerm = "%" + theSearchTerm.toLowerCase() + "%";

        query.setParameter("searchTerm", theSearchTerm);

        return query.getResultList();
    }
}
