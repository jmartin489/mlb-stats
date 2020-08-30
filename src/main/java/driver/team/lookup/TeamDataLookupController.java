package driver.team.lookup;

import driver.team.dto.DepthChart;
import driver.team.service.TeamDataLookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/team")
public class TeamDataLookupController {

    @Autowired
    private TeamDataLookupService teamDataLookupService;

    @GetMapping("/{teamId}/depthChart")
    public DepthChart getCurrentTeamDepthChart(@PathVariable(value = "teamId") String teamId){
        return teamDataLookupService.getTeamDepthChartById(teamId);
    }
}
