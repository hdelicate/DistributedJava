package hibernate.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "FishingSpot")
public class FishingSpot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spot_id")
    private int id;
    @Column(name = "nm")
    private String spotName;
    @Column(name = "type")
    private String type;
    @Column(name = "summary")
    private String summary;
    @ManyToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinTable(name = "SpotSpecies",
            joinColumns = @JoinColumn(name = "spot_id"),
            inverseJoinColumns = @JoinColumn(name = "species_id"))
    private List<FishSpecies> speciesList;

    public FishingSpot() {
    }

    public FishingSpot(String spotName, String type, String summary) {
        this.spotName = spotName;
        this.type = type;
        this.summary = summary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<FishSpecies> getSpeciesList() {
        return speciesList;
    }

    public void setSpeciesList(List<FishSpecies> speciesList) {
        this.speciesList = speciesList;
    }

    public String getSpotName() {
        return spotName;
    }

    public void setSpotName(String spotName) {
        this.spotName = spotName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "FishingSpot{" +
                "id=" + id +
                ", spotName='" + spotName + '\'' +
                ", type='" + type + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
