package driver.team.service;

import driver.team.MlbRadarTeamDataClient;
import driver.team.dto.DepthChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeamDataLookupService {

    @Autowired
    private MlbRadarTeamDataClient mlbRadarTeamDataClient;

    public DepthChart getTeamDepthChartById(String teamId){
        return mlbRadarTeamDataClient.getCurrentTeamDepthChart(teamId);
    }
}
