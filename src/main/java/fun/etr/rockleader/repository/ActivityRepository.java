package fun.etr.rockleader.repository;

import fun.etr.rockleader.repository.model.Activity;
import fun.etr.rockleader.repository.projection.ActivityProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
