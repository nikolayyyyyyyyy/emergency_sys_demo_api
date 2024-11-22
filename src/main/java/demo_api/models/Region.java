package demo_api.models;

import demo_api.models.enums.RegionPlace;
import jakarta.persistence.*;

@Entity
@Table(name = "regions")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private RegionPlace regionPlace;

    public Region() {
    }

    public Region(RegionPlace regionPlace) {
        this.regionPlace = regionPlace;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RegionPlace getRegionPlace() {
        return regionPlace;
    }

    public void setRegionPlace(RegionPlace regionPlace) {
        this.regionPlace = regionPlace;
    }
}
