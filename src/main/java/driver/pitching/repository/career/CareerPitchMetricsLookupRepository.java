package driver.pitching.repository.career;

import driver.pitching.client.MlbRadarClient;
import driver.pitching.dto.pitching.PitchMetaData;
import driver.pitching.dto.pitching.PitchMetrics;
import driver.pitching.dto.pitching.PitchType;
import driver.pitching.repository.PitchMetricLookupRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.*;

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

    /**
     * Move this to mapper util class
     * */
    private PitchMetrics mapApiDataToPitchMetricsDTO(Map pitcherProfile) {
        PitchMetrics pitchMetrics = new PitchMetrics();
        Map<String, PitchMetaData> pitchMetaDataMap = new HashMap<>();

        List<Map> seasons = (List<Map>) pitcherProfile.get("seasons");

        for(Map item : seasons){

            LinkedHashMap totals = (LinkedHashMap) item.get("totals");
            LinkedHashMap statistics = (LinkedHashMap) totals.get("statistics");
            LinkedHashMap pitchMetricsLinkedMap = (LinkedHashMap) statistics.get("pitch_metrics");
            List<HashMap> pitch_types = (List<HashMap>) pitchMetricsLinkedMap.get("pitch_types");

            for(HashMap pitchType : pitch_types){
                if(pitchMetaDataMap.containsKey(pitchType.get("type"))){
                    pitchMetaDataMap.put((String) pitchType.get("type"), PitchMetaData.builder().pitchTypeCount(pitchMetaDataMap.get(pitchType.get("type")).getPitchTypeCount() + (Integer) pitchType.get("count")).build());
                }
                else{
                    pitchMetaDataMap.put((String) pitchType.get("type"), PitchMetaData.builder()
                            .pitchTypeCount((Integer) pitchType.get("count"))
                            .build());
                }
            }
        }
        pitchMetrics.setPitchMetaDataMap(pitchMetaDataMap);

        return pitchMetrics;
    }
}
