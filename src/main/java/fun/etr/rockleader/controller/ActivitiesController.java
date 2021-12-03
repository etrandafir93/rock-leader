package fun.etr.rockleader.controller;

import fun.etr.rockleader.persistence.Activity;
import fun.etr.rockleader.persistence.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("activities")
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
