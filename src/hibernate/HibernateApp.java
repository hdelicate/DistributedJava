package hibernate;

import hibernate.entity.FishSpecies;
import hibernate.entity.FishingSpot;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateApp {


    private SessionFactory factory;

    public HibernateApp() {
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(FishingSpot.class)
                .addAnnotatedClass(FishSpecies.class)
                .buildSessionFactory();
    }

    public static void main(String[] args) {
        HibernateApp fish = new HibernateApp();
        try {
            fish.createSpecies();
        } finally {
            fish.close();
        }

    }

    private void createSpecies() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();
        FishSpecies species = new FishSpecies("Walleye", "Walleye are native to North America and Europe(known in Europe as Zander), and are an elusive and picky fish that are the prize of anglers everywhere.");
        session.save(species);
        session.getTransaction().commit();
    }

    private void readSpecies(int speciesId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        FishSpecies species = session.get(FishSpecies.class, speciesId);

        if (species == null) {
            System.out.println("No species found for ID " + speciesId);
        } else {
            System.out.println(species);
        }

        session.getTransaction().commit();
    }

    private void updateSpecies(int SpeciesId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        FishSpecies species = session.get(FishSpecies.class, SpeciesId);
        if (species != null)
            species.setSpeciesName(species.getSpeciesName() + " UPDATED");

        session.getTransaction().commit();
    }

    private void deleteSpecies(int speciesId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        FishSpecies doomedFish = session.get(FishSpecies.class, speciesId);
        if (doomedFish != null)
            session.delete(doomedFish);

        session.getTransaction().commit();
    }

    //Fishing Spot
    private void createSpot() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();
        FishingSpot spot = new FishingSpot("Lake Woebegon", "Lake", "Lake Woebegon is a fantastic Minnesota lake described often in the Prarie Home Companion Radio show");
        session.save(spot);
        session.getTransaction().commit();
    }

    private void readSpot(int spotId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        FishingSpot spot = session.get(FishingSpot.class, spotId);

        if (spot == null) {
            System.out.println("No fishing spot found for ID " + spotId);
        } else {
            System.out.println(spot);
        }

        session.getTransaction().commit();
    }

    private void updateSpot(int spotId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        FishingSpot spot = session.get(FishingSpot.class, spotId);
        if (spot != null)
            spot.setSpotName(spot.getSpotName() + " UPDATED");

        session.getTransaction().commit();
    }

    private void deleteSpot(int spotId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        FishingSpot doomedSpot = session.get(FishingSpot.class, spotId);
        if (doomedSpot != null)
            session.delete(doomedSpot);

        session.getTransaction().commit();
    }

    private void close() {
        factory.close();
    }

}
