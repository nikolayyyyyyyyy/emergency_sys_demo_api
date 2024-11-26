package demo_api.services.impl;

import demo_api.models.Region;
import demo_api.repositories.RegionRepository;
import demo_api.services.RegionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionService;

    public RegionServiceImpl(RegionRepository regionService){
        this.regionService = regionService;
    }

    @Override
    public void createRegion(Region region) {
        this.regionService.save(region);
    }

    @Override
    public Region getRegion(Long id) {
        return this.regionService
                .findById(id)
                .orElse(null);
    }

    @Override
    public List<Region> getAllRegions() {
        return this.regionService.findAll();
    }

    @Override
    public void deleteRegion(long id) {
        this.regionService.deleteById(id);
    }
}
