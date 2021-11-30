package fun.etr.rockleader.controller;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("activities")
public class ActivitiesController {

	@GetMapping
	public String wakeUpHeroku() {
		return "is Alive!";
	}

}
