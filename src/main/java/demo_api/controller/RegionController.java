package demo_api.controller;

import demo_api.models.Category;
import demo_api.models.Region;
import demo_api.services.RegionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/regions")
public class RegionController {
    private final RegionService regionService;

    public RegionController(RegionService regionService){

        this.regionService = regionService;
    }

    @GetMapping("{id}")
    public Region getCategory(@PathVariable("id")Long id){
        return this.regionService.getRegion(id);
    }

    @PostMapping
    public String createCategory(@RequestBody Region category){
        this.regionService.createRegion(category);
        return "Region created!";
    }

    @GetMapping
    public List<Region> getAllCategories(){
        return this.regionService.getAllRegions();
    }
}
