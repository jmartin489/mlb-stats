package driver.pitching.util;

import driver.pitching.dto.pitching.PitchMetaData;
import driver.pitching.dto.pitching.PitchMetrics;
import lombok.experimental.UtilityClass;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@UtilityClass
public class PitchMetricMappingUtil {

    public static PitchMetrics mapApiDataToPitchMetricsDTO(Map pitcherProfile) {
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
                    pitchMetaDataMap.put((String) pitchType.get("type"), PitchMetaData.builder()
                            .pitchTypeCount(getCareerPitchTypeCount(pitchMetaDataMap, pitchType))
                            .build());
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

    private static int getCareerPitchTypeCount(Map<String, PitchMetaData> pitchMetaDataMap, HashMap pitchType) {
        return pitchMetaDataMap.get(pitchType.get("type")).getPitchTypeCount() + (Integer) pitchType.get("count");
    }
}