package driver.pitching.repository;

import driver.pitching.dto.pitching.PitchMetrics;
import org.springframework.stereotype.Component;

@Component
public interface PitchMetricLookupRepository {
    PitchMetrics getPitchMetrics(String pitcherId);
}
