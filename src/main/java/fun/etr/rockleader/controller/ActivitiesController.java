package fun.etr.rockleader.controller;

import fun.etr.rockleader.repository.AccountRepository;
import fun.etr.rockleader.repository.ActivityRepository;
import fun.etr.rockleader.repository.model.Account;
import fun.etr.rockleader.repository.model.Activity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("api/custom")
@RequiredArgsConstructor
public class ActivitiesController {

    private final ActivityRepository activityRepository;
    private final AccountRepository accountRepository;

    @Transactional
    @PostMapping("activities")
    private Activity save(@RequestBody Activity activity, Principal principal) {
        activity.setAccount(extractUserAccount(principal));
        log.info("saving activity: {}", activity);
        return activityRepository.save(activity);
    }

    private Account extractUserAccount(Principal pricipal) {
        var attributes = (Map<String, String>) ((OAuth2Authentication) pricipal).getUserAuthentication().getDetails();
        var fbId = Long.parseLong(attributes.get("id"));
        var name = attributes.get("name");
        return accountRepository.findByFacebookId(fbId)
                .orElseGet(() -> accountRepository.save(new Account(fbId, name)));
    }

}
