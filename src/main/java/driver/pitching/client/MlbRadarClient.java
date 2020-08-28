package driver.pitching.client;

import com.google.gson.Gson;
import driver.pitching.dto.pitching.Pitcher;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
@AllArgsConstructor
public class MlbRadarClient {

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<Map> getPitcherProfile(String pitcherId){
        String resourceUrl = "https://api.sportradar.us/mlb/trial/v7/en/players/" + pitcherId + "/pitch_metrics.json?api_key=dbd3knrhsj4vu75gsjg6n8xz";
        return restTemplate.getForEntity(resourceUrl, Map.class);
    }
}
