package driver.pitching.lookup;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PitchingStatsLookupController {

    @GetMapping("/home")
    public String home(){
        return "Application is running!!";
    }
}
