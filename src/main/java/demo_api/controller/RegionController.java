package demo_api.controller;

import demo_api.exception.RegionNotFoundException;
import demo_api.models.Region;
import demo_api.models.dto.RegionDTO;
import demo_api.services.RegionService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/regions")
public class RegionController {
    private final RegionService regionService;
    private final ModelMapper modelMapper;

    public RegionController(RegionService regionService,
                            ModelMapper modelMapper){

        this.regionService = regionService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("{id}")
    public RegionDTO getRegion(@PathVariable("id")Long id){
        Region region = this.regionService.getRegion(id);
        if(region == null){
            throw new RegionNotFoundException("Region does not exist in the database!");
        }

        return modelMapper.map(region,RegionDTO.class);
    }

    @PostMapping
    public String createRegion(@RequestBody RegionDTO region){
        this.regionService.createRegion(this.modelMapper.map(region,Region.class));
        return "Region created!";
    }

    @GetMapping
    public List<RegionDTO> getAllRegions(){
        List<Region> regions = this.regionService.getAllRegions();
        if(regions == null){
            throw new RegionNotFoundException("");
        }

        return regions
                .stream()
                .map(r -> modelMapper.map(r,RegionDTO.class))
                .toList();
    }

    @DeleteMapping("{id}")
    public String deleteRegion(@PathVariable(name = "id")Long id){
        Region region = this.regionService.getRegion(id);
        if(region == null){
            throw new RegionNotFoundException("Region does not exist in the database!");
        }

        this.regionService.deleteRegion(id);
        return "Region deleted successfully!";
    }
}
