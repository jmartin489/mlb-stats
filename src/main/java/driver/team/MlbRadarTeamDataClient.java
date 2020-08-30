package driver.team;

import com.google.gson.Gson;
import driver.team.dto.DepthChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MlbRadarTeamDataClient {

    @Autowired
    private RestTemplate restTemplate;

    public DepthChart getCurrentTeamDepthChart(String teamId){
        Gson gson = new Gson();
        String resourceUrl = "https://api.sportradar.us/mlb/trial/v7/en/teams/" + teamId + "/depth_chart.json?api_key=dbd3knrhsj4vu75gsjg6n8xz";
        String jsonString = gson.toJson(restTemplate.getForObject(resourceUrl, Object.class));
        DepthChart depthChart = gson.fromJson(jsonString, DepthChart.class);
        return depthChart;
    }
}