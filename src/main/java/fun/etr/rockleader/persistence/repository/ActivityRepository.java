package fun.etr.rockleader.persistence.repository;

import fun.etr.rockleader.persistence.model.Activity;
import fun.etr.rockleader.persistence.model.ActivityProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "activities", path = "activities",
        excerptProjection= ActivityProjection.class)
public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
