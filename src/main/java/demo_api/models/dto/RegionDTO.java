package demo_api.models.dto;

import demo_api.models.enums.RegionPlace;

public class RegionDTO {
    private RegionPlace regionPlace;

    public RegionPlace getRegionPlace() {
        return regionPlace;
    }

    public void setRegionPlace(RegionPlace regionPlace) {
        this.regionPlace = regionPlace;
    }
}
