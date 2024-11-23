package demo_api.controller;

import demo_api.models.Category;
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
    private final ModelMapper modelMapper = new ModelMapper();

    public RegionController(RegionService regionService){

        this.regionService = regionService;
    }

    @GetMapping("{id}")
    public RegionDTO getRegion(@PathVariable("id")Long id){
        return modelMapper.map(this.regionService.getRegion(id),RegionDTO.class);
    }

    @PostMapping
    public String createRegion(@RequestBody RegionDTO region){
        Region createdRegion = new Region();
        createdRegion.setRegionPlace(region.getRegionPlace());

        this.regionService.createRegion(createdRegion);
        return "Region created!";
    }

    @GetMapping
    public List<RegionDTO> getAllRegions(){
        return this.regionService
                .getAllRegions()
                .stream()
                .map(r -> modelMapper.map(r,RegionDTO.class))
                .toList();
    }
}
