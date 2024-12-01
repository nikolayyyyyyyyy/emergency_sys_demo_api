package demo_api.services;

import demo_api.models.Region;
import demo_api.models.enums.RegionPlace;

import java.util.List;

public interface RegionService {

    public void createRegion(Region region);
    public Region getRegion(Long id);
    public List<Region> getAllRegions();
    public void deleteRegion(long id);
    public boolean hasRegion(RegionPlace regionPlace);
}
