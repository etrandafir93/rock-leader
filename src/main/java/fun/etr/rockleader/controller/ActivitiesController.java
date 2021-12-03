package fun.etr.rockleader.controller;

import fun.etr.rockleader.persistence.model.Activity;
import fun.etr.rockleader.persistence.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
public class ActivitiesController {

	private final ActivityRepository repo;

	@GetMapping
	public String wakeUpHeroku() {
		return "is Alive!";
	}

	@GetMapping("new")
	public Activity test(@RequestParam String name) {
		return repo.save(Activity.builder().name(name).build());
	}

	@GetMapping("all")
	public Collection<Activity> test() {
		return repo.findAll();
	}

}
