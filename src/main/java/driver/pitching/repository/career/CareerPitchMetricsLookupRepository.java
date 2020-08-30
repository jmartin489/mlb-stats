package driver.pitching.repository.career;

import driver.pitching.client.MlbRadarClient;
import driver.pitching.dto.pitching.PitchMetrics;
import driver.pitching.repository.PitchMetricLookupRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Map;

import static driver.pitching.util.PitchMetricMappingUtil.mapApiDataToPitchMetricsDTO;

@Component
@AllArgsConstructor
public class CareerPitchMetricsLookupRepository implements PitchMetricLookupRepository {

    private MlbRadarClient mlbRadarClient;

    @Override
    public PitchMetrics getPitchMetrics(String pitcherId) {
        ResponseEntity<Map> playerDataResponseEntity = mlbRadarClient.getPitcherProfile(pitcherId);
        if(playerDataResponseEntity.getStatusCode().equals(HttpStatus.OK)){
            return mapApiDataToPitchMetricsDTO((Map) playerDataResponseEntity.getBody().get("player"));
        }
        else
            return null;
    }
}
