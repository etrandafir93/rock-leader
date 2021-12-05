package fun.etr.rockleader.persistence.controller;

import fun.etr.rockleader.persistence.model.Account;
import fun.etr.rockleader.persistence.model.Activity;
import fun.etr.rockleader.persistence.model.ActivityProjection;
import fun.etr.rockleader.persistence.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("activities")
@RequiredArgsConstructor
public class ActivitiesController {

    private final ActivityRepository repo;

    @PostMapping
    private Activity save(@RequestBody Activity activity) {
        log.info("{}", activity);
        return repo.save(activity);
    }

}
