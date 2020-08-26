package driver.pitching.repository.career;

import driver.pitching.client.MlbRadarClient;
import driver.pitching.dto.pitching.PitchMetrics;
import driver.pitching.repository.PitchMetricLookupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CareerPitchMetricsLookupRepository implements PitchMetricLookupRepository {

    private MlbRadarClient mlbRadarClient;

    @Override
    public PitchMetrics getPitchMetrics(String pitcherId) {
        return mapApiDataToPitchMetricsDTO(mlbRadarClient.getPitcherProfile(pitcherId));
    }

    private PitchMetrics mapApiDataToPitchMetricsDTO(Object pitcherProfile) {
        return new PitchMetrics();
    }
}
