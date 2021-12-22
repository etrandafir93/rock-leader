package fun.etr.rockleader.controller;

import fun.etr.rockleader.repository.AccountRepository;
import fun.etr.rockleader.repository.ActivityRepository;
import fun.etr.rockleader.repository.model.Account;
import fun.etr.rockleader.repository.model.Activity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("api/custom")
@RequiredArgsConstructor
public class CustomController {

    private final ActivityRepository activityRepository;
    private final AccountRepository accountRepository;

    @Transactional
    @PostMapping("activities")
    private Activity save(@RequestBody Activity activity, Principal principal) {
        activity.setAccount(extractUserAccount(principal));
        log.info("saving activity: {}", activity);
        return activityRepository.save(activity);
    }

    @GetMapping("user")
    public Account user(Principal principal) {
        return extractAccount(principal);
    }

    private Account extractUserAccount(Principal principal) {
        Account user = extractAccount(principal);
        return accountRepository.findByFacebookId(user.getFacebookId())
                .orElseGet(() -> accountRepository.save(user));
    }

    private Account extractAccount(Principal principal) {
        Map<String, String> attributes = (Map<String, String>) ((OAuth2Authentication) principal).getUserAuthentication().getDetails();
        long fbId = Long.parseLong(attributes.get("id"));
        String name = attributes.get("name");
        return new Account(fbId, name);
    }

}
