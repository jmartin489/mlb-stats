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



//        ResponseEntity responseEntity = (ResponseEntity) pitcherProfile;
//        LinkedHashMap linkedHashMap = (LinkedHashMap) responseEntity.getBody();
//        LinkedHashMap linkedHashMap1 = (LinkedHashMap) linkedHashMap.get("player");
//        String firstName = (String) linkedHashMap1.get("first_name");
//        System.out.println("His name is: " + firstName);

        PitchMetrics pitchMetrics = new PitchMetrics();
        List<PitchType> pitchTypes = new ArrayList<>();

        Map<String, PitchMetaData> pitchMetaDataMap = new HashMap<>();

        List<Map> seasons = (List<Map>) pitcherProfile.get("seasons");

        for(Map item : seasons){

            LinkedHashMap totals = (LinkedHashMap) item.get("totals");
            LinkedHashMap statistics = (LinkedHashMap) totals.get("statistics");
            LinkedHashMap pitchMetricsLinkedMap = (LinkedHashMap) statistics.get("pitch_metrics");
            List<Map> pitch_types = (List<Map>) pitchMetricsLinkedMap.get("pitch_types");

            for(Map pitchType : pitch_types){
                pitchMetaDataMap.put(pitchType.get("type"), PitchMetaData.builder().build());
            }
        }
        pitchMetrics.setPitchType(pitchTypes);
        return pitchMetrics;
    }
}
