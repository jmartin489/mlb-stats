package driver.pitching.lookup;

import driver.pitching.dto.pitching.CareerPitchMetrics;
import driver.pitching.service.PitchMetricLookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pitching")
public class PitchingStatsLookupController {

    @Autowired
    private PitchMetricLookupService pitchMetricLookupService;

    @GetMapping("/home")
    public String home(){
        return "Application is running!!";
    }

    @GetMapping("/career/{playerId}/metrics")
    public CareerPitchMetrics getCareerPitchMetricsByPlayerId(@PathVariable(value = "playerId") String playerId){
        return pitchMetricLookupService.getCareerPitchMetrics(playerId);
    }
}