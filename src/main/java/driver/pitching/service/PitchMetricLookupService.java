package driver.pitching.service;

import driver.pitching.dto.pitching.CareerPitchMetrics;
import driver.pitching.dto.pitching.PitchMetrics;
import driver.pitching.dto.pitching.Pitcher;
import driver.pitching.repository.PitchMetricLookupRepository;
import driver.pitching.repository.career.CareerPitchMetricsLookupRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PitchMetricLookupService {

    @Autowired
    private CareerPitchMetricsLookupRepository careerPitchMetricsLookupRepository;

    public CareerPitchMetrics getCareerPitchMetrics(String pitcherId){
        return mapPitchMetricsToCareerPitchMetrics(careerPitchMetricsLookupRepository.getPitchMetrics(pitcherId));
    }

    private CareerPitchMetrics mapPitchMetricsToCareerPitchMetrics(PitchMetrics pitchMetrics) {
        CareerPitchMetrics careerPitchMetrics = new CareerPitchMetrics();
        careerPitchMetrics.setPitchMetrics(pitchMetrics);
        return careerPitchMetrics;
    }
}
