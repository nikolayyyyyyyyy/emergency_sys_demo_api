package demo_api.repositories;

import demo_api.models.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface RegionRepository extends JpaRepository<Region,Long> {
}
