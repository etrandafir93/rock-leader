package fun.etr.rockleader.repository.projection;

import fun.etr.rockleader.repository.model.Activity;
import fun.etr.rockleader.repository.model.ActivityType;
import org.springframework.data.rest.core.config.Projection;

import java.util.Set;

@Projection(types = Activity.class)
public interface ActivityProjection {
    long getId();
    String getName();
    String getDescription();
    ActivityType getType();
    int getDifficulty();
    Set<String> getTags();
}
