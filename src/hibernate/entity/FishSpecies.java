package hibernate.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "FishSpecies")
public class FishSpecies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "species_id")
    private int id;
    @Column(name = "species_nm")
    private String speciesName;
    @Column(name = "summary")
    private String summary;
    @ManyToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinTable(name = "SpotSpecies",
            joinColumns = @JoinColumn(name = "species_id"),
            inverseJoinColumns = @JoinColumn(name = "spot_id"))
    private List<FishingSpot> spotList;

    public FishSpecies() {
    }

    public FishSpecies(String speciesName, String summary) {
        this.speciesName = speciesName;
        this.summary = summary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<FishingSpot> getSpotList() {
        return spotList;
    }

    public void setSpotList(List<FishingSpot> spotList) {
        this.spotList = spotList;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "FishSpecies{" +
                "id=" + id +
                ", speciesName='" + speciesName + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}

