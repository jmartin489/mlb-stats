package driver.pitching.client;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
public class MlbRadarClient {

    @Autowired
    private RestTemplate restTemplate;

    public Object getPitcherProfile(String pitcherId){
        String resourceUrl = "https://api.sportradar.us/mlb/trial/v7/en/players/" + pitcherId + "/profile.json?api_key=dbd3knrhsj4vu75gsjg6n8xz";
        return restTemplate.getForEntity(resourceUrl, Object.class);
    }
}
